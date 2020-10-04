import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Report} from "./report";
import {catchError} from "rxjs/operators";

@Injectable()
export class ReportService {

  private baseUrl = "http://localhost:8080/report";

  constructor(private http: HttpClient) {
  }

  getReport(type: string): Observable<Report> {
    return this.http.get<Report>(`${this.baseUrl}?type=${type}`)
      .pipe(catchError(this.handleError<Report>(`getReport type=${type}`)));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
