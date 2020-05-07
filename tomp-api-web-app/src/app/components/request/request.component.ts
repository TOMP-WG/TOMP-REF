import { Component } from '@angular/core';
import { PlanningService } from '../../services/planning.service';
import { PlanningOptions } from '../../domain/planning-options.model';
import { Endpoint } from '../../domain/endpoint.model';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.scss']
})
export class RequestComponent {

  public planning: PlanningOptions;
  public url = 'http://localhost:8090';
  public endpoints: Endpoint[] = [
    { type: 'POST', value: 'planning-options' },
    { type: 'GET', value: 'operator/information' },
    { type: 'POST', value: 'legs/{id}/events' }
  ];
  public endpoint: Endpoint = this.endpoints[0];
  public header: { [key: string]: string } = {
    content: 'application/json',
    language: 'NL',
    api: 'TOMP',
    apiVersion: '0.5.0',
    accept: 'application/json',
    maasId: '333',
  };

  constructor(public planningService: PlanningService) {
    this.planningService.onUpdatePlanning().subscribe(planning => this.updatePlanning(planning));
  }

  public onSubmit() {

  }

  private updatePlanning(planning: PlanningOptions) {
    this.planning = planning;
  }

}
