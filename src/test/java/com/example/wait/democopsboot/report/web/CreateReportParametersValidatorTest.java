package com.example.wait.democopsboot.report.web;

import static com.example.wait.democopsboot.util.test.ConstraintViolationSetAssert.assertThat;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class CreateReportParametersValidatorTest {

	@Test
	public void givenTrafficIndicentButInvolvedCarsZero_invalid() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		CreateReportParameters parameters = new CreateReportParameters(
				ZonedDateTime.now(), "The suspect was wearing a black hat",
				true, 0);
		Set<ConstraintViolation<CreateReportParameters>> violationSet = validator
				.validate(parameters);
		assertThat(violationSet).hasViolationOnPath("");
	}

	@Test
	public void givenTrafficIndicent_involvedCarsMustBePositive() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		CreateReportParameters parameters = new CreateReportParameters(
				ZonedDateTime.now(), "The suspect was wearing a black hat.",
				true, 2);
		Set<ConstraintViolation<CreateReportParameters>> violationSet = validator
				.validate(parameters);
		assertThat(violationSet).hasNoViolations();
	}

	@Test
	public void givenNoTrafficIndicent_involvedCarsDoesNotMatter() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		CreateReportParameters parameters = new CreateReportParameters(
				ZonedDateTime.now(), "The suspect was wearing a black hat.",
				false, 0);
		Set<ConstraintViolation<CreateReportParameters>> violationSet = validator
				.validate(parameters);
		assertThat(violationSet).hasNoViolations();
	}
}
