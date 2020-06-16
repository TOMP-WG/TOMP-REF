/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.20).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-10T13:55:00.069Z[GMT]")
@Api(value = "plannings", description = "the plannings API")
public interface PlanningsApi {

    @ApiOperation(value = "", nickname = "planningsIdGet", notes = "Returns the planning result.", response = Planning.class, authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "planning","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The planning was found", response = Planning.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists."),
        @ApiResponse(code = 410, message = "The requested resource is no longer available. This is permanent.") })
    @RequestMapping(value = "/plannings/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Planning> planningsIdGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Planning identifier",required=true) @PathVariable("id") String id
);


    @ApiOperation(value = "", nickname = "planningsPost", notes = "Returns plannings for the given travel plan. <p>Start time can be defined, but is optional. If startTime is not provided, but required by the third party API, a default value of \"Date.now()\" is used. [from MaaS-API /listing]. During the routing phase this service can be used to check availability without any state changes. <p>In the final check, just before presenting the alternatives to the user, a call should be made using `booking-intent`, requesting the TO to provide booking IDs to reference to during communication with the MP. <p>see (2.1) in the process flow - planning", response = Planning.class, authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "planning","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Available transport methods matching the given query parameters. If no transport methods are available, an empty array is returned.", response = Planning.class),
        @ApiResponse(code = 202, message = "Request was successfully accepted for processing but has not yet completed."),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/plannings/",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Planning> planningsPost(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = ""  )  @Valid @RequestBody PlanningRequest body
,@ApiParam(value = "Specifies whether IDs should be returned for the leg options that can be referred to when booking", defaultValue = "false") @Valid @RequestParam(value = "booking-intent", required = false, defaultValue="false") Boolean bookingIntent
);

}