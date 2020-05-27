import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CustomHeaders } from '../domain/custom-headers.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) { }

  public doRequest(type: string, url: string, endpoint: string, headers: CustomHeaders, body?: string): Observable<any> {
    const options = this.generateOptions(headers, body);
    return this.httpClient.request(type, `${url + endpoint}`, options);
  }

  public loadEndpointConfig(version: string): Observable<any> {
    const url = 'assets/endpoints-' + version + '.json?_=' + Date.now();
    return this.httpClient.get(url);
  }

  private generateOptions(headers: CustomHeaders, body: string) {
    return {
      headers: new HttpHeaders(headers),
      body
    };
  }

}
