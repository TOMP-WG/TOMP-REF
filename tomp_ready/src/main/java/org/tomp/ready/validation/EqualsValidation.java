package org.tomp.ready.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.tomp.ready.generic.ErrorType;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class EqualsValidation implements IValidation {

	private String expression;
	private String errorMessage;
	private ErrorType type;
	private List<String> expected;
	private String method;
	private String endpoint;

	public EqualsValidation(String expression, String errorMessage, ErrorType type, String... expected) {
		this.expression = expression;
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
		if (expected.contains("EXISTS")) {
			validateExists(errors, jsonContext);
		} else {
			validateEquals(errors, jsonContext);
		}
		return errors;
	}

	private void validateExists(List<ValidationResult> errors, DocumentContext jsonContext) {
		try {
			Object read = jsonContext.read(expression);
			if (read instanceof JSONArray) {
				JSONArray r = (JSONArray) read;
				if (!r.isEmpty()) {
					errors.add(new ValidationResult(true, expression, errorMessage));
				} else {
					errors.add(new ValidationResult(false, expression,
							String.format("%s does not exist", errorMessage)));
				}
			} else {
				errors.add(new ValidationResult(true, expression, errorMessage));
			}
		} catch (Exception e) {
			errors.add(new ValidationResult(false, expression,
					String.format("%s does not exist", errorMessage)));
		}
	}

	private void validateEquals(List<ValidationResult> errors, DocumentContext jsonContext) {
		try {
			Object read = jsonContext.read(expression);
			List<String> values = new ArrayList<>();
			if (read instanceof String) {
				values.add((String) read);
			} else {
				JSONArray array = (JSONArray) read;
				for (Object o : array) {
					if (o instanceof String) {
						values.add((String) o);
					}
				}
			}

			if (!values.isEmpty()) {
				for (String s : values) {
					if (!expected.contains(s)) {
						errors.add(new ValidationResult(false, expression,
								errorMessage + String.format(" %s: %s (%s results in %s instead of %s)", type,
										errorMessage, expression, read, expected)));
					} else {
						errors.add(new ValidationResult(true, expression + "=" + s, errorMessage));
					}
				}
			} else {
				errors.add(new ValidationResult(false, expression,
						errorMessage + String.format(" %s: %s (%s results in %s instead of %s)", type, errorMessage,
								expression, read, expected)));
			}

		} catch (Exception e) {
			errors.add(new ValidationResult(false, expression,
					errorMessage + String.format("%s: %s not found (expected %s)", type, expression, expected)));
		}
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

	public void setEndpoint(String method, String endpoint) {
		setMethod(method);
		this.endpoint = endpoint;
	}
}
