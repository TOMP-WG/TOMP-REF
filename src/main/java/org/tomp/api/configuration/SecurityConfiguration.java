package org.tomp.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tomp.api.authentication.Authenticator;

@Configuration
public class SecurityConfiguration {

	@Bean
	public Authenticator getAuthenticator() {
		return new Authenticator();
	}
}
