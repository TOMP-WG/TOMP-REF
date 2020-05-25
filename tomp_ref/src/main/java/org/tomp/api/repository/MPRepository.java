package org.tomp.api.repository;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.tomp.api.model.TransportOperator;
import org.tomp.api.model.Trip;

import io.swagger.model.Booking;
import io.swagger.model.CompositeLeg;
import io.swagger.model.Leg;

@Component
public class MPRepository {

	private static final Map<String, Trip> options = new HashMap<>();
	private static final Map<Booking, ArrayList<SimpleEntry<Booking, TransportOperator>>> bookings = new HashMap<>();
	private static final Map<String, Leg> legs = new HashMap<>();

	public void saveTrip(CompositeLeg leg, Trip trip) {
		options.put(leg.getId(), trip);
	}

	public Trip getTrip(String id) {
		return options.get(id);
	}

	public void addClientBooking(Booking booking, TransportOperator operator, Booking clientBooking) {
		ArrayList<SimpleEntry<Booking, TransportOperator>> clientBookings = bookings.get(booking);
		if (clientBookings == null) {
			clientBookings = new ArrayList<>();
		}
		clientBookings.add(new SimpleEntry<Booking, TransportOperator>(clientBooking, operator));
		bookings.put(booking, clientBookings);
	}

	public Booking getClientBooking(String id) {
		for (Entry<Booking, ArrayList<SimpleEntry<Booking, TransportOperator>>> entry : bookings.entrySet()) {
			for (SimpleEntry<Booking, TransportOperator> clientBooking : entry.getValue()) {
				if (clientBooking.getKey().getId().equals(id)) {
					return clientBooking.getKey();
				}
			}
		}
		return null;
	}

	public ArrayList<SimpleEntry<Booking, TransportOperator>> getClientBookings(Booking maasBooking) {
		return bookings.get(maasBooking);
	}

	public void saveLeg(String id, Leg leg) {
		legs.put(id, leg);
	}

	public Leg getLeg(String id) {
		return legs.get(id);
	}
}
