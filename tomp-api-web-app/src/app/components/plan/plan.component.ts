import { Component, OnInit } from '@angular/core';
import { PlanningOptions } from '../../domain/planning-options.model';
import { InternalService } from '../../services/internal.service';
import moment from 'moment';

@Component({
  selector: 'app-plan',
  templateUrl: './plan.component.html',
  styleUrls: ['./plan.component.scss']
})
export class PlanComponent implements OnInit {

  planning: PlanningOptions;

  constructor(public internalService: InternalService) { }

  ngOnInit(): void {
    this.planning = new PlanningOptions();
    this.planning.startTime = moment().unix();
    this.planning.endTime = moment().add(6, 'hours').unix();
  }

  onSubmit() {
    const object = JSON.parse(JSON.stringify(this.planning));
    object.startTime = object.startTime * 1000;
    object.endTime = object.endTime * 1000;
    this.internalService.updatePlanning(object as PlanningOptions);
  }

  toMetaLookup() {
    window.open('https://tomp.dat.nl/maas-operators/', '_blank');
  }

  onUpdatedStartPeriod(period: number) {
    this.planning.startTime = period;
  }

  onUpdatedEndPeriod(period: number) {
    this.planning.endTime = period;
  }

}
