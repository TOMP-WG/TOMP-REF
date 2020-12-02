package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;
import org.threeten.bp.OffsetDateTime;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-08-06T12:33:00.035Z[GMT]")
@Controller
public class PaymentApiController implements PaymentApi {

    private static final Logger log = LoggerFactory.getLogger(PaymentApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PaymentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<JournalEntry> paymentIdClaimExtraCostsPost(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody ExtraCosts body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<JournalEntry>(objectMapper.readValue("\"\"", JournalEntry.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<JournalEntry>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<JournalEntry>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<JournalEntry>> paymentJournalEntryGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "start of the selection") @Valid @RequestParam(value = "from", required = false) OffsetDateTime from
,@ApiParam(value = "end of the selection") @Valid @RequestParam(value = "to", required = false) OffsetDateTime to
,@ApiParam(value = "") @Valid @RequestParam(value = "state", required = false) JournalState state
,@ApiParam(value = "") @Valid @RequestParam(value = "id", required = false) String id
,@ApiParam(value = "type of booking line (e.g. fare, addition costs, fines, ...)", allowableValues = "ALL, DAMAGE, LOSS, STOLEN, EXTRA_USAGE, REFUND, FINE, OTHER_ASSET_USED, CREDIT, VOUCHER, DEPOSIT, OTHER") @Valid @RequestParam(value = "category", required = false) String category
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<JournalEntry>>(objectMapper.readValue("[ \"\", \"\" ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<JournalEntry>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<JournalEntry>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
