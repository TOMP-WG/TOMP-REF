package org.tomp.api.providers.conditions;

import java.util.List;

import io.swagger.model.Condition;
import io.swagger.model.Leg;
import io.swagger.model.OneOflegConditionsItems;

public interface ConditionProvider {
	public List<OneOflegConditionsItems> getApplyingConditions(String acceptLanguage, Leg result);
}
