package org.tomp.ready.generic;

import java.util.List;

import org.tomp.ready.utils.ApiException;
import org.tomp.ready.validation.ValidationResult;

public interface TestCaseInterface {
	public void given();

	public void when() throws ApiException;

	public List<ValidationResult> then();
}
