package com.wasteless.sd.Factory;

import com.wasteless.sd.Model.Report;
import com.wasteless.sd.Model.ReportType;

public abstract class ReportFactory {
    public abstract Report getInstance(ReportType reportType);
}
