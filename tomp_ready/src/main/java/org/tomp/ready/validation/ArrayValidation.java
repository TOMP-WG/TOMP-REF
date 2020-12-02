package org.tomp.ready.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.tomp.ready.generic.ErrorType;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class ArrayValidation implements IValidation {

	private String expression;
	private String errorMessage;
	private ErrorType type;
	private List<String> expected;
	private String arrayExpression;
	private String method;
	private String endpoint;

	public ArrayValidation(String arrayExpression, String fieldExpression, String errorMessage, ErrorType type,
			String... expected) {
		this.arrayExpression = arrayExpression;
		this.expression = fieldExpression;
		this.expected = Arrays.asList(expected);
		this.errorMessage = errorMessage;
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tomp.ready.generic.IValidation#validate(java.lang.String)
	 */
	@Override
	public Collection<ValidationResult> validate(String resultJson) {
		List<ValidationResult> errors = new ArrayList<>();
		DocumentContext jsonContext = JsonPath.parse(resultJson);
		JSONArray array = jsonContext.read(arrayExpression);
		for (Object o : array) {
			jsonContext = JsonPath.parse(o);
			if (expected.contains("EXISTS")) {
				validateExists(errors, jsonContext);
			} else {
				validateEquals(errors, jsonContext);
			}
		}

		return errors;
	}

	private void validateExists(List<ValidationResult> errors, DocumentContext jsonContext) {
		try {
			jsonContext.read(expression);
			errors.add(new ValidationResult(true, expression, errorMessage));
		} catch (Exception e) {
			errors.add(new ValidationResult(false, expression,
					errorMessage + String.format("%s: %s does not exist", type, expression)));
		}
	}

	private void validateEquals(List<ValidationResult> errors, DocumentContext jsonContext) {
		try {
			String read = jsonContext.read(expression);
			read = read.replace(Character.toString((char) 8203), "");
			if (!expected.contains(read.trim())) {
				errors.add(new ValidationResult(false, expression,
						errorMessage + String.format("%s: %s (%s results in %s instead of %s)", type, errorMessage,
								expression, read, expected)));
			} else {
				errors.add(new ValidationResult(true, expression + "=" + read, errorMessage));
			}
		} catch (Exception e) {
			errors.add(new ValidationResult(false, expression,
					errorMessage + String.format("%s: %s not found (expected %s)", type, expression, expected)));
		}
	}

	@Override
	public void setEndpoint(String method, String endpoint) {
		this.setMethod(method);
		this.endpoint = endpoint;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
}
