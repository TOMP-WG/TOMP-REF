package org.tomp.api.operatorinformation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.providers.assets.AssetProvider;
import org.tomp.api.utils.ObjectFromFileProvider;

import io.swagger.model.Day;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.FarePart.UnitTypeEnum;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;
import io.swagger.model.Time;
import io.swagger.model.TypeOfAsset;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "car", matchIfMissing = false)
public class CarOperatorInformationProvider implements OperatorInformationProvider {

	@Autowired
	ExternalConfiguration configuration;

	@Autowired
	AssetProvider assetProvider;

	@Override
	public List<TypeOfAsset> getAvailableAssetTypes(String acceptLanguage) {
		return assetProvider.getAssetTypes();
	}

	@Override
	public SystemInformation getOperatorInformation(String acceptLanguage) {
		SystemInformation info = new SystemInformation();
		info.setSystemId("maas-car-3342");
		info.setEmail("email@caroperator.org");
		info.setLanguage(Arrays.asList(acceptLanguage));
		info.setName("Car Operator");
		return info;
	}

	@Override
	public List<StationInformation> getStations(String acceptLanguage) {
		return new ArrayList<>();
	}

	@Override
	public List<SystemRegion> getRegions(String acceptLanguage) {
		ObjectFromFileProvider<SystemRegion[]> provider = new ObjectFromFileProvider<>();
		SystemRegion[] regionArray = provider.getObject(acceptLanguage, SystemRegion[].class,
				configuration.getRegionsFile());
		List<SystemRegion> regions = new ArrayList<>();
		for (int i = 0; i < regionArray.length; i++) {
			regions.add(regionArray[i]);
		}
		return regions;
	}

	@Override
	public List<SystemPricingPlan> getPricingPlans(String acceptLanguage) {
		SystemPricingPlan membersOnly = new SystemPricingPlan();
		membersOnly.setPlanId("MO");
		membersOnly.setDescription("Subscribed members can apply for this pricing plan");
		membersOnly.setIsTaxable(true);
		membersOnly.setName("Members only");
		Fare fare = new Fare();
		FarePart partsItem = new FarePart();
		partsItem.setAmount(BigDecimal.valueOf(1.25));
		partsItem.setCurrencyCode("NL");
		partsItem.setUnitType(UnitTypeEnum.KM);
		partsItem.setType(TypeEnum.FLEX);
		fare.addPartsItem(partsItem);
		membersOnly.setFare(fare);

		SystemPricingPlan nonMembers = new SystemPricingPlan();
		nonMembers.setPlanId("NM");
		nonMembers.setDescription("Pricing plan for non-subscribers");
		nonMembers.setIsTaxable(true);
		nonMembers.setName("Non members");
		fare = new Fare();
		partsItem = new FarePart();
		partsItem.setAmount(BigDecimal.valueOf(1.55));
		partsItem.setCurrencyCode("NL");
		partsItem.setUnitType(UnitTypeEnum.KM);
		partsItem.setType(TypeEnum.FLEX);
		fare.addPartsItem(partsItem);

		partsItem = new FarePart();
		partsItem.setAmount(BigDecimal.valueOf(10));
		partsItem.setCurrencyCode("NL");
		partsItem.setType(TypeEnum.FIXED);
		fare.addPartsItem(partsItem);
		nonMembers.setFare(fare);

		return Arrays.asList(membersOnly, nonMembers);
	}

	@Override
	public List<SystemHours> getHours(String acceptLanguage) {
		SystemHours weekHours = new SystemHours();
		weekHours.setDays(Arrays.asList(Day.MON, Day.TUE, Day.WED, Day.THU, Day.FRI));
		Time startTime = new Time();
		startTime.setTime("08:00");
		weekHours.setStartTime(startTime);
		Time endTime = new Time();
		endTime.setTime("18:00");
		weekHours.setEndTime(endTime);

		SystemHours hours = new SystemHours();
		hours.setDays(Arrays.asList(Day.SAT));
		startTime = new Time();
		startTime.setTime("10:00");
		hours.setStartTime(startTime);
		endTime = new Time();
		endTime.setTime("16:00");
		hours.setEndTime(endTime);

		return Arrays.asList(weekHours, hours);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<SystemCalendar> getCalendar(String acceptLanguage) {
		SystemCalendar c = new SystemCalendar();
		c.setStartYear(2019);
		c.setStartMonth(1);
		c.setStartDay(1);

		c.setEndYear(new Date().getYear());
		c.setEndMonth(12);
		c.setEndDay(31);
		return new ArrayList<>();
	}
}
