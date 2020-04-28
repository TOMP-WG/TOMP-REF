package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.PlanningCheck;
import io.swagger.model.PlanningOptions;
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
public class PlanningOptionsApiController implements PlanningOptionsApi {

    private static final Logger log = LoggerFactory.getLogger(PlanningOptionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PlanningOptionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<PlanningOptions> planningOptionsPost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = ""  )  @Valid @RequestBody PlanningCheck body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PlanningOptions>(objectMapper.readValue("{\n  \"validUntil\" : 1546336800,\n  \"conditions\" : [ {\n    \"name\" : \"name\",\n    \"conditionType\" : \"conditionType\"\n  }, {\n    \"name\" : \"name\",\n    \"conditionType\" : \"conditionType\"\n  } ],\n  \"results\" : [ \"\", \"\" ]\n}", PlanningOptions.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PlanningOptions>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PlanningOptions>(HttpStatus.NOT_IMPLEMENTED);
    }

}
