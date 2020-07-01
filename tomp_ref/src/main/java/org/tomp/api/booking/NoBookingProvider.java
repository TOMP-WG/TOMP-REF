package org.tomp.api.booking;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingRequest;

@Component
@ConditionalOnProperty(value = "tomp.providers.booking", havingValue = "none", matchIfMissing = false)
public class NoBookingProvider implements BookingProvider {

	@Override
	public void setRequest(HttpServletRequest request) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Booking addNewBooking(@Valid BookingRequest body, String acceptLanguage) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Booking addNewBookingEvent(BookingOperation body, String acceptLanguage, String id) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Booking getBooking(String id) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public void subscribeToBookings(String acceptLanguage, String api, String apiVersion, String id,
			@Valid Booking body) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public void unsubscribeToBookings(String acceptLanguage, String api, String apiVersion, String id) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

}
