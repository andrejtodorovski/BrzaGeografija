import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Answer } from './Answer';
import { Country } from './Country';

@Injectable({
  providedIn: 'root'
})
export class BgService {

  private url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public getAllCountries(): Observable<Country[]>{
    return this.http.get<Country[]>(`${this.url}/countries`);
  }
  public addResult(answer: Answer): Observable<Answer>{
    return this.http.post<Answer>(`${this.url}/add`,answer);
  }
}
