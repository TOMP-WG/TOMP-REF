package org.tomp.api.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "overpass")
public class OverpassConfiguration {

	private static final Logger log = LoggerFactory.getLogger(OverpassConfiguration.class);

	private String ql;

	public OverpassConfiguration() {
		log.info("Overpass Configuration file");
	}

	public String getQl() {
		return ql;
	}

	public void setQl(String ql) {
		this.ql = ql;
	}

}
