package org.tomp.api.configuration;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.tomp.api.model.MaasEnvironmentType;
import org.tomp.api.model.TransportOperator;

@Component
@ConfigurationProperties(prefix = "tomp")
public class ExternalConfiguration {

	private static final Logger log = LoggerFactory.getLogger(ExternalConfiguration.class);

	public ExternalConfiguration() {
		log.info("Configuration file");
	}

	@Value("${spring.application.name}")
	private String appName;

	private String lookupService;
	@NotEmpty
	private String maasId;
	@NotEmpty
	private String acceptLanguage;
	@NotEmpty
	private String apiVersion;
	private String assetFile;
	private String systemInformationFile;
	private String conditionFile;

	private List<TransportOperator> transportOperators;
	private String fareFile;
	private String legFile;
	private String typeOfAssetFile;
	private String regionsFile;
	private String stationsFile;
	private String areaFile;
	private String bookingMailBox;
	private int expirationDays;

	private String externalUrl;
	private String currencyCode;
	private long vatRate;

	private String versionFile;
	private boolean refreshOnStartUp = true;
	private boolean allowUnknownOperators = false;
	private boolean authenticationRequired = true;

	private MaasEnvironmentType environmentType = MaasEnvironmentType.TO;

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

	public void setSystemInformationFile(String file) {
		this.systemInformationFile = file;
	}

	public String getSystemInformationFile() {
		return systemInformationFile;
	}

	public String getConditionFile() {
		return conditionFile;
	}

	public void setConditionFile(String conditionFile) {
		this.conditionFile = conditionFile;
	}

	public String getFareFile() {
		return fareFile;
	}

	public void setFareFile(String fareFile) {
		this.fareFile = fareFile;
	}

	public String getOptionsLegFile() {
		return getLegFile();
	}

	public String getTypeOfAssetFile() {
		return typeOfAssetFile;
	}

	public String getLegFile() {
		return legFile;
	}

	public void setLegFile(String legFile) {
		this.legFile = legFile;
	}

	public void setTypeOfAssetFile(String typeOfAssetFile) {
		this.typeOfAssetFile = typeOfAssetFile;
	}

	public String getRegionsFile() {
		return regionsFile;
	}

	public String getStationsFile() {
		return stationsFile;
	}

	public void setRegionsFile(String regionsFile) {
		this.regionsFile = regionsFile;
	}

	public void setStationsFile(String stationsFile) {
		this.stationsFile = stationsFile;
	}

	public String getExternalUrl() {
		return externalUrl;
	}

	public void setExternalUrl(String externalUrl) {
		this.externalUrl = externalUrl;
	}

	public String getAreaFile() {
		return areaFile;
	}

	public void setAreaFile(String areaFile) {
		this.areaFile = areaFile;
	}

	public String getBookingMailBox() {
		return bookingMailBox;
	}

	public void setBookingMailBox(String bookingMailBox) {
		this.bookingMailBox = bookingMailBox;
	}

	public int getExpirationDays() {
		return expirationDays;
	}

	public void setExpirationDays(int expirationDays) {
		this.expirationDays = expirationDays;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public long getVatRate() {
		return vatRate;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setVatRate(long vatRate) {
		this.vatRate = vatRate;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getVersionFile() {
		return versionFile;
	}

	public void setVersionFile(String versionFile) {
		this.versionFile = versionFile;
	}

	public MaasEnvironmentType getEnvironmentType() {
		return environmentType;
	}

	public void setEnvironmentType(MaasEnvironmentType environmentType) {
		this.environmentType = environmentType;
	}

	public boolean isRefreshOnStartUp() {
		return refreshOnStartUp;
	}

	public void setRefreshOnStartUp(boolean refreshOnStartUp) {
		this.refreshOnStartUp = refreshOnStartUp;
	}

	public boolean isAllowUnknownOperators() {
		return allowUnknownOperators;
	}

	public void setAllowUnknownOperators(boolean allowUnknownOperators) {
		this.allowUnknownOperators = allowUnknownOperators;
	}

	public boolean isAuthenticationRequired() {
		return authenticationRequired;
	}

	public void setAuthenticationRequired(boolean authenticationRequired) {
		this.authenticationRequired = authenticationRequired;
	}
}
