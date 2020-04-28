package org.tomp.api.booking;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.mp.ClientUtil;
import org.tomp.api.mp.Segment;
import org.tomp.api.mp.TransportOperator;
import org.tomp.api.mp.Trip;
import org.tomp.api.repository.MaaSRepository;

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

	@Autowired
	MaaSRepository repository;

	@Override
	public Booking addNewBooking(@Valid BookingOption body, String acceptLanguage) {
		System.out.println("Book option " + body.getId());

		Trip savedOption = repository.getTrip(body.getId());
		if (savedOption != null) {
			System.out.println("Found option " + body.getId());
			Booking booking = new Booking();
			booking.setId(body.getId());
			System.out.println("Book legs");
			boolean blockingTransportOperator = bookAllLegs(body, savedOption);
			// all bookings in pending
			if (!blockingTransportOperator) {
				System.out.println("Commit legs");
				commitAllLegs(body, savedOption, booking);
				System.out.println("Ready!");
				return booking;
			}
		}
		System.out.println("Illegal request. I didn't provide this id");
		throw new RuntimeException();
	}

	private void commitAllLegs(BookingOption body, Trip savedOption, Booking booking) {
		for (Segment segment : savedOption.getSegments()) {
			TransportOperator operator = segment.getOperators().iterator().next();
			BookingOperation operation = new BookingOperation();
			SimpleLeg planningResult = (SimpleLeg) segment.getResult(operator).getResults().get(0);
			operation.setOperation(OperationEnum.COMMIT);
			try {
				Booking clientBooking = ClientUtil.post(operator, "/bookings/" + planningResult.getId() + "/events/",
						operation, Booking.class);
				if (clientBooking == null || !clientBooking.getState().equals(BookingState.CONFIRMED)) {
					throw new RuntimeException();
				}
			} catch (ApiException e) {
				System.out.println("Error during committing " + operator.getName());
				e.printStackTrace();
			}
		}
		booking.setCustomer(body.getCustomer());
		booking.setState(BookingState.CONFIRMED);
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
				Booking clientBooking = ClientUtil.post(operator, "/bookings/", option, Booking.class);
				if (clientBooking == null || !clientBooking.getState().equals(BookingState.PENDING)) {
					blockingTransportOperator = true;
				}
			} catch (ApiException e) {
				System.out.println("Error during booking " + operator.getName());
				e.printStackTrace();
			}
		}
		return blockingTransportOperator;
	}
}
