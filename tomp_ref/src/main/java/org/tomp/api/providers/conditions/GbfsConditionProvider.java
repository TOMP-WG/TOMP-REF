package org.tomp.api.providers.conditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.repository.GbfsRepository;
import org.tomp.api.utils.GeoUtil;

import io.swagger.model.Condition;
import io.swagger.model.ConditionReturnArea;
import io.swagger.model.Leg;
import io.swagger.model.StationInformation;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "gbfs", matchIfMissing = false)
public class GbfsConditionProvider implements ConditionProvider {

	@Autowired
	GbfsRepository repository;

	public List<Condition> getConditions(String acceptLanguage) {
		ArrayList<Condition> conditions = new ArrayList<>();
		for (StationInformation station : repository.getStations()) {
			ConditionReturnArea condition = new ConditionReturnArea();
			condition.setId("RA_" + station.getStationId());
			condition.setCoordinates(station.getCoordinates());
			condition.setStationId(station.getStationId());
			condition.setReturnHours(repository.getSystemHours());
			condition.setReturnArea(GeoUtil.toPolygon(station.getCoordinates(), 0.0001));
			conditions.add(condition);
		}
		return conditions;
	}

	@Override
	public List<Condition> getApplyingConditions(String acceptLanguage, Leg leg) {
		String fromStationId = leg.getAssetType().getAssets().get(0).getOverriddenProperties().getLocation().getStationId();
		return getConditions(acceptLanguage).stream().filter(x -> x.getId().equals("RA_" + fromStationId))
				.collect(Collectors.toList());
	}

}
