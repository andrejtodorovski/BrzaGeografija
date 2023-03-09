import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Answer } from './components/Answer/Answer';
import { Result } from './components/app-component/result.model';

@Injectable({
  providedIn: 'root'
})
export class BgService {

  private url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public addResult(answer: Answer): Observable<Result>{
    return this.http.post<Result>(`${this.url}/submitAnswer`,answer);
  }
  public getLetter():Observable<String>
  {
    return this.http.get(`${this.url}/generateRandomLetter`,{responseType:'text'});
  }
}
