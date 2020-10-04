import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {finalize} from "rxjs/operators";
import {Router} from "@angular/router";

@Injectable()
export class AuthService {

  private baseUrl = "http://localhost:8080/";

  constructor(private http: HttpClient, private router: Router) {
  }

  authenticate(credentials: any, callback: any): void {
    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.get(this.baseUrl + 'user', {headers: headers}).subscribe(user => {
      sessionStorage.setItem('token', headers.get('authorization'));
      sessionStorage.setItem('username', credentials.username);
      return callback && callback();
    })
  }

  logout(): void {
    this.http.post(this.baseUrl + 'logout', {}).pipe(
      finalize(() => {
        sessionStorage.removeItem('token');
        sessionStorage.removeItem('username');
        this.router.navigateByUrl('login');
      })
    ).subscribe();
  }

  isAuthenticated() {
    let token = sessionStorage.getItem('token');
    return token !== null && token.startsWith('Basic');
  }
}
