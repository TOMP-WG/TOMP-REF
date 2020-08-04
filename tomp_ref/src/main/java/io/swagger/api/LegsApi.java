/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.20).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Asset;
import io.swagger.model.Error;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.LegProgress;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-30T14:11:18.823Z[GMT]")
@Api(value = "legs", description = "the legs API")
public interface LegsApi {

    @ApiOperation(value = "", nickname = "legsIdAvailableAssetsGet", notes = "Returns a list of available assets for the given leg. These assets can be used to POST to /legs/{id}/asset if no specific asset is assigned by the TO. If picking an asset is not allowed for this booking, or one already has been, 403 should be returned. If the booking is unknown, 404 should be returned. See (4.7) in the process flow. - trip execution", response = Asset.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "trip execution","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Available assets for the leg. If no suitable assets are found an empty array is to be returned.", response = Asset.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", response = Error.class),
        @ApiResponse(code = 403, message = "The request will not be fulfilled, because the request is not legal in the current state. Authorization will not help. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/legs/{id}/available-assets",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Asset>> legsIdAvailableAssetsGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
);


    @ApiOperation(value = "", nickname = "legsIdEventsPost", notes = "This endpoint must be used to alter the state of a leg.<br> Operations:<br> `PREPARE` the TO can send a message telling the MP that he is preparing the booked leg [To be implemented by the MP] (see (7.2) in the process flow - trip execution),<br> `ASSIGN_ASSET` can assign an asset to a leg. Can be to assign an asset in case there is still an asset type assigned [Optionally implementable by the MP]. See (4.7) in the process flow - trip execution<br> `RESERVE` will claim an asset ahead in time [Optionally implementable by the TO],<br> `SET_IN_USE` will activate the leg or resume the leg [TO and MP] (see (4.6) in process flow),<br> `PAUSE` will pause the leg [TO and MP] (see (4.6) in process flow),<br> `START_FINISHING` will start the end-of-leg [Optionally implementable by TO and MP],<br> `FINISH` will end this leg (see (4.6) in process flow) [TO and MP]", response = Leg.class, authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "trip execution","MP","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "operation successful", response = Leg.class),
        @ApiResponse(code = 204, message = "Request was successful, no content to return."),
        @ApiResponse(code = 400, message = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/legs/{id}/events",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Leg> legsIdEventsPost(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody LegEvent body
);


    @ApiOperation(value = "", nickname = "legsIdGet", notes = "Retrieves the latest summary of the leg, being the execution of a portion of a journey travelled using one asset (vehicle). Every leg belongs to one booking, every booking has at least one leg. Where the booking describes the agreement between user/MP and TO, the leg describes the journey as it occured. See (4.3) in the flow chart - trip execution", response = Leg.class, authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "trip execution","TO","MP", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "operation successful", response = Leg.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/legs/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Leg> legsIdGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
);


    @ApiOperation(value = "", nickname = "legsIdProgressGet", notes = "Monitors the current location of the asset and duration & distance of the leg (see (4.7) in process flow)", response = LegProgress.class, authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "trip execution","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "operation successful", response = LegProgress.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/legs/{id}/progress",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<LegProgress> legsIdProgressGet(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = "Specifies if only the location should be returned", defaultValue = "false") @Valid @RequestParam(value = "location-only", required = false, defaultValue="false") Boolean locationOnly
);


    @ApiOperation(value = "", nickname = "legsIdProgressPost", notes = "Monitors the current location of the asset and duration & distance of the leg", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "trip execution","MP", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Request was successful, no content to return."),
        @ApiResponse(code = 400, message = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/legs/{id}/progress",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> legsIdProgressPost(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody LegProgress body
);


    @ApiOperation(value = "", nickname = "legsIdPut", notes = "Updates the leg with new information. Only used for updates about execution to the MP. To request changes as the MP, the booking should be updated and the TO can accept the change and update the leg in turn.", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "trip execution","MP", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Request was successful, no content to return."),
        @ApiResponse(code = 400, message = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/legs/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> legsIdPut(@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = "changed leg (e.g. with different duration or destination)" ,required=true )  @Valid @RequestBody Leg body
);

}

