package org.tomp.api.booking;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.tomp.api.model.MaasOperator;
import org.tomp.api.repository.DummyRepository;
import org.tomp.api.utils.ClientUtil;

import io.swagger.client.ApiException;
import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOption;
import io.swagger.model.BookingState;

@Component
@Profile(value = { "dummy", "bike", "bus", "train", "car" })
public class GenericBookingProvider implements BookingProvider {

	private static final Logger log = LoggerFactory.getLogger(GenericBookingProvider.class);

	protected DummyRepository repository;

	private HashMap<String, Booking> listeners = new HashMap<>();

	@Autowired
	ClientUtil clientUtil;

	@Autowired
	public GenericBookingProvider(DummyRepository repository) {
		this.repository = repository;
	}

	@Override
	public Booking addNewBooking(@Valid BookingOption body, String acceptLanguage) {
		log.info("POST bookings {}", body.getId());

		String id = body.getId();
		validateId(id);
		Booking booking = new Booking();
		booking.setId(id);
		booking.setState(BookingState.PENDING);
		repository.saveBooking(booking);

		log.info("Response {}", booking);
		return booking;
	}

	protected void validateId(String id) {
		if (repository.getSavedOption(id) == null) {
			log.error("Did not provide this leg {}", id);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Booking addNewBookingEvent(BookingOperation body, String acceptLanguage, String id) {
		validateId(id);
		log.info("POST bookings/{}/events {}", id, body.getOperation());
		Booking booking = repository.getBooking(id);
		if (booking == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		switch (body.getOperation()) {
		case COMMIT:
			booking.setState(BookingState.CONFIRMED);
			break;
		case CANCEL:
			booking.setState(BookingState.CANCELLED);
			break;
		case DENY:
			booking.setState(BookingState.RELEASED);
			break;
		case EXPIRE:
			booking.setState(BookingState.EXPIRED);
			break;
		}

		informListeners(body, id);
		repository.saveBooking(booking);
		return booking;
	}

	private void informListeners(BookingOperation body, String id) {
		Booking listener = listeners.get(id);
		if (listener != null) {
			MaasOperator to = new MaasOperator();
			to.setUrl(listener.getWebhook());
			try {
				clientUtil.post(to, "", body, Void.class);
			} catch (ApiException e) {
				log.error(e.getMessage());
			}
		}
	}

	@Override
	public void setRequest(HttpServletRequest request) {
	}

	@Override
	public Booking getBooking(String id) {
		return repository.getBooking(id);
	}

	@Override
	public void subscribeToBookings(String acceptLanguage, String api, String apiVersion, String id,
			@Valid Booking body) {
		listeners.put(id, body);
	}

	@Override
	public void unsubscribeToBookings(String acceptLanguage, String api, String apiVersion, String id) {
		listeners.remove(id);
	}
}
