package com.example.wait.democopsboot.user.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.wait.democopsboot.infrastructure.SpringProfiles;
import com.example.wait.democopsboot.infrastructure.security.OAuth2ServerConfiguration;
import static com.example.wait.democopsboot.infrastructure.security.SecurityHelperForMockMvc.*;
import com.example.wait.democopsboot.infrastructure.security.SecurityConfiguration;
import com.example.wait.democopsboot.infrastructure.security.StubUserDetailsService;
import com.example.wait.democopsboot.user.UserService;
import com.example.wait.democopsboot.user.Users;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRestController.class)
@ActiveProfiles(SpringProfiles.TEST)
public class UserRestControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService service;

	@Test
	public void givenNotAuthenticated_whenAskingMyDetails_forbidden()
			throws Exception {
		mvc.perform(get("/api/users/me")).andExpect(status().isUnauthorized());
	}

	@Test
	public void givenAuthenticatedAsOfficer_whenAskingMyDetails_detailsReturned()
			throws Exception {
		String accessToken = obtainAccessToken(mvc, Users.OFFICER_EMAIL,
				Users.OFFICER_PASSWORD);
		when(service.getUser(Users.officer().getId()))
				.thenReturn(Optional.of(Users.officer()));
		mvc.perform(get("/api/users/me").header(HEADER_AUTHORIZATION,
				bearer(accessToken))).andExpect(status().isOk())
				.andExpect(jsonPath("id").exists())
				.andExpect(jsonPath("email").value(Users.OFFICER_EMAIL))
				.andExpect(jsonPath("roles").isArray())
				.andExpect(jsonPath("roles[0]").value("OFFICER"));
	}

	@TestConfiguration
	@Import(OAuth2ServerConfiguration.class)
	static class TestConfig {
		@Bean
		public UserDetailsService userDetailsService() {
			return new StubUserDetailsService();
		}

		@Bean
		public SecurityConfiguration securityConfiguration() {
			return new SecurityConfiguration();
		}

	}
}
