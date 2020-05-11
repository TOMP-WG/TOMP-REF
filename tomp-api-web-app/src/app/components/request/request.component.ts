import { Component, ViewChild, ElementRef } from '@angular/core';
import { InternalService } from '../../services/internal.service';
import { PlanningOptions } from '../../domain/planning-options.model';
import { Endpoint } from '../../domain/endpoint.model';
import { ApiService } from '../../services/api.service';
import { EndpointType } from '../../domain/endpoint.enum';
import { CustomHeaders } from '../../domain/custom-headers.model';
import * as endpointData from '../../../assets/endpoints.json';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.scss']
})
export class RequestComponent {

  @ViewChild('bodyInput', { static: true }) textArea: ElementRef<HTMLInputElement>;

  public body: any = null;
  public url = 'https://tomp.dat.nl/bike';
  public endpoints: any[];
  public endpoint: Endpoint;
  public headers: CustomHeaders = new CustomHeaders();
  public id: string;

  constructor(public internalService: InternalService, public apiService: ApiService) {
    this.internalService.onUpdatePlanning().subscribe(planning => this.updatePlanning(planning));
    this.endpoints = (endpointData  as  any).default;
    if (this.endpoints.length > 0) {
      this.endpoint = this.endpoints[0];
      this.body = this.endpoint.body;
    }
  }

  public onSubmit() {
    let endpointPath = this.endpoint.value;
    if (this.hasIdVariable) {
      endpointPath = endpointPath.replace('{id}', this.id);
    }
    if (this.endpoint.type === EndpointType.GET) {
      this.apiService.doRequest(this.endpoint.type, this.url, endpointPath, this.headers).subscribe(
        (result) => {
          console.log(result);
          this.internalService.addResponse(result);
        }, (error) => {
          this.internalService.addResponse(error);
          console.log('Error in request: ', error);
        });
      } else {
      const updatedBody = this.textArea.nativeElement.value.replace(/\n/ig, '');
      this.apiService.doRequest(this.endpoint.type, this.url, endpointPath, this.headers, updatedBody).subscribe(
        (result) => {
          console.log(result);
          this.internalService.addResponse(result);
        }, (error) => {
          this.internalService.addResponse(error);
          console.log('Error in request: ', error);
        });
    }
    this.internalService.requestMade();
  }

  public onEndpointChanged() {
    this.id = null;
    if (this.endpoint.body) {
      this.body = JSON.parse(JSON.stringify(this.endpoint.body));
    } else {
      this.body = null;
    }
  }

  public hasIdVariable() {
    return this.endpoint.value.includes('{id}');
  }

  public headerChanged(key: string, value: string) {
    this.headers[key] = value;
  }

  public getHeaderProperties() {
    return Object.getOwnPropertyNames(this.headers);
  }

  private updatePlanning(planning: PlanningOptions) {
    const body = this.body as PlanningOptions;
    body.endTime = planning.endTime;
    body.startTime = planning.startTime;
    body.from = planning.from;
    body.to = planning.to;
  }

}
