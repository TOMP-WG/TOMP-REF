package org.tomp.api.booking;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.model.LookupService;
import org.tomp.api.model.MaasOperator;
import org.tomp.api.repository.DummyRepository;
import org.tomp.api.utils.ClientUtil;
import org.tomp.api.utils.FareUtil;
import org.tomp.api.utils.LegUtil;
import org.tomp.api.utils.MailUtil;

import io.swagger.client.ApiException;
import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOperation.OperationEnum;
import io.swagger.model.BookingOption;
import io.swagger.model.BookingState;
import io.swagger.model.Coordinates;
import io.swagger.model.Customer;
import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalCategory;
import io.swagger.model.JournalEntry;
import io.swagger.model.KeyValue;
import io.swagger.model.OptionsLeg;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;

@Component
@Profile(value = { "shared-car" })
public class SharedCarBookingProvider implements BookingProvider {

	private static final String MAAS_ID = "maas-id";
	private static final Logger log = LoggerFactory.getLogger(SharedCarBookingProvider.class);

	private DummyRepository repository;
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
	public SharedCarBookingProvider(DummyRepository repository, MailUtil mailService,
			ExternalConfiguration configuration, ClientUtil clientUtil, LookupService lookupService) {
		this.repository = repository;
		this.mailService = mailService;
		this.configuration = configuration;
		this.clientUtil = clientUtil;
		this.lookupService = lookupService;
	}

	@Override
	public Booking addNewBooking(@Valid BookingOption body, String acceptLanguage) {
		log.info("Booking request {}", body.getId());
		String id = body.getId();
		Booking booking = new Booking();
		booking.setId(id);
		booking.setState(BookingState.PENDING);
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

	private Booking cancelBooking(String id) {
		Booking booking = repository.getBooking(id);

		if (booking.getState() == BookingState.CONFIRMED) {
			// TODO test if it's not yet started!

			booking.setState(BookingState.CANCELLED);
			JournalEntry entry = new JournalEntry();
			PlanningResult savedOption = repository.getSavedOption(id);

			double calculated = fareUtil.calculateFare(savedOption);
			if (calculated > 0) {
				entry.setAmount(BigDecimal.valueOf(calculated * 0.05)); // 5% fine in case of cancelling a booked leg
				ExtraCosts costs = new ExtraCosts();
				costs.setAmount(BigDecimal.valueOf(calculated * 0.05));
				costs.setCategory(JournalCategory.FINE);
				entry.setDetails(costs);
				repository.saveJournalEntry(entry, request.getHeader("maas-id"));
			}
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only CONFIRMED bookings can be cancelled");
		}
		return booking;
	}

	private Booking commitBooking(String id) {
		Booking booking = repository.getBooking(id);
		booking.setState(BookingState.CONDITIONAL_CONFIRMED);
		String maasId = request.getHeader(MAAS_ID);
		KeyValue e = new KeyValue();
		e.put(MAAS_ID, maasId);
		ArrayList<KeyValue> meta = new ArrayList<>();
		meta.add(e);
		booking.setMeta(meta);
		String mpUrl = getMPUrl(maasId);
		if (mpUrl.endsWith("/")) {
			mpUrl = mpUrl.substring(0, mpUrl.length() - 1);
		}
		booking.setWebhook(mpUrl + "/bookings/" + id + "/events");
		repository.saveBooking(booking);
		sendMail(booking);
		return booking;
	}

	private void sendMail(Booking booking) {
		StringBuilder builder = getBookingRequestText(booking);
		String to = booking.getCustomer().getEmail();
		if (to == null || to.equals("")) {
			to = configuration.getBookingMailBox();
		}

		SendMailThread t = new SendMailThread(configuration.getBookingMailBox(), to, booking.getId(),
				builder.toString());
		new Thread(t).start();
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
		builder.append("Customer: ");
		builder.append(customer.getFirstName());
		builder.append(" ");
		builder.append(customer.getLastName());
		builder.append("\r\n");
		builder.append("Birth date: ");
		builder.append(customer.getBirthDate());
		builder.append("\r\n");

		PlanningResult savedOption = repository.getSavedOption(booking.getId());
		if (savedOption instanceof SimpleLeg) {
			OptionsLeg leg = ((SimpleLeg) savedOption).getLeg();
			Coordinates from = leg.getFrom();
			builder.append("Start ");
			builder.append(leg.getStartTime());
			builder.append(" - ");
			builder.append(from.getLat());
			builder.append("/");
			builder.append(from.getLng());
			builder.append("\r\n");
			Coordinates to = leg.getTo();
			builder.append("End ");
			builder.append(leg.getEndTime());
			builder.append(" - ");
			builder.append(to.getLat());
			builder.append("/");
			builder.append(to.getLng());
			builder.append("\r\n");
		}
		return builder;
	}

	private String getMPUrl(String maasId) {
		MaasOperator maasProvider = lookupService.getMaasOperator(maasId);

		if (maasProvider != null) {
			return maasProvider.getUrl();
		}
		String address = request.getRemoteAddr();
		int indexOf = address.indexOf('/', 10);
		if (indexOf == -1) {
			address = "http://localhost:8086";
			return address;
		}
		return address.substring(0, indexOf);
	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;
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

	public void saveResult(String id, boolean committed, String remark) {
		Booking booking = repository.getBooking(id);
		booking.setState(committed ? BookingState.CONFIRMED : BookingState.CANCELLED);
		if (!committed) {
			KeyValue e = new KeyValue();
			e.put("DenyReason", remark);
			booking.getMeta().add(e);
		}
		repository.saveBooking(booking);

		BookingOperation operation = new BookingOperation();
		operation.setOperation(committed ? OperationEnum.COMMIT : OperationEnum.DENY);
		for (KeyValue kv : booking.getMeta()) {
			if (kv.get(MAAS_ID) != null) {
				MaasOperator mp = lookupService.getMaasOperator(kv.get(MAAS_ID).toString());
				if (mp != null) {
					try {
						clientUtil.post(mp, "/bookings/" + id + "/events", operation, Void.class);
					} catch (ApiException e) {
						log.error("MP {} cannot be reached", kv.get(MAAS_ID));
						log.error(e.getMessage());
					}
				} else {
					log.error("MP not in meta directory: {} or Meta directory not available", kv.get(MAAS_ID));
				}
				return;
			}
		}
	}

}
