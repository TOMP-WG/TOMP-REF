package org.tomp.api.booking;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingRequest;

public interface BookingProvider {

	void setRequest(HttpServletRequest request);

	Booking addNewBooking(@Valid BookingRequest body, String acceptLanguage);

	Booking addNewBookingEvent(BookingOperation body, String acceptLanguage, String id);

	Booking getBooking(String id);

	void subscribeToBookings(String acceptLanguage, String api, String apiVersion, String id, @Valid Booking body);

	void unsubscribeToBookings(String acceptLanguage, String api, String apiVersion, String id);

}
