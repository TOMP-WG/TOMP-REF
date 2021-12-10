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
import io.swagger.model.OneOflegConditionsItems;

@Component
@ConditionalOnProperty(value = "tomp.condition-file", matchIfMissing = false)
public class FileBasedConditionProvider implements ConditionProvider {

	@Autowired
	protected ExternalConfiguration configuration;

	public List<OneOflegConditionsItems> getConditions(String acceptLanguage) {
		ObjectFromFileProvider<OneOflegConditionsItems[]> conditionFileProvider = new ObjectFromFileProvider<>();
		OneOflegConditionsItems[] conditions = conditionFileProvider.getObject(acceptLanguage,
				OneOflegConditionsItems[].class, configuration.getConditionFile());
		List<OneOflegConditionsItems> conditionList = new ArrayList<>();
		for (OneOflegConditionsItems c : conditions) {
			conditionList.add(c);
		}
		return conditionList;
	}

	@Override
	public List<OneOflegConditionsItems> getApplyingConditions(String acceptLanguage, Leg result) {
		return getConditions(acceptLanguage);
	}

}
