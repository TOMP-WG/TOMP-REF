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
import org.tomp.api.authentication.AuthenticationException;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.exceptions.MissingArgumentException;

@Component
public class HeaderValidator {
	private HashMap<String, String> requiredHeaderValues = new HashMap<>();
	private static HeaderValidator singleton;

	private static final Logger log = LoggerFactory.getLogger(HeaderValidator.class);

	@Autowired
	private HeaderValidator(ExternalConfiguration configuration) {
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
				String errorMessage = String.format("%s contains invalid value: %s", required, value);
				log.error(errorMessage);
				throw new IllegalArgumentException(errorMessage);
			}
		}

		Principal p = request.getUserPrincipal();
		if (p != null) {
			checkValidCombination(p.getName(), request.getHeader("maas-id"));
		}
	}

	private static void checkValidCombination(String thumbprint, String maasId) {
		if (validateCertificate(maasId)) {
			String msg = String.format("Invalid combination maas-id/certificate %s %s", maasId, thumbprint);
			log.error(msg);
			throw new AuthenticationException(msg);
		}
	}

	private static boolean validateCertificate(String maasId) {
		return !maasId.equals("1");
	}
}
