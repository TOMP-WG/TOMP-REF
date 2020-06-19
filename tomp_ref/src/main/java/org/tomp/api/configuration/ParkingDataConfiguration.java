package org.tomp.api.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "parking")
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "parking", matchIfMissing = false)
public class ParkingDataConfiguration {
	private String opendataUrl;
	private String[] uuids;
	private long refreshInMillis;
	private String nameContains;
	private double r;

	public String getOpendataUrl() {
		return opendataUrl;
	}

	public void setOpendataUrl(String opendataUrl) {
		this.opendataUrl = opendataUrl;
	}

	public String[] getUuids() {
		return uuids;
	}

	public void setUuids(String[] uuids) {
		this.uuids = uuids;
	}

	public long getRefreshInMillis() {
		return refreshInMillis;
	}

	public void setRefreshInMillis(long refreshInMillis) {
		this.refreshInMillis = refreshInMillis;
	}

	public String getNameContains() {
		return nameContains;
	}

	public void setNameContains(String nameContains) {
		this.nameContains = nameContains;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
}
