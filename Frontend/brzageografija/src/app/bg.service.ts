import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Answer } from './components/Answer/Answer';

@Injectable({
  providedIn: 'root'
})
export class BgService {

  private url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public addResult(answer: Answer): Observable<Answer>{
    return this.http.post<Answer>(`${this.url}/add`,answer);
  }
  public getLetter():Observable<String>
  {
    return this.http.get(`${this.url}/generateRandomLetter`,{responseType:'text'});
  }
}
