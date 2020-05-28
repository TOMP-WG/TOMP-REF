package org.tomp.api.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.tomp.api.payment.PaymentProvider;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.PaymentApiController;
import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;

@RestController
public class PaymentController extends PaymentApiController {

	@Autowired
	PaymentProvider provider;
	private HttpServletRequest request;

	public PaymentController(ObjectMapper objectMapper, HttpServletRequest request) {
		super(objectMapper, request);
		this.request = request;
	}

	@Override
	public ResponseEntity<JournalEntry> paymentIdClaimExtraCostsPatch(String acceptLanguage, String api,
			String apiVersion, String id, ExtraCosts body) {
		return new ResponseEntity<>(provider.claimExtraCosts(acceptLanguage, api, apiVersion, id, body), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<JournalEntry>> paymentJournalEntryGet(String acceptLanguage, String api,
			String apiVersion, BigDecimal from, BigDecimal to, JournalState state, String category) {
		String maasId = request.getHeader("maas-id");
		return new ResponseEntity<>(
				provider.getJournalEntries(acceptLanguage, api, apiVersion, from, to, state, category, maasId),
				HttpStatus.OK);
	}
}
