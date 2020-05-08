import { Component } from '@angular/core';
import { PlanningService } from '../../services/planning.service';
import { PlanningOptions } from '../../domain/planning-options.model';
import { Endpoint } from '../../domain/endpoint.model';
import { ApiService } from '../../services/api.service';
import { EndpointType } from '../../domain/endpoint.enum';
import { CustomHeaders } from '../../domain/custom-headers.model';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.scss']
})
export class RequestComponent {

  public body: PlanningOptions;
  public url = 'http://localhost:8090';
  public endpoints: Endpoint[] = [
    { type: EndpointType.POST, value: '/planning-options/' },
    { type: EndpointType.GET, value: '/operator/information' },
    { type: EndpointType.POST, value: '/bookings/' },
    { type: EndpointType.POST, value: '/bookings/{id}/events' },
    { type: EndpointType.GET, value: '/bookings/{id}' }
  ];
  public endpoint: Endpoint = this.endpoints[0];
  public headers: CustomHeaders = new CustomHeaders();

  constructor(public planningService: PlanningService, public apiService: ApiService) {
    this.planningService.onUpdatePlanning().subscribe(planning => this.updatePlanning(planning));
  }

  public onSubmit() {
    if (this.endpoint.type === EndpointType.GET) {
      this.apiService.doRequest(this.endpoint.type, this.url, this.endpoint.value, this.headers).subscribe(
        (result) => {
          console.log(result);
          this.planningService.addResponse(result);
        }, (error) => {
          this.planningService.addResponse(error);
          console.log('Error in request: ', error);
        });
    } else {
      this.apiService.doRequest(this.endpoint.type, this.url, this.endpoint.value, this.headers, JSON.stringify(this.body)).subscribe(
        (result) => {
          console.log(result);
          this.planningService.addResponse(result);
        }, (error) => {
          this.planningService.addResponse(error);
          console.log('Error in request: ', error);
        });
    }
  }

  public headerChanged(key: string, value: string) {
    this.headers[key] = value;
  }

  public getHeaderProperties() {
    return Object.getOwnPropertyNames(this.headers);
  }

  private updatePlanning(planning: PlanningOptions) {
    this.body = planning;
  }

}
