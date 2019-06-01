package com.example.wait.democopsboot.report.web;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidCreateReportParameters
public class CreateReportParameters {
	private ZonedDateTime dateTime;

	@ValidReportDescription
	private String description;

	private boolean trafficIncident;
	private int numberOfInvolvedCars;
}
