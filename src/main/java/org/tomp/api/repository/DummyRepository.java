package org.tomp.api.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.swagger.model.LegEvent;
import io.swagger.model.PlanningOptions;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;

@Component
public class DummyRepository {

	public Map<String, PlanningOptions> options = new HashMap<>();

	public void saveOptions(PlanningOptions optionsToSave) {
		for (PlanningResult result : optionsToSave.getResults()) {
			if (result instanceof SimpleLeg) {
				SimpleLeg leg = (SimpleLeg) result;
				options.put(leg.getId(), optionsToSave);
				System.out.println("I've got to remember this leg: " + leg.getId());
			}
		}
	}

	public SimpleLeg getSavedOption(String id) {
		PlanningOptions planningOptions = options.get(id);
		if (planningOptions == null) {
			System.out.println("missing leg: " + id);
			return null;
		}
		for (PlanningResult result : planningOptions.getResults()) {
			if (result instanceof SimpleLeg) {
				SimpleLeg leg = (SimpleLeg) result;
				if (leg.getId().equals(id)) {
					return leg;
				}
			}
		}
		return null;
	}

	public void saveLegEvent(String id, LegEvent body) {
		// TODO Auto-generated method stub
		
	}
}
