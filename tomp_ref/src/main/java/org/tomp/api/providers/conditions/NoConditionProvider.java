package org.tomp.api.providers.conditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;

import io.swagger.model.Condition;
import io.swagger.model.Leg;

@Component
@ConditionalOnProperty(value = "tomp.condition-file", havingValue = "empty", matchIfMissing = false)
public class NoConditionProvider implements ConditionProvider {

	@Autowired
	protected ExternalConfiguration configuration;

	@Override
	public List<Condition> getApplyingConditions(String acceptLanguage, Leg result) {
		return new ArrayList<>();
	}
}
