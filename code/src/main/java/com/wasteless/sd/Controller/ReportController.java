package com.wasteless.sd.Controller;

import com.wasteless.sd.Model.ReportDTO;
import com.wasteless.sd.mediator.Mediator;
import com.wasteless.sd.mediator.handlers.ReadReportQueryHandler;
import com.wasteless.sd.mediator.query.ReadReportQuery;
import com.wasteless.sd.mediator.response.ReadReportQueryResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class ReportController {

    private final Mediator mediator;

    public ReportController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/report")
    public ReportDTO getReport(@RequestParam("type") String reportType, Principal principal) {
        ReadReportQuery request = new ReadReportQuery(reportType, principal.getName());
        ReadReportQueryHandler handler = (ReadReportQueryHandler)
                mediator.<ReadReportQuery, ReadReportQueryResponse>handle(request);
        ReadReportQueryResponse response = handler.handle(request);
        return response.getReportDTO();

    }
}
