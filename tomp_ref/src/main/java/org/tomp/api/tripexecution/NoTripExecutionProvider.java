package org.tomp.api.tripexecution;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.model.Leg;
import io.swagger.model.LegEvent;

@Component
@ConditionalOnProperty(value = "tomp.providers.tripexecution", havingValue = "none", matchIfMissing = false)
public class NoTripExecutionProvider implements TripExecutionProvider {

	@Override
	public Leg prepare(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg assignAsset(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg reserve(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg setInUse(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg pause(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg startFinishing(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg finish(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

}
