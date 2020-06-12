package org.tomp.api.tripexecution;

import io.swagger.model.Execution;
import io.swagger.model.ExecutionEvent;

public interface TripExecutionProvider {

	Execution prepare(ExecutionEvent body, String acceptLanguage, String id, String maasId);

	Execution assignAsset(ExecutionEvent body, String acceptLanguage, String id, String maasId);

	Execution reserve(ExecutionEvent body, String acceptLanguage, String id, String maasId);

	Execution setInUse(ExecutionEvent body, String acceptLanguage, String id, String maasId);

	Execution pause(ExecutionEvent body, String acceptLanguage, String id, String maasId);

	Execution startFinishing(ExecutionEvent body, String acceptLanguage, String id, String maasId);

	Execution finish(ExecutionEvent body, String acceptLanguage, String id, String maasId);

}
