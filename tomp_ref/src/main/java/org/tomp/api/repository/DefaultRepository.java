package org.tomp.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;
import org.tomp.api.configuration.ExternalConfiguration;

import io.swagger.model.Booking;
import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.Planning;

@Component
public class DefaultRepository {

	private static final Logger log = LoggerFactory.getLogger(DefaultRepository.class);

	@Autowired
	ExternalConfiguration configuration;

	private Map<String, Booking> bookings = new HashMap<>();
	private Map<String, Map<String, List<JournalEntry>>> journalEntries = new HashMap<>();
	private Map<String, List<LegEvent>> legEvents = new HashMap<>();

	public void saveBookingOption(Planning optionsToSave) {
		if (optionsToSave == null) {
			return;
		}
		for (Booking booking : optionsToSave.getOptions()) {
			log.info("Saved booking: {}", booking.getId());
			bookings.put(booking.getId(), booking);
		}
	}

	public Booking getSavedOption(String id) {
		return bookings.get(id);
	}

	public void saveBooking(Booking booking) {
		bookings.put(booking.getId(), booking);
	}

	public Booking getBooking(String id) {
		return bookings.get(id);
	}

	public Stream<Booking> getBookings(Predicate<? super Booking> predicate) {
		return bookings.values().stream().filter(predicate);
	}

	public Leg getLeg(String id) {
		for (Booking b : bookings.values()) {
			for (Leg leg : b.getLegs()) {
				if (leg.getId().equals(id)) {
					return leg;
				}
			}
		}
		return null;
	}

	public void saveLegEvent(String id, LegEvent body) {
		if (!legEvents.containsKey(id)) {
			legEvents.put(id, new ArrayList<>());
		}

		legEvents.get(id).add(body);
	}

	public List<LegEvent> getLegEvents(String id) {
		return legEvents.get(id);
	}

	public void saveJournalEntry(JournalEntry entry, String maasId) {
		String journalId = entry.getJournalId();

		if (!journalEntries.containsKey(maasId)) {
			journalEntries.put(maasId, new HashMap<>());
		}

		Map<String, List<JournalEntry>> journalItemsPerMP = journalEntries.get(maasId);
		calculateSequenceId(journalItemsPerMP, entry);

		if (!journalItemsPerMP.containsKey(journalId)) {
			journalItemsPerMP.put(journalId, new ArrayList<>());
		}
		journalItemsPerMP.get(journalId).add(entry);
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
			JournalState state, String category, String id, String maasId) {
		ArrayList<JournalEntry> entries = new ArrayList<>();
		Map<String, List<JournalEntry>> map = journalEntries.get(maasId);
		if (map != null) {
			for (List<JournalEntry> journal : map.values()) {
				for (JournalEntry entry : journal) {
					if (conditionsMet(entry, from, to, state, category, id)) {
						entries.add(entry);
					}
				}
			}
		}
		return entries;
	}

	private boolean conditionsMet(JournalEntry entry, OffsetDateTime from, OffsetDateTime to, JournalState state,
			String category, String id) {
		if (id != null && entry.getJournalId().equals(id)) {
			return true;
		}
		if (entry == null || entry.getExpirationDate() == null || entry.getState() == null)
			return false;
		if (to != null && entry.getExpirationDate().isAfter(to))
			return false;
		if (from != null && entry.getExpirationDate().isBefore(from))
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
