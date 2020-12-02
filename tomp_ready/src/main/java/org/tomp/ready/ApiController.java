package org.tomp.ready;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.tomp.ready.generic.TestProcessor;
import org.tomp.ready.utils.ApiException;
import org.tomp.ready.validation.ValidationResult;

@RestController
public class ApiController implements Api {

	@Autowired
	TestProcessor processor;

	@Override
	public ResponseEntity<List<ValidationResult>> validate(String apiVersion, String id, String url)
			throws ApiException {
		List<ValidationResult> errors = new ArrayList<>();
		try {
			errors = processor.validateProcess(apiVersion, id, url);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(errors, HttpStatus.OK);
	}
}
