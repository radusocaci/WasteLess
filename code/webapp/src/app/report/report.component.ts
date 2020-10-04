import {Component, OnInit} from '@angular/core';
import {Report} from "../report";
import {ReportService} from "../report.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  report: Report;
  private type: string;

  constructor(private reportService: ReportService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.type = params['type']
    });
    this.reportService.getReport(this.type).subscribe(rep => this.report = rep);
  }

}
