package org.tomp.api.configuration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.tomp.api.authentication.APIKeyAuthFilter;
import org.tomp.api.model.LookupService;
import org.tomp.api.model.MaasOperator;

@Component
@EnableWebSecurity
@Order(1)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

	private static final Logger log = LoggerFactory.getLogger(SecurityAdapter.class);

	@Autowired
	LookupService lookupService;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		APIKeyAuthFilter filter = new APIKeyAuthFilter("maas-id");
		filter.setAuthenticationManager(new AuthenticationManager() {

			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				String maasId = (String) authentication.getPrincipal();
				MaasOperator maasOperator = lookupService.getMaasOperator(maasId);
				if (maasOperator == null) {
					log.error("Unknown MaaS Operator is trying to request information {}", maasId);
					// throw new BadCredentialsException("Unknown MaaS Operator.");
				}
				authentication.setAuthenticated(true);
				return authentication;
			}
		});
		Customizer<CorsConfigurer<HttpSecurity>> corsCustomizer = t -> {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(true);
			//config.addAllowedOrigin("http://localhost:4200");
			config.addAllowedOrigin("*");
			config.addAllowedHeader("*");
			config.addAllowedMethod("*");
			source.registerCorsConfiguration("/**", config);
			t.configurationSource(source);
		};
		httpSecurity
			.csrf().disable()
				.authorizeRequests().antMatchers("/postponed/**").permitAll()
				.and()
				.antMatcher("/**").cors(corsCustomizer)
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().addFilter(filter).authorizeRequests()
				.anyRequest().authenticated();
	}
}