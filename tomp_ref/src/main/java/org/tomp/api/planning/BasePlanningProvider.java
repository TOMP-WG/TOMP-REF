package org.tomp.api.planning;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.threeten.bp.OffsetDateTime;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.providers.conditions.ConditionProvider;
import org.tomp.api.repository.DefaultRepository;
import org.tomp.api.utils.LegUtil;

import io.swagger.model.AssetType;
import io.swagger.model.Booking;
import io.swagger.model.BookingState;
import io.swagger.model.Condition;
import io.swagger.model.Fare;
import io.swagger.model.Leg;
import io.swagger.model.Place;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;

public abstract class BasePlanningProvider implements PlanningProvider {

	private static final Logger log = LoggerFactory.getLogger(BasePlanningProvider.class);

	protected Place from;
	protected Place to;
	protected @Valid OffsetDateTime start;
	protected @Valid OffsetDateTime end;

	@Autowired
	protected DefaultRepository repository;
	@Autowired
	protected ExternalConfiguration configuration;
	@Autowired
	protected ConditionProvider conditionProvider;

	@Autowired
	LegUtil legUtil;

	public Planning getOptions(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		log.info("Request for options");
		boolean provideIds = bookingIntent;

		Planning options = new Planning();
		from = body.getFrom();
		to = body.getTo();
		start = body.getDepartureTime();
		end = body.getArrivalTime();
		options.setOptions(getResults(body, acceptLanguage, bookingIntent));
		if (provideIds) {
			repository.saveBookingOption(options);
		} else {
			log.info("Forget this one");
		}
		return options;
	}

	protected List<Booking> getResults(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		boolean provideIds = bookingIntent;

		Booking booking = new Booking();
		booking.setState(BookingState.NEW);

		Leg leg = new Leg();
		leg.setAssetType(getAssetType());
		leg.setFrom(body.getFrom());
		leg.setTo(body.getTo());
		leg.setDepartureTime(getStartTime());
		leg.setArrivalTime(getEndTime());
		if (getEndTime() == null) {
			double duration = legUtil.getDuration(leg);
			leg.setArrivalTime(getStartTime().plusSeconds((long) duration));
		}
		leg.setPricing(getFare());
		leg.setConditions(getConditionsForLeg(leg, acceptLanguage));

		if (provideIds) {
			String uuid = UUID.randomUUID().toString();
			leg.setId(uuid);
			log.info("Generated uuid: {}", uuid);
			booking.setId(uuid);
		}
		booking.setLegs(Arrays.asList(leg));
		booking.setFrom(body.getFrom());
		booking.setTo(body.getTo());
//		booking.setDepartureTime(leg.getDepartureTime());
//		booking.setArrivalTime(leg.getArrivalTime());
//		booking.setNrOfTravelers(body.getNrOfTravelers());
		booking.setPricing(leg.getPricing());
//		booking.setRadius(body.getRadius());
		return Arrays.asList(booking);
	}

	protected OffsetDateTime getEndTime() {
		return end;
	}

	protected OffsetDateTime getStartTime() {
		return start;
	}

	protected List<Condition> getConditionsForLeg(Leg result, String acceptLanguage) {
		return conditionProvider.getApplyingConditions(acceptLanguage, result);
	}

	protected abstract Fare getFare();

	protected abstract AssetType getAssetType();

}
