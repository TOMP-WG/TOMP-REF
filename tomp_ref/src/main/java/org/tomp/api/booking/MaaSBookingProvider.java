package org.tomp.api.booking;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.model.Segment;
import org.tomp.api.model.TransportOperator;
import org.tomp.api.model.Trip;
import org.tomp.api.repository.DummyRepository;
import org.tomp.api.repository.MPRepository;
import org.tomp.api.utils.ClientUtil;

import io.swagger.client.ApiException;
import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOperation.OperationEnum;
import io.swagger.model.BookingOption;
import io.swagger.model.BookingState;
import io.swagger.model.SimpleLeg;

@Component
@Profile("maasprovider")
public class MaaSBookingProvider extends GenericBookingProvider {

	private static final Logger log = LoggerFactory.getLogger(MaaSBookingProvider.class);

	@Autowired
	MPRepository maasRepository;

	@Autowired
	ClientUtil clientUtil;

	@Autowired
	public MaaSBookingProvider(DummyRepository repository) {
		super(repository);
	}

	@Override
	public Booking addNewBooking(@Valid BookingOption body, String acceptLanguage) {
		log.info("Book option {}", body.getId());

		Trip savedOption = maasRepository.getTrip(body.getId());
		if (savedOption != null) {
			log.info("Found option {}", body.getId());
			Booking booking = new Booking();
			booking.setId(body.getId());
			log.info("Book legs");
			boolean blockingTransportOperator = bookAllLegs(body, savedOption);

			repository.saveBooking(booking);
			// all bookings in pending
			if (!blockingTransportOperator) {
				log.info("Commit legs");
				commitAllLegs(body, savedOption, booking);
				log.info("Ready!");
				return booking;
			}
		}
		log.error("Illegal request. I didn't provide this id");
		throw new RuntimeException();
	}

	@Override
	public Booking addNewBookingEvent(BookingOperation body, String acceptLanguage, String id) {
		log.info("{} {}", body.getOperation(), id);
		Booking booking = repository.getBooking(id);

		switch (body.getOperation()) {
		case COMMIT:
			booking.setState(BookingState.CONFIRMED);
			repository.saveBooking(booking);
			return booking;
		case CANCEL:
			booking.setState(BookingState.CANCELLED);
			repository.saveBooking(booking);
			return booking;
		case DENY:
			booking.setState(BookingState.RELEASED);
			repository.saveBooking(booking);
			return booking;
		case EXPIRE:
			booking.setState(BookingState.EXPIRED);
			repository.saveBooking(booking);
			return booking;
		default:
			break;
		}
		return null;
	}

	private void commitAllLegs(BookingOption body, Trip savedOption, Booking booking) {
		boolean allPending = true;
		boolean cancelled = false;
		for (Segment segment : savedOption.getSegments()) {
			TransportOperator operator = segment.getOperators().iterator().next();
			BookingOperation operation = new BookingOperation();
			SimpleLeg planningResult = (SimpleLeg) segment.getResult(operator).getResults().get(0);
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

				maasRepository.addTOBooking(booking, clientBooking);
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
			SimpleLeg planningResult = (SimpleLeg) segment.getResult(operator).getResults().get(0);
			try {
				clientUtil.post(operator, "/bookings/" + planningResult.getId() + "/events/", operation, Booking.class);
			} catch (ApiException e) {
				log.error("Operator {} possibly didn't receive CANCEL {}", operator.getName(), planningResult.getId());
			}
		}
	}

	private boolean bookAllLegs(BookingOption body, Trip savedOption) {
		boolean blockingTransportOperator = false;
		for (Segment segment : savedOption.getSegments()) {
			TransportOperator operator = segment.getOperators().iterator().next();
			BookingOption option = new BookingOption();
			String id = ((SimpleLeg) segment.getResult(operator).getResults().get(0)).getId();
			option.setId(id);
			option.setCustomer(body.getCustomer());
			try {
				Booking clientBooking = clientUtil.post(operator, "/bookings/", option, Booking.class);
				if (clientBooking == null || !clientBooking.getState().equals(BookingState.PENDING)) {
					blockingTransportOperator = true;
				}
			} catch (ApiException e) {
				log.error("Error during booking {}", operator.getName());
				e.printStackTrace();
			}
		}
		return blockingTransportOperator;
	}
}
