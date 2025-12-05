import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, retry, map} from 'rxjs';
import {Rateresponse} from '../models/rateresponse.model';

@Injectable({
  providedIn: 'root',
})
export class Rateservice {
  constructor(private http: HttpClient) {
  }
  getRate(): Observable<Rateresponse> {
    return this.http.get<any>("http://localhost:8080").pipe(
      map(data => new Rateresponse(data))
    );
  }

}
