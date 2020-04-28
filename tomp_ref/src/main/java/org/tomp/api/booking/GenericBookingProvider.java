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
public class GenericBookingProvider implements BookingProvider {

	@Autowired
	protected DummyRepository repository;

	@Override
	public Booking addNewBooking(@Valid BookingOption body, String acceptLanguage) {
		System.out.println("Booking request " + body.getId());

		String id = body.getId();
		validateId(body.getId());
		Booking booking = new Booking();
		booking.setId(id);
		booking.setState(BookingState.PENDING);
		return booking;
	}

	protected void validateId(String id) {
		if (repository.getSavedOption(id) == null) {
			System.out.println("Did not provide this leg " + id);
			throw new RuntimeException();
		}
	}

	@Override
	public Booking addNewBookingEvent(BookingOperation body, String acceptLanguage, String id) {
		validateId(id);
		System.out.println(body.getOperation() + " " + id);

		switch (body.getOperation()) {
		case COMMIT:
			Booking booking = new Booking();
			booking.setId(id);
			booking.setState(BookingState.CONFIRMED);
			return booking;
		case CANCEL:
			break;
		case DENY:
			break;
		case EXPIRE:
			break;
		default:
			break;
		}
		return null;
	}

}
