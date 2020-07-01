package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-10T13:55:00.069Z[GMT]")
@Controller
public class PlanningsApiController implements PlanningsApi {

    private static final Logger log = LoggerFactory.getLogger(PlanningsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PlanningsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Planning> planningsIdGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Planning identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Planning>(objectMapper.readValue("{\n  \"legOptions\" : [ {\n    \"parts\" : [ null, null ],\n    \"from\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"id\" : \"id\",\n    \"asset\" : {\n      \"pets\" : true,\n      \"airConditioning\" : true,\n      \"other\" : \"other\",\n      \"amountAvailable\" : 0.8008281904610115,\n      \"fuel\" : \"NONE\",\n      \"travelAbroad\" : true,\n      \"assetClass\" : \"AIR\",\n      \"energyLabel\" : \"A\",\n      \"winterTires\" : true,\n      \"undergroundParking\" : true,\n      \"assets\" : [ \"\", \"\" ],\n      \"smoking\" : true,\n      \"towingHook\" : true,\n      \"model\" : \"model\",\n      \"gearbox\" : \"MANUAL\",\n      \"cargo\" : \"cargo\",\n      \"brand\" : \"brand\",\n      \"gears\" : 5,\n      \"cabrio\" : true,\n      \"image\" : \"http://example.com/aeiou\",\n      \"buildingYear\" : 1.4658129805029452,\n      \"stateOfCharge\" : 23,\n      \"co2PerKm\" : 6.027456183070403,\n      \"propulsion\" : \"MUSCLE\",\n      \"assetSubClass\" : \"assetSubClass\",\n      \"infantSeat\" : true,\n      \"persons\" : 5,\n      \"colour\" : \"colour\",\n      \"easyAccessibility\" : \"LIFT\",\n      \"meta\" : [ {\n        \"wheelchair\" : true\n      }, {\n        \"wheelchair\" : true\n      } ],\n      \"name\" : \"name\",\n      \"typeId\" : \"typeId\"\n    },\n    \"conditions\" : [ \"conditions\", \"conditions\" ],\n    \"suboperator\" : {\n      \"maasId\" : \"maasId\",\n      \"contact\" : \"contact\",\n      \"name\" : \"name\",\n      \"description\" : \"description\"\n    },\n    \"pricing\" : {\n      \"estimated\" : true,\n      \"parts\" : [ {\n        \"amount\" : 9.96,\n        \"currencyCode\" : \"EUR\",\n        \"taxRate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unitType\" : \"HOUR\",\n        \"units\" : 1\n      }, {\n        \"amount\" : 9.96,\n        \"currencyCode\" : \"EUR\",\n        \"taxRate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unitType\" : \"HOUR\",\n        \"units\" : 1\n      } ],\n      \"description\" : \"description\",\n      \"class\" : \"class\"\n    }\n  }, {\n    \"parts\" : [ null, null ],\n    \"from\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"id\" : \"id\",\n    \"asset\" : {\n      \"pets\" : true,\n      \"airConditioning\" : true,\n      \"other\" : \"other\",\n      \"amountAvailable\" : 0.8008281904610115,\n      \"fuel\" : \"NONE\",\n      \"travelAbroad\" : true,\n      \"assetClass\" : \"AIR\",\n      \"energyLabel\" : \"A\",\n      \"winterTires\" : true,\n      \"undergroundParking\" : true,\n      \"assets\" : [ \"\", \"\" ],\n      \"smoking\" : true,\n      \"towingHook\" : true,\n      \"model\" : \"model\",\n      \"gearbox\" : \"MANUAL\",\n      \"cargo\" : \"cargo\",\n      \"brand\" : \"brand\",\n      \"gears\" : 5,\n      \"cabrio\" : true,\n      \"image\" : \"http://example.com/aeiou\",\n      \"buildingYear\" : 1.4658129805029452,\n      \"stateOfCharge\" : 23,\n      \"co2PerKm\" : 6.027456183070403,\n      \"propulsion\" : \"MUSCLE\",\n      \"assetSubClass\" : \"assetSubClass\",\n      \"infantSeat\" : true,\n      \"persons\" : 5,\n      \"colour\" : \"colour\",\n      \"easyAccessibility\" : \"LIFT\",\n      \"meta\" : [ {\n        \"wheelchair\" : true\n      }, {\n        \"wheelchair\" : true\n      } ],\n      \"name\" : \"name\",\n      \"typeId\" : \"typeId\"\n    },\n    \"conditions\" : [ \"conditions\", \"conditions\" ],\n    \"suboperator\" : {\n      \"maasId\" : \"maasId\",\n      \"contact\" : \"contact\",\n      \"name\" : \"name\",\n      \"description\" : \"description\"\n    },\n    \"pricing\" : {\n      \"estimated\" : true,\n      \"parts\" : [ {\n        \"amount\" : 9.96,\n        \"currencyCode\" : \"EUR\",\n        \"taxRate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unitType\" : \"HOUR\",\n        \"units\" : 1\n      }, {\n        \"amount\" : 9.96,\n        \"currencyCode\" : \"EUR\",\n        \"taxRate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unitType\" : \"HOUR\",\n        \"units\" : 1\n      } ],\n      \"description\" : \"description\",\n      \"class\" : \"class\"\n    }\n  } ],\n  \"validUntil\" : \"2020-06-28T14:55:00+02:00\",\n  \"conditions\" : [ {\n    \"conditionType\" : \"conditionType\",\n    \"id\" : \"deposit50eu\"\n  }, {\n    \"conditionType\" : \"conditionType\",\n    \"id\" : \"deposit50eu\"\n  } ]\n}", Planning.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Planning>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Planning>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Planning> planningsPost(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = ""  )  @Valid @RequestBody PlanningRequest body
,@ApiParam(value = "Specifies whether IDs should be returned for the leg options that can be referred to when booking", defaultValue = "false") @Valid @RequestParam(value = "booking-intent", required = false, defaultValue="false") Boolean bookingIntent
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Planning>(objectMapper.readValue("{\n  \"legOptions\" : [ {\n    \"parts\" : [ null, null ],\n    \"from\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"id\" : \"id\",\n    \"asset\" : {\n      \"pets\" : true,\n      \"airConditioning\" : true,\n      \"other\" : \"other\",\n      \"amountAvailable\" : 0.8008281904610115,\n      \"fuel\" : \"NONE\",\n      \"travelAbroad\" : true,\n      \"assetClass\" : \"AIR\",\n      \"energyLabel\" : \"A\",\n      \"winterTires\" : true,\n      \"undergroundParking\" : true,\n      \"assets\" : [ \"\", \"\" ],\n      \"smoking\" : true,\n      \"towingHook\" : true,\n      \"model\" : \"model\",\n      \"gearbox\" : \"MANUAL\",\n      \"cargo\" : \"cargo\",\n      \"brand\" : \"brand\",\n      \"gears\" : 5,\n      \"cabrio\" : true,\n      \"image\" : \"http://example.com/aeiou\",\n      \"buildingYear\" : 1.4658129805029452,\n      \"stateOfCharge\" : 23,\n      \"co2PerKm\" : 6.027456183070403,\n      \"propulsion\" : \"MUSCLE\",\n      \"assetSubClass\" : \"assetSubClass\",\n      \"infantSeat\" : true,\n      \"persons\" : 5,\n      \"colour\" : \"colour\",\n      \"easyAccessibility\" : \"LIFT\",\n      \"meta\" : [ {\n        \"wheelchair\" : true\n      }, {\n        \"wheelchair\" : true\n      } ],\n      \"name\" : \"name\",\n      \"typeId\" : \"typeId\"\n    },\n    \"conditions\" : [ \"conditions\", \"conditions\" ],\n    \"suboperator\" : {\n      \"maasId\" : \"maasId\",\n      \"contact\" : \"contact\",\n      \"name\" : \"name\",\n      \"description\" : \"description\"\n    },\n    \"pricing\" : {\n      \"estimated\" : true,\n      \"parts\" : [ {\n        \"amount\" : 9.96,\n        \"currencyCode\" : \"EUR\",\n        \"taxRate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unitType\" : \"HOUR\",\n        \"units\" : 1\n      }, {\n        \"amount\" : 9.96,\n        \"currencyCode\" : \"EUR\",\n        \"taxRate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unitType\" : \"HOUR\",\n        \"units\" : 1\n      } ],\n      \"description\" : \"description\",\n      \"class\" : \"class\"\n    }\n  }, {\n    \"parts\" : [ null, null ],\n    \"from\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"id\" : \"id\",\n    \"asset\" : {\n      \"pets\" : true,\n      \"airConditioning\" : true,\n      \"other\" : \"other\",\n      \"amountAvailable\" : 0.8008281904610115,\n      \"fuel\" : \"NONE\",\n      \"travelAbroad\" : true,\n      \"assetClass\" : \"AIR\",\n      \"energyLabel\" : \"A\",\n      \"winterTires\" : true,\n      \"undergroundParking\" : true,\n      \"assets\" : [ \"\", \"\" ],\n      \"smoking\" : true,\n      \"towingHook\" : true,\n      \"model\" : \"model\",\n      \"gearbox\" : \"MANUAL\",\n      \"cargo\" : \"cargo\",\n      \"brand\" : \"brand\",\n      \"gears\" : 5,\n      \"cabrio\" : true,\n      \"image\" : \"http://example.com/aeiou\",\n      \"buildingYear\" : 1.4658129805029452,\n      \"stateOfCharge\" : 23,\n      \"co2PerKm\" : 6.027456183070403,\n      \"propulsion\" : \"MUSCLE\",\n      \"assetSubClass\" : \"assetSubClass\",\n      \"infantSeat\" : true,\n      \"persons\" : 5,\n      \"colour\" : \"colour\",\n      \"easyAccessibility\" : \"LIFT\",\n      \"meta\" : [ {\n        \"wheelchair\" : true\n      }, {\n        \"wheelchair\" : true\n      } ],\n      \"name\" : \"name\",\n      \"typeId\" : \"typeId\"\n    },\n    \"conditions\" : [ \"conditions\", \"conditions\" ],\n    \"suboperator\" : {\n      \"maasId\" : \"maasId\",\n      \"contact\" : \"contact\",\n      \"name\" : \"name\",\n      \"description\" : \"description\"\n    },\n    \"pricing\" : {\n      \"estimated\" : true,\n      \"parts\" : [ {\n        \"amount\" : 9.96,\n        \"currencyCode\" : \"EUR\",\n        \"taxRate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unitType\" : \"HOUR\",\n        \"units\" : 1\n      }, {\n        \"amount\" : 9.96,\n        \"currencyCode\" : \"EUR\",\n        \"taxRate\" : 21,\n        \"type\" : \"FLEX\",\n        \"unitType\" : \"HOUR\",\n        \"units\" : 1\n      } ],\n      \"description\" : \"description\",\n      \"class\" : \"class\"\n    }\n  } ],\n  \"validUntil\" : \"2020-06-28T14:55:00+02:00\",\n  \"conditions\" : [ {\n    \"conditionType\" : \"conditionType\",\n    \"id\" : \"deposit50eu\"\n  }, {\n    \"conditionType\" : \"conditionType\",\n    \"id\" : \"deposit50eu\"\n  } ]\n}", Planning.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Planning>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Planning>(HttpStatus.NOT_IMPLEMENTED);
    }

}
