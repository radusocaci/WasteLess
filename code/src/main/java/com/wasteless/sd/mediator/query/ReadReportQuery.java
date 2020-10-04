package com.wasteless.sd.mediator.query;

import com.wasteless.sd.mediator.Request;

public class ReadReportQuery implements Request {

    private String reportType;
    private String principal;

    public ReadReportQuery(String reportType, String principal) {
        this.reportType = reportType;
        this.principal = principal;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
