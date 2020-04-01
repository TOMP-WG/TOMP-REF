package org.tomp.api.booking;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.repository.DummyRepository;

import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOption;
import io.swagger.model.BookingState;

@Component
@Profile(value = { "dummy", "bike", "bus", "train", "car" })
public class DummyBookingProvider implements BookingProvider {

	@Autowired
	DummyRepository repository;

	@Override
	public Booking addNewBooking(@Valid BookingOption body, String acceptLanguage) {
		String id = body.getId();
		validateId(body.getId());

		Booking booking = new Booking();
		booking.setId(id);
		booking.setState(BookingState.PENDING);
		return booking;
	}

	private void validateId(String id) {
		if (repository.getSavedOption(id) == null) {
			System.out.println("Missing booking " + id);
			throw new RuntimeException();
		}
	}

	@Override
	public Booking addNewBookingEvent(BookingOperation body, String acceptLanguage, String id) {
		validateId(id);

		Booking booking = new Booking();
		booking.setId(id);
		booking.setState(BookingState.CONFIRMED);
		return booking;
	}

}
