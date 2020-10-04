import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {catchError} from "rxjs/operators";
import {GroceryItem} from "./grocery-item";

@Injectable()
export class GroceryItemService {

  private baseUrl = "http://localhost:8080/grocery-items";
  private httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  getGroceryListItems(id: number): Observable<GroceryItem[]> {
    return this.http.get<GroceryItem[]>(`${this.baseUrl}/${id}`)
      .pipe(catchError(this.handleError<GroceryItem[]>(`getGroceryListItems id=${id}`)));
  }

  createGroceryItem(groceryItem: GroceryItem, listId: number): Observable<GroceryItem> {
    return this.http.post<GroceryItem>(`${this.baseUrl}/${listId}`, groceryItem, this.httpOptions)
      .pipe(catchError(this.handleError<GroceryItem>("createGroceryItem")));
  }

  deleteGroceryItem(groceryItem: GroceryItem | number): Observable<GroceryItem> {
    const id = typeof groceryItem === 'number' ? groceryItem : groceryItem.id;

    return this.http.delete<GroceryItem>(`${this.baseUrl}/${id}`, this.httpOptions).pipe(
      catchError(this.handleError<GroceryItem>('deleteGroceryItem'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
