package com.example.wait.democopsboot.report.web;

import static com.example.wait.democopsboot.util.test.ConstraintViolationSetAssert.assertThat;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class ReportDescriptionValidatorTest {

	@Test
	public void givenEmptyString_notValid() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		CreateReportParameters parameters = new CreateReportParameters(
				ZonedDateTime.now(), "");
		Set<ConstraintViolation<CreateReportParameters>> violationSet = validator
				.validate(parameters);
		assertThat(violationSet).hasViolationOnPath("description");
	}

	@Test
	public void givenSuspectWordPresent_valid() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		CreateReportParameters parameters = new CreateReportParameters(
				ZonedDateTime.now(), "The suspect was wearing a black hat.");
		Set<ConstraintViolation<CreateReportParameters>> violationSet = validator
				.validate(parameters);
		assertThat(violationSet).hasNoViolations();
	}
}
