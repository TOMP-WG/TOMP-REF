package org.tomp.ready.validation;

import java.util.Collection;

public interface IValidation {

	Collection<ValidationResult> validate(String resultJson);

	void setEndpoint(String method, String endpoint);
}