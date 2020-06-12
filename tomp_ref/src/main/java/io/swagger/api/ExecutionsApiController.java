package io.swagger.api;

import io.swagger.model.Asset;
import io.swagger.model.Error;
import io.swagger.model.Execution;
import io.swagger.model.ExecutionEvent;
import io.swagger.model.ExecutionProgress;
import io.swagger.model.TypeOfAsset;
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
public class ExecutionsApiController implements ExecutionsApi {

    private static final Logger log = LoggerFactory.getLogger(ExecutionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ExecutionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Asset> executionsIdAssetGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Asset>(objectMapper.readValue("\"\"", Asset.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Asset>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Asset>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<TypeOfAsset>> executionsIdAvailableAssetsGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<TypeOfAsset>>(objectMapper.readValue("[ {\n  \"pets\" : true,\n  \"airConditioning\" : true,\n  \"other\" : \"other\",\n  \"amountAvailable\" : 0.8008281904610115,\n  \"fuel\" : \"NONE\",\n  \"travelAbroad\" : true,\n  \"assetClass\" : \"AIR\",\n  \"energyLabel\" : \"A\",\n  \"winterTires\" : true,\n  \"undergroundParking\" : true,\n  \"assets\" : [ \"\", \"\" ],\n  \"smoking\" : true,\n  \"towingHook\" : true,\n  \"model\" : \"model\",\n  \"gearbox\" : \"MANUAL\",\n  \"cargo\" : \"cargo\",\n  \"brand\" : \"brand\",\n  \"gears\" : 5,\n  \"cabrio\" : true,\n  \"image\" : \"http://example.com/aeiou\",\n  \"buildingYear\" : 1.4658129805029452,\n  \"stateOfCharge\" : 23,\n  \"co2PerKm\" : 6.027456183070403,\n  \"propulsion\" : \"MUSCLE\",\n  \"assetSubClass\" : \"assetSubClass\",\n  \"infantSeat\" : true,\n  \"persons\" : 5,\n  \"colour\" : \"colour\",\n  \"easyAccessibility\" : \"LIFT\",\n  \"meta\" : [ {\n    \"wheelchair\" : true\n  }, {\n    \"wheelchair\" : true\n  } ],\n  \"name\" : \"name\",\n  \"typeId\" : \"typeId\"\n}, {\n  \"pets\" : true,\n  \"airConditioning\" : true,\n  \"other\" : \"other\",\n  \"amountAvailable\" : 0.8008281904610115,\n  \"fuel\" : \"NONE\",\n  \"travelAbroad\" : true,\n  \"assetClass\" : \"AIR\",\n  \"energyLabel\" : \"A\",\n  \"winterTires\" : true,\n  \"undergroundParking\" : true,\n  \"assets\" : [ \"\", \"\" ],\n  \"smoking\" : true,\n  \"towingHook\" : true,\n  \"model\" : \"model\",\n  \"gearbox\" : \"MANUAL\",\n  \"cargo\" : \"cargo\",\n  \"brand\" : \"brand\",\n  \"gears\" : 5,\n  \"cabrio\" : true,\n  \"image\" : \"http://example.com/aeiou\",\n  \"buildingYear\" : 1.4658129805029452,\n  \"stateOfCharge\" : 23,\n  \"co2PerKm\" : 6.027456183070403,\n  \"propulsion\" : \"MUSCLE\",\n  \"assetSubClass\" : \"assetSubClass\",\n  \"infantSeat\" : true,\n  \"persons\" : 5,\n  \"colour\" : \"colour\",\n  \"easyAccessibility\" : \"LIFT\",\n  \"meta\" : [ {\n    \"wheelchair\" : true\n  }, {\n    \"wheelchair\" : true\n  } ],\n  \"name\" : \"name\",\n  \"typeId\" : \"typeId\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<TypeOfAsset>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<TypeOfAsset>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Execution> executionsIdEventsPost(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody ExecutionEvent body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Execution>(objectMapper.readValue("{\n  \"legGeometry\" : \"legGeometry\",\n  \"fare\" : {\n    \"estimated\" : true,\n    \"parts\" : [ {\n      \"amount\" : 9.96,\n      \"currencyCode\" : \"EUR\",\n      \"taxRate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unitType\" : \"HOUR\",\n      \"units\" : 1\n    }, {\n      \"amount\" : 9.96,\n      \"currencyCode\" : \"EUR\",\n      \"taxRate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unitType\" : \"HOUR\",\n      \"units\" : 1\n    } ],\n    \"description\" : \"description\",\n    \"class\" : \"class\"\n  },\n  \"distance\" : 7250,\n  \"agencyId\" : \"agencyId\",\n  \"departureDelay\" : 11112,\n  \"routeLongName\" : \"routeLongName\",\n  \"assetAccessData\" : \"\",\n  \"mode\" : {\n    \"pets\" : true,\n    \"airConditioning\" : true,\n    \"other\" : \"other\",\n    \"amountAvailable\" : 0.8008281904610115,\n    \"fuel\" : \"NONE\",\n    \"travelAbroad\" : true,\n    \"assetClass\" : \"AIR\",\n    \"energyLabel\" : \"A\",\n    \"winterTires\" : true,\n    \"undergroundParking\" : true,\n    \"assets\" : [ \"\", \"\" ],\n    \"smoking\" : true,\n    \"towingHook\" : true,\n    \"model\" : \"model\",\n    \"gearbox\" : \"MANUAL\",\n    \"cargo\" : \"cargo\",\n    \"brand\" : \"brand\",\n    \"gears\" : 5,\n    \"cabrio\" : true,\n    \"image\" : \"http://example.com/aeiou\",\n    \"buildingYear\" : 1.4658129805029452,\n    \"stateOfCharge\" : 23,\n    \"co2PerKm\" : 6.027456183070403,\n    \"propulsion\" : \"MUSCLE\",\n    \"assetSubClass\" : \"assetSubClass\",\n    \"infantSeat\" : true,\n    \"persons\" : 5,\n    \"colour\" : \"colour\",\n    \"easyAccessibility\" : \"LIFT\",\n    \"meta\" : [ {\n      \"wheelchair\" : true\n    }, {\n      \"wheelchair\" : true\n    } ],\n    \"name\" : \"name\",\n    \"typeId\" : \"typeId\"\n  },\n  \"routeShortName\" : \"routeShortName\",\n  \"route\" : \"route\",\n  \"from\" : {\n    \"name\" : \"name\",\n    \"coordinates\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"physicalAddress\" : {\n      \"areaReference\" : \"Smallcity, Pinetree county\",\n      \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n      \"postalCode\" : \"postalCode\"\n    },\n    \"stopReference\" : [ {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    }, {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    } ],\n    \"stationId\" : \"stationId\",\n    \"extraInfo\" : [ {\n      \"wheelchair\" : true\n    }, {\n      \"wheelchair\" : true\n    } ]\n  },\n  \"startTime\" : \"2020-06-28T14:55:00+02:00\",\n  \"state\" : \"NOT_STARTED\"\n}", Execution.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Execution>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Execution>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Execution> executionsIdGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Execution>(objectMapper.readValue("{\n  \"legGeometry\" : \"legGeometry\",\n  \"fare\" : {\n    \"estimated\" : true,\n    \"parts\" : [ {\n      \"amount\" : 9.96,\n      \"currencyCode\" : \"EUR\",\n      \"taxRate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unitType\" : \"HOUR\",\n      \"units\" : 1\n    }, {\n      \"amount\" : 9.96,\n      \"currencyCode\" : \"EUR\",\n      \"taxRate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unitType\" : \"HOUR\",\n      \"units\" : 1\n    } ],\n    \"description\" : \"description\",\n    \"class\" : \"class\"\n  },\n  \"distance\" : 7250,\n  \"agencyId\" : \"agencyId\",\n  \"departureDelay\" : 11112,\n  \"routeLongName\" : \"routeLongName\",\n  \"assetAccessData\" : \"\",\n  \"mode\" : {\n    \"pets\" : true,\n    \"airConditioning\" : true,\n    \"other\" : \"other\",\n    \"amountAvailable\" : 0.8008281904610115,\n    \"fuel\" : \"NONE\",\n    \"travelAbroad\" : true,\n    \"assetClass\" : \"AIR\",\n    \"energyLabel\" : \"A\",\n    \"winterTires\" : true,\n    \"undergroundParking\" : true,\n    \"assets\" : [ \"\", \"\" ],\n    \"smoking\" : true,\n    \"towingHook\" : true,\n    \"model\" : \"model\",\n    \"gearbox\" : \"MANUAL\",\n    \"cargo\" : \"cargo\",\n    \"brand\" : \"brand\",\n    \"gears\" : 5,\n    \"cabrio\" : true,\n    \"image\" : \"http://example.com/aeiou\",\n    \"buildingYear\" : 1.4658129805029452,\n    \"stateOfCharge\" : 23,\n    \"co2PerKm\" : 6.027456183070403,\n    \"propulsion\" : \"MUSCLE\",\n    \"assetSubClass\" : \"assetSubClass\",\n    \"infantSeat\" : true,\n    \"persons\" : 5,\n    \"colour\" : \"colour\",\n    \"easyAccessibility\" : \"LIFT\",\n    \"meta\" : [ {\n      \"wheelchair\" : true\n    }, {\n      \"wheelchair\" : true\n    } ],\n    \"name\" : \"name\",\n    \"typeId\" : \"typeId\"\n  },\n  \"routeShortName\" : \"routeShortName\",\n  \"route\" : \"route\",\n  \"from\" : {\n    \"name\" : \"name\",\n    \"coordinates\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"physicalAddress\" : {\n      \"areaReference\" : \"Smallcity, Pinetree county\",\n      \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n      \"postalCode\" : \"postalCode\"\n    },\n    \"stopReference\" : [ {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    }, {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    } ],\n    \"stationId\" : \"stationId\",\n    \"extraInfo\" : [ {\n      \"wheelchair\" : true\n    }, {\n      \"wheelchair\" : true\n    } ]\n  },\n  \"startTime\" : \"2020-06-28T14:55:00+02:00\",\n  \"state\" : \"NOT_STARTED\"\n}", Execution.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Execution>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Execution>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ExecutionProgress> executionsIdProgressGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg execution identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = "Specifies if only the location should be returned", defaultValue = "false") @Valid @RequestParam(value = "location-only", required = false, defaultValue="false") Boolean locationOnly
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ExecutionProgress>(objectMapper.readValue("{\n  \"duration\" : 11112,\n  \"distance\" : 7250,\n  \"coordinates\" : {\n    \"lng\" : 6.169639,\n    \"lat\" : 52.253279\n  }\n}", ExecutionProgress.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ExecutionProgress>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ExecutionProgress>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> executionsIdProgressPost(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg execution identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody ExecutionProgress body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> executionsIdPut(@ApiParam(value = "changed leg (e.g. with different duration or destination)" ,required=true )  @Valid @RequestBody Execution body
,@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
