import { Component } from '@angular/core';
import { PlanningService } from '../../services/planning.service';
import { PlanningOptions } from '../../domain/planning-options.model';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.scss']
})
export class RequestComponent {

  public planning: PlanningOptions;

  constructor(public planningService: PlanningService) {
    this.planningService.onUpdatePlanning().subscribe(planning => this.updatePlanning(planning));
  }

  private updatePlanning(planning: PlanningOptions) {
    this.planning = planning;
  }

}
