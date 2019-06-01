package com.example.wait.democopsboot.report.web;

import java.time.ZonedDateTime;

import com.example.wait.democopsboot.report.Report;
import com.example.wait.democopsboot.report.ReportId;

import lombok.Value;

@Value
public class ReportDto {
	private ReportId id;
	private String reporter;
	private ZonedDateTime dateTime;
	private String description;

	public static ReportDto fromReport(Report report) {
		return new ReportDto(report.getId(), report.getReporter().getEmail(),
				report.getDateTime(), report.getDescription());
	}
}
