package com.wasteless.sd.Factory;

import com.wasteless.sd.Model.ReportType;

public class FactoryProvider {
    public static ReportFactory getFactory(ReportType reportType) {
        if (reportType == ReportType.MONTHLY) {
            return new MonthlyReportFactory();
        } else {
            return new WeeklyReportFactory();
        }
    }
}
