package org.tomp.api.providers.conditions;

import java.util.List;

import io.swagger.model.Condition;
import io.swagger.model.Leg;

public interface ConditionProvider {
	public List<Condition> getApplyingConditions(String acceptLanguage, Leg result);
}
