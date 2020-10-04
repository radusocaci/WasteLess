package com.wasteless.sd.Factory;

import com.wasteless.sd.Model.Report;
import com.wasteless.sd.Model.ReportType;
import com.wasteless.sd.Model.WeeklyReport;

public class WeeklyReportFactory extends ReportFactory {
    @Override
    public Report getInstance(ReportType reportType) {
        return new WeeklyReport();
    }
}
