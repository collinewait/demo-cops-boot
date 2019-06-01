package com.example.wait.democopsboot.report;

import java.time.ZonedDateTime;

import com.example.wait.democopsboot.user.UserId;

public interface ReportService {
	Report createReport(UserId reporterId, ZonedDateTime dateTime,
			String description);
}
