import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) { }

  public doRequest(type: string, url: string, endpoint: string, headers: HttpHeaders, body?: string): Observable<any> {
    const options = this.generateOptions(headers, body);
    return this.httpClient.request(type, `${url + endpoint}`, options);
  }

  private generateOptions(headers: HttpHeaders, body: string) {
    return {
      headers,
      body
    };
  }
}
