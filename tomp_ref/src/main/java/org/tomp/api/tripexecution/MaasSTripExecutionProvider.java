package org.tomp.api.tripexecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.model.Segment;
import org.tomp.api.model.TransportOperator;
import org.tomp.api.model.Trip;
import org.tomp.api.repository.MPRepository;
import org.tomp.api.utils.ClientUtil;

import io.swagger.client.ApiException;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;

@Component
@Profile("maasprovider")
public class MaasSTripExecutionProvider implements TripExecutionProvider {

	@Autowired
	MPRepository repository;

	@Autowired
	ClientUtil clientUtil;

	@Override
	public void addNewTripEvent(LegEvent body, String acceptLanguage, String id) {
		Trip trip = repository.getTrip(id);
		Segment segment = trip.getSegments().get(Integer.parseInt(body.getComment()));
		TransportOperator operator = segment.getOperators().iterator().next();
		PlanningResult result = segment.getResult(operator).getResults().get(0);
		SimpleLeg leg = (SimpleLeg) result;
		try {
			clientUtil.post(operator, String.format("/legs/%s/events", leg.getId()), body, Leg[].class);
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
}
