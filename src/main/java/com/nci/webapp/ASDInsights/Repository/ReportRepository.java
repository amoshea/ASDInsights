package com.nci.webapp.ASDInsights.Repository;

import com.nci.webapp.ASDInsights.Model.Report;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {

    public boolean existsByDate(Date date);
}
