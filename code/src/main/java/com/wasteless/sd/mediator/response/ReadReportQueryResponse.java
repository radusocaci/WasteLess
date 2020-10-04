package com.wasteless.sd.mediator.response;

import com.wasteless.sd.Model.ReportDTO;
import com.wasteless.sd.mediator.Response;

public class ReadReportQueryResponse implements Response {

    private ReportDTO reportDTO;

    public ReadReportQueryResponse(ReportDTO reportDTO) {
        this.reportDTO = reportDTO;
    }

    public ReportDTO getReportDTO() {
        return reportDTO;
    }

    public void setReportDTO(ReportDTO reportDTO) {
        this.reportDTO = reportDTO;
    }
}
