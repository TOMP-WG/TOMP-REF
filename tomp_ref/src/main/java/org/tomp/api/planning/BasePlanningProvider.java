package org.tomp.api.planning;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.threeten.bp.OffsetDateTime;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.providers.conditions.ConditionProvider;
import org.tomp.api.repository.DummyRepository;

import io.swagger.model.Condition;
import io.swagger.model.Coordinates;
import io.swagger.model.Fare;
import io.swagger.model.Leg;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;
import io.swagger.model.TypeOfAsset;

public abstract class BasePlanningProvider implements PlanningProvider {

	private static final Logger log = LoggerFactory.getLogger(BasePlanningProvider.class);

	protected Coordinates from;
	protected Coordinates to;
	protected @Valid OffsetDateTime start;
	protected @Valid OffsetDateTime end;

	@Autowired
	protected DummyRepository repository;
	@Autowired
	protected ExternalConfiguration configuration;
	@Autowired
	protected ConditionProvider conditionProvider;

	public Planning getOptions(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		log.info("Request for options");
		boolean provideIds = bookingIntent;

		Planning options = new Planning();
		from = body.getFrom().getCoordinates();
		to = body.getTo().getCoordinates();
		start = body.getStartTime();
		end = body.getEndTime();
		options.setConditions(getConditions(acceptLanguage));
		options.setLegOptions(getResults(body, bookingIntent));

		if (provideIds) {
			repository.saveOptions(options);
		} else {
			log.info("Forget this one");
		}
		return options;
	}

	protected List<Condition> getConditions(String acceptLanguage) {
		return conditionProvider.getConditions(acceptLanguage);
	}

	protected ArrayList<Leg> getResults(@Valid PlanningRequest body, boolean bookingIntent) {
		boolean provideIds = bookingIntent;

		ArrayList<Leg> arrayList = new ArrayList<>();
		Leg result = new Leg();
		result.setAsset(getAssetType());
		result.setFrom(getFrom());
		result.setTo(getTo());
		result.setStartTime(getStartTime());
		result.setEndTime(getEndTime());
		result.setPricing(getFare());
		result.setConditions(getConditionsForLeg(result));
		if (provideIds) {
			String uuid = UUID.randomUUID().toString();
			result.setId(uuid);
			log.info("Save this leg: {}", uuid);
		}
		arrayList.add(result);

		return arrayList;
	}

	protected OffsetDateTime getEndTime() {
		return end;
	}

	protected OffsetDateTime getStartTime() {
		return start;
	}

	protected Coordinates getTo() {
		return to;
	}

	protected Coordinates getFrom() {
		return from;
	}

	protected List<String> getConditionsForLeg(Leg result) {
		return new ArrayList<>();
	}

	protected abstract Fare getFare();

	protected abstract TypeOfAsset getAssetType();

}
