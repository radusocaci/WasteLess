package com.wasteless.sd.Factory;

import com.wasteless.sd.Model.MonthlyReport;
import com.wasteless.sd.Model.Report;
import com.wasteless.sd.Model.ReportType;

public class MonthlyReportFactory extends ReportFactory {
    @Override
    public Report getInstance(ReportType reportType) {
        return new MonthlyReport();
    }
}
