package org.tomp.ready.testcases.plan.book;

import java.util.List;

import org.tomp.ready.generic.BaseTestCase;
import org.tomp.ready.generic.ErrorType;
import org.tomp.ready.generic.TestCase;
import org.tomp.ready.utils.ApiClient;
import org.tomp.ready.utils.ApiException;
import org.tomp.ready.validation.ValidationResult;

@TestCase(httpMethod = "POST", endpoint = "/bookings", version = { "0.9.*" })
public class CommitValidation extends BaseTestCase {

	public CommitValidation(ApiClient client, String baseUrl, String apiVersion, String mpId) {
		super(client, baseUrl, apiVersion, mpId);
	}

	@Override
	public void given() {
		// planning
		this.configEndpoint("POST", "/plannings?booking-intent=true", "");
		try {
			this.executeCall();
		} catch (ApiException e) {
			e.printStackTrace();
		}

		this.configEndpoint("POST", "/bookings", "");
		super.given();
	}

	@Override
	public List<ValidationResult> then() {
		addEquals("", "State is pending", ErrorType.ERROR, "PENDING");
		return super.then();
	}

}
