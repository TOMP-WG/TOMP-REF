package org.tomp.api.booking;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.controllers.WebsocketController;
import org.tomp.api.model.LookupService;
import org.tomp.api.model.MaasOperator;
import org.tomp.api.repository.DefaultRepository;
import org.tomp.api.utils.ClientUtil;
import org.tomp.api.utils.FareUtil;
import org.tomp.api.utils.LegUtil;
import org.tomp.api.utils.MailUtil;

import io.swagger.client.ApiException;
import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOperation.OperationEnum;
import io.swagger.model.BookingRequest;
import io.swagger.model.BookingState;
import io.swagger.model.Coordinates;
import io.swagger.model.Customer;
import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalCategory;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalEntry.DistanceTypeEnum;
import io.swagger.model.JournalState;
import io.swagger.model.Leg;

@Component
@ConditionalOnProperty(value = "tomp.providers.booking", havingValue = "shared-car", matchIfMissing = false)
public class SharedCarBookingProvider implements BookingProvider {

	private static final String MAAS_ID = "maas-id";
	private static final Logger log = LoggerFactory.getLogger(SharedCarBookingProvider.class);

	private DefaultRepository repository;
	private MailUtil mailService;
	private LookupService lookupService;

	private ExternalConfiguration configuration;
	private HttpServletRequest request;
	private ClientUtil clientUtil;

	@Autowired
	FareUtil fareUtil;

	@Autowired
	LegUtil legUtil;

	@Autowired
	WebsocketController websocket;

	@Autowired
	public SharedCarBookingProvider(DefaultRepository repository, Optional<MailUtil> mailService,
			ExternalConfiguration configuration, ClientUtil clientUtil, LookupService lookupService) {
		this.repository = repository;
		this.mailService = mailService.isPresent() ? mailService.get() : null;
		this.configuration = configuration;
		this.clientUtil = clientUtil;
		this.lookupService = lookupService;
	}

	@Override
	public Booking addNewBooking(@Valid BookingRequest body, String acceptLanguage) {
		log.info("Booking request {}", body.getId());
		String id = body.getId();
		Booking booking = repository.getBooking(id);
		booking.setId(id);
		booking.setState(BookingState.PENDING);
		booking.getFrom().setPhysicalAddress(body.getFrom().getPhysicalAddress());
		booking.getTo().setPhysicalAddress(body.getTo().getPhysicalAddress());
		booking.setCustomer(body.getCustomer());
		repository.saveBooking(booking);
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
		log.info("{} {}", body.getOperation(), id);

		switch (body.getOperation()) {
		case COMMIT:
			return commitBooking(id);
		case CANCEL:
			return cancelBooking(id);
		case DENY:
			throw new UnsupportedOperationException();
		case EXPIRE:
			throw new UnsupportedOperationException();
		default:
			throw new UnsupportedOperationException();
		}
	}

	protected Booking cancelBooking(String id) {
		Booking booking = repository.getBooking(id);

		if (booking.getState() == BookingState.CONFIRMED) {
			// TODO test if it's not yet started!

			booking.setState(BookingState.CANCELLED);
			JournalEntry entry = new JournalEntry();
			Leg savedOption = repository.getLeg(id);

			double calculated = fareUtil.calculateFare(savedOption);
			if (calculated > 0) {
				entry.setAmount((float)(calculated * 0.05)); // 5% fine in case of cancelling a booked leg
				ExtraCosts costs = new ExtraCosts();
				costs.setAmount((float)(calculated * 0.05));
				costs.setCategory(JournalCategory.FINE);
				entry.setDetails(costs);
				repository.saveJournalEntry(entry, request.getHeader("maas-id"));
			}
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only CONFIRMED bookings can be cancelled");
		}
		return booking;
	}

	protected Booking commitBooking(String id) {
		Booking booking = repository.getBooking(id);
		booking.setState(BookingState.CONDITIONAL_CONFIRMED);
		String maasId = request.getHeader(MAAS_ID);
		HashMap<String, Object> extraData = new HashMap<>();
		extraData.put(MAAS_ID, maasId);
		booking.setExtraData(extraData);
		repository.saveBooking(booking);

		JournalEntry entry = new JournalEntry();
		Leg leg = repository.getLeg(id);
		entry.setState(JournalState.TO_INVOICE);
		entry.setDetails(leg.getPricing());
		leg.getPricing().setEstimated(false);
		entry.setJournalId(leg.getId());

		FareUtil f = new FareUtil();
		LegUtil l = new LegUtil();

		double distance = l.getDistance(leg);
		entry.setDistance((float)(distance / 1000));
		entry.setDistanceType(DistanceTypeEnum.KM);

		int duration = l.getDuration(leg);
		entry.setUsedTime(duration);

		entry.setAmount((float)(f.calculateFare(leg.getPricing(), duration / 60, distance)));
		repository.saveJournalEntry(entry, request.getHeader("maas-id"));

		sendMail(booking);
		return booking;
	}

	private void sendMail(Booking booking) {
		String mpUrl = configuration.getExternalUrl();
		if (this.mailService != null) {
			StringBuilder builder = getBookingRequestText(booking);
			String to = booking.getCustomer().getEmail();
			if (to == null || to.equals("")) {
				to = configuration.getBookingMailBox();
			}

			SendMailThread t = new SendMailThread(configuration.getBookingMailBox(), to, booking.getId(),
					builder.toString());
			new Thread(t).start();
		} else {
			if (mpUrl.endsWith("/")) {
				mpUrl = mpUrl.substring(0, mpUrl.length() - 1);
			}
		}
		String url = mpUrl + "/postponed/" + booking.getId();
		log.info("URL: {}", url);
		websocket.sendMessage(url, null);
	}

	private class SendMailThread implements Runnable {
		private String to;
		private String bookingId;
		private String body;
		private String from;

		public SendMailThread(String from, String to, String bookingId, String body) {
			this.from = from;
			this.to = to;
			this.bookingId = bookingId;
			this.body = body;
		}

		public void run() {
			mailService.sendSimpleMessage(from, to, "Booking request: " + bookingId, body);
		}
	}

	private StringBuilder getBookingRequestText(Booking booking) {
		StringBuilder builder = new StringBuilder();
		builder.append("Request for booking ");

		String mpUrl = configuration.getExternalUrl();
		if (mpUrl.endsWith("/")) {
			mpUrl = mpUrl.substring(0, mpUrl.length() - 1);
		}
		builder.append(mpUrl + "/postponed/" + booking.getId());
		builder.append("\r\n");

		Customer customer = booking.getCustomer();
		if (customer != null) {
			builder.append("Customer: ");
			if (customer.getFirstName() != null) {
				builder.append(customer.getFirstName());
			}
			builder.append(" ");
			if (customer.getLastName() != null) {
				builder.append(customer.getLastName());
			}
			builder.append("\r\n");
			builder.append("Birth date: ");
			if (customer.getBirthDate() != null) {
				builder.append(customer.getBirthDate());
			}
			builder.append("\r\n");
		}

		Leg leg = repository.getLeg(booking.getId());
		Coordinates from = leg.getFrom().getCoordinates();
		builder.append("Start ");
		builder.append(leg.getDepartureTime());
		builder.append(" - ");
		builder.append(from.getLat());
		builder.append("/");
		builder.append(from.getLng());
		builder.append("\r\n");
		Coordinates to = leg.getTo().getCoordinates();
		builder.append("End ");
		builder.append(leg.getArrivalTime());
		builder.append(" - ");
		builder.append(to.getLat());
		builder.append("/");
		builder.append(to.getLng());
		builder.append("\r\n");
		return builder;
	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	protected HttpServletRequest getRequest() {
		return this.request;
	}

	public String getPostponedBookingHtml(String id, String url) {
		Booking booking = repository.getBooking(id);
		StringBuilder builder = getBookingRequestText(booking);
		String firstPart = builder.toString().replace("\r\n", "<br>");
		return firstPart + "<form action=\"" + url + "\" method=\"post\"> <div class=\"control\">"
				+ "<input type=\"hidden\" name=\"id\" value=\"" + id + "\">" + "  <label class=\"radio\">"
				+ "    <input type=\"radio\" name=\"choice\" value=0>DENY" + "  </label><br>"
				+ "  <label class=\"radio\">"
				+ "    <input type=\"radio\" name=\"choice\" value=1 checked=\"checked\">COMMIT" + "  </label>"
				+ "</div>" + "<input type=\"submit\" value=\"Submit\"> " + "</form>";
	}

	@SuppressWarnings("unchecked")
	public void saveResult(String id, boolean committed, String remark) {
		Booking booking = repository.getBooking(id);
		booking.setState(committed ? BookingState.CONFIRMED : BookingState.CANCELLED);
		if (!committed) {
			Map<String, Object> extraData = booking.getExtraData();
			if (extraData == null) {
				extraData = new HashMap<>();
			}
			extraData.put("DenyReason", remark);
			booking.setExtraData(extraData);
		}
		repository.saveBooking(booking);

		BookingOperation operation = new BookingOperation();
		operation.setOperation(committed ? OperationEnum.COMMIT : OperationEnum.DENY);
		for (Entry<String, Object> kv : ((Map<String, Object>) booking.getExtraData()).entrySet()) {
			if (kv.getKey().equals(MAAS_ID)) {
				MaasOperator mp = lookupService.getMaasOperator(kv.getValue().toString());
				if (mp != null) {
					try {
						clientUtil.post(mp, "/bookings/" + id + "/events", operation, Void.class);
					} catch (ApiException e) {
						log.error("MP {} cannot be reached", kv.getValue());
						log.error(e.getMessage());
					}
				} else {
					log.error("MP not in meta directory: {} or Meta directory not available", kv.getValue());
				}
				return;
			}
		}
	}

	@Override
	public Booking getBooking(String id) {
		return repository.getBooking(id);
	}

	@Override
	public void subscribeToBookings(String acceptLanguage, String api, String apiVersion, String id) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public void unsubscribeToBookings(String acceptLanguage, String api, String apiVersion, String id) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

}
