package org.tomp.api.planning;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.threeten.bp.temporal.ChronoUnit;

import io.swagger.model.Condition;
import io.swagger.model.ConditionPostponedCommit;
import io.swagger.model.ConditionRequireBookingData;
import io.swagger.model.Leg;
import io.swagger.model.OneOflegConditionsItems;
import io.swagger.model.ConditionRequireBookingData.RequiredFieldsEnum;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "taxi", matchIfMissing = false)
public class TaxiPlanningProvider extends SharedCarPlanningProvider {

	@Override
	protected List<OneOflegConditionsItems> getConditionsForLeg(Leg leg, String acceptLanguage) {
		List<OneOflegConditionsItems> conditions = new ArrayList<>();
		ConditionPostponedCommit condition = new ConditionPostponedCommit();
		condition.setConditionType("conditionPostponedCommit");
		condition.setUltimateResponseTime(ChronoUnit.SECONDS.addTo(this.getStartTime(), -3600));
		conditions.add(condition);

		ConditionRequireBookingData bookingDataCondition = new ConditionRequireBookingData();
		bookingDataCondition.setConditionType("conditionRequireBookingData");
		bookingDataCondition.addRequiredFieldsItem(RequiredFieldsEnum.FROM_ADDRESS);
		bookingDataCondition.addRequiredFieldsItem(RequiredFieldsEnum.TO_ADDRESS);
		conditions.add(bookingDataCondition);

		return conditions;
	}
}
