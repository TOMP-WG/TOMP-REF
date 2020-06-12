package org.tomp.api.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.swagger.model.Leg;
import io.swagger.model.Planning;

public class Segment extends Leg {

	private Map<TransportOperator, Planning> offeredResults = new HashMap<>();

	public void addResult(TransportOperator operator, Planning result) {
		offeredResults.put(operator, result);
	}

	public Planning getResult(TransportOperator operator) {
		return offeredResults.get(operator);
	}

	public Planning getResult(String operatorId) {
		for (Entry<TransportOperator, Planning> entry : offeredResults.entrySet()) {
			if (entry.getKey().getId().equals(operatorId))
				return offeredResults.get(entry.getKey());
		}
		return null;
	}

	public Set<TransportOperator> getOperators() {
		return offeredResults.keySet();
	}
}
