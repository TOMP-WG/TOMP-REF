package org.tomp.api.planning;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.repository.DummyRepository;

import io.swagger.model.AssetClass;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.OptionsLeg;
import io.swagger.model.TypeOfAsset;
import io.swagger.model.TypeOfAsset.EnergyLabelEnum;

@Component
@Profile("car")
public class CarPlanningProvider extends BasePlanningProvider {

	@Autowired
	public CarPlanningProvider(DummyRepository repository, ExternalConfiguration configuration) {
		super(repository, configuration);
	}

	@Override
	protected Fare getFare() {
		Fare fare = new Fare();
		FarePart part = new FarePart();
		part.setType(TypeEnum.FIXED);
		part.setCurrencyCode("EUR");
		part.setAmount(BigDecimal.valueOf(3.33));
		part.setVatRate(BigDecimal.valueOf(21.0));
		fare.addPartsItem(part);
		return fare;
	}

	@Override
	protected OptionsLeg getLeg() {
		OptionsLeg leg = new OptionsLeg();
		leg.setFrom(from);
		leg.setTo(to);
		leg.setStartTime(start);
		leg.setEndTime(end);
		return leg;
	}

	@Override
	protected TypeOfAsset getAssetType() {
		TypeOfAsset typeOfAsset = new TypeOfAsset();
		typeOfAsset.setAssetClass(AssetClass.CAR);
		typeOfAsset.setAssetSubClass("Small car");
		typeOfAsset.setModel("Peugeot 208");
		typeOfAsset.setEnergyLabel(EnergyLabelEnum.A);
		return typeOfAsset;
	}
}
