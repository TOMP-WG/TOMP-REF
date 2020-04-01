package io.swagger.api;

import io.swagger.model.Asset;
import io.swagger.model.Error;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.LegProgress;
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
public class LegsApiController implements LegsApi {

    private static final Logger log = LoggerFactory.getLogger(LegsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LegsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Asset> legsIdAssetGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Asset>(objectMapper.readValue("{\n  \"rental-url\" : \"https://www.rentmyfreebike.com/rental\",\n  \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n  \"is-reserved-from\" : 1546336800,\n  \"is-disabled\" : true,\n  \"asset-id\" : \"asset-id\",\n  \"place\" : {\n    \"coordinate\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"station-id\" : \"station-id\",\n    \"extra-info\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ],\n    \"name\" : \"name\",\n    \"stop-reference\" : [ {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    }, {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    } ],\n    \"physical-address\" : {\n      \"country\" : \"NL\",\n      \"postal-code\" : \"postal-code\",\n      \"street-address\" : \"example street 18, 2nd floor, 18B-33\",\n      \"area-reference\" : \"Smallcity, Pinetree county\"\n    }\n  },\n  \"is-reserved\" : true\n}", Asset.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Asset>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Asset>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Asset>> legsIdAvailableAssetsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Asset>>(objectMapper.readValue("[ {\n  \"rental-url\" : \"https://www.rentmyfreebike.com/rental\",\n  \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n  \"is-reserved-from\" : 1546336800,\n  \"is-disabled\" : true,\n  \"asset-id\" : \"asset-id\",\n  \"place\" : {\n    \"coordinate\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"station-id\" : \"station-id\",\n    \"extra-info\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ],\n    \"name\" : \"name\",\n    \"stop-reference\" : [ {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    }, {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    } ],\n    \"physical-address\" : {\n      \"country\" : \"NL\",\n      \"postal-code\" : \"postal-code\",\n      \"street-address\" : \"example street 18, 2nd floor, 18B-33\",\n      \"area-reference\" : \"Smallcity, Pinetree county\"\n    }\n  },\n  \"is-reserved\" : true\n}, {\n  \"rental-url\" : \"https://www.rentmyfreebike.com/rental\",\n  \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n  \"is-reserved-from\" : 1546336800,\n  \"is-disabled\" : true,\n  \"asset-id\" : \"asset-id\",\n  \"place\" : {\n    \"coordinate\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"station-id\" : \"station-id\",\n    \"extra-info\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ],\n    \"name\" : \"name\",\n    \"stop-reference\" : [ {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    }, {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    } ],\n    \"physical-address\" : {\n      \"country\" : \"NL\",\n      \"postal-code\" : \"postal-code\",\n      \"street-address\" : \"example street 18, 2nd floor, 18B-33\",\n      \"area-reference\" : \"Smallcity, Pinetree county\"\n    }\n  },\n  \"is-reserved\" : true\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Asset>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Asset>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Leg>> legsIdEventsPost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody LegEvent body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Leg>>(objectMapper.readValue("[ {\n  \"fare\" : {\n    \"estimated\" : true,\n    \"parts\" : [ {\n      \"amount\" : 9.96,\n      \"currency-code\" : \"EUR\",\n      \"tax-rate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unit-type\" : \"HOUR\",\n      \"units\" : 1\n    }, {\n      \"amount\" : 9.96,\n      \"currency-code\" : \"EUR\",\n      \"tax-rate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unit-type\" : \"HOUR\",\n      \"units\" : 1\n    } ],\n    \"description\" : \"description\",\n    \"class\" : \"class\"\n  },\n  \"start-time\" : 1546336800,\n  \"distance\" : 7250,\n  \"asset-access-data\" : {\n    \"meta\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ]\n  },\n  \"mode\" : {\n    \"travel-abroad\" : true,\n    \"pets\" : true,\n    \"other\" : \"other\",\n    \"fuel\" : \"NONE\",\n    \"amount-available\" : 0.8008281904610115,\n    \"energy-label\" : \"A\",\n    \"infant-seat\" : true,\n    \"co2-per-km\" : 6.027456183070403,\n    \"smoking\" : true,\n    \"model\" : \"model\",\n    \"gearbox\" : \"MANUAL\",\n    \"cargo\" : \"cargo\",\n    \"brand\" : \"brand\",\n    \"gears\" : 5,\n    \"cabrio\" : true,\n    \"image\" : \"http://example.com/aeiou\",\n    \"state-of-charge\" : 23,\n    \"asset-class\" : \"AIR\",\n    \"type-id\" : \"type-id\",\n    \"propulsion\" : \"MUSCLE\",\n    \"underground-parking\" : true,\n    \"building-year\" : 1.4658129805029452,\n    \"air-conditioning\" : true,\n    \"easy-accessibility\" : \"LIFT\",\n    \"winter-tires\" : true,\n    \"persons\" : 5,\n    \"colour\" : \"colour\",\n    \"asset-sub-class\" : \"asset-sub-class\",\n    \"towing-hook\" : true,\n    \"meta\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ],\n    \"name\" : \"name\"\n  },\n  \"route-short-name\" : \"route-short-name\",\n  \"route\" : \"route\",\n  \"leg-geometry\" : \"leg-geometry\",\n  \"from\" : {\n    \"coordinate\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"station-id\" : \"station-id\",\n    \"extra-info\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ],\n    \"name\" : \"name\",\n    \"stop-reference\" : [ {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    }, {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    } ],\n    \"physical-address\" : {\n      \"country\" : \"NL\",\n      \"postal-code\" : \"postal-code\",\n      \"street-address\" : \"example street 18, 2nd floor, 18B-33\",\n      \"area-reference\" : \"Smallcity, Pinetree county\"\n    }\n  },\n  \"state\" : \"NOT_STARTED\",\n  \"route-long-name\" : \"route-long-name\",\n  \"departure-delay\" : 11112,\n  \"agency-id\" : \"agency-id\"\n}, {\n  \"fare\" : {\n    \"estimated\" : true,\n    \"parts\" : [ {\n      \"amount\" : 9.96,\n      \"currency-code\" : \"EUR\",\n      \"tax-rate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unit-type\" : \"HOUR\",\n      \"units\" : 1\n    }, {\n      \"amount\" : 9.96,\n      \"currency-code\" : \"EUR\",\n      \"tax-rate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unit-type\" : \"HOUR\",\n      \"units\" : 1\n    } ],\n    \"description\" : \"description\",\n    \"class\" : \"class\"\n  },\n  \"start-time\" : 1546336800,\n  \"distance\" : 7250,\n  \"asset-access-data\" : {\n    \"meta\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ]\n  },\n  \"mode\" : {\n    \"travel-abroad\" : true,\n    \"pets\" : true,\n    \"other\" : \"other\",\n    \"fuel\" : \"NONE\",\n    \"amount-available\" : 0.8008281904610115,\n    \"energy-label\" : \"A\",\n    \"infant-seat\" : true,\n    \"co2-per-km\" : 6.027456183070403,\n    \"smoking\" : true,\n    \"model\" : \"model\",\n    \"gearbox\" : \"MANUAL\",\n    \"cargo\" : \"cargo\",\n    \"brand\" : \"brand\",\n    \"gears\" : 5,\n    \"cabrio\" : true,\n    \"image\" : \"http://example.com/aeiou\",\n    \"state-of-charge\" : 23,\n    \"asset-class\" : \"AIR\",\n    \"type-id\" : \"type-id\",\n    \"propulsion\" : \"MUSCLE\",\n    \"underground-parking\" : true,\n    \"building-year\" : 1.4658129805029452,\n    \"air-conditioning\" : true,\n    \"easy-accessibility\" : \"LIFT\",\n    \"winter-tires\" : true,\n    \"persons\" : 5,\n    \"colour\" : \"colour\",\n    \"asset-sub-class\" : \"asset-sub-class\",\n    \"towing-hook\" : true,\n    \"meta\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ],\n    \"name\" : \"name\"\n  },\n  \"route-short-name\" : \"route-short-name\",\n  \"route\" : \"route\",\n  \"leg-geometry\" : \"leg-geometry\",\n  \"from\" : {\n    \"coordinate\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"station-id\" : \"station-id\",\n    \"extra-info\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ],\n    \"name\" : \"name\",\n    \"stop-reference\" : [ {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    }, {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    } ],\n    \"physical-address\" : {\n      \"country\" : \"NL\",\n      \"postal-code\" : \"postal-code\",\n      \"street-address\" : \"example street 18, 2nd floor, 18B-33\",\n      \"area-reference\" : \"Smallcity, Pinetree county\"\n    }\n  },\n  \"state\" : \"NOT_STARTED\",\n  \"route-long-name\" : \"route-long-name\",\n  \"departure-delay\" : 11112,\n  \"agency-id\" : \"agency-id\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Leg>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Leg>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Leg> legsIdGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Leg>(objectMapper.readValue("{\n  \"fare\" : {\n    \"estimated\" : true,\n    \"parts\" : [ {\n      \"amount\" : 9.96,\n      \"currency-code\" : \"EUR\",\n      \"tax-rate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unit-type\" : \"HOUR\",\n      \"units\" : 1\n    }, {\n      \"amount\" : 9.96,\n      \"currency-code\" : \"EUR\",\n      \"tax-rate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unit-type\" : \"HOUR\",\n      \"units\" : 1\n    } ],\n    \"description\" : \"description\",\n    \"class\" : \"class\"\n  },\n  \"start-time\" : 1546336800,\n  \"distance\" : 7250,\n  \"asset-access-data\" : {\n    \"meta\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ]\n  },\n  \"mode\" : {\n    \"travel-abroad\" : true,\n    \"pets\" : true,\n    \"other\" : \"other\",\n    \"fuel\" : \"NONE\",\n    \"amount-available\" : 0.8008281904610115,\n    \"energy-label\" : \"A\",\n    \"infant-seat\" : true,\n    \"co2-per-km\" : 6.027456183070403,\n    \"smoking\" : true,\n    \"model\" : \"model\",\n    \"gearbox\" : \"MANUAL\",\n    \"cargo\" : \"cargo\",\n    \"brand\" : \"brand\",\n    \"gears\" : 5,\n    \"cabrio\" : true,\n    \"image\" : \"http://example.com/aeiou\",\n    \"state-of-charge\" : 23,\n    \"asset-class\" : \"AIR\",\n    \"type-id\" : \"type-id\",\n    \"propulsion\" : \"MUSCLE\",\n    \"underground-parking\" : true,\n    \"building-year\" : 1.4658129805029452,\n    \"air-conditioning\" : true,\n    \"easy-accessibility\" : \"LIFT\",\n    \"winter-tires\" : true,\n    \"persons\" : 5,\n    \"colour\" : \"colour\",\n    \"asset-sub-class\" : \"asset-sub-class\",\n    \"towing-hook\" : true,\n    \"meta\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ],\n    \"name\" : \"name\"\n  },\n  \"route-short-name\" : \"route-short-name\",\n  \"route\" : \"route\",\n  \"leg-geometry\" : \"leg-geometry\",\n  \"from\" : {\n    \"coordinate\" : {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    },\n    \"station-id\" : \"station-id\",\n    \"extra-info\" : [ {\n      \"key\" : \"value\"\n    }, {\n      \"key\" : \"value\"\n    } ],\n    \"name\" : \"name\",\n    \"stop-reference\" : [ {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    }, {\n      \"country\" : \"NL\",\n      \"id\" : \"id\",\n      \"type\" : \"GTFS_STOP_ID\"\n    } ],\n    \"physical-address\" : {\n      \"country\" : \"NL\",\n      \"postal-code\" : \"postal-code\",\n      \"street-address\" : \"example street 18, 2nd floor, 18B-33\",\n      \"area-reference\" : \"Smallcity, Pinetree county\"\n    }\n  },\n  \"state\" : \"NOT_STARTED\",\n  \"route-long-name\" : \"route-long-name\",\n  \"departure-delay\" : 11112,\n  \"agency-id\" : \"agency-id\"\n}", Leg.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Leg>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Leg>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<LegProgress> legsIdProgressGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = "Specifies if only the location should be returned", defaultValue = "false") @Valid @RequestParam(value = "location-only", required = false, defaultValue="false") Boolean locationOnly
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<LegProgress>(objectMapper.readValue("{\n  \"duration\" : 11112,\n  \"coordinate\" : {\n    \"lng\" : 6.169639,\n    \"lat\" : 52.253279\n  },\n  \"distance\" : 7250\n}", LegProgress.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<LegProgress>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<LegProgress>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> legsIdProgressPost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody LegProgress body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> legsIdPut(@ApiParam(value = "changed leg (e.g. with different duration or destination)" ,required=true )  @Valid @RequestBody Leg body
,@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
