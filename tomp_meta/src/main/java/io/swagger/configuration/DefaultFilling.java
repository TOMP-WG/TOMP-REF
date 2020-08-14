package io.swagger.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.model.MaasOperator;

@Component
public class DefaultFilling {

	Registry repository;
	MetaLookUpConfiguration configuration;

	@Autowired
	public DefaultFilling(Registry repository, MetaLookUpConfiguration configuration) {
		this.repository = repository;
		this.configuration = configuration;

		ObjectFromFileProvider<MaasOperator[]> provider = new ObjectFromFileProvider<>();

		MaasOperator[] operators = provider.getObject("", MaasOperator[].class, configuration.getOperatorFile());
		if (operators != null) {
			for (int i = 0; i < operators.length; i++) {
				MaasOperator operator = operators[i];
				repository.register(operator);
			}
		}
	}
}
