package org.tomp.api.tripexecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.repository.MPRepository;
import org.tomp.api.utils.ClientUtil;

import io.swagger.model.Execution;
import io.swagger.model.ExecutionEvent;

@Component
@Profile("maasprovider")
public class MaasSTripExecutionProvider implements TripExecutionProvider {

	@Autowired
	MPRepository repository;

	@Autowired
	ClientUtil clientUtil;

	@Override
	public Execution prepare(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		/*
		 * Trip trip = repository.getTrip(id); Segment segment =
		 * trip.getSegments().get(Integer.parseInt(body.getComment()));
		 * TransportOperator operator = segment.getOperators().iterator().next();
		 * PlanningResult result = segment.getResult(operator).getResults().get(0);
		 * SimpleLeg simpleLeg = (SimpleLeg) result; try { clientUtil.post(operator,
		 * String.format("/legs/%s/events", simpleLeg.getId()), body, Leg[].class); }
		 * catch (ApiException e) { e.printStackTrace(); }
		 */
		return null;
	}

	@Override
	public Execution assignAsset(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execution reserve(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execution setInUse(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execution pause(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execution startFinishing(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execution finish(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}
}
