package org.tomp.api.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.tomp.api.mp.Trip;

import io.swagger.model.CompositeLeg;

@Component
public class MaaSRepository {

	public Map<String, Trip> options = new HashMap<>();

	public void saveTrip(CompositeLeg leg, Trip trip) {
		options.put(leg.getId(), trip);
	}

	public Trip getTrip(String id) {
		return options.get(id);
	}
}
