package org.tomp.api.tripexecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.repository.DummyRepository;

import io.swagger.model.LegEvent;
import io.swagger.model.SimpleLeg;

@Component
@Profile(value = { "dummy", "bike", "bus", "train", "car" })
public class DummyTripExecutionProvider implements TripExecutionProvider {

	@Autowired
	DummyRepository repository;

	@Override
	public void addNewTripEvent(LegEvent body, String acceptLanguage, String id) {
		repository.saveLegEvent(id, body);

		switch (body.getEvent()) {
		case ASSIGN_ASSET:
			break;
		case FINISH:
			break;
		case ISSUE:
			break;
		case PAUSE:
			break;
		case PREPARE:
			break;
		case SET_IN_USE:
			startTrip(id, body);
			break;
		case START_FINISHING:
			break;
		default:
			break;
		}
	}

	private void startTrip(String id, LegEvent body) {
		SimpleLeg savedOption = repository.getSavedOption(id);
		System.out.println("Starting trip " + id);
	}

}
