package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.threeten.bp.temporal.ChronoUnit;

import io.swagger.model.Condition;
import io.swagger.model.ConditionPostponedCommit;
import io.swagger.model.ConditionRequireBookingData;
import io.swagger.model.ConditionRequireBookingData.RequiredFieldsEnum;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.FarePart.UnitTypeEnum;
import io.swagger.model.Leg;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "shared-car", matchIfMissing = false)
public class SharedCarPlanningProvider extends GenericPlanningProvider {

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
	protected List<Condition> getConditionsForLeg(Leg leg, String acceptLanguage) {
		List<Condition> conditions = super.getConditionsForLeg(leg, acceptLanguage);
		ConditionPostponedCommit condition = new ConditionPostponedCommit();
		condition.setConditionType("conditionPostponedCommit");

		condition.setUltimateResponseTime(ChronoUnit.SECONDS.addTo(this.getStartTime(), -3600));
		conditions.add(condition);

		ConditionRequireBookingData bookingDataCondition = new ConditionRequireBookingData();
		bookingDataCondition.setConditionType("conditionRequireBookingData");
		bookingDataCondition.addRequiredFieldsItem(RequiredFieldsEnum.LICENSES);
		conditions.add(bookingDataCondition);

		return conditions;
	}
}
