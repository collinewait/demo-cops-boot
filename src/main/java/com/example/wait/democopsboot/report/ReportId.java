package com.example.wait.democopsboot.report;

import java.util.UUID;

import com.example.wait.orm.jpa.AbstractEntityId;
import com.example.wait.util.ArtifactForFramework;

public class ReportId extends AbstractEntityId<UUID> {
	@ArtifactForFramework
	protected ReportId() {
	}

	public ReportId(UUID id) {
		super(id);
	}
}
