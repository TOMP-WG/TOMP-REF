import { Component, OnInit } from '@angular/core';
import { PlanningOptions } from '../../domain/planning-options.model';

@Component({
  selector: 'app-plan',
  templateUrl: './plan.component.html',
  styleUrls: ['./plan.component.scss']
})
export class PlanComponent implements OnInit {

  planning: PlanningOptions;

  constructor() { }

  ngOnInit(): void {
    this.planning = new PlanningOptions();
  }

  onSubmit() {
    console.log(this.planning);
  }

}
