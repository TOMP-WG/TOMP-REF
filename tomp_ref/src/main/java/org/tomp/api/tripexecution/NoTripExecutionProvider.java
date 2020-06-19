package org.tomp.api.tripexecution;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.model.Execution;
import io.swagger.model.ExecutionEvent;

@Component
@ConditionalOnProperty(value = "tomp.providers.tripexecution", havingValue = "none", matchIfMissing = false)
public class NoTripExecutionProvider implements TripExecutionProvider {

	@Override
	public Execution prepare(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Execution assignAsset(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Execution reserve(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Execution setInUse(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Execution pause(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Execution startFinishing(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Execution finish(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

}
