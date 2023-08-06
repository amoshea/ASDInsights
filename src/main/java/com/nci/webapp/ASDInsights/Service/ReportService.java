package com.nci.webapp.ASDInsights.Service;

import com.nci.webapp.ASDInsights.Model.Report;




public interface ReportService {

    public Report reportData(Report data);

    public boolean checkDate(Integer date);
}
