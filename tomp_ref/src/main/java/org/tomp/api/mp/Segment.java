package org.tomp.api.mp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.swagger.model.PlanningCheck;
import io.swagger.model.PlanningOptions;
import io.swagger.model.TypeOfAsset;

public class Segment extends PlanningCheck {

	private Map<TransportOperator, PlanningOptions> offeredResults = new HashMap<>();
	private TypeOfAsset assetType;

	public void addResult(TransportOperator operator, PlanningOptions result) {
		offeredResults.put(operator, result);
	}

	public PlanningOptions getResult(TransportOperator operator) {
		return offeredResults.get(operator);
	}

	public TypeOfAsset getAssetType() {
		return assetType;
	}

	public void setAssetType(TypeOfAsset assetType) {
		this.assetType = assetType;
	}

	public Set<TransportOperator> getOperators() {
		return offeredResults.keySet();
	}
}
