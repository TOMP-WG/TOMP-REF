package org.tomp.ready.testcases.plan.book;

import java.util.List;

import org.tomp.ready.generic.BaseTestCase;
import org.tomp.ready.generic.ErrorType;
import org.tomp.ready.generic.TestCase;
import org.tomp.ready.utils.ApiClient;
import org.tomp.ready.utils.ApiException;
import org.tomp.ready.validation.ValidationResult;

@TestCase(httpMethod = "POST", endpoint = "/bookings", scenarios = { "POSTPONED_COMMIT" }, version = { "0.9.*" })
public class PendingValidation extends BaseTestCase {

	public PendingValidation(ApiClient client, String baseUrl, String apiVersion, String mpId) {
		super(client, baseUrl, apiVersion, mpId);
	}

	@Override
	public void given() {
		try {
			// planning
			this.configEndpoint("POST", "/plannings?booking-intent=true", "");
			this.executeCall();
			this.configEndpoint("POST", "/bookings", "");
			this.executeCall();
			String id = getValue("");
			this.configEndpoint("POST", "/bookings/" + id + "/events", "COMMITBODY");

		} catch (ApiException e) {
			e.printStackTrace();
		}
		super.given();
	}

	@Override
	public List<ValidationResult> then() {
		addEquals("", "State is pending", ErrorType.ERROR, "PENDING");
		return super.then();
	}

}
