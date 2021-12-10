package org.tomp.api.planning;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
import io.swagger.model.AssetType;
import io.swagger.model.Booking;
import io.swagger.model.Coordinates;
import io.swagger.model.Leg;
import io.swagger.model.Place;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;
import io.swagger.model.Requirements;
import io.swagger.model.Suboperator;
import io.swagger.model.Traveler;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "maasprovider", matchIfMissing = false)
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
		// option.setConditions(gatherConditions(trips));
		// option.setValidUntil(getMinimalValidUntil(trips));
		option.setOptions(gatherResults(trips));
		return option;
	}

	private List<Booking> gatherResults(List<Trip> trips) {
		List<Booking> results = new ArrayList<>();
		for (Trip trip : trips) {
			Booking booking = new Booking();

			List<Leg> constructOperatorLegs = constructOperatorLegs(trip);

			booking.setLegs(constructOperatorLegs);

			results.add(booking);

			repository.saveBooking(booking, trip);
		}
		return results;
	}

	private List<Leg> constructOperatorLegs(Trip trip) {
		List<Leg> legs = new ArrayList<>();
		for (Segment segment : trip.getSegments()) {
			// take first operator
			TransportOperator operator = segment.getOperators().iterator().next();
			Planning options = segment.getResult(operator);
			Leg leg = options.getOptions().get(0).getLegs().get(0);
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
		for (Traveler user : body.getTravelers()) {
			// you can apply your knowledge of the end user in the body. It will be passed
			// to the TOs
			user.setIsValidated(true);
			if (first) {
				Requirements requirements = new Requirements();
				requirements.put("CROW-RK", "HR-02");
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

		Float deltaX = to.getLat() - from.getLat();
		deltaX = deltaX / numberOfLegs;
		Float deltaY = to.getLng() - from.getLng();
		deltaY = deltaY / numberOfLegs;
		// int deltaT = (body.getEndTime().subtract(body.getStartTime())).intValue();
		long deltaT = ChronoUnit.SECONDS.between(body.getArrivalTime(), body.getDepartureTime());
		deltaT = deltaT / numberOfLegs;

		to = new Coordinates();
		to.setLat(body.getFrom().getCoordinates().getLat());
		to.setLng(body.getFrom().getCoordinates().getLng());
		to = applyDelta(to, 1, deltaX, deltaY);

		for (int i = 0; i < numberOfLegs; i++) {
			Segment segment = new Segment();
			AssetType typeOfAsset = new AssetType();

			segment.setFrom(toPlace(from));
			segment.setTo(toPlace(to));

			from = applyDelta(from, i + 1, deltaX, deltaY);
			to = applyDelta(to, i + 1, deltaX, deltaY);

			List<TransportOperator> transportOperators = toProvider.getTransportOperators(segment);
			int index = new Random().nextInt(transportOperators.size());
			AssetClass assetClass = transportOperators.get(index).getAssetClasses().get(0);
			typeOfAsset.setAssetClass(assetClass);
			segment.setAssetType(typeOfAsset);

			segment.setDepartureTime(applyDelta(body.getDepartureTime(), i, deltaT));
			segment.setArrivalTime(applyDelta(body.getArrivalTime(), i + 1, deltaT));

			segments.add(segment);
		}

		Trip trip = new Trip();
		trip.setSegments(segments);
		return trip;
	}

	private Place toPlace(Coordinates coord) {
		Place place = new Place();
		place.setCoordinates(coord);
		return place;
	}

	private void findTransportOperatorsPerLeg(List<Trip> trips) {
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
		check.from(segment.getFrom());
		check.to(segment.getTo());
		check.setRadius(body.getRadius());
		check.departureTime(segment.getDepartureTime());
		check.arrivalTime(segment.getArrivalTime());
		check.setTravelers(body.getTravelers());
		return check;
	}

	private List<Trip> constructBestTrips(List<Trip> allTrips) {
		return allTrips;
	}

	private OffsetDateTime applyDelta(@Valid OffsetDateTime offsetDateTime, int i, long deltaT) {
		return ChronoUnit.SECONDS.addTo(offsetDateTime, i * deltaT);
	}

	private Coordinates applyDelta(Coordinates coord, int i, Float deltaX, Float deltaY) {
		Coordinates result = new Coordinates();
		result.setLat(coord.getLat() + (deltaX * i));
		result.setLng(coord.getLng() + (deltaY * i));
		return result;
	}
}
