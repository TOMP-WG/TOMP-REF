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
import io.swagger.model.AssetType;
import io.swagger.model.Booking;
import io.swagger.model.Fare;
import io.swagger.model.Leg;
import io.swagger.model.Place;
import io.swagger.model.PlanningRequest;

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
	protected ArrayList<Booking> getResults(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		List<AssetType> assets = gbfsRepository.getNearestAssets(body.getFrom(), body.getRadius());
		ArrayList<Booking> bookingList = new ArrayList<>();

		for (AssetType assetType : assets) {
			Booking booking = new Booking();
			Leg leg = new Leg();
			leg.setAssetType(assetType);
			leg.setFrom(from);
			leg.setTo(to);
			leg.setDepartureTime(getStartTime());
			leg.setArrivalTime(getEndTime());
			leg.setPricing(getFare());
			leg.setConditions(getConditionsForLeg(leg, acceptLanguage));

			Place assetLocation = getAssetLocation(assetType);
			if (assetLocation == null) {
				assetLocation = body.getFrom();
			}
			booking.addLegsItem(leg);

			Leg byFoot = new Leg();
			AssetType asset = new AssetType();
			asset.setAssetClass(AssetClass.FOOT);
			byFoot.setAssetType(asset);
			byFoot.setFrom(from);
			byFoot.setTo(assetLocation);
			byFoot.setDepartureTime(body.getDepartureTime());
			byFoot.setArrivalTime(body.getArrivalTime().plusMinutes(5));
			booking.addLegsItem(byFoot);

			Leg byBike = new Leg();
			byBike.setAssetType(assetType);
			byBike.setFrom(assetLocation);
			byBike.setTo(to);
			byBike.setDepartureTime(body.getDepartureTime().plusMinutes(5));
			byBike.setArrivalTime(body.getArrivalTime());
			booking.addLegsItem(byBike);

			bookingList.add(booking);
		}
		return bookingList;
	}

	private Place getAssetLocation(AssetType assetType) {
		if (assetType != null && !assetType.getAssets().isEmpty()
				&& assetType.getAssets().get(0).getOverriddenProperties().getLocation() != null) {
			return assetType.getAssets().get(0).getOverriddenProperties().getLocation();
		}
		return null;
	}

	@Override
	protected Fare getFare() {
		return fareProvider.getFare();
	}

	@Override
	protected AssetType getAssetType() {
		return assetProvider.getTypeOfAsset();
	}

}
