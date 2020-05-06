package org.tomp.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.tomp.api.model.Trip;

import io.swagger.model.Booking;
import io.swagger.model.CompositeLeg;

@Component
public class MPRepository {

	private static final Map<String, Trip> options = new HashMap<>();
	private static final Map<Booking, ArrayList<Booking>> bookings = new HashMap<>();

	public void saveTrip(CompositeLeg leg, Trip trip) {
		options.put(leg.getId(), trip);
	}

	public Trip getTrip(String id) {
		return options.get(id);
	}

	public void addTOBooking(Booking booking, Booking clientBooking) {
		ArrayList<Booking> clientBookings = bookings.get(booking);
		if (clientBookings == null) {
			clientBookings = new ArrayList<>();
		}
		clientBookings.add(clientBooking);
		bookings.put(booking, clientBookings);
	}

	public Booking getClientBooking(String id) {
		for (Entry<Booking, ArrayList<Booking>> entry : bookings.entrySet()) {
			for (Booking clientBooking : entry.getValue()) {
				if (clientBooking.getId().equals(id)) {
					return clientBooking;
				}
			}
		}
		return null;
	}
}
