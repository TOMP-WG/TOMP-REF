import { Injectable } from '@angular/core';
import { PlanningOptions } from '../domain/planning-options.model';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlanningService {

  private planningSubject: Subject<PlanningOptions> = new Subject();

  public updatePlanning(planning: PlanningOptions) {
    this.planningSubject.next(planning);
  }

  public onUpdatePlanning(): Observable<PlanningOptions> {
    return this.planningSubject;
  }
}
