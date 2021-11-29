import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { User } from './user'

import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  private baseUrl = "http://localhost:8090";
  constructor(private http: HttpClient) { }

  private log(message: string) {
    console.log(`LoginService: ${message}`);
  }

  getUser(email:string):Observable<User> {
    const fullUrl = this.baseUrl + "/userbyemail/"+email;
    console.log("full Url =" + fullUrl)
    return this.http.get<User>(fullUrl)
      .pipe(
        tap(_ => this.log('fetched a user')),
        catchError(this.handleError<User>('getUserByEmail'))
      );
  }
  
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
    
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


}
