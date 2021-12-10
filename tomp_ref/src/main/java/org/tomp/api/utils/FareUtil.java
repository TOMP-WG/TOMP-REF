package org.tomp.api.utils;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.UnitTypeEnum;
import io.swagger.model.Leg;

@Component
public class FareUtil {

	private static final Logger log = LoggerFactory.getLogger(FareUtil.class);

	@Autowired
	LegUtil legUtil;

	public double calculateFare(Leg leg) {
		Fare fare = leg.getPricing();
		double minutes = legUtil.getDuration(leg);
		double distanceInMeters = legUtil.getDistance(leg);

		return calculateFare(fare, minutes, distanceInMeters);
	}

	public double calculateFare(Fare fare, double minutes, double distanceInMeters) {
		double amount = 0;
		Float max = null;

		for (FarePart part : fare.getParts()) {
			switch (part.getType()) {
			case FIXED:
				amount += part.getAmount().doubleValue();
				break;
			case FLEX:
				amount += calculateFlexPart(part, minutes, distanceInMeters);
				break;
			case MAX:
				max = part.getAmount();
				break;

			default:
				break;
			}
		}

		if (max != null && max.doubleValue() > amount) {
			amount = max.doubleValue();
		}

		return Math.round(amount * 100.0) / 100.0;
	}

	private double calculateFlexPart(FarePart part, double minutes, double distanceInMeters) {
		log.info("calc fare {} {} {}", part, minutes, distanceInMeters);
		if (part.getScaleType() == null) {
			double amount = part.getAmount().doubleValue();
			if (part.getUnitType() == UnitTypeEnum.HOUR || part.getUnitType() == UnitTypeEnum.MINUTE
					|| part.getUnitType() == UnitTypeEnum.SECOND) {
				double minutesPerUnit = getMinutesPerUnitType(part.getUnitType());
				minutesPerUnit = minutesPerUnit * part.getUnits().doubleValue();
				log.info("minutesPerUnit {}", minutesPerUnit);
				amount = amount * Math.ceil(minutes / minutesPerUnit);
			} else if (part.getUnitType() == UnitTypeEnum.KM) {
				double meterPerUnit = getMetersPerUnitType(part.getUnitType());
				log.info("meterPerUnit {}", meterPerUnit);
				amount = amount * Math.ceil(distanceInMeters / meterPerUnit);
			}
			return amount;
		}
		switch (part.getScaleType()) {
		case HOUR:
			double startMinutes = part.getScaleFrom().doubleValue();
			double endMinutes = part.getScaleTo().doubleValue();
			if (minutes > startMinutes && minutes < endMinutes) {
				return calculatePrice(part, minutes, startMinutes);
			}
			break;
		case KM:
			break;
		case MILE:
			break;
		case MINUTE:
			break;
		default:
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unknown ScaleType: " + part.getScaleType());
		}
		return 0;
	}

	private double getMetersPerUnitType(@NotNull UnitTypeEnum unitType) {
		switch (unitType) {
		case KM:
			return 1000;
		case MILE:
			return 1609.344;
		default:
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unknown UnitType for getMeters: " + unitType);
		}
	}

	private double getMinutesPerUnitType(@NotNull UnitTypeEnum unitType) {
		switch (unitType) {
		case HOUR:
			return 60;
		case MINUTE:
			return 1;
		case SECOND:
			return 1D / 60;
		default:
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Unknown UnitType for getMinutesPerUnitType: " + unitType);
		}
	}

	private double calculatePrice(FarePart part, double minutes, double startMinutes) {
		double fareMinutes = minutes - startMinutes;
		switch (part.getUnitType()) {
		case HOUR:
			long fareHours = Math.round(fareMinutes / 60.0) + 1;
			return part.getAmount().doubleValue() * fareHours;
		case MINUTE:
			return part.getAmount().doubleValue() * fareMinutes;
		case SECOND:
			long wholeFareMinutes = Math.round(minutes);
			long fareSeconds = Math.round((minutes - wholeFareMinutes) * 60.0);
			return part.getAmount().doubleValue() * fareSeconds;
		default:
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Illegal fare part configuration: " + part);

		}
	}
}
