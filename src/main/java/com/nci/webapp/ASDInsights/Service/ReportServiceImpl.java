package com.nci.webapp.ASDInsights.Service;

import com.nci.webapp.ASDInsights.Model.Report;
import com.nci.webapp.ASDInsights.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportRepository reportRepo;
    @Override
    public Report reportData(Report data) {
        return reportRepo.save(data);
    }

    @Override
    public boolean checkDate(Integer date) {
        return reportRepo.existsByDate(date);
    }
}
