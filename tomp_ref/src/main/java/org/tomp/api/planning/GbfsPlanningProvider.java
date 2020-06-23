package org.tomp.api.planning;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.providers.assets.AssetProvider;
import org.tomp.api.providers.fares.FareProvider;
import org.tomp.api.repository.GbfsRepository;

import io.swagger.model.AssetClass;
import io.swagger.model.Coordinates;
import io.swagger.model.Fare;
import io.swagger.model.Leg;
import io.swagger.model.PlanningRequest;
import io.swagger.model.TypeOfAsset;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "gbfs", matchIfMissing = false)
public class GbfsPlanningProvider extends BasePlanningProvider {

	@Autowired
	FareProvider fareProvider;

	@Autowired
	AssetProvider assetProvider;

	@Autowired
	GbfsRepository gbfsRepository;

	@Override
	protected ArrayList<Leg> getResults(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		List<TypeOfAsset> assets = gbfsRepository.getNearestAssets(body.getFrom(), body.getRadius());
		ArrayList<Leg> arrayList = new ArrayList<>();

		for (TypeOfAsset assetType : assets) {
			Leg result = new Leg();
			result.setAsset(assetType);
			result.setFrom(getFrom());
			result.setTo(getTo());
			result.setStartTime(getStartTime());
			result.setEndTime(getEndTime());
			result.setPricing(getFare());
			result.setConditions(getConditionsForLeg(result, acceptLanguage));

			Coordinates assetLocation = getAssetLocation(assetType);
			if (assetLocation == null) {
				assetLocation = body.getFrom().getCoordinates();
			}

			Leg byFoot = new Leg();
			TypeOfAsset asset = new TypeOfAsset();
			asset.setAssetClass(AssetClass.FOOT);
			byFoot.setAsset(asset);
			byFoot.setFrom(getFrom());
			byFoot.setTo(assetLocation);
			byFoot.setStartTime(body.getStartTime());
			byFoot.setEndTime(body.getStartTime().plusMinutes(5));
			result.addPartsItem(byFoot);

			Leg byBike = new Leg();
			byBike.setAsset(assetType);
			byBike.setFrom(assetLocation);
			byBike.setTo(getTo());
			byBike.setStartTime(body.getStartTime().plusMinutes(5));
			byBike.setEndTime(body.getEndTime());
			result.addPartsItem(byBike);

			arrayList.add(result);
		}
		return arrayList;
	}

	private Coordinates getAssetLocation(TypeOfAsset assetType) {
		if (assetType != null && !assetType.getAssets().isEmpty() && assetType.getAssets().get(0).getPlace() != null) {
			return assetType.getAssets().get(0).getPlace().getCoordinates();
		}
		return null;
	}

	@Override
	protected Fare getFare() {
		return fareProvider.getFare();
	}

	@Override
	protected TypeOfAsset getAssetType() {
		return assetProvider.getTypeOfAsset();
	}

}
