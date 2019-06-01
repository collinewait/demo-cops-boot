package com.example.wait.democopsboot.user.web;

import static com.example.wait.democopsboot.infrastructure.security.SecurityHelperForMockMvc.HEADER_AUTHORIZATION;
import static com.example.wait.democopsboot.infrastructure.security.SecurityHelperForMockMvc.bearer;
import static com.example.wait.democopsboot.infrastructure.security.SecurityHelperForMockMvc.obtainAccessToken;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.wait.democopsboot.infrastructure.test.CopsbootControllerTest;
import com.example.wait.democopsboot.user.UserService;
import com.example.wait.democopsboot.user.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@CopsbootControllerTest(UserRestController.class)
public class UserRestControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

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

	@Test
	public void testCreateOfficer() throws Exception {
		String email = "wim.deblauwe@example.com";
		String password = "my-super-secret-pwd";

		CreateOfficerParameters parameters = new CreateOfficerParameters();
		parameters.setEmail(email);
		parameters.setPassword(password);

		when(service.createOfficer(email, password))
				.thenReturn(Users.newOfficer(email, password));

		mvc.perform(
				post("/api/users").contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(parameters)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("id").exists())
				.andExpect(jsonPath("email").value(email))
				.andExpect(jsonPath("roles").isArray())
				.andExpect(jsonPath("roles[0]").value("OFFICER"));
		verify(service).createOfficer(email, password);
	}

	@Test
	public void testCreateOfficerIfPasswordIsTooShort() throws Exception {
		String email = "wim.deblauwe@example.com";
		String password = "pwd";
		CreateOfficerParameters parameters = new CreateOfficerParameters();
		parameters.setEmail(email);
		parameters.setPassword(password);
		mvc.perform(
				post("/api/users").contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(parameters)))
				.andExpect(status().isBadRequest()).andDo(print());
		verify(service, never()).createOfficer(email, password);
	}
}
