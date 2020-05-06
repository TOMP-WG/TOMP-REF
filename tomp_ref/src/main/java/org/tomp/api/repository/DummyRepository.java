package org.tomp.api.repository;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.swagger.model.Booking;
import io.swagger.model.CompositeLeg;
import io.swagger.model.LegEvent;
import io.swagger.model.PlanningOptions;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;

@Component
public class DummyRepository {

	private static final Logger log = LoggerFactory.getLogger(DummyRepository.class);

	private Map<String, PlanningOptions> options = new HashMap<>();
	private Map<String, Booking> bookings = new HashMap<>();

	public void saveOptions(PlanningOptions optionsToSave) {
		for (PlanningResult result : optionsToSave.getResults()) {
			if (result instanceof SimpleLeg) {
				SimpleLeg leg = (SimpleLeg) result;
				options.put(leg.getId(), optionsToSave);
				log.info("I've got to remember this leg: {}", leg.getId());
			} else if (result instanceof CompositeLeg) {
				CompositeLeg leg = (CompositeLeg) result;
				options.put(leg.getId(), optionsToSave);
				log.info("I've got to remember this leg: {}", leg.getId());
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
	}

	public Booking getBooking(String id) {
		return bookings.get(id);
	}

	public void saveLegEvent(String id, LegEvent body) {
		// TODO Auto-generated method stub

	}
}
