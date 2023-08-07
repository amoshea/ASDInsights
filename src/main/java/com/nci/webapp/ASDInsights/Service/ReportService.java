package com.nci.webapp.ASDInsights.Service;

import java.util.Date;

import com.nci.webapp.ASDInsights.Model.Report;




public interface ReportService {

    public Report reportData(Report data);

    public boolean checkDate(Date date);
}
