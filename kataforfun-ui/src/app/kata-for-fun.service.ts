import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const URL: string= "/kata-for-fun/";

@Injectable({
  providedIn: 'root'
})
export class KataForFunService {
  constructor(private httpClient: HttpClient) { }
  public convertNumber(number: number) : Observable<String> {
    return this.httpClient.get<String>(environment.apiURL + URL+ number)
  }

}
