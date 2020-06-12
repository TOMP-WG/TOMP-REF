package org.tomp.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;
import org.tomp.api.configuration.ExternalConfiguration;

import io.swagger.model.Booking;
import io.swagger.model.BookingState;
import io.swagger.model.ExecutionEvent;
import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;
import io.swagger.model.Leg;
import io.swagger.model.Planning;
import io.swagger.model.Suboperator;

@Component
public class DummyRepository {

	private static final Logger log = LoggerFactory.getLogger(DummyRepository.class);

	@Autowired
	ExternalConfiguration configuration;

	private Map<String, Planning> options = new HashMap<>();
	private Map<String, Booking> bookings = new HashMap<>();
	private Map<String, Leg> legs = new HashMap<>();
	private Map<String, Map<String, List<JournalEntry>>> journalEntries = new HashMap<>();
	private Map<String, List<ExecutionEvent>> startEvents = new HashMap<>();

	public void saveOptions(Planning optionsToSave) {
		if (optionsToSave == null) {
			return;
		}
		for (Leg leg : optionsToSave.getLegOptions()) {
			log.info("Saved leg: {}", leg.getId());
			options.put(leg.getId(), optionsToSave);
		}
	}

	public Leg getSavedOption(String id) {
		Planning planningOptions = options.get(id);
		if (planningOptions == null) {
			log.info("missing leg: {}", id);
			return null;
		}
		for (Leg leg : planningOptions.getLegOptions()) {
			if (leg.getId().equals(id)) {
				return leg;
			}
		}
		return null;
	}

	public void saveBooking(Booking booking) {
		bookings.put(booking.getId(), booking);

		if (booking.getState().equals(BookingState.CONFIRMED)) {
			legs.put(booking.getId(), constructLeg(booking));
		}
	}

	private Leg constructLeg(Booking booking) {
		Leg leg = new Leg();
		Leg simpleLeg = getPlanningResult(booking.getId());
		if (simpleLeg != null) {
			injectOptionsLeg(simpleLeg, leg);
		}
		return leg;
	}

	private void injectOptionsLeg(Leg simpleLeg, Leg leg) {
		leg.setPricing(simpleLeg.getPricing());
		leg.setSuboperator(simpleLeg.getSuboperator() == null ? new Suboperator() : simpleLeg.getSuboperator());
		leg.getSuboperator().setMaasId(configuration.getMaasId());
		leg.setStartTime(simpleLeg.getStartTime());
		leg.setEndTime(simpleLeg.getEndTime());
		leg.setAsset(simpleLeg.getAsset());
		leg.setFrom(simpleLeg.getFrom());
		leg.setTo(simpleLeg.getTo());
	}

	private Leg getPlanningResult(String id) {
		for (Entry<String, Planning> o : options.entrySet()) {
			for (Leg result : o.getValue().getLegOptions()) {
				if (result.getId().equals(id)) {
					return result;
				}
			}
		}
		return null;
	}

	public Booking getBooking(String id) {
		return bookings.get(id);
	}

	public Leg getLeg(String id) {
		return legs.get(id);
	}

	public void saveLegEvent(String id, ExecutionEvent body) {
		if (!startEvents.containsKey(id)) {
			startEvents.put(id, new ArrayList<>());
		}

		startEvents.get(id).add(body);
	}

	public List<ExecutionEvent> getLegEvents(String id) {
		return startEvents.get(id);
	}

	public void saveJournalEntry(JournalEntry entry, String maasId) {
		String journalId = entry.getJournalId();

		if (!journalEntries.containsKey(maasId)) {
			journalEntries.put(maasId, new HashMap<>());
		}

		Map<String, List<JournalEntry>> journalItemsPerTO = journalEntries.get(maasId);
		calculateSequenceId(journalItemsPerTO, entry);

		if (!journalItemsPerTO.containsKey(journalId)) {
			journalItemsPerTO.put(journalId, new ArrayList<>());
		}
		journalItemsPerTO.get(journalId).add(entry);
	}

	private void calculateSequenceId(Map<String, List<JournalEntry>> journalItemsPerTO, JournalEntry entry) {
		List<JournalEntry> journal = journalItemsPerTO.get(entry.getJournalId());
		if (journal == null)
			entry.setJournalSequenceId("0");
		else {
			entry.setJournalSequenceId(String.valueOf(journalItemsPerTO.size()));
		}
	}

	public JournalEntry getLastStartJournalEntry(String maasId, String id) {
		List<JournalEntry> list = journalEntries.get(maasId).get(id);
		for (int i = list.size() - 1; i >= 0; i--) {
			JournalEntry journalEntry = list.get(i);
			if (journalEntry.getState() == null) {
				return journalEntry;
			}
		}
		return list.get(0);
	}

	public List<JournalEntry> getJournalEntries(String acceptLanguage, OffsetDateTime from, OffsetDateTime to,
			JournalState state, String category, String maasId) {
		ArrayList<JournalEntry> entries = new ArrayList<>();
		Map<String, List<JournalEntry>> map = journalEntries.get(maasId);
		if (map != null) {
			for (List<JournalEntry> journal : map.values()) {
				for (JournalEntry entry : journal) {
					if (conditionsMet(entry, from, to, state, category)) {
						entries.add(entry);
					}
				}
			}
		}
		return entries;
	}

	private boolean conditionsMet(JournalEntry entry, OffsetDateTime from, OffsetDateTime to, JournalState state,
			String category) {
		if (entry == null || entry.getExpirationDate() == null || entry.getState() == null)
			return false;

		if (entry.getExpirationDate().isAfter(to))
			return false;
		if (entry.getExpirationDate().isBefore(from))
			return false;
		if (state != null && entry.getState() != state)
			return false;
		if (category != null && entry.getDetails() != null && entry.getDetails() instanceof ExtraCosts) {
			ExtraCosts c = (ExtraCosts) entry.getDetails();
			return c.getCategory().toString().equals(category);
		}

		return true;
	}
}
