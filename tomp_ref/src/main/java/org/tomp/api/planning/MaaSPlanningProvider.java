package org.tomp.api.planning;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.temporal.ChronoUnit;
import org.tomp.api.model.Segment;
import org.tomp.api.model.TransportOperator;
import org.tomp.api.model.Trip;
import org.tomp.api.mp.TOProvider;
import org.tomp.api.repository.MPRepository;
import org.tomp.api.utils.ClientUtil;

import io.swagger.client.ApiException;
import io.swagger.model.AssetClass;
import io.swagger.model.Condition;
import io.swagger.model.Coordinates;
import io.swagger.model.KeyValue;
import io.swagger.model.Leg;
import io.swagger.model.Place;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;
import io.swagger.model.Requirements;
import io.swagger.model.Suboperator;
import io.swagger.model.TypeOfAsset;
import io.swagger.model.User;

@Component
@Profile("maasprovider")
public class MaaSPlanningProvider implements PlanningProvider {

	private static final Logger log = LoggerFactory.getLogger(MaaSPlanningProvider.class);

	@Autowired
	TOProvider toProvider;

	@Autowired
	MPRepository repository;

	@Autowired
	ClientUtil clientUtil;

	public Planning getOptions(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		log.info("Request for planning options");
		applyPersonalStuff(body);

		List<Trip> trips = constructPossibleTrips(body);
		log.info("Number of trips constructed {}", trips.size());
		findTransportOperatorsPerLeg(trips);
		log.info("Looking for transport operators");

		try {
			getTransportOperatorInformation(trips, body);
			log.info("Fetched planning options from TOs");
			trips = constructBestTrips(trips);
			log.info("Constructed best trips {}", trips.size());
			log.info("Request ids");
			provideIds(trips, body);
			log.info("Done");
		} catch (ApiException e) {
			log.error(e.getMessage());
			log.error(e.getResponseBody());
		}

		return createPlanningOption(trips);
	}

	private Planning createPlanningOption(List<Trip> trips) {
		Planning option = new Planning();
		option.setConditions(gatherConditions(trips));
		option.setValidUntil(getMinimalValidUntil(trips));
		option.setLegOptions(gatherResults(trips));
		return option;
	}

	private List<Leg> gatherResults(List<Trip> trips) {
		List<Leg> results = new ArrayList<>();
		for (Trip trip : trips) {
			Leg leg = new Leg();
			leg.setParts(constructOperatorLegs(trip));
			leg.setId(UUID.randomUUID().toString());
			repository.saveTrip(leg, trip);
			results.add(leg);
		}
		return results;
	}

	private List<Leg> constructOperatorLegs(Trip trip) {
		List<Leg> legs = new ArrayList<>();
		for (Segment segment : trip.getSegments()) {
			// take first operator
			TransportOperator operator = segment.getOperators().iterator().next();
			Planning options = segment.getResult(operator);
			Leg leg = options.getLegOptions().get(0);
			legs.add(toOperatorLeg(leg, operator));
		}
		return legs;
	}

	private Leg toOperatorLeg(Leg leg, TransportOperator operator) {
		Suboperator suboperator = new Suboperator();
		suboperator.setMaasId(operator.getId());
		suboperator.setName(operator.getName());
		leg.setSuboperator(suboperator);
		return leg;
	}

	private OffsetDateTime getMinimalValidUntil(List<Trip> trips) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Condition> gatherConditions(List<Trip> trips) {
		// TODO Auto-generated method stub
		return null;
	}

	private void provideIds(List<Trip> trips, PlanningRequest body) throws ApiException {
		for (Trip trip : trips) {
			for (Segment segment : trip.getSegments()) {
				for (TransportOperator operator : segment.getOperators()) {
					PlanningRequest planningCheck = createPlanningCheck(segment, body);
					// planningCheck.provideIds(true);
					Planning options = clientUtil.post(operator, "/plannings/&bookingIntent=true", planningCheck,
							Planning.class);
					segment.addResult(operator, options);
				}
			}
		}
	}

	private void applyPersonalStuff(PlanningRequest body) {
		boolean first = true;
		for (User user : body.getUsers()) {
			// you can apply your knowledge of the end user in the body. It will be passed
			// to the TOs
			user.setValidated(true);
			if (first) {
				Requirements requirements = new Requirements();
				KeyValue e = new KeyValue();
				e.put("CROW-RK", "HR-02");
				requirements.add(e);
				user.setRequirements(requirements);
				first = false;
			}
		}
	}

	private List<Trip> constructPossibleTrips(PlanningRequest body) {
		int numberOfTrips = new Random().nextInt(3) + 1;
		List<Trip> trips = new ArrayList<>();
		for (int i = 0; i < numberOfTrips; i++) {
			trips.add(generateTrip(body));
		}
		return trips;
	}

	private Trip generateTrip(PlanningRequest body) {
		int numberOfLegs = new Random().nextInt(3) + 1;
		List<Segment> segments = new ArrayList<>();

		Coordinates from = new Coordinates();
		from.setLat(body.getFrom().getCoordinates().getLat());
		from.setLng(body.getFrom().getCoordinates().getLng());

		Coordinates to = body.getTo().getCoordinates();

		BigDecimal deltaX = to.getLat().subtract(from.getLat());
		deltaX = deltaX.divide(BigDecimal.valueOf(numberOfLegs), RoundingMode.DOWN);
		BigDecimal deltaY = to.getLng().subtract(from.getLng());
		deltaY = deltaY.divide(BigDecimal.valueOf(numberOfLegs), RoundingMode.DOWN);
		// int deltaT = (body.getEndTime().subtract(body.getStartTime())).intValue();
		long deltaT = ChronoUnit.SECONDS.between(body.getEndTime(), body.getStartTime());
		deltaT = deltaT / numberOfLegs;

		to = new Coordinates();
		to.setLat(body.getFrom().getCoordinates().getLat());
		to.setLng(body.getFrom().getCoordinates().getLng());
		to = applyDelta(to, 1, deltaX, deltaY);

		for (int i = 0; i < numberOfLegs; i++) {
			Segment segment = new Segment();
			TypeOfAsset typeOfAsset = new TypeOfAsset();

			segment.setFrom(from);
			segment.setTo(to);

			from = applyDelta(from, i + 1, deltaX, deltaY);
			to = applyDelta(to, i + 1, deltaX, deltaY);

			List<TransportOperator> transportOperators = toProvider.getTransportOperators(segment);
			int index = new Random().nextInt(transportOperators.size());
			AssetClass assetClass = transportOperators.get(index).getAssetClasses().get(0);
			typeOfAsset.setAssetClass(assetClass);
			segment.setAsset(typeOfAsset);

			segment.setStartTime(applyDelta(body.getStartTime(), i, deltaT));
			segment.setEndTime(applyDelta(body.getStartTime(), i + 1, deltaT));

			segments.add(segment);
		}

		Trip trip = new Trip();
		trip.setSegments(segments);
		return trip;
	}

	private void findTransportOperatorsPerLeg(List<Trip> trips) {
		for (Trip trip : trips) {
			for (Segment segment : trip.getSegments()) {
				for (TransportOperator to : toProvider.getTransportOperators(segment)) {
					if (to.providesAssetClass(segment.getAsset().getAssetClass())) {
						segment.addResult(to, null);
					}
				}
			}
		}
	}

	private void getTransportOperatorInformation(List<Trip> trips, PlanningRequest body) throws ApiException {
		for (Trip trip : trips) {
			for (Segment segment : trip.getSegments()) {
				for (TransportOperator operator : segment.getOperators()) {
					Planning options = clientUtil.post(operator, "/plannings/", createPlanningCheck(segment, body),
							Planning.class);
					segment.addResult(operator, options);
				}
			}
		}
	}

	private PlanningRequest createPlanningCheck(Segment segment, PlanningRequest body) {
		PlanningRequest check = new PlanningRequest();
		Place from = new Place();
		from.setCoordinates(segment.getFrom());
		check.from(from);
		Place to = new Place();
		to.setCoordinates(segment.getTo());
		check.to(to);
		check.setRadius(body.getRadius());
		check.startTime(segment.getStartTime());
		check.endTime(segment.getEndTime());
		check.setUsers(body.getUsers());
		check.setTravelers(body.getTravelers());
		return check;
	}

	private List<Trip> constructBestTrips(List<Trip> allTrips) {
		return allTrips;
	}

	private OffsetDateTime applyDelta(@Valid OffsetDateTime offsetDateTime, int i, long deltaT) {
		return ChronoUnit.SECONDS.addTo(offsetDateTime, i * deltaT);
	}

	private Coordinates applyDelta(Coordinates coord, int i, BigDecimal deltaX, BigDecimal deltaY) {
		Coordinates result = new Coordinates();
		result.setLat(coord.getLat().add(deltaX.multiply(BigDecimal.valueOf(i))));
		result.setLng(coord.getLng().add(deltaY.multiply(BigDecimal.valueOf(i))));
		return result;
	}
}
