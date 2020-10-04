import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {GroceryList} from "./grocery-list";
import {catchError} from "rxjs/operators";

@Injectable()
export class GroceryService {

  private baseUrl = "http://localhost:8080/grocery-lists";
  private httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  getGroceryLists(): Observable<GroceryList[]> {
    return this.http.get<GroceryList[]>(this.baseUrl)
      .pipe(catchError(this.handleError<GroceryList[]>("getGroceryLists", [])));
  }

  createGroceryList(groceryList: GroceryList): Observable<GroceryList> {
    return this.http.post<GroceryList>(this.baseUrl, groceryList, this.httpOptions)
      .pipe(catchError(this.handleError<GroceryList>("createGroceryList")));
  }

  deleteGroceryList(grocertList: GroceryList | number): Observable<GroceryList> {
    const id = typeof grocertList === 'number' ? grocertList : grocertList.id;

    return this.http.delete<GroceryList>(`${this.baseUrl}/${id}`, this.httpOptions).pipe(
      catchError(this.handleError<GroceryList>('deleteGroceryList'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
