package com.example.wait.democopsboot.report;

import org.springframework.data.repository.CrudRepository;

public interface ReportRepository
		extends CrudRepository<Report, ReportId>, ReportRepositoryCustom {
}
