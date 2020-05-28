package org.tomp.api.utils;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.exceptions.MissingArgumentException;
import org.tomp.api.model.LookupService;

@Component
public class HeaderValidator {
	private HashMap<String, String> requiredHeaderValues = new HashMap<>();
	private static HeaderValidator singleton;

	private static final Logger log = LoggerFactory.getLogger(HeaderValidator.class);
	private LookupService lookupService;

	@Autowired
	private HeaderValidator(ExternalConfiguration configuration, LookupService lookupService) {
		this.lookupService = lookupService;

		requiredHeaderValues.put("api-version", configuration.getApiVersion());
		requiredHeaderValues.put("api", "TOMP");
		requiredHeaderValues.put("accept-language", "*");
		requiredHeaderValues.put("maas-id", "*");
		singleton = this;
	}

	public static void validateHeader(HttpServletRequest request) {
		singleton.privateValidateHeader(request);
	}

	private void privateValidateHeader(HttpServletRequest request) {
		ArrayList<String> headerNames = Collections.list(request.getHeaderNames());
		headerNames.replaceAll(String::toLowerCase);

		for (String required : requiredHeaderValues.keySet()) {
			if (!headerNames.contains(required)) {
				throw new MissingArgumentException(required);
			}
			String value = requiredHeaderValues.get(required);
			if (!value.equals("*") && !request.getHeader(required).equalsIgnoreCase(value)) {
				log.error("{} contains invalid value: {}", required, value);
				throw new IllegalArgumentException(required);
			}
		}

		Principal p = request.getUserPrincipal();
		if (p != null) {
			checkValidCombination(p.getName(), request.getHeader("maas-id"));
		}
	}

	private void checkValidCombination(String token, String maasId) {
		if (validateCertificate(maasId, token)) {
			String msg = String.format("Invalid combination maas-id/certificate %s %s", maasId, token);
			log.error(msg);
		}
	}

	private boolean validateCertificate(String maasId, String token) {
		return lookupService.validate(maasId, token);
	}
}
