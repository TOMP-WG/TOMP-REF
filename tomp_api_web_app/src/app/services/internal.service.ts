import { Injectable } from '@angular/core';
import { PlanningOptions } from '../domain/planning-options.model';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InternalService {

  private planningSubject: Subject<PlanningOptions> = new Subject();
  private responseSubject: Subject<string> = new Subject();
  private requestSubject: Subject<void> = new Subject();

  public updatePlanning(planning: PlanningOptions) {
    this.planningSubject.next(planning);
  }

  public onUpdatePlanning(): Observable<PlanningOptions> {
    return this.planningSubject;
  }

  public addResponse(response: string) {
    this.responseSubject.next(response);
  }

  public onAddResponse(): Observable<string> {
    return this.responseSubject;
  }

  public requestMade() {
    this.requestSubject.next();
  }

  public onrequestMade(): Observable<void> {
    return this.requestSubject;
  }
}
