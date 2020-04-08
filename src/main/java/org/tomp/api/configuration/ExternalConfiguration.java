package org.tomp.api.configuration;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.tomp.api.mp.TransportOperator;

@Component
@ConfigurationProperties(prefix = "tomp")
@Validated
public class ExternalConfiguration {

	private String lookupService;
	@NotBlank
	private String maasId;
	@NotBlank
	private String acceptLanguage;
	@NotBlank
	private String apiVersion;
	private String assetFile;

	private List<TransportOperator> transportOperators;

	public String getLookupService() {
		return lookupService;
	}

	public void setLookupService(String lookupService) {
		this.lookupService = lookupService;
	}

	public String getMaasId() {
		return maasId;
	}

	public void setMaasId(String maasId) {
		this.maasId = maasId;
	}

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public List<TransportOperator> getTransportOperators() {
		return transportOperators;
	}

	public void setTransportOperators(List<TransportOperator> transportOperators) {
		this.transportOperators = transportOperators;
	}

	public String getAssetFile() {
		return assetFile;
	}

	public void setAssetFile(String assetFile) {
		this.assetFile = assetFile;
	}
}
