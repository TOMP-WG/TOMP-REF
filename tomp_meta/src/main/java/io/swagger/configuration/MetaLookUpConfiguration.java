package io.swagger.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "meta")
public class MetaLookUpConfiguration {
	@Value("${meta.operatorfile}")
	private String operatorFile;

	public String getOperatorFile() {
		return operatorFile;
	}

	public void setOperatorFile(String operatorFile) {
		this.operatorFile = operatorFile;
	}
}
