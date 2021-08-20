package org.tomp.api.planning;

import java.util.*;

import javax.validation.Valid;

import io.swagger.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.threeten.bp.OffsetDateTime;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.providers.conditions.ConditionProvider;
import org.tomp.api.repository.DefaultRepository;
import org.tomp.api.utils.LegUtil;

public abstract class BasePlanningProvider implements PlanningProvider {

	private static final Logger log = LoggerFactory.getLogger(BasePlanningProvider.class);

	protected Place from;
	protected Place to;
	protected @Valid OffsetDateTime start;
	protected @Valid OffsetDateTime end;
	protected String assetId = "";
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

		if (body.getUseAssets() != null) {
			assetId = body.getUseAssets().get(0);
		}else {
			assetId = "";
		}

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

		Asset asset = new Asset();
		asset.setId(assetId);

		Leg leg = new Leg();
		leg.setAssetType(getAssetType());
		leg.setFrom(body.getFrom());
		leg.setTo(body.getTo());

		//Add conditons
		Condition condition1 = new Condition();
		condition1.setConditionType("conditionRequireBookingData");
		condition1.setId("minAge18");

		Condition condition2 = new Condition();
		condition2.setConditionType("conditionRequireBookingData");
		condition2.setId("driverLicense");

		List<Condition> conditions = new ArrayList<>();

		conditions.add(condition1);
		conditions.add(condition2);

		log.info("conditons: {}", conditions);

		leg.setConditions(conditions);
		leg.setDepartureTime(getStartTime());
		leg.setArrivalTime(getEndTime());
		leg.setAsset(asset);
		leg.setPricing(getFare());

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
