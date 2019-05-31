package com.example.wait.democopsboot.infrastructure.test;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.wait.democopsboot.infrastructure.security.OAuth2ServerConfiguration;
import com.example.wait.democopsboot.infrastructure.security.SecurityConfiguration;
import com.example.wait.democopsboot.infrastructure.security.StubUserDetailsService;

@TestConfiguration
@Import(OAuth2ServerConfiguration.class)
public class CopsbootControllerTestConfiguration {
	@Bean
	public UserDetailsService userDetailsService() {
		return new StubUserDetailsService();
	}

	@Bean
	public SecurityConfiguration securityConfiguration() {
		return new SecurityConfiguration();
	}

}
