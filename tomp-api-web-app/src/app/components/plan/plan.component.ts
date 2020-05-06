import { Component, OnInit } from '@angular/core';
import { PlanningOptions } from '../../domain/planning-options.model';
import { PlanningService } from '../../services/planning.service';
import moment from 'moment';

@Component({
  selector: 'app-plan',
  templateUrl: './plan.component.html',
  styleUrls: ['./plan.component.scss']
})
export class PlanComponent implements OnInit {

  planning: PlanningOptions;

  constructor(public planningService: PlanningService) { }

  ngOnInit(): void {
    this.planning = new PlanningOptions();
    this.planning.startTime = moment().unix();
    this.planning.endTime = moment().add(6, 'hours').unix();
  }

  onSubmit() {
    console.log(this.planning);
    this.planningService.updatePlanning(this.planning);
  }

}