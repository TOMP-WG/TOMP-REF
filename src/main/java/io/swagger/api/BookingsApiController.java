package io.swagger.api;

import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOption;
import io.swagger.model.BookingState;
import io.swagger.model.Error;
import io.swagger.model.Notification;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-24T08:44:01.688Z[GMT]")
@Controller
public class BookingsApiController implements BookingsApi {

    private static final Logger log = LoggerFactory.getLogger(BookingsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BookingsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Booking>> bookingsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "state", required = true) BookingState state
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Booking>>(objectMapper.readValue("[ \"\", \"\" ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Booking>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Booking>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Booking> bookingsIdEventsPost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody BookingOperation body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Booking>(objectMapper.readValue("\"\"", Booking.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Booking>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Booking>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Booking> bookingsIdGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Booking>(objectMapper.readValue("\"\"", Booking.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Booking>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Booking>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Notification>> bookingsIdNotificationsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Notification>>(objectMapper.readValue("[ {\n  \"comment\" : \"comment\",\n  \"type\" : \"VEHICLE_NOT_AVAILABLE\"\n}, {\n  \"comment\" : \"comment\",\n  \"type\" : \"VEHICLE_NOT_AVAILABLE\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Notification>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Notification>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> bookingsIdNotificationsPost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody Notification body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Booking> bookingsIdPut(@ApiParam(value = "changed booking" ,required=true )  @Valid @RequestBody Booking body
,@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Booking>(objectMapper.readValue("\"\"", Booking.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Booking>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Booking>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> bookingsIdSubscriptionDelete(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> bookingsIdSubscriptionPost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody Booking body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Booking> bookingsPost(@ApiParam(value = "One of available options, returned by /planning-options, with an ID." ,required=true )  @Valid @RequestBody BookingOption body
,@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Booking>(objectMapper.readValue("\"\"", Booking.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Booking>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Booking>(HttpStatus.NOT_IMPLEMENTED);
    }

}
