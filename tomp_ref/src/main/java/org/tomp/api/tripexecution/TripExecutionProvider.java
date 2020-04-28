package org.tomp.api.tripexecution;

import io.swagger.model.LegEvent;

public interface TripExecutionProvider {

	void addNewTripEvent(LegEvent body, String acceptLanguage, String id);

}
