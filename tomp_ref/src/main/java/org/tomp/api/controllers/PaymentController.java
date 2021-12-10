package org.tomp.api.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.OffsetDateTime;
import org.tomp.api.payment.PaymentProvider;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.PaymentApiController;
import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class PaymentController extends PaymentApiController {

	@Autowired
	PaymentProvider provider;

	public PaymentController(ObjectMapper objectMapper, HttpServletRequest request) {
		super(objectMapper, request);
	}

	@Override
	public ResponseEntity<JournalEntry> paymentIdClaimExtraCostsPost(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.PATH, description = "Booking identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo,
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody ExtraCosts body) {
		return new ResponseEntity<>(provider.claimExtraCosts(acceptLanguage, api, apiVersion, id, body), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<JournalEntry>> paymentJournalEntryGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema()) @Valid @RequestParam(value = "from", required = false) OffsetDateTime from,
			@Parameter(in = ParameterIn.QUERY, description = "end of the selection", schema = @Schema()) @Valid @RequestParam(value = "to", required = false) OffsetDateTime to,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "state", required = false) JournalState state,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "id", required = false) String id,
			@Parameter(in = ParameterIn.QUERY, description = "type of booking line (e.g. fare, addition costs, fines, ...)", schema = @Schema(allowableValues = {
					"ALL", "DAMAGE", "LOSS", "STOLEN", "EXTRA_USAGE", "REFUND", "FINE", "OTHER_ASSET_USED", "CREDIT",
					"VOUCHER", "DEPOSIT",
					"OTHER" })) @Valid @RequestParam(value = "category", required = false) String category,
			@Min(0) @Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(allowableValues = {}, defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
			@Min(0) @Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema(allowableValues = {})) @Valid @RequestParam(value = "limit", required = false) Integer limit) {
		List<JournalEntry> journalEntries = provider.getJournalEntries(acceptLanguage, api, apiVersion, from, to, state,
				category, id, maasId);
		return new ResponseEntity<>(journalEntries, HttpStatus.OK);
	}
}
