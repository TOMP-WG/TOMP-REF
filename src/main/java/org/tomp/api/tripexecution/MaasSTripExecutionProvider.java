package org.tomp.api.tripexecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.mp.ClientUtil;
import org.tomp.api.mp.Segment;
import org.tomp.api.mp.TransportOperator;
import org.tomp.api.mp.Trip;
import org.tomp.api.repository.MaaSRepository;

import io.swagger.client.ApiException;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;

@Component
@Profile("maasprovider")
public class MaasSTripExecutionProvider implements TripExecutionProvider {

	@Autowired
	MaaSRepository repository;

	@Override
	public void addNewTripEvent(LegEvent body, String acceptLanguage, String id) {
		Trip trip = repository.getTrip(id);
		Segment segment = trip.getSegments().get(Integer.parseInt(body.getComment()));
		TransportOperator operator = segment.getOperators().iterator().next();
		PlanningResult result = segment.getResult(operator).getResults().get(0);
		SimpleLeg leg = (SimpleLeg) result;
		try {
			ClientUtil.post(operator, String.format("/legs/%s/events", leg.getId()), body, Leg[].class);
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
}
