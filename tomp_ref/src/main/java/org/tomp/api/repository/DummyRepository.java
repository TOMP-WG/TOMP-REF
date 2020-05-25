package org.tomp.api.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;

import io.swagger.model.Booking;
import io.swagger.model.BookingState;
import io.swagger.model.CompositeLeg;
import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.PlanningOptions;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;

@Component
public class DummyRepository {

	private static final Logger log = LoggerFactory.getLogger(DummyRepository.class);

	@Autowired
	ExternalConfiguration configuration;

	private Map<String, PlanningOptions> options = new HashMap<>();
	private Map<String, Booking> bookings = new HashMap<>();
	private Map<String, Leg> legs = new HashMap<>();
	private Map<String, Map<String, List<JournalEntry>>> journalEntries = new HashMap<>();
	private Map<String, List<LegEvent>> startEvents = new HashMap<>();

	public void saveOptions(PlanningOptions optionsToSave) {
		for (PlanningResult result : optionsToSave.getResults()) {
			if (result instanceof SimpleLeg) {
				SimpleLeg leg = (SimpleLeg) result;
				log.info("Saved leg: {}", leg.getId());
				options.put(leg.getId(), optionsToSave);
			} else if (result instanceof CompositeLeg) {
				CompositeLeg leg = (CompositeLeg) result;
				log.info("Saved leg: {}", leg.getId());
				options.put(leg.getId(), optionsToSave);
			}
		}
	}

	public PlanningResult getSavedOption(String id) {
		PlanningOptions planningOptions = options.get(id);
		if (planningOptions == null) {
			log.info("missing leg: {}", id);
			return null;
		}
		for (PlanningResult result : planningOptions.getResults()) {
			if (result instanceof SimpleLeg) {
				SimpleLeg leg = (SimpleLeg) result;
				if (leg.getId().equals(id)) {
					return leg;
				}
			} else if (result instanceof CompositeLeg) {
				CompositeLeg leg = (CompositeLeg) result;
				if (leg.getId().equals(id)) {
					return leg;
				}
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
		SimpleLeg simpleLeg = (SimpleLeg) getPlanningResult(booking.getId());
		if (simpleLeg != null) {
			injectOptionsLeg(simpleLeg, leg);
		}
		return leg;
	}

	private void injectOptionsLeg(SimpleLeg simpleLeg, Leg leg) {
		leg.setFare(simpleLeg.getPricing());
		leg.setAgencyId(configuration.getMaasId());
		leg.setStartTime(simpleLeg.getLeg().getStartTime());
		leg.setEndTime(simpleLeg.getLeg().getEndTime());
		leg.setMode(simpleLeg.getTypeOfAsset());
	}

	private PlanningResult getPlanningResult(String id) {
		for (Entry<String, PlanningOptions> o : options.entrySet()) {
			for (PlanningResult result : o.getValue().getResults()) {
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

	public void saveLegEvent(String id, LegEvent body) {
		if (!startEvents.containsKey(id)) {
			startEvents.put(id, new ArrayList<>());
		}

		startEvents.get(id).add(body);
	}

	public List<LegEvent> getLegEvents(String id) {
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

	public List<JournalEntry> getJournalEntries(String acceptLanguage, BigDecimal from, BigDecimal to,
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

	private boolean conditionsMet(JournalEntry entry, BigDecimal from, BigDecimal to, JournalState state,
			String category) {
		if (entry == null || entry.getExpirationDate() == null || entry.getState() == null)
			return false;

		if (entry.getExpirationDate().longValue() > to.longValue())
			return false;
		if (entry.getExpirationDate().longValue() < from.longValue())
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
