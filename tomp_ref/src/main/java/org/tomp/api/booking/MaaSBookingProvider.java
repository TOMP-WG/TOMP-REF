package org.tomp.api.booking;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.tomp.api.model.Segment;
import org.tomp.api.model.TransportOperator;
import org.tomp.api.model.Trip;
import org.tomp.api.repository.MPRepository;
import org.tomp.api.utils.ClientUtil;

import io.swagger.client.ApiException;
import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOperation.OperationEnum;
import io.swagger.model.BookingRequest;
import io.swagger.model.BookingState;
import io.swagger.model.Card;
import io.swagger.model.CardType.TypeEnum;
import io.swagger.model.Condition;
import io.swagger.model.ConditionRequireBookingData;
import io.swagger.model.ConditionRequireBookingData.RequiredFieldsEnum;
import io.swagger.model.Leg;
import io.swagger.model.Planning;

@Component
@ConditionalOnProperty(value = "tomp.providers.booking", havingValue = "maasprovider", matchIfMissing = false)
public class MaaSBookingProvider extends GenericBookingProvider {

	private static final Logger log = LoggerFactory.getLogger(MaaSBookingProvider.class);

	@Autowired
	MPRepository maasRepository;

	@Autowired
	ClientUtil clientUtil;

	@Override
	public Booking addNewBooking(@Valid BookingRequest body, String acceptLanguage) {
		log.info("Book option {}", body.getId());

		Trip savedOption = maasRepository.getTrip(body.getId());
		if (savedOption != null) {
			log.info("Found option {}", body.getId());
			Booking booking = new Booking();
			booking.setState(BookingState.PENDING);
			booking.setId(body.getId());
			log.info("Book legs");
			BookingState state = bookAllLegs(body, savedOption);

			repository.saveBooking(booking);
			// all bookings in pending
			if (state == BookingState.PENDING) {
				commitAllLegs(body, savedOption, booking);
				return booking;
			} else {
				log.info("Booking switched to state {}", state);
				booking.setState(state);
				return booking;
			}
		}
		log.error("Illegal request. I didn't provide this id");
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@Override
	public Booking addNewBookingEvent(BookingOperation body, String acceptLanguage, String id) {
		log.info("{} {}", body.getOperation(), id);
		Booking booking = repository.getBooking(id);
		if (booking != null) {
			handleMaaSBooking(body, booking);
			return booking;
		}
		return handleClientBooking(body, id, booking);
	}

	private Booking handleClientBooking(BookingOperation body, String id, Booking booking) {
		Booking clientBooking = maasRepository.getClientBooking(id);

		switch (body.getOperation()) {
		case COMMIT:
			return commitConditionalConfirmedBooking(booking, clientBooking);
		case CANCEL:
			return bookingIsCancelled(clientBooking);
		case DENY:
			return denyConditionalConfirmedBooking(booking, clientBooking);
		case EXPIRE:
			return conditionalConfirmedBookingIsExpired(booking);
		default:
			break;
		}
		return null;
	}

	private Booking bookingIsCancelled(Booking booking) {
		booking.setState(BookingState.CANCELLED);
		repository.saveBooking(booking);
		return booking;
	}

	private Booking conditionalConfirmedBookingIsExpired(Booking booking) {
		booking.setState(BookingState.EXPIRED);
		repository.saveBooking(booking);
		return booking;
	}

	private Booking denyConditionalConfirmedBooking(Booking maasBooking, Booking deniedBooing) {
		if (deniedBooing.getState() == BookingState.CONDITIONAL_CONFIRMED) {
			deniedBooing.setState(BookingState.RELEASED);
		} else {
			throw new UnsupportedOperationException();
		}

		maasBooking.setState(BookingState.RELEASED);
		repository.saveBooking(maasBooking);
		return maasBooking;
	}

	private Booking commitConditionalConfirmedBooking(Booking booking, Booking clientBooking) {
		if (clientBooking.getState() == BookingState.CONDITIONAL_CONFIRMED) {
			clientBooking.setState(BookingState.CONFIRMED);
		} else {
			throw new UnsupportedOperationException();
		}

		booking.setState(BookingState.CONFIRMED);
		repository.saveBooking(booking);
		return booking;
	}

	private void handleMaaSBooking(BookingOperation body, Booking booking) {
		if (body.getOperation() == OperationEnum.CANCEL) {
			cancelAllClientBookings(booking);
			return;
		}
		throw new UnsupportedOperationException();
	}

	private void cancelAllClientBookings(Booking booking) {
		List<SimpleEntry<Booking, TransportOperator>> clientBookings = maasRepository.getClientBookings(booking);
		for (SimpleEntry<Booking, TransportOperator> clientBooking : clientBookings) {
			BookingOperation operation = new BookingOperation();
			operation.setOperation(OperationEnum.CANCEL);
			try {
				clientUtil.post(clientBooking.getValue(), "/bookings/" + clientBooking.getKey().getId() + "/events/",
						operation, Booking.class);
			} catch (ApiException e) {
				log.error(e.getMessage());
			}
		}
		booking.setState(BookingState.CANCELLED);
	}

	private void commitAllLegs(BookingRequest body, Trip savedOption, Booking booking) {
		boolean allPending = true;
		boolean cancelled = false;
		for (Segment segment : savedOption.getSegments()) {
			TransportOperator operator = segment.getOperators().iterator().next();
			BookingOperation operation = new BookingOperation();
			Booking planningResult = segment.getResult(operator).getOptions().get(0);
			operation.setOperation(OperationEnum.COMMIT);
			try {
				Booking clientBooking = clientUtil.post(operator, "/bookings/" + planningResult.getId() + "/events/",
						operation, Booking.class);
				if (clientBooking == null) {
					throw new RuntimeException();
				}
				if (!clientBooking.getState().equals(BookingState.CONFIRMED)) {
					allPending = false;
				}

				if (clientBooking.getState().equals(BookingState.CANCELLED)) {
					cancelAll(savedOption.getSegments());
					cancelled = true;
					break;
				}

				maasRepository.addClientBooking(booking, operator, clientBooking);
			} catch (ApiException e) {
				log.error("Error during committing {}", operator.getName());
				log.error(e.getMessage());
			}
		}
		booking.setCustomer(body.getCustomer());
		if (cancelled) {
			booking.setState(BookingState.CANCELLED);
		} else if (allPending) {
			booking.setState(BookingState.CONFIRMED);
		} else {
			booking.setState(BookingState.CONDITIONAL_CONFIRMED);
		}
	}

	private void cancelAll(List<Segment> segments) {
		BookingOperation operation = new BookingOperation();
		operation.setOperation(OperationEnum.CANCEL);
		for (Segment segment : segments) {
			TransportOperator operator = segment.getOperators().iterator().next();
			Booking planningResult = segment.getResult(operator).getOptions().get(0);
			try {
				clientUtil.post(operator, "/bookings/" + planningResult.getId() + "/events/", operation, Booking.class);
			} catch (ApiException e) {
				log.error("Operator {} possibly didn't receive CANCEL {}", operator.getName(), planningResult.getId());
			}
		}
	}

	private BookingState bookAllLegs(BookingRequest body, Trip savedOption) {
		BookingState generalState = BookingState.PENDING;
		for (Segment segment : savedOption.getSegments()) {
			TransportOperator operator = segment.getOperators().iterator().next();
			BookingRequest option = new BookingRequest();
			Planning result = segment.getResult(operator);
			Booking simpleLeg = result.getOptions().get(0);
			String id = simpleLeg.getId();
			option.setId(id);
			option.setCustomer(body.getCustomer());

			addRequiredFields(option, result, simpleLeg);

			try {
				Booking clientBooking = clientUtil.post(operator, "/bookings/", option, Booking.class);
				if (clientBooking == null) {
					return BookingState.CANCELLED;
				}
				if (!clientBooking.getState().equals(BookingState.PENDING)) {
					generalState = clientBooking.getState();
				}
			} catch (ApiException e) {
				log.error("Error during booking {}", operator.getName());
			}
		}
		return generalState;
	}

	private void addRequiredFields(BookingRequest option, Planning result, Booking booking) {
		for (Leg leg : booking.getLegs()) {
			for (Condition condition : leg.getConditions()) {
				if (condition instanceof ConditionRequireBookingData) {
					for (RequiredFieldsEnum field : ((ConditionRequireBookingData) condition).getRequiredFields()) {
						addRequiredField(option, field);
					}
				}
			}
		}
	}

	private void addRequiredField(BookingRequest option, RequiredFieldsEnum field) {
		switch (field) {
		case BANK_CARDS:
			Card card = new Card();
			card.setType(TypeEnum.BANK);
			card.setCardNumber("NL21RABO43892222");
			card.setCountry("NL");
			option.getCustomer().setCards(Arrays.asList(card));
			break;
		case BIRTHDATE:
			break;
		case CREDIT_CARDS:
			break;
		case DISCOUNT_CARDS:
			break;
		case EMAIL:
			break;
		case FROM_ADDRESS:
			break;
		case ID_CARDS:
			break;
		case LICENSES:
			break;
		case PERSONAL_ADDRESS:
			break;
		case PHONE_NUMBERS:
			break;
		case TO_ADDRESS:
			break;
		case TRAVEL_CARDS:
			break;
		default:
			break;
		}

	}
}
