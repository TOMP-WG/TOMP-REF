package org.tomp.ready.testcases.operator.information;

import java.util.List;

import org.tomp.ready.generic.BaseTestCase;
import org.tomp.ready.generic.ErrorType;
import org.tomp.ready.generic.TestCase;
import org.tomp.ready.utils.ApiClient;
import org.tomp.ready.validation.EqualsValidation;
import org.tomp.ready.validation.OrValidation;
import org.tomp.ready.validation.ValidationResult;

@TestCase(httpMethod = "GET", endpoint = "/operator/meta", version = { "0.9.*" })
public class MetaValidation extends BaseTestCase {

	public MetaValidation(ApiClient client, String baseUrl, String apiVersion, String mpId) {
		super(client, baseUrl, apiVersion, mpId);
	}

	@Override
	public void given() {
		super.given();
		this.setBody("");
	}

	@Override
	public List<ValidationResult> then() {
		addMandatoryFieldInEachObject("$[*]", "$.version");
		addMandatoryFieldInEachObject("$[*]", "$.baseUrl");
		addMandatoryFieldInEachObject("$[*]", "$.endpoints");
		addMandatoryFieldInEachObject("$[*]", "$.scenarios");
		addMandatoryFieldInEachObject("$[*]", "$.processIdentifiers");

		addEquals("$[0].version", "Correct version number", ErrorType.ERROR, this.getApiVersion());

		addEqualsInEachObject("$[*]", "$.baseUrl", "Correct base URL", ErrorType.WARNING, this.getUrl(),
				this.getUrl() + "/");

		addEqualsInEachObject("$[*].['endpoints'].*", "$.method", "Correct http method", ErrorType.ERROR, "GET", "POST",
				"PATCH");

		addEqualsInEachObject("$[*].['endpoints'].*", "$.path", "Known endpoint", ErrorType.ERROR, "/plannings",
				"/plannings/", "/operator/meta", "/operator/meta/", "/operator/stations", "/operator/stations/",
				"/operator/available-assets", "/operator/available-assets/", "/operator/alerts", "/operator/alerts/",
				"/operator/operating-calender", "/operator/operating-calender/", "/operator/operating-hours",
				"/operator/operating-hours/", "/operator/information", "/operator/information/",
				"/operator/pricing-plans", "/operator/pricing-plans/", "/operator/regions", "/operator/regions/",
				"/bookings/", "/bookings", "/bookings/{id}/events", "/bookings/{id}/events/", "/legs/{id}/events",
				"/legs/{id}/events/", "/payment/journal-entry", "/payment/journal-entry");

		addMandatoryEndpoint("/operator/meta");
		addMandatoryEndpoint("/operator/information");
		addMandatoryEndpoint("/operator/regions");
		addMandatoryEndpoint("/operator/pricing-plans");
		addMandatoryEndpoint("/operator/alerts");
		addMandatoryEndpoint("/operator/operating-hours");
		addMandatoryEndpoint("/operator/operating-calendar");
		addMandatoryEndpoint("/operator/available-assets");
		addEndpointValidation("/operator/stations", ErrorType.WARNING);

		return super.then();
	}

	private void addEndpointValidation(String endpoint, ErrorType type) {
		EqualsValidation v1 = new EqualsValidation("$[*].['endpoints'].[?(@.path=='" + endpoint + "/')].['path']",
				(type.equals(ErrorType.ERROR) ? "Mandatory" : "Optional") + " endpoint", type, "EXISTS");
		EqualsValidation v2 = new EqualsValidation("$[*].['endpoints'].[?(@.path=='" + endpoint + "')].['path']",
				(type.equals(ErrorType.ERROR) ? "Mandatory" : "Optional") + " endpoint", type, "EXISTS");

		addValidation(new OrValidation(v1, v2));
	}

	private void addMandatoryEndpoint(String endpoint) {
		addEndpointValidation(endpoint, ErrorType.ERROR);
	}
}
