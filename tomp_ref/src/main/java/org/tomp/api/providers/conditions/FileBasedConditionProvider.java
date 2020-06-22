package org.tomp.api.providers.conditions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.utils.ObjectFromFileProvider;

import io.swagger.model.Condition;

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

}
