package com.example.wait.democopsboot.report;

import java.util.UUID;

import com.example.wait.orm.jpa.UniqueIdGenerator;

public class ReportRepositoryImpl implements ReportRepositoryCustom {
	private final UniqueIdGenerator<UUID> generator;

	public ReportRepositoryImpl(UniqueIdGenerator<UUID> generator) {
		this.generator = generator;
	}

	@Override
	public ReportId nextId() {
		return new ReportId(generator.getNextUniqueId());
	}
}
