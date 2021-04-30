package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.SupportRequest;
import io.swagger.model.SupportStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-26T08:47:05.979Z[GMT]")
@RestController
public class SupportApiController implements SupportApi {

    private static final Logger log = LoggerFactory.getLogger(SupportApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SupportApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<SupportStatus>> supportIdStatusGet(@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true,schema=@Schema()) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage,@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true,schema=@Schema()) @RequestHeader(value="Api", required=true) String api,@Parameter(in = ParameterIn.HEADER, description = "Version of the API." ,required=true,schema=@Schema()) @RequestHeader(value="Api-Version", required=true) String apiVersion,@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator" ,required=true,schema=@Schema()) @RequestHeader(value="maas-id", required=true) String maasId,@Parameter(in = ParameterIn.PATH, description = "Booking identifier", required=true, schema=@Schema()) @PathVariable("id") String id,@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message" ,schema=@Schema()) @RequestHeader(value="addressed-to", required=false) String addressedTo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<SupportStatus>>(objectMapper.readValue("[ {\n  \"timeToResolution\" : 9,\n  \"comment\" : \"comment\",\n  \"status\" : \"PROCESSING\",\n  \"order\" : 0\n}, {\n  \"timeToResolution\" : 9,\n  \"comment\" : \"comment\",\n  \"status\" : \"PROCESSING\",\n  \"order\" : 0\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<SupportStatus>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<SupportStatus>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SupportStatus> supportPost(@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information" ,required=true,schema=@Schema()) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage,@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true,schema=@Schema()) @RequestHeader(value="Api", required=true) String api,@Parameter(in = ParameterIn.HEADER, description = "Version of the API." ,required=true,schema=@Schema()) @RequestHeader(value="Api-Version", required=true) String apiVersion,@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator" ,required=true,schema=@Schema()) @RequestHeader(value="maas-id", required=true) String maasId,@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message" ,schema=@Schema()) @RequestHeader(value="addressed-to", required=false) String addressedTo,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody SupportRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SupportStatus>(objectMapper.readValue("{\n  \"timeToResolution\" : 9,\n  \"comment\" : \"comment\",\n  \"status\" : \"PROCESSING\",\n  \"order\" : 0\n}", SupportStatus.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SupportStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SupportStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

}
