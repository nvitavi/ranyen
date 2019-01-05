import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

import { Person } from './model/person'

import { environment } from '../environments/environment';

//access environment.apiUrl
const endpoint = environment.apiUrl;

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RanyenService {

  constructor(private http: HttpClient) { }

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }    

  addUser (person: Person): Observable<Person> {
      console.log("Adding the person: " + person.firstName + " " + person.lastName);
      return this.http.post<Person>(endpoint + '/add-user', JSON.stringify(person), httpOptions).pipe(
        tap((person) => console.log(`added person with username=${person.username}`)),
        catchError(this.handleError<any>('addPerson'))
      );
  }
    
  handleError<T> (operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {

        // TODO: send the error to remote logging infrastructure
        console.error(error); // log to console instead

        // TODO: better job of transforming error for user consumption
        console.log(`${operation} failed: ${error.message}`);

        // Let the app keep running by returning an empty result.
        return of(result as T);
      };
  }

}
