package org.tomp.ready.testcases.planning;

import org.tomp.ready.generic.BaseTestCase;
import org.tomp.ready.generic.TestCase;
import org.tomp.ready.utils.ApiClient;

@TestCase(httpMethod = "POST", endpoint = "/plannings?booking-intent=false", version = { "0.9.*" })
public class BookingIntentFalse extends BaseTestCase {

	public BookingIntentFalse(ApiClient client, String baseUrl, String apiVersion, String mpId) {
		super(client, baseUrl, apiVersion, mpId);
	}

}
