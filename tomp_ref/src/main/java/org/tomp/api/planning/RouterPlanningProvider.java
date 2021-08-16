package org.tomp.api.planning;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.utils.ClientUtil;
import org.tomp.api.utils.RouterUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Place;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "router", matchIfMissing = false)
public class RouterPlanningProvider implements PlanningProvider {

	private static final Logger log = LoggerFactory.getLogger(RouterPlanningProvider.class);

	protected Place from;
	protected Place to;
	protected @Valid OffsetDateTime start;
	protected @Valid OffsetDateTime end;
	@Autowired
	ClientUtil clientUtil;
	@Autowired
	ExternalConfiguration configuration;
	@Autowired
	ObjectMapper mapper;

	@Autowired
	RouterUtil routerUtil;

	@Override
	public Planning getOptions(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		log.info("Request for options");
		try {
			return getResults(body, acceptLanguage, bookingIntent);
		} catch (UnrecoverableKeyException | InvalidKeyException | FileNotFoundException | KeyStoreException
				| CertificateException | UnsupportedEncodingException | NoSuchAlgorithmException | SignatureException
				| JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Planning getResults(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent)
			throws UnrecoverableKeyException, InvalidKeyException, FileNotFoundException, KeyStoreException,
			CertificateException, UnsupportedEncodingException, NoSuchAlgorithmException, SignatureException,
			JsonProcessingException {

		String localVarPath = "/plannings/?booking-intent=" + Boolean.toString(bookingIntent);
		return routerUtil.sendToTO("POST", localVarPath, Planning.class, body, acceptLanguage);
	}
}
