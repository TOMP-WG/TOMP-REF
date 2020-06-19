package org.tomp.api.booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.tomp.api.configuration.GeoDecodeConfiguration;
import org.tomp.api.model.MaasOperator;
import org.tomp.api.repository.DummyRepository;
import org.tomp.api.utils.ClientUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.client.ApiException;
import io.swagger.model.Address;
import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOption;
import io.swagger.model.BookingState;
import io.swagger.model.Coordinates;
import io.swagger.model.Leg;

@Component
@ConditionalOnProperty(value = "tomp.providers.booking", havingValue = "generic", matchIfMissing = true)
public class GenericBookingProvider implements BookingProvider {

	private static final Logger log = LoggerFactory.getLogger(GenericBookingProvider.class);

	protected DummyRepository repository;

	private HashMap<String, Booking> listeners = new HashMap<>();

	@Autowired
	ClientUtil clientUtil;

	@Autowired
	GeoDecodeConfiguration configuration;

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

		if (configuration.isActive()) {
			Leg savedOption = repository.getSavedOption(id);
			Address address = booking.getFromAddress();
			if (address == null) {
				address = new Address();
				booking.setFromAddress(address);
			}
			Coordinates coord = savedOption.getFrom();
			geodecodeAddress(address, coord);

			address = booking.getToAddress();
			if (address == null) {
				address = new Address();
				booking.setToAddress(address);
			}
			coord = savedOption.getTo();
			geodecodeAddress(address, coord);
		}

		repository.saveBooking(booking);

		log.info("Response {}", booking);
		return booking;
	}

	@SuppressWarnings("unchecked")
	private void geodecodeAddress(Address address, Coordinates from) {
		ObjectMapper mapper = new ObjectMapper();
		String url = configuration.getUrl() + "&" + configuration.getLon() + "=" + from.getLng() + "&"
				+ configuration.getLat() + "=" + from.getLat();
		Map<String, Object> map = new HashMap<>();
		try (InputStream is = new URL(url).openStream()) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			String jsonText = readAll(rd);
			map = mapper.readValue(jsonText, Map.class);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		address.setStreetAddress(getValue(configuration.getStreetAddress(), map));
		address.setAreaReference(getValue(configuration.getArea(), map));
		address.setPostalCode(getValue(configuration.getPostalCode(), map));
		address.setCountry(getValue(configuration.getCountry(), map));
	}

	private String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private String getValue(String fields, Map<String, Object> map) {
		StringBuilder street = new StringBuilder();
		for (String field : fields.split("\\|")) {
			String value = getFieldValue(field, map);
			if (value != null) {
				street.append(value);
			} else if (field.contains(",") || field.contains(" ") || field.equals("-")) {
				street.append(field);
			}
		}

		return street.toString().trim();
	}

	@SuppressWarnings("unchecked")
	private String getFieldValue(String field, Map<String, Object> map) {
		if (field.contains(".")) {
			String mapName = field.split("\\.")[0];
			Map<String, Object> submap = (Map<String, Object>) map.get(mapName);
			return getFieldValue(field.substring(field.indexOf('.') + 1), submap);
		}
		if (map.containsKey(field)) {
			return ((String) map.get(field)).trim();
		}
		return null;
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
