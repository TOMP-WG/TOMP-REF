package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.threeten.bp.temporal.ChronoUnit;
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
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "shared-car", matchIfMissing = false)
public class SharedCarPlanningProvider extends GenericPlanningProvider {

	@Autowired
	public SharedCarPlanningProvider(DummyRepository repository, ExternalConfiguration configuration) {
		super(repository, configuration);
	}

	@Override
	public Planning getOptions(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		return super.getOptions(body, acceptLanguage, bookingIntent);
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
	protected List<Condition> getConditions(String acceptLanguage) {
		List<Condition> conditions = super.getConditions(acceptLanguage);
		ConditionPostponedCommit condition = new ConditionPostponedCommit();

		condition.setUltimateResponseTime(ChronoUnit.SECONDS.addTo(this.getStartTime(), -3600));
		conditions.add(condition);

		ConditionRequireBookingData bookingDataCondition = new ConditionRequireBookingData();
		bookingDataCondition.addRequiredFieldsItem(RequiredFieldsEnum.LICENSES);
		conditions.add(bookingDataCondition);

		return conditions;
	}
}
