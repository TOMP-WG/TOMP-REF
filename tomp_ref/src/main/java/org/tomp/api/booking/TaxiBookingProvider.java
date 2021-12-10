package org.tomp.api.booking;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.model.LookupService;
import org.tomp.api.repository.DefaultRepository;
import org.tomp.api.tripexecution.TaxiTripExecutionProvider;
import org.tomp.api.utils.ClientUtil;
import org.tomp.api.utils.FareUtil;
import org.tomp.api.utils.MailUtil;

import io.swagger.model.Booking;
import io.swagger.model.BookingRequest;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;

@Component
@ConditionalOnProperty(value = "tomp.providers.booking", havingValue = "taxi", matchIfMissing = false)
public class TaxiBookingProvider extends SharedCarBookingProvider {

	@Autowired
	TaxiTripExecutionProvider tripExecution;

	@Autowired
	FareUtil fareUtil;

	public TaxiBookingProvider(DefaultRepository repository, Optional<MailUtil> mailService,
			ExternalConfiguration configuration, ClientUtil clientUtil, LookupService lookupService) {
		super(repository, mailService, configuration, clientUtil, lookupService);
	}

	@Override
	public Booking addNewBooking(@Valid BookingRequest body, String acceptLanguage) {
		if (body.getFrom() == null || body.getTo() == null || body.getFrom().getPhysicalAddress() == null
				|| body.getTo().getPhysicalAddress() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "From and to addresses are required");
		}
		Booking booking = super.addNewBooking(body, acceptLanguage);

		double fare = fareUtil.calculateFare(booking.getLegs().get(0));

		Fare pricing = new Fare();
		FarePart partsItem = new FarePart();
		partsItem.setAmount((float)(fare));
		partsItem.setType(TypeEnum.FIXED);
		partsItem.setCurrencyCode(booking.getLegs().get(0).getPricing().getParts().get(0).getCurrencyCode());
		pricing.addPartsItem(partsItem);
		pricing.setEstimated(false);

		booking.setPricing(pricing);
		return booking;
	}

	@Override
	public void saveResult(String id, boolean committed, String remark) {
		super.saveResult(id, committed, remark);
		if (committed) {
			startTripExecution(id);
		}
	}

	private void startTripExecution(String tripId) {
		tripExecution.startExecution(tripId);
	}
}
