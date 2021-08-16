package org.tomp.api.operatorinformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.utils.ExternalFileService;

import io.swagger.model.EndpointImplementation;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "router-meta", matchIfMissing = false)
public class RouterWithoutMetaOperatorInformationProvider extends RouterOperatorInformationProvider {

	@Autowired
	ExternalConfiguration configuration;

	@Autowired
	ExternalFileService fileService;

	@Override
	public List<EndpointImplementation> getMeta(String acceptLanguage) {
		return fileService.getEndPoints();
	}
}
