package org.tomp.api.configuration;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.tomp.api.authentication.Authenticator;

@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = false)
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

	private static final Logger log = LoggerFactory.getLogger(SecurityAdapter.class);

	public SecurityAdapter() {
		log.info("SecurityAdapter activated");
	}

	@Autowired
	Authenticator authenticator;
	@Autowired
	AccessDecisionManager accessDecisionManager;

	@Override
	public void configure(HttpSecurity sec) throws Exception {
		sec.authorizeRequests()
				.antMatchers("/").permitAll()
				//.antMatchers("/planning-options/").permitAll()
				//.antMatchers("/bookings/").authenticated()
				//.accessDecisionManager(accessDecisionManager).and().authenticationProvider(authenticator).x509()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and().csrf().disable();
	}

	@Bean
	public AccessDecisionManager getAdm() {
		return new AccessDecisionManager() {

			@Override
			public boolean supports(Class<?> arg0) {
				return true;
			}

			@Override
			public boolean supports(ConfigAttribute arg0) {
				return true;
			}

			@Override
			public void decide(Authentication arg0, Object arg1, Collection<ConfigAttribute> arg2)
					throws AccessDeniedException, InsufficientAuthenticationException {
				authenticator.authenticate(arg0);
			}
		};
	}
}
