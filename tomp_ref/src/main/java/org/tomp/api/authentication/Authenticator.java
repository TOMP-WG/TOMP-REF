package org.tomp.api.authentication;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class Authenticator implements AuthenticationProvider {

	private static final Logger log = LoggerFactory.getLogger(Authenticator.class);

	@Override
	public Authentication authenticate(Authentication arg0) {
		log.info("Authenticating " + arg0.getPrincipal());
		if (arg0.getCredentials() instanceof X509Certificate) {
			X509Certificate credentials = (X509Certificate) arg0.getCredentials();
			validateCertificate(credentials);
			TompPrincipal principal = new TompPrincipal(toHex(credentials.getSignature()));
			List<GrantedAuthority> asList = new ArrayList<>();
			asList.add(new GrantedAuthority() {
				private static final long serialVersionUID = 3015850783709722829L;

				@Override
				public String getAuthority() {
					return "me";
				}
			});
			return new PreAuthenticatedAuthenticationToken(principal, arg0.getCredentials(), asList);
		}
		log.info("Certificate required " + arg0.getPrincipal());
		throw new AuthenticationException("Not Authorized");
	}

	private void validateCertificate(X509Certificate credentials) {
		log.debug(toHex(credentials.getSignature()));
	}

	private String toHex(byte[] a) {
		StringBuilder hex = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			hex.append(String.format("%02X", a[i]));
		}
		return hex.toString();
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
