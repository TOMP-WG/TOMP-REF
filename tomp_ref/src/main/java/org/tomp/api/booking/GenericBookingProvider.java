package org.tomp.api.booking;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory.getLogger(GenericBookingProvider.class);

	protected DummyRepository repository;

	@Autowired
	public GenericBookingProvider(DummyRepository repository) {
		this.repository = repository;

	}

	@Override
	public Booking addNewBooking(@Valid BookingOption body, String acceptLanguage) {
		log.info("Booking request {}", body.getId());

		String id = body.getId();
		validateId(id);
		Booking booking = new Booking();
		booking.setId(id);
		booking.setState(BookingState.PENDING);
		repository.saveBooking(booking);
		return booking;
	}

	protected void validateId(String id) {
		if (repository.getSavedOption(id) == null) {
			log.error("Did not provide this leg {}", id);
			throw new RuntimeException();
		}
	}

	@Override
	public Booking addNewBookingEvent(BookingOperation body, String acceptLanguage, String id) {
		validateId(id);
		log.info("{} {}", body.getOperation(), id);

		switch (body.getOperation()) {
		case COMMIT:
			Booking booking = repository.getBooking(id);
			booking.setState(BookingState.CONFIRMED);
			repository.saveBooking(booking);
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

	@Override
	public void setRequest(HttpServletRequest request) {
	}

}
