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
import io.swagger.model.OneOflegConditionsItems;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "shared-car", matchIfMissing = false)
public class SharedCarPlanningProvider extends GenericPlanningProvider {

	@Override
	protected Fare getFare() {
		Fare fare = new Fare();
		fare.setEstimated(true);

		FarePart part = new FarePart();
		part.setAmount(5F);
		part.setCurrencyCode("EUR");
		part.setType(TypeEnum.FIXED);
		fare.addPartsItem(part);

		FarePart part2 = new FarePart();
		part2.setAmount(1F);
		part2.setCurrencyCode("EUR");
		part2.setType(TypeEnum.FLEX);
		part2.setUnits(0.5F);
		part2.setUnitType(UnitTypeEnum.HOUR);
		fare.addPartsItem(part2);
		return fare;
	}

	@Override
	protected List<OneOflegConditionsItems> getConditionsForLeg(Leg leg, String acceptLanguage) {
		List<OneOflegConditionsItems> conditions = super.getConditionsForLeg(leg, acceptLanguage);
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
