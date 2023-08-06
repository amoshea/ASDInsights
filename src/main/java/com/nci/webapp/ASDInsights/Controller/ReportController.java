package com.nci.webapp.ASDInsights.Controller;

import com.nci.webapp.ASDInsights.Model.Report;
import com.nci.webapp.ASDInsights.Service.ReportService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReportController {


    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public String report(){
        return "report";
    }

    @PostMapping("/reportData")
    public String reportdata(@ModelAttribute Report data, HttpSession session) {

        System.out.println(data);

        boolean f= reportService.checkDate(data.getDate());

        if(f){
            session.setAttribute("msg", "Date already registered!");
        } else {
            Report report=reportService.reportData(data);
            if(report!=null){
                session.setAttribute("msg", "Register Successful!");
            }else{
                session.setAttribute("msg", "Sorry!!! Something wrong on server.");;
            }
        }
        return "redirect:/report";
    }

}
