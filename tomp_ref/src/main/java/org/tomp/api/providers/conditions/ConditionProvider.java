package org.tomp.api.providers.conditions;

import java.util.List;

import io.swagger.model.Condition;

public interface ConditionProvider {
	public List<Condition> getConditions(String acceptLanguage);
}
