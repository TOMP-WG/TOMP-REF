package org.tomp.api.providers.conditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.utils.ObjectFromFileProvider;

import io.swagger.model.Condition;
import io.swagger.model.Leg;

@Component
@ConditionalOnProperty(value = "tomp.condition-file", matchIfMissing = false)
public class FileBasedConditionProvider implements ConditionProvider {

	@Autowired
	protected ExternalConfiguration configuration;

	@Override
	public List<Condition> getConditions(String acceptLanguage) {
		ObjectFromFileProvider<Condition[]> conditionFileProvider = new ObjectFromFileProvider<>();
		Condition[] conditions = conditionFileProvider.getObject(acceptLanguage, Condition[].class,
				configuration.getConditionFile());
		List<Condition> conditionList = new ArrayList<>();
		for (Condition c : conditions) {
			conditionList.add(c);
		}
		return conditionList;
	}

	@Override
	public List<String> getApplyingConditions(String acceptLanguage, Leg result) {
		Random r = new Random();
		return getConditions(acceptLanguage).stream().filter(x -> r.nextBoolean()).map(Condition::getId).collect(Collectors.toList());
	}

}
