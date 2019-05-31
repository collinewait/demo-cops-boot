package com.example.wait.democopsboot.user.web;

import static com.example.wait.democopsboot.infrastructure.security.SecurityHelperForMockMvc.HEADER_AUTHORIZATION;
import static com.example.wait.democopsboot.infrastructure.security.SecurityHelperForMockMvc.bearer;
import static com.example.wait.democopsboot.infrastructure.security.SecurityHelperForMockMvc.obtainAccessToken;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.removeMatchingHeaders;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.wait.democopsboot.infrastructure.test.CopsbootControllerTest;
import com.example.wait.democopsboot.user.UserService;
import com.example.wait.democopsboot.user.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

//tag::class-setup[]
@RunWith(SpringRunner.class)
@CopsbootControllerTest(UserRestController.class)
public class UserRestControllerDocumentation {
	@Rule
	public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation(
			"target/generated-snippets");

	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	private UserService service;
	// end::class-setup[]

	// tag::setup-method[]
	@Autowired
	private WebApplicationContext context;
	private RestDocumentationResultHandler resultHandler;

	@Before
	public void setUp() {
		resultHandler = document("{method-name}",
				preprocessRequest(prettyPrint()),
				preprocessResponse(prettyPrint(),
						removeMatchingHeaders("X.*", "Pragma", "Expires")));
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(springSecurity())
				.apply(documentationConfiguration(restDocumentation))
				.alwaysDo(resultHandler).build();
	}
	// end::setup-method[]

	// tag::not-logged-in[]
	@Test
	public void ownUserDetailsWhenNotLoggedInExample() throws Exception {
		mvc.perform(get("/api/users/me")).andExpect(status().isUnauthorized());
	}
	// end::not-logged-in[]

	// tag::officer-details[]
	@Test
	public void authenticatedOfficerDetailsExample() throws Exception {
		String accessToken = obtainAccessToken(mvc, Users.OFFICER_EMAIL,
				Users.OFFICER_PASSWORD);

		when(service.getUser(Users.officer().getId()))
				.thenReturn(Optional.of(Users.officer()));

		mvc.perform(get("/api/users/me")
				.header(HEADER_AUTHORIZATION, bearer(accessToken)))
				.andExpect(status().isOk())
				.andDo(resultHandler.document(responseFields(
						fieldWithPath("id")
								.description("The unique id of the user."),
						fieldWithPath("email")
								.description("The email address of the user."),
						fieldWithPath("roles").description(
								"The security roles of the user."))));
	}

	// end::officer-details[]

	// tag::create-officer[]
	@Test
	public void createOfficerExample() throws Exception {
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
				.andDo(resultHandler.document(
						requestFields(fieldWithPath("email").description(
								"The email address of the user to be created."),
								fieldWithPath("password").description(
										"The password for the new user.")),
						responseFields(
								fieldWithPath("id").description(
										"The unique id of the user."),
								fieldWithPath("email").description(
										"The email address of the user."),
								fieldWithPath("roles").description(
										"The security roles of the user."))));
	}
}
