package org.tomp.ready.validation;

import org.tomp.ready.generic.ErrorType;

public class ValidationResult {
	private boolean ok;
	private String test;
	private String description;
	private ErrorType type;
	private String httpMethod;
	private String endpoint;

	public ValidationResult(boolean ok, String test, String description) {
		this(ErrorType.ERROR, ok, test, description);
	}

	public ValidationResult(ErrorType type, boolean ok, String test, String description) {
		this.setType(type);
		this.ok = ok;
		this.setTest(test);
		this.setRepairAction(description);
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getDescription() {
		return description;
	}

	public void setRepairAction(String repairAction) {
		this.description = repairAction;
	}

	public ErrorType getType() {
		return type;
	}

	public void setType(ErrorType type) {
		this.type = type;
	}

	public void setEndpoint(String httpMethod, String endpoint) {
		this.setHttpMethod(httpMethod);
		this.endpoint = endpoint;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	@Override
	public String toString() {
		return String.format("  %s: %s (%s)", isOk() ? "OK" : getType(), getDescription(), getTest());
	}

}
