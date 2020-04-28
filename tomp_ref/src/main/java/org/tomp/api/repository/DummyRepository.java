package org.tomp.api.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.swagger.model.Booking;
import io.swagger.model.LegEvent;
import io.swagger.model.PlanningOptions;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;

@Component
public class DummyRepository {

    static final Map<String, PlanningOptions> options = new HashMap<>();
	static final Map<String, Booking> bookings = new HashMap<>();

	public void saveOptions(PlanningOptions optionsToSave) {
		for (PlanningResult result : optionsToSave.getResults()) {
			if (result instanceof SimpleLeg) {
				SimpleLeg leg = (SimpleLeg) result;
				options.put(leg.getId(), optionsToSave);
				System.out.println("I've got to remember this leg: " + leg.getId());
			}
		}
	}

	public SimpleLeg getSavedOption(String id) {
		PlanningOptions planningOptions = options.get(id);
		if (planningOptions == null) {
			System.out.println("missing leg: " + id);
			return null;
		}
		for (PlanningResult result : planningOptions.getResults()) {
			if (result instanceof SimpleLeg) {
				SimpleLeg leg = (SimpleLeg) result;
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
