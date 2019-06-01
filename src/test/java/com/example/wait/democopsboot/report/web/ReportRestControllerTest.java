package com.example.wait.democopsboot.report.web;

import static com.example.wait.democopsboot.infrastructure.security.SecurityHelperForMockMvc.HEADER_AUTHORIZATION;
import static com.example.wait.democopsboot.infrastructure.security.SecurityHelperForMockMvc.bearer;
import static com.example.wait.democopsboot.infrastructure.security.SecurityHelperForMockMvc.obtainAccessToken;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.wait.democopsboot.infrastructure.test.CopsbootControllerTest;
import com.example.wait.democopsboot.report.Report;
import com.example.wait.democopsboot.report.ReportId;
import com.example.wait.democopsboot.report.ReportService;
import com.example.wait.democopsboot.user.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@CopsbootControllerTest(ReportRestController.class)
public class ReportRestControllerTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	private ReportService service;

	@Test
	public void officerIsAbleToPostAReport() throws Exception {
		String accessToken = obtainAccessToken(mvc, Users.OFFICER_EMAIL,
				Users.OFFICER_PASSWORD);
		ZonedDateTime dateTime = ZonedDateTime
				.parse("2018-04-11T22:59:03.189+02:00");
		String description = "The suspect is wearing a black hat.";
		CreateReportParameters parameters = new CreateReportParameters(dateTime,
				description, false, 0);
		when(service.createReport(eq(Users.officer().getId()),
				any(ZonedDateTime.class), eq(description)))
						.thenReturn(new Report(new ReportId(UUID.randomUUID()),
								Users.officer(), dateTime, description));

		mvc.perform(post("/api/reports")
				.header(HEADER_AUTHORIZATION, bearer(accessToken))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(parameters)))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(jsonPath("id").exists())
				.andExpect(jsonPath("reporter").value(Users.OFFICER_EMAIL))
				.andExpect(jsonPath("dateTime")
						.value("2018-04-11T22:59:03.189+02:00"))
				.andExpect(jsonPath("description").value(description));
	}
}
