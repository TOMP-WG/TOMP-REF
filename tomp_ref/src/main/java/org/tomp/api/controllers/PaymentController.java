package org.tomp.api.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.OffsetDateTime;
import org.tomp.api.payment.PaymentProvider;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
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
    public ResponseEntity<List<JournalEntry>> paymentJournalEntryGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "start of the selection") @Valid @RequestParam(value = "from", required = false) OffsetDateTime from
,@ApiParam(value = "end of the selection") @Valid @RequestParam(value = "to", required = false) OffsetDateTime to
,@ApiParam(value = "") @Valid @RequestParam(value = "state", required = false) JournalState state
,@ApiParam(value = "") @Valid @RequestParam(value = "id", required = false) String id
,@ApiParam(value = "type of booking line (e.g. fare, addition costs, fines, ...)", allowableValues = "ALL, DAMAGE, LOSS, STOLEN, EXTRA_USAGE, REFUND, FINE, OTHER_ASSET_USED, CREDIT, VOUCHER, DEPOSIT, OTHER") @Valid @RequestParam(value = "category", required = false) String category
) {
		String maasId = request.getHeader("maas-id");

		return new ResponseEntity<>(
				provider.getJournalEntries(acceptLanguage, api, apiVersion, from, to, state, category, id, maasId),
				HttpStatus.OK);
	}
}
