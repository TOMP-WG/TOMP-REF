package org.tomp.ready.validation;

import java.util.Collection;

public class OrValidation implements IValidation {

	protected IValidation v1;
	private IValidation v2;
	private String method;
	private String endpoint;

	public OrValidation(IValidation v1, IValidation v2) {
		this.v1 = v1;
		this.v2 = v2;

	}

	@Override
	public Collection<ValidationResult> validate(String resultJson) {

		Collection<ValidationResult> v1Result = v1.validate(resultJson);

		for (ValidationResult result : v1Result) {
			if (result.isOk()) {
				return v1Result;
			}
		}

		return v2.validate(resultJson);
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
