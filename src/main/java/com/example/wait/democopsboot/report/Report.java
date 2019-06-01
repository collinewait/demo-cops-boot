package com.example.wait.democopsboot.report;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.example.wait.democopsboot.user.User;
import com.example.wait.orm.jpa.AbstractEntity;
import com.example.wait.util.ArtifactForFramework;

@Entity
public class Report extends AbstractEntity<ReportId> {
	@ManyToOne
	private User reporter;
	private ZonedDateTime dateTime;
	private String description;

	@ArtifactForFramework
	protected Report() {
	}

	public Report(ReportId id, User reporter, ZonedDateTime dateTime,
			String description) {
		super(id);
		this.reporter = reporter;
		this.dateTime = dateTime;
		this.description = description;
	}

	public User getReporter() {
		return reporter;
	}

	public ZonedDateTime getDateTime() {
		return dateTime;
	}

	public String getDescription() {
		return description;
	}
}
