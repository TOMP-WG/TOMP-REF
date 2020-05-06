package org.tomp.api.booking;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOption;

public interface BookingProvider {

	void setRequest(HttpServletRequest request);

	Booking addNewBooking(@Valid BookingOption body, String acceptLanguage);

	Booking addNewBookingEvent(BookingOperation body, String acceptLanguage, String id);
}
