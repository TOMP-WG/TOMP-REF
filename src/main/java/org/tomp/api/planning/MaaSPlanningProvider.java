package org.tomp.api.planning;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.mp.ClientUtil;
import org.tomp.api.mp.Segment;
import org.tomp.api.mp.TOProvider;
import org.tomp.api.mp.TransportOperator;
import org.tomp.api.mp.Trip;
import org.tomp.api.repository.MaaSRepository;

import io.swagger.client.ApiException;
import io.swagger.model.AssetClass;
import io.swagger.model.CompositeLeg;
import io.swagger.model.Condition;
import io.swagger.model.Coordinates;
import io.swagger.model.OperatorLeg;
import io.swagger.model.PlanningCheck;
import io.swagger.model.PlanningOptions;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;
import io.swagger.model.TypeOfAsset;
import io.swagger.model.User;

@Component
@Profile("maasprovider")
public class MaaSPlanningProvider implements PlanningProvider {

	private static final Logger log = LoggerFactory.getLogger(MaaSPlanningProvider.class);

	@Autowired
	TOProvider toProvider;

	@Autowired
	MaaSRepository repository;

	public PlanningOptions getOptions(@Valid PlanningCheck body, String acceptLanguage) {
		log.info("Request for planning options");
		applyPersonalStuff(body);

		List<Trip> trips = constructPossibleTrips(body);
		log.info(String.format("Number of trips constructed %d", trips.size()));
		findTransportOperatorsPerLeg(trips);
		log.info("Looking for transport operators");

		try {
			getTransportOperatorInformation(trips, body);
			log.info("Fetched planning options from TOs");
			trips = constructBestTrips(trips);
			log.info(String.format("Constructed best trips %d", trips.size()));
			log.info("Request ids");
			provideIds(trips, body);
			log.info("Done");
		} catch (ApiException e) {
			log.error(e.getMessage());
			log.error(e.getResponseBody());
			// e.printStackTrace();
		}

		return createPlanningOption(trips);
	}

	private PlanningOptions createPlanningOption(List<Trip> trips) {
		PlanningOptions option = new PlanningOptions();
		option.setConditions(gatherConditions(trips));
		option.setValidUntil(getMinimalValidUntil(trips));
		option.setResults(gatherResults(trips));
		return option;
	}

	private List<PlanningResult> gatherResults(List<Trip> trips) {
		List<PlanningResult> results = new ArrayList<>();
		for (Trip trip : trips) {
			CompositeLeg leg = new CompositeLeg();
			leg.setLegs(constructOperatorLegs(trip));
			leg.setId(UUID.randomUUID().toString());
			repository.saveTrip(leg, trip);
			results.add(leg);
		}
		return results;
	}

	private List<OperatorLeg> constructOperatorLegs(Trip trip) {
		List<OperatorLeg> legs = new ArrayList<>();
		for (Segment segment : trip.getSegments()) {
			// take first operator
			TransportOperator operator = segment.getOperators().iterator().next();
			PlanningOptions options = segment.getResult(operator);
			PlanningResult planningResult = options.getResults().get(0);
			if (planningResult instanceof SimpleLeg) {
				SimpleLeg simpleLeg = (SimpleLeg) planningResult;
				legs.add(toOperatorLeg(simpleLeg, operator));
			}
		}
		return legs;
	}

	private OperatorLeg toOperatorLeg(SimpleLeg simpleLeg, TransportOperator operator) {
		OperatorLeg leg = new OperatorLeg();
		leg.setTypeOfAsset(simpleLeg.getTypeOfAsset());
		leg.setLeg(simpleLeg.getLeg());
		leg.setId(simpleLeg.getId());

		leg.setOperatorName(operator.getName());
		return leg;
	}

	private BigDecimal getMinimalValidUntil(List<Trip> trips) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Condition> gatherConditions(List<Trip> trips) {
		// TODO Auto-generated method stub
		return null;
	}

	private void provideIds(List<Trip> trips, PlanningCheck body) throws ApiException {
		for (Trip trip : trips) {
			for (Segment segment : trip.getSegments()) {
				for (TransportOperator operator : segment.getOperators()) {
					PlanningCheck planningCheck = createPlanningCheck(segment, body);
					planningCheck.provideIds(true);
					PlanningOptions options = ClientUtil.post(operator, "/planning-options/", planningCheck,
							PlanningOptions.class);
					segment.addResult(operator, options);
				}
			}
		}
	}

	private void applyPersonalStuff(PlanningCheck body) {
		for (User user : body.getUsers()) {
			// you can apply your knowledge of the end user in the body. It will be passed
			// to the TOs

		}
	}

	private List<Trip> constructPossibleTrips(PlanningCheck body) {
		int numberOfTrips = new Random().nextInt(3) + 1;
		List<Trip> trips = new ArrayList<>();
		for (int i = 0; i < numberOfTrips; i++) {
			trips.add(generateTrip(body));
		}
		return trips;
	}

	private Trip generateTrip(PlanningCheck body) {
		int numberOfLegs = new Random().nextInt(3) + 1;
		List<Segment> segments = new ArrayList<>();

		Coordinates from = new Coordinates();
		from.setLat(body.getFrom().getLat());
		from.setLng(body.getFrom().getLng());

		Coordinates to = body.getTo();

		BigDecimal deltaX = to.getLat().subtract(from.getLat());
		deltaX = deltaX.divide(BigDecimal.valueOf(numberOfLegs), RoundingMode.DOWN);
		BigDecimal deltaY = to.getLng().subtract(from.getLng());
		deltaY = deltaY.divide(BigDecimal.valueOf(numberOfLegs), RoundingMode.DOWN);
		int deltaT = (body.getEndTime().subtract(body.getStartTime())).intValue();
		deltaT = deltaT / numberOfLegs;

		to = new Coordinates();
		to.setLat(body.getFrom().getLat());
		to.setLng(body.getFrom().getLng());
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
			segment.setAssetType(typeOfAsset);
			
			segment.setStartTime(applyDelta(body.getStartTime(), i, deltaT));
			segment.setEndTime(applyDelta(body.getStartTime(), i + 1, deltaT));

			segments.add(segment);
		}

		Trip trip = new Trip();
		trip.setSegments(segments);
		return trip;
	}

	private void findTransportOperatorsPerLeg(List<Trip> trips) {
		toProvider.clearCache();
		for (Trip trip : trips) {
			for (Segment segment : trip.getSegments()) {
				for (TransportOperator to : toProvider.getTransportOperators(segment)) {
					if (to.providesAssetClass(segment.getAssetType().getAssetClass())) {
						segment.addResult(to, null);
					}
				}
			}
		}
	}

	private void getTransportOperatorInformation(List<Trip> trips, PlanningCheck body) throws ApiException {
		for (Trip trip : trips) {
			for (Segment segment : trip.getSegments()) {
				for (TransportOperator operator : segment.getOperators()) {
					PlanningOptions options = ClientUtil.post(operator, "/planning-options/",
							createPlanningCheck(segment, body), PlanningOptions.class);
					segment.addResult(operator, options);
				}
			}
		}
	}

	private PlanningCheck createPlanningCheck(Segment segment, PlanningCheck body) {
		PlanningCheck check = new PlanningCheck();
		check.from(segment.getFrom());
		check.to(segment.getTo());
		check.setRadius(body.getRadius());
		check.startTime(segment.getStartTime());
		check.endTime(segment.getEndTime());
		check.setUsers(body.getUsers());
		check.setTravellers(body.getTravellers());
		return check;
	}

	private List<Trip> constructBestTrips(List<Trip> allTrips) {
		return allTrips;
	}

	private BigDecimal applyDelta(BigDecimal time, int i, int deltaT) {
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(time.longValue() * 1000);
		instance.add(Calendar.SECOND, i * deltaT);
		return BigDecimal.valueOf(instance.getTimeInMillis() / 1000);
	}

	private Coordinates applyDelta(Coordinates coord, int i, BigDecimal deltaX, BigDecimal deltaY) {
		Coordinates result = new Coordinates();
		result.setLat(coord.getLat().add(deltaX.multiply(BigDecimal.valueOf(i))));
		result.setLng(coord.getLng().add(deltaY.multiply(BigDecimal.valueOf(i))));
		return result;
	}
}
