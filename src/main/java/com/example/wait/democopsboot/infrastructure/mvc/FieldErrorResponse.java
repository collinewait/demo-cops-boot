package com.example.wait.democopsboot.infrastructure.mvc;

import lombok.Value;

@Value
public class FieldErrorResponse {
	private String fieldName;
	private String errorMessage;
}
