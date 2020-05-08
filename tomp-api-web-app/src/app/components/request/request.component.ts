import { Component, ViewChild, ElementRef } from '@angular/core';
import { InternalService } from '../../services/internal.service';
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
  @ViewChild('bodyInput', { static: true }) textArea: ElementRef<HTMLInputElement>;
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

  constructor(public internalService: InternalService, public apiService: ApiService) {
    this.internalService.onUpdatePlanning().subscribe(planning => this.updatePlanning(planning));
  }

  public onSubmit() {
    const updatedBody = this.textArea.nativeElement.value.replace(/\n/ig, '');
    if (this.endpoint.type === EndpointType.GET) {
      this.apiService.doRequest(this.endpoint.type, this.url, this.endpoint.value, this.headers).subscribe(
        (result) => {
          console.log(result);
          this.internalService.addResponse(result);
        }, (error) => {
          this.internalService.addResponse(error);
          console.log('Error in request: ', error);
        });
    } else {
      this.apiService.doRequest(this.endpoint.type, this.url, this.endpoint.value, this.headers, updatedBody).subscribe(
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
