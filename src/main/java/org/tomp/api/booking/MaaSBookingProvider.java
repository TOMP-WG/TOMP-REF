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
public class MaaSBookingProvider extends DummyBookingProvider {

	@Autowired
	MaaSRepository repository;

	@Override
	public Booking addNewBooking(@Valid BookingOption body, String acceptLanguage) {

		Trip savedOption = repository.getTrip(body.getId());
		if (savedOption != null) {
			Booking booking = new Booking();
			booking.setId(body.getId());
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
					e.printStackTrace();
				}
			}
			// all bookings in pending
			if (!blockingTransportOperator) {
				for (Segment segment : savedOption.getSegments()) {
					TransportOperator operator = segment.getOperators().iterator().next();
					BookingOperation operation = new BookingOperation();
					SimpleLeg planningResult = (SimpleLeg) segment.getResult(operator).getResults().get(0);
					operation.setOperation(OperationEnum.COMMIT);
					try {
						Booking clientBooking = ClientUtil.post(operator,
								"/bookings/" + planningResult.getId() + "/events/", operation, Booking.class);
						if (clientBooking == null || !clientBooking.getState().equals(BookingState.CONFIRMED)) {
							throw new RuntimeException();
						}
					} catch (ApiException e) {
						e.printStackTrace();
					}
				}
				booking.setCustomer(body.getCustomer());
				booking.setState(BookingState.CONFIRMED);
				return booking;
			}
		}
		throw new RuntimeException();

	}
}
