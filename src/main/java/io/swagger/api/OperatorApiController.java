package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemAlert;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-24T15:10:42.894Z[GMT]")
@Controller
public class OperatorApiController implements OperatorApi {

    private static final Logger log = LoggerFactory.getLogger(OperatorApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OperatorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<SystemAlert> operatorAlertsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SystemAlert>(objectMapper.readValue("{\n  \"alerts\" : [ {\n    \"summary\" : \"station closed\",\n    \"alert-id\" : \"alert-id\",\n    \"start-and-end-times\" : [ {\n      \"start-time\" : 1546336800\n    }, {\n      \"start-time\" : 1546336800\n    } ],\n    \"alert-type\" : \"SYSTEMCLOSURE\",\n    \"station-ids\" : \"stationID0001\",\n    \"region-id\" : \"regionID0001\",\n    \"description\" : \"station closed indefinitely due to vandalism\",\n    \"url\" : \"http://www.rentmyfreebike.com/alerts\"\n  }, {\n    \"summary\" : \"station closed\",\n    \"alert-id\" : \"alert-id\",\n    \"start-and-end-times\" : [ {\n      \"start-time\" : 1546336800\n    }, {\n      \"start-time\" : 1546336800\n    } ],\n    \"alert-type\" : \"SYSTEMCLOSURE\",\n    \"station-ids\" : \"stationID0001\",\n    \"region-id\" : \"regionID0001\",\n    \"description\" : \"station closed indefinitely due to vandalism\",\n    \"url\" : \"http://www.rentmyfreebike.com/alerts\"\n  } ]\n}", SystemAlert.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SystemAlert>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SystemAlert>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Object>> operatorAvailableAssetsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Object>>(objectMapper.readValue("[ \"\", \"\" ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Object>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<SystemInformation>> operatorInformationGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<SystemInformation>>(objectMapper.readValue("[ {\n  \"information\" : [ {\n    \"phone-number\" : \"555-12345\",\n    \"purchase-url\" : \"https://www.rentmyfreebike.com/purchase\",\n    \"timezone\" : \"IST\",\n    \"language\" : \"eng\",\n    \"start-date\" : \"2000-01-23\",\n    \"operator\" : \"FreeBike\",\n    \"url\" : \"https://www.rentmyfreebike.com\",\n    \"short-name\" : \"FB\",\n    \"type-of-system\" : \"FREE_FLOATING\",\n    \"system-id\" : \"XXTO0001\",\n    \"name\" : \"FreeBike\",\n    \"license-url\" : \"https://www.rentmyfreebike.com/license\",\n    \"conditions\" : \"conditions\",\n    \"email\" : \"rent@freebike.com\"\n  }, {\n    \"phone-number\" : \"555-12345\",\n    \"purchase-url\" : \"https://www.rentmyfreebike.com/purchase\",\n    \"timezone\" : \"IST\",\n    \"language\" : \"eng\",\n    \"start-date\" : \"2000-01-23\",\n    \"operator\" : \"FreeBike\",\n    \"url\" : \"https://www.rentmyfreebike.com\",\n    \"short-name\" : \"FB\",\n    \"type-of-system\" : \"FREE_FLOATING\",\n    \"system-id\" : \"XXTO0001\",\n    \"name\" : \"FreeBike\",\n    \"license-url\" : \"https://www.rentmyfreebike.com/license\",\n    \"conditions\" : \"conditions\",\n    \"email\" : \"rent@freebike.com\"\n  } ]\n}, {\n  \"information\" : [ {\n    \"phone-number\" : \"555-12345\",\n    \"purchase-url\" : \"https://www.rentmyfreebike.com/purchase\",\n    \"timezone\" : \"IST\",\n    \"language\" : \"eng\",\n    \"start-date\" : \"2000-01-23\",\n    \"operator\" : \"FreeBike\",\n    \"url\" : \"https://www.rentmyfreebike.com\",\n    \"short-name\" : \"FB\",\n    \"type-of-system\" : \"FREE_FLOATING\",\n    \"system-id\" : \"XXTO0001\",\n    \"name\" : \"FreeBike\",\n    \"license-url\" : \"https://www.rentmyfreebike.com/license\",\n    \"conditions\" : \"conditions\",\n    \"email\" : \"rent@freebike.com\"\n  }, {\n    \"phone-number\" : \"555-12345\",\n    \"purchase-url\" : \"https://www.rentmyfreebike.com/purchase\",\n    \"timezone\" : \"IST\",\n    \"language\" : \"eng\",\n    \"start-date\" : \"2000-01-23\",\n    \"operator\" : \"FreeBike\",\n    \"url\" : \"https://www.rentmyfreebike.com\",\n    \"short-name\" : \"FB\",\n    \"type-of-system\" : \"FREE_FLOATING\",\n    \"system-id\" : \"XXTO0001\",\n    \"name\" : \"FreeBike\",\n    \"license-url\" : \"https://www.rentmyfreebike.com/license\",\n    \"conditions\" : \"conditions\",\n    \"email\" : \"rent@freebike.com\"\n  } ]\n} ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<SystemInformation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<SystemInformation>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SystemCalendar> operatorOperatingCalendarGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SystemCalendar>(objectMapper.readValue("{\n  \"periods\" : [ {\n    \"end-month\" : 12,\n    \"start-day\" : 1,\n    \"end-year\" : 2099,\n    \"start-year\" : 2019,\n    \"end-day\" : 31,\n    \"start-month\" : 1\n  }, {\n    \"end-month\" : 12,\n    \"start-day\" : 1,\n    \"end-year\" : 2099,\n    \"start-year\" : 2019,\n    \"end-day\" : 31,\n    \"start-month\" : 1\n  } ]\n}", SystemCalendar.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SystemCalendar>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SystemCalendar>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SystemHours> operatorOperatingHoursGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SystemHours>(objectMapper.readValue("{\n  \"hours\" : [ {\n    \"user-type\" : \"MEMBER\",\n    \"start-time\" : {\n      \"timezone\" : \"timezone\",\n      \"time\" : \"time\"\n    },\n    \"days\" : [ \"MON\", \"MON\" ]\n  }, {\n    \"user-type\" : \"MEMBER\",\n    \"start-time\" : {\n      \"timezone\" : \"timezone\",\n      \"time\" : \"time\"\n    },\n    \"days\" : [ \"MON\", \"MON\" ]\n  } ]\n}", SystemHours.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SystemHours>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SystemHours>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SystemPricingPlan> operatorPricingPlansGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SystemPricingPlan>(objectMapper.readValue("{\n  \"pricing-plan\" : [ {\n    \"plan-id\" : \"freeplan1\",\n    \"fare\" : {\n      \"estimated\" : true,\n      \"parts\" : [ {\n        \"amount\" : 9.96,\n        \"currency-code\" : \"EUR\",\n        \"tax-rate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unit-type\" : \"HOUR\",\n        \"units\" : 1\n      }, {\n        \"amount\" : 9.96,\n        \"currency-code\" : \"EUR\",\n        \"tax-rate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unit-type\" : \"HOUR\",\n        \"units\" : 1\n      } ],\n      \"description\" : \"description\",\n      \"class\" : \"class\"\n    },\n    \"is-taxable\" : true,\n    \"name\" : \"Free Plan\",\n    \"description\" : \"Unlimited plan for free bikes, as long as you don't break them!\",\n    \"url\" : \"https://www.rentmyfreebike.com/freeplan\"\n  }, {\n    \"plan-id\" : \"freeplan1\",\n    \"fare\" : {\n      \"estimated\" : true,\n      \"parts\" : [ {\n        \"amount\" : 9.96,\n        \"currency-code\" : \"EUR\",\n        \"tax-rate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unit-type\" : \"HOUR\",\n        \"units\" : 1\n      }, {\n        \"amount\" : 9.96,\n        \"currency-code\" : \"EUR\",\n        \"tax-rate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unit-type\" : \"HOUR\",\n        \"units\" : 1\n      } ],\n      \"description\" : \"description\",\n      \"class\" : \"class\"\n    },\n    \"is-taxable\" : true,\n    \"name\" : \"Free Plan\",\n    \"description\" : \"Unlimited plan for free bikes, as long as you don't break them!\",\n    \"url\" : \"https://www.rentmyfreebike.com/freeplan\"\n  } ]\n}", SystemPricingPlan.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SystemPricingPlan>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SystemPricingPlan>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SystemRegion> operatorRegionsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SystemRegion>(objectMapper.readValue("{\n  \"regions\" : [ {\n    \"name\" : \"BikeTown\",\n    \"region-id\" : \"BikeRegion\"\n  }, {\n    \"name\" : \"BikeTown\",\n    \"region-id\" : \"BikeRegion\"\n  } ]\n}", SystemRegion.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SystemRegion>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SystemRegion>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<StationInformation> operatorStationsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StationInformation>(objectMapper.readValue("{\n  \"stations\" : [ {\n    \"rental-url\" : \"https://www.rentmyfreebike.com\",\n    \"coordinate\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"station-id\" : \"XX:Y:12345678\",\n    \"cross-street\" : \"on the corner with Secondary Road\",\n    \"name\" : \"Island Central\",\n    \"region-id\" : \"region-id\",\n    \"rental-methods\" : [ \"CREDITCARD\", \"PAYPASS\", \"APPLEPAY\" ],\n    \"physical-address\" : {\n      \"country\" : \"NL\",\n      \"postal-code\" : \"postal-code\",\n      \"street-address\" : \"example street 18, 2nd floor, 18B-33\",\n      \"area-reference\" : \"Smallcity, Pinetree county\"\n    }\n  }, {\n    \"rental-url\" : \"https://www.rentmyfreebike.com\",\n    \"coordinate\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"station-id\" : \"XX:Y:12345678\",\n    \"cross-street\" : \"on the corner with Secondary Road\",\n    \"name\" : \"Island Central\",\n    \"region-id\" : \"region-id\",\n    \"rental-methods\" : [ \"CREDITCARD\", \"PAYPASS\", \"APPLEPAY\" ],\n    \"physical-address\" : {\n      \"country\" : \"NL\",\n      \"postal-code\" : \"postal-code\",\n      \"street-address\" : \"example street 18, 2nd floor, 18B-33\",\n      \"area-reference\" : \"Smallcity, Pinetree county\"\n    }\n  } ]\n}", StationInformation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StationInformation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StationInformation>(HttpStatus.NOT_IMPLEMENTED);
    }

}
