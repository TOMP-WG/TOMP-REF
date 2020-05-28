package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.repository.DummyRepository;

import io.swagger.model.Condition;
import io.swagger.model.ConditionPostponedCommit;
import io.swagger.model.ConditionRequireBookingData;
import io.swagger.model.ConditionRequireBookingData.RequiredFieldsEnum;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.FarePart.UnitTypeEnum;
import io.swagger.model.OptionsLeg;
import io.swagger.model.PlanningCheck;
import io.swagger.model.PlanningOptions;

@Component
@Profile("shared-car")
public class SharedCarPlanningProvider extends GenericPlanningProvider {

	@Autowired
	public SharedCarPlanningProvider(DummyRepository repository, ExternalConfiguration configuration) {
		super(repository, configuration);
	}

	private BigDecimal startTime;
	private PlanningCheck planningCheck;

	@Override
	public PlanningOptions getOptions(@Valid PlanningCheck body, String acceptLanguage) {
		startTime = body.getStartTime();
		this.planningCheck = body;
		return super.getOptions(body, acceptLanguage);
	}

	@Override
	protected Fare getFare() {
		Fare fare = new Fare();
		fare.setEstimated(true);

		FarePart part = new FarePart();
		part.setAmount(BigDecimal.valueOf(5));
		part.setCurrencyCode("EUR");
		part.setType(TypeEnum.FIXED);
		fare.addPartsItem(part);

		FarePart part2 = new FarePart();
		part2.setAmount(BigDecimal.valueOf(1));
		part2.setCurrencyCode("EUR");
		part2.setType(TypeEnum.FLEX);
		part2.setUnits(BigDecimal.valueOf(0.5));
		part2.setUnitType(UnitTypeEnum.HOUR);
		fare.addPartsItem(part2);
		return fare;
	}

	@Override
	protected OptionsLeg getLeg() {
		OptionsLeg leg = new OptionsLeg();
		leg.setStartTime(planningCheck.getStartTime());
		leg.setEndTime(planningCheck.getEndTime());
		leg.setFrom(planningCheck.getFrom());
		leg.setTo(planningCheck.getTo());
		return leg;
	}

	@Override
	protected List<Condition> getConditions(String acceptLanguage) {
		List<Condition> conditions = super.getConditions(acceptLanguage);
		ConditionPostponedCommit condition = new ConditionPostponedCommit();
		condition.setUltimateResponseTime(startTime.subtract(BigDecimal.valueOf(3600)));
		conditions.add(condition);

		ConditionRequireBookingData bookingDataCondition = new ConditionRequireBookingData();
		bookingDataCondition.addRequiredFieldsItem(RequiredFieldsEnum.LICENSES);
		conditions.add(bookingDataCondition);

		return conditions;
	}
}
