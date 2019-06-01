package com.example.wait.democopsboot.user.web;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.wait.democopsboot.user.UserService;

public class CreateUserParametersValidator implements
		ConstraintValidator<ValidCreateUserParameters, CreateOfficerParameters> {

	private final UserService userService;

	@Autowired
	public CreateUserParametersValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void initialize(ValidCreateUserParameters constraintAnnotation) {

	}

	@Override
	public boolean isValid(CreateOfficerParameters userParameters,
			ConstraintValidatorContext context) {

		boolean result = true;

		if (userService.findUserByEmail(userParameters.getEmail())
				.isPresent()) {
			context.buildConstraintViolationWithTemplate(
					"There is already a user with the given email address.")
					.addPropertyNode("email").addConstraintViolation();

			result = false;
		}

		return result;
	}
}
