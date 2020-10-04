package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Model.ReportType;
import com.wasteless.sd.Service.query.ReportQueryService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.query.ReadReportQuery;
import com.wasteless.sd.mediator.response.ReadReportQueryResponse;

public class ReadReportQueryHandler implements Handler<ReadReportQuery, ReadReportQueryResponse> {

    private final ReportQueryService reportService;

    public ReadReportQueryHandler(ReportQueryService reportService) {
        this.reportService = reportService;
    }

    @Override
    public ReadReportQueryResponse handle(ReadReportQuery request) {
        return new ReadReportQueryResponse(reportService.getReport(
                ReportType.valueOf(request.getReportType().toUpperCase()),
                request.getPrincipal()
        ));
    }
}
