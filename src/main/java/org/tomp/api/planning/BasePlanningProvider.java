package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.mp.ObjectFromFileProvider;
import org.tomp.api.repository.DummyRepository;

import io.swagger.model.Condition;
import io.swagger.model.Coordinate;
import io.swagger.model.Fare;
import io.swagger.model.OptionsLeg;
import io.swagger.model.PlanningCheck;
import io.swagger.model.PlanningOptions;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;
import io.swagger.model.TypeOfAsset;

@Component
public abstract class BasePlanningProvider implements PlanningProvider {

	@NotNull
	@Valid
	protected Coordinate from;
	protected @Valid Coordinate to;
	protected @Valid BigDecimal start;
	protected @Valid BigDecimal end;

	@Autowired
	private DummyRepository repository;

	@Autowired
	ExternalConfiguration configuration;

	public PlanningOptions getOptions(@Valid PlanningCheck body, String acceptLanguage) {
		System.out.println("Request for options");
		boolean provideIds = body.isProvideIds() != null && body.isProvideIds().booleanValue();

		PlanningOptions options = new PlanningOptions();
		options.setConditions(getConditions(acceptLanguage));
		from = body.getFrom();
		to = body.getTo();
		start = body.getStartTime();
		end = body.getEndTime();
		options.setResults(getResults(body));

		if (provideIds) {
			repository.saveOptions(options);
		} else {
			System.out.println("Forget this one");
		}
		return options;
	}

	protected List<Condition> getConditions(String acceptLanguage) {
		ObjectFromFileProvider<Condition[]> conditionFileProvider = new ObjectFromFileProvider<>();
		Condition[] conditions = conditionFileProvider.getObject(acceptLanguage, Condition[].class,
				configuration.getConditionFile());
		List<Condition> conditionList = new ArrayList<>();
		for (Condition c : conditions) {
			conditionList.add(c);
		}
		return conditionList;
	}

	protected ArrayList<PlanningResult> getResults(@Valid PlanningCheck body) {
		boolean provideIds = body.isProvideIds() != null && body.isProvideIds().booleanValue();

		ArrayList<PlanningResult> arrayList = new ArrayList<>();
		SimpleLeg result = new SimpleLeg();
		result.setTypeOfAsset(getAssetType());
		result.setLeg(getLeg());
		result.setPricing(getFare());
		if (provideIds) {
			System.out.println(
					"We have to take a closer look. Can we more or less guarantee that we can fulfill this request?");
			result.setId(UUID.randomUUID().toString());
		}
		arrayList.add(result);

		return arrayList;
	}

	protected abstract Fare getFare();

	protected abstract OptionsLeg getLeg();

	protected abstract TypeOfAsset getAssetType();

}
