import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
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
export class RequestComponent implements OnInit {

  @ViewChild('bodyInput', { static: true }) textArea: ElementRef<HTMLInputElement>;

  public body: any;
  public url = 'https://tomp.dat.nl/bike';
  public endpoints: Endpoint[];
  public endpoint: Endpoint;
  public headers: CustomHeaders = new CustomHeaders();
  public id: string;

  constructor(public internalService: InternalService, public apiService: ApiService) {
    this.internalService.onUpdatePlanning().subscribe(planning => this.updatePlanning(planning));
  }

  ngOnInit() {
    this.apiService.loadEndpointConfig().subscribe(data => {
      this.endpoints = data;
      if (this.endpoints.length > 0) {
        this.endpoint = this.endpoints[0];
        this.body = this.endpoint.body;
      }
    });
  }

  public onSubmit() {
    let endpointPath = this.endpoint.value;
    if (this.hasIdVariable(endpointPath)) {
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
      this.apiService.doRequest(this.endpoint.type, this.url, endpointPath, this.headers, this.body).subscribe(
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
    if (this.endpoint.body) {
      this.updateBody();
    } else {
      this.body = null;
    }
  }

  public hasIdVariable(value: string) {
    return value.includes('{id}');
  }

  public headerChanged(key: string, value: string) {
    this.headers[key] = value;
  }

  public getHeaderProperties() {
    return Object.getOwnPropertyNames(this.headers);
  }

  public jsonChanged() {
    this.body = JSON.parse(this.textArea.nativeElement.value);
  }

  public updateBody() {
    if (this.endpoint.body) {
      if (this.hasIdVariable(JSON.stringify(this.endpoint.body))) {
        this.body = JSON.parse(JSON.stringify(this.endpoint.body).replace('{id}', this.id));
      } else {
        this.body = this.endpoint.body;
      }
    }
  }

  private updatePlanning(planning: PlanningOptions) {
    const body = (this.body as any) as PlanningOptions;
    body.endTime = planning.endTime;
    body.startTime = planning.startTime;
    body.from = planning.from;
    body.to = planning.to;
  }

}
