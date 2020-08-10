package org.tomp.api.tripexecution;

import java.math.BigDecimal;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.tomp.api.controllers.WebsocketController;
import org.tomp.api.model.LookupService;
import org.tomp.api.model.MaasEnvironmentType;
import org.tomp.api.model.MaasOperator;
import org.tomp.api.repository.DefaultRepository;
import org.tomp.api.utils.ClientUtil;

import io.swagger.client.ApiException;
import io.swagger.model.Booking;
import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalCategory;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.LegEvent.EventEnum;
import io.swagger.model.Notification;
import io.swagger.model.Notification.TypeEnum;

@Component
@ConditionalOnProperty(value = "tomp.providers.tripexecution", havingValue = "taxi", matchIfMissing = false)
/*
 * The Taxi Trip Executor is in the lead. It will report the MP about the
 * progress using a) sending the prepare event as soon the taxi starts heading
 * to the pick up point b) sends notifications with ETAs c) sends a notification
 * at arrival at the pick up point d) sends a setInUse event when leaving the
 * pick up point e) sends a finish event when arrived
 */
public class TaxiTripExecutionProvider implements TripExecutionProvider {

	private static final String MAAS_ID = "maas-id";
	private static final Logger log = LoggerFactory.getLogger(TaxiTripExecutionProvider.class);

	@Autowired
	private DefaultRepository repository;
	@Autowired
	private LookupService lookupService;
	@Autowired
	private ClientUtil clientUtil;
	@Autowired
	WebsocketController websocket;

	String tripId;
	String maasIdFromMP;
	MaasOperator mp;

	Random random = new Random();

	public void startExecution(String tripId) {
		this.tripId = tripId;

		Booking booking = repository.getBooking(tripId);

		for (Entry<String, Object> kv : booking.getExtraData().entrySet()) {
			if (kv.getKey().equals(MAAS_ID)) {
				maasIdFromMP = kv.getValue().toString();
			}
		}
		if (maasIdFromMP == null)
			return;

		findMp();

		waitAFewSeconds();
		sendPrepare();

		int remainingSeconds = random.nextInt(10);
		while (remainingSeconds > 0) {
			waitAFewSeconds();
			sendETA(remainingSeconds);
			int minus = random.nextInt(remainingSeconds);
			if (minus == 0)
				remainingSeconds = 0;
			else
				remainingSeconds -= minus;
		}
		sendArrivalAtPickup();
		waitAFewSeconds();
		sendSetInUse();
		waitAFewSeconds();
		sendFinish();
		sendExtraCosts();
	}

	private void findMp() {
		if (mp == null) {
			mp = lookupService.getMaasOperator(maasIdFromMP);
			if (mp == null) {
				mp = new MaasOperator();
				mp.setId(UUID.randomUUID().toString());
				mp.setName("Dummy MP");
				mp.setType(MaasEnvironmentType.MP);
				mp.setUrl("http://localhost:7999/");
			}
			return;
		}
		if (!mp.getId().equals(maasIdFromMP)) {
			mp = lookupService.getMaasOperator(maasIdFromMP);
		}
	}

	private void sendExtraCosts() {
		if (mp != null) {
			try {
				ExtraCosts toSend = new ExtraCosts();
				toSend.setAmount(BigDecimal.valueOf(3.12));
				toSend.setCategory(JournalCategory.EXTRA_USAGE);
				toSend.setCurrencyCode("EUR");
				toSend.setDescription("Difference between estimated initial costs");

				JournalEntry entry = new JournalEntry();
				entry.setAmount(toSend.getAmount());
				entry.setComment(toSend.getDescription());
				entry.setDetails(toSend);
				entry.setState(JournalState.TO_INVOICE);
				entry.setJournalId(tripId);
				repository.saveJournalEntry(entry, maasIdFromMP);

				clientUtil.patch(mp, "/payment/" + tripId + "/claim-extra-costs", toSend, Void.class);
				websocket.sendMessage("PATCH /payment/" + tripId + "/claim-extra-costs", toSend);
			} catch (ApiException e) {
				log.error("MP {} cannot be reached", maasIdFromMP);
				log.error(e.getMessage());
			}
		} else {
			log.error("MP not in meta directory: {} or Meta directory not available", maasIdFromMP);
		}
	}

	private void send(String url, Object toSend) {
		websocket.sendMessage(url, toSend);
		if (mp != null) {
			try {

				clientUtil.post(mp, url, toSend, Void.class);
			} catch (ApiException e) {
				log.error("MP {} cannot be reached", maasIdFromMP);
				log.error(e.getMessage());
			}
		} else {
			log.error("MP not in meta directory: {} or Meta directory not available", maasIdFromMP);
		}
	}

	private void sendFinish() {
		LegEvent event = new LegEvent();
		event.setEvent(EventEnum.FINISH);
		send("/legs/" + tripId + "/events", event);
	}

	private void sendSetInUse() {
		LegEvent event = new LegEvent();
		event.setEvent(EventEnum.SET_IN_USE);
		send("/legs/" + tripId + "/events", event);
	}

	private void sendArrivalAtPickup() {
		Notification notification = new Notification();
		notification.setType(TypeEnum.ETA);
		notification.setComment("Arrived");
		send("/bookings/" + tripId + "/notifications", notification);
	}

	private void sendETA(int remainingSeconds) {
		Notification notification = new Notification();
		notification.setType(TypeEnum.ETA);
		notification.setComment(String.format("Seconds to ETA: %s", remainingSeconds));
		send("/bookings/" + tripId + "/notifications", notification);
	}

	private void sendPrepare() {
		LegEvent event = new LegEvent();
		event.setEvent(EventEnum.PREPARE);
		send("/legs/" + tripId + "/events", event);
	}

	private void waitAFewSeconds() {
		try {
			Thread.sleep(1000L * random.nextInt(5));
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public Leg prepare(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg assignAsset(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg reserve(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg setInUse(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg pause(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg startFinishing(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public Leg finish(LegEvent body, String acceptLanguage, String id, String maasId) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}
}
