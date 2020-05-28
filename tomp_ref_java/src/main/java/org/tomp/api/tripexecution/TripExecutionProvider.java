package org.tomp.api.tripexecution;

import io.swagger.model.Leg;
import io.swagger.model.LegEvent;

public interface TripExecutionProvider {

	Leg prepare(LegEvent body, String acceptLanguage, String id, String maasId);

	Leg assignAsset(LegEvent body, String acceptLanguage, String id, String maasId);

	Leg reserve(LegEvent body, String acceptLanguage, String id, String maasId);

	Leg setInUse(LegEvent body, String acceptLanguage, String id, String maasId);

	Leg pause(LegEvent body, String acceptLanguage, String id, String maasId);

	Leg startFinishing(LegEvent body, String acceptLanguage, String id, String maasId);

	Leg finish(LegEvent body, String acceptLanguage, String id, String maasId);

}
