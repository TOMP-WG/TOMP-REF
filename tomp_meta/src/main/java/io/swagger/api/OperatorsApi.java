/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.20).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Body;
import io.swagger.model.Error;
import io.swagger.model.MaasOperator;
import io.swagger.model.SearchCondition;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-18T13:09:36.434Z[GMT]")
@Api(value = "operators", description = "the operators API")
public interface OperatorsApi {

    @ApiOperation(value = "", nickname = "operatorsAuthenticatePost", notes = "validates if the MaaS Operator is valid. If the maasId and token don't match (or the maasId doesnt exist), a 400 should be returned.", response = MaasOperator.class, tags={ "lookup", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The MaaS Operator is found, result contains details", response = MaasOperator.class),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/operators/authenticate",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<MaasOperator> operatorsAuthenticatePost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "id", required = true) String id
,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token
);


    @ApiOperation(value = "", nickname = "operatorsIdGet", notes = "get information about the TO or MP with provided maasId", response = MaasOperator.class, tags={ "lookup", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A new booking was succesfully created, status pending", response = MaasOperator.class),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/operators/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<MaasOperator> operatorsIdGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "maasId",required=true) @PathVariable("id") String id
,@ApiParam(value = "the old token") @Valid @RequestParam(value = "token", required = false) String token
);

    
    @ApiOperation(value = "", nickname = "operatorsIdPut", notes = "refresh data from TO/MP. The TO/MP should provide this to the lookup service as soon there are changes.", response = MaasOperator.class, tags={ "lookup", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The MaaS Operator information", response = MaasOperator.class),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/operators/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<MaasOperator> operatorsIdPut(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "maasId",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody MaasOperator body
,@ApiParam(value = "the old token") @Valid @RequestParam(value = "token", required = false) String token
);

    @ApiOperation(value = "", nickname = "operatorsPost", notes = "returns TOs based on the search conditions", response = MaasOperator.class, responseContainer = "List", tags={ "lookup", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A new booking was succesfully created, status pending", response = MaasOperator.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/operators",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<List<MaasOperator>> operatorsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody SearchCondition body
,@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
);


    @ApiOperation(value = "", nickname = "operatorsRegistratePost", notes = "registrate a TO", tags={ "lookup", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Request was successfully accepted for processing but has not yet completed."),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/operators/registrate",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<MaasOperator> operatorsRegistratePost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = ""  )  @Valid @RequestBody Body body
);

}
