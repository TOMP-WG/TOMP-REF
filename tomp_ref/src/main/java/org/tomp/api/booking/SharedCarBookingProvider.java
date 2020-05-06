package org.tomp.api.booking;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.model.LookupService;
import org.tomp.api.model.MaasOperator;
import org.tomp.api.model.MaasProvider;
import org.tomp.api.repository.DummyRepository;
import org.tomp.api.utils.ClientUtil;
import org.tomp.api.utils.MailUtil;

import io.swagger.client.ApiException;
import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOperation.OperationEnum;
import io.swagger.model.BookingOption;
import io.swagger.model.BookingState;
import io.swagger.model.Coordinates;
import io.swagger.model.Customer;
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
			sendMail(mpUrl, booking);
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

	private void sendMail(String mpUrl, Booking booking) {
		StringBuilder builder = getBookingRequestText(booking);
		mailService.sendSimpleMessage("booking@tomp.nl", configuration.getBookingMailBox(),
				"Booking request: " + booking.getId(), builder.toString());

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
		MaasProvider maasProvider = lookupService.callEndpoint("GET", "/operators/" + maasId, null, MaasProvider.class);

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

	public String getPostponedBookingHtml(String id) {
		Booking booking = repository.getBooking(id);
		StringBuilder builder = getBookingRequestText(booking);
		String firstPart = builder.toString().replace("\r\n", "<br>");
		return firstPart + "<form action=\"/postponed/\" method=\"post\"> <div class=\"control\">"
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
				MaasOperator mp = lookupService.callEndpoint("GET", "/operators/" + kv.get(MAAS_ID).toString(), null,
						MaasOperator.class);
				try {
					clientUtil.post(mp, "/bookings/" + id + "/events", operation, Void.class);
				} catch (ApiException e) {
					log.error(e.getMessage());
				}
				return;
			}
		}
	}

}
