package io.swagger.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")
@RestController
public class PaymentApiController implements PaymentApi {

	private static final Logger log = LoggerFactory.getLogger(PaymentApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public PaymentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<JournalEntry> paymentIdClaimExtraCostsPost(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Booking identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody ExtraCosts body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<JournalEntry>(objectMapper.readValue("\"\"", JournalEntry.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<JournalEntry>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<JournalEntry>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<JournalEntry>> paymentJournalEntryGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema()) @Valid @RequestParam(value = "from", required = false) OffsetDateTime from,
			@Parameter(in = ParameterIn.QUERY, description = "end of the selection", schema = @Schema()) @Valid @RequestParam(value = "to", required = false) OffsetDateTime to,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "state", required = false) JournalState state,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "id", required = false) String id,
			@Parameter(in = ParameterIn.QUERY, description = "type of booking line (e.g. fare, addition costs, fines, ...)", schema = @Schema(allowableValues = {
					"ALL", "DAMAGE", "LOSS", "STOLEN", "EXTRA_USAGE", "REFUND", "FINE", "OTHER_ASSET_USED", "CREDIT",
					"VOUCHER", "DEPOSIT",
					"OTHER" })) @Valid @RequestParam(value = "category", required = false) String category,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<JournalEntry>>(objectMapper.readValue("[ \"\", \"\" ]", List.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<JournalEntry>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<JournalEntry>>(HttpStatus.NOT_IMPLEMENTED);
	}

}
