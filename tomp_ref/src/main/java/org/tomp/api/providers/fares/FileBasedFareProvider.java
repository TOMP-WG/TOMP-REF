package org.tomp.api.providers.fares;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.utils.ObjectFromFileProvider;

import io.swagger.model.Fare;

@Component
@Primary
@ConditionalOnProperty(value = "tomp.fare-file", matchIfMissing = false)
public class FileBasedFareProvider implements FareProvider {

	@Autowired
	ExternalConfiguration configuration;

	@Override
	public Fare getFare() {
		ObjectFromFileProvider<Fare> conditionFileProvider = new ObjectFromFileProvider<>();
		return conditionFileProvider.getObject("", Fare.class, configuration.getFareFile());
	}

}
