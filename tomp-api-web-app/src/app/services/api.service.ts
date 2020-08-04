import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CustomHeaders } from '../domain/custom-headers.model';
import { Endpoint } from '../domain/endpoint.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) { }

  public doRequest(type: string, url: string, endpoint: string, headers: CustomHeaders, body?: string): Observable<any> {
    const options = this.generateOptions(headers, body);
    return this.httpClient.request(type, `${url + endpoint}`, options);
  }

  public loadEndpointConfig(externalUrl: string, version: string,  headers: CustomHeaders): Observable<any> {
    const url = 'assets/endpoints-' + version + '.json?_=' + Date.now();

    if ( version > '0.6.0' )  {
      return new Observable((o) =>
        this.httpClient.get(url).subscribe((data: any) => {
            const endpoints = [];
            this.metaObservable(externalUrl, version, headers).subscribe(metaEndpoints => {
              let endpoint: any;
              for ( endpoint of data ) {
                for ( const meta of metaEndpoints ) {
                  if ( endpoint.value.indexOf( meta ) === 0 ) {
                    endpoints.push(endpoint);
                    break;
                  }
                }
              }
              o.next(endpoints);
            } );
          }
        )
      );
    }
    else {
      return this.httpClient.get(url);
    }
  }

  private generateOptions(headers: CustomHeaders, body: string) {
    return {
      headers: new HttpHeaders(headers),
      body
    };
  }

  private metaObservable(externalUrl: string, version: string,  headers: CustomHeaders): Observable<any> {
    const options = this.generateOptions(headers, '');
    return new Observable( (o) => {
      const toUrl = externalUrl + '/operator/meta/';
      const metaEndpoints = [];
      this.httpClient.get(toUrl, options).subscribe((versions: any) => {
        let versionImpl: any;
        for ( versionImpl of versions ){
          if (versionImpl.version === version) {
            let ep: any;
            for ( ep of versionImpl.endpoints ) {
              if ( ep.status === 'IMPLEMENTED') {
                let path: string = ep.path;
                if (path.endsWith('/')) {
                  path = path.substr(0, path.length - 1);
                }
                metaEndpoints.push(path);
              }
            }
          }
        }
        o.next(metaEndpoints);
      } );
    } );
  }
}
