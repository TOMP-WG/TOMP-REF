package org.tomp.ready.testcases.operator.information;

import java.util.List;

import org.tomp.ready.generic.BaseTestCase;
import org.tomp.ready.generic.ErrorType;
import org.tomp.ready.generic.TestCase;
import org.tomp.ready.utils.ApiClient;
import org.tomp.ready.validation.ValidationResult;

import net.minidev.json.JSONArray;

@TestCase(httpMethod = "GET", endpoint = "/operator/regions", version = { "0.9.*" })
public class RegionsValidation extends BaseTestCase {

	public RegionsValidation(ApiClient client, String baseUrl, String apiVersion, String mpId) {
		super(client, baseUrl, apiVersion, mpId);
	}

	@Override
	public void given() {
		super.given();
		this.setBody("");
	}

	@Override
	public List<ValidationResult> then() {
		JSONArray array = super.getValue("$..['serviceArea'].[0].[-1:]");
		addEquals("$..['serviceArea'].[0].[0]", "Start and endpoint of polygon are the same", ErrorType.ERROR,
				array.toString());
		return super.then();
	}
}
