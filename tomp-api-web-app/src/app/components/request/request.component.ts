import { Component } from '@angular/core';
import { PlanningService } from '../../services/planning.service';
import { PlanningOptions } from '../../domain/planning-options.model';
import { Endpoint } from '../../domain/endpoint.model';
import { ApiService } from '../../services/api.service';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.scss']
})
export class RequestComponent {

  public body: PlanningOptions;
  public url = 'http://localhost:8090';
  public endpoints: Endpoint[] = [
    { type: 'POST', value: '/planning-options/' },
    { type: 'GET', value: '/operator/information' },
    { type: 'POST', value: '/legs/{id}/events' }
  ];
  public endpoint: Endpoint = this.endpoints[0];
  public headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept-Language': 'NL',
    Accept: 'application/json',
    api: 'TOMP',
    'api-Version': '0.4.0',
    'maas-id': '1',
  });

  constructor(public planningService: PlanningService, public apiService: ApiService) {
    this.planningService.onUpdatePlanning().subscribe(planning => this.updatePlanning(planning));
  }

  public onSubmit() {
    if (this.endpoint.type === 'GET') {
      this.apiService.doRequest(this.endpoint.type, this.url, this.endpoint.value, this.headers).subscribe(
        (result) => {
          console.log(result);
          this.planningService.addResponse(result);
        }, (error) => {
          console.log('Error in request: ', error);
        });
    } else {
      this.apiService.doRequest(this.endpoint.type, this.url, this.endpoint.value, this.headers, JSON.stringify(this.body)).subscribe(
        (result) => {
          console.log(result);
          this.planningService.addResponse(result);
        }, (error) => {
          console.log('Error in request: ', error);
        });
    }
  }

  private updatePlanning(planning: PlanningOptions) {
    this.body = planning;
  }

}
