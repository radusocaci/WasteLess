import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {catchError} from "rxjs/operators";
import {Goal} from "./goal";

@Injectable()
export class GoalService {

  private baseUrl = "http://localhost:8080/goal";
  private httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  saveGoal(goal: Goal): Observable<Goal> {
    return this.http.post<Goal>(this.baseUrl, goal, this.httpOptions)
      .pipe(catchError(this.handleError<Goal>(`saveGoal`)));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
