package org.tomp.api.providers.fares;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import io.swagger.model.Fare;

@Component
@ConditionalOnProperty(value = "tomp.fare-file", matchIfMissing = true)
public class NoFareProvider implements FareProvider {

	@Override
	public Fare getFare() {
		return new Fare();
	}
}
