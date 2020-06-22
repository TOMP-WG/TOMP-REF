package org.tomp.api.model.gbfs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Gbfs {

	@JsonProperty("data")
	private GbfsData gbfsdata;

	public GbfsData getGbfsdata() {
		return gbfsdata;
	}

	public void setGbfsdata(GbfsData gbfsdata) {
		this.gbfsdata = gbfsdata;
	}
}
