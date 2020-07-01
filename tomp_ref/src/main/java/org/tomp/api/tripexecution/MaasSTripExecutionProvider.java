package org.tomp.api.tripexecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.repository.MPRepository;
import org.tomp.api.utils.ClientUtil;

import io.swagger.model.Leg;
import io.swagger.model.LegEvent;

@Component
@ConditionalOnProperty(value = "tomp.providers.tripexecution", havingValue = "maasprovider", matchIfMissing = false)
public class MaasSTripExecutionProvider implements TripExecutionProvider {

	@Autowired
	MPRepository repository;

	@Autowired
	ClientUtil clientUtil;

	@Override
	public Leg prepare(LegEvent body, String acceptLanguage, String id, String maasId) {
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
	public Leg assignAsset(LegEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Leg reserve(LegEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Leg setInUse(LegEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Leg pause(LegEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Leg startFinishing(LegEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Leg finish(LegEvent body, String acceptLanguage, String id, String maasId) {
		// TODO Auto-generated method stub
		return null;
	}
}
