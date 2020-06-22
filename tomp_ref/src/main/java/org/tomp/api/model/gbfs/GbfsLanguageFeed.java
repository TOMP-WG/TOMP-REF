package org.tomp.api.model.gbfs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GbfsLanguageFeed {

	@JsonProperty("feeds")
	private GbfsLink[] feeds;

	public GbfsLink[] getFeeds() {
		return feeds;
	}

	public void setFeeds(GbfsLink[] link) {
		this.feeds = link;
	}
}
