package org.tomp.ready;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.tomp.ready.utils.ApiException;
import org.tomp.ready.validation.ValidationResult;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface Api {
	@ApiOperation(value = "", nickname = "validate", response = String.class, responseContainer = "List", authorizations = {}, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "support status delivered", response = String.class, responseContainer = "List"), })
	@GetMapping(value = "/validate/{id}", produces = { "application/json" })
	ResponseEntity<List<ValidationResult>> validate(
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "MaaS id of the TO", required = true) @PathVariable("id") String id,
			@ApiParam(value = "Base url of TOMP implementation", required = true) @PathVariable("id") String url)
			throws ApiException;
}
