import { Component } from '@angular/core';
import { PlanningService } from '../../services/planning.service';

@Component({
  selector: 'app-response',
  templateUrl: './response.component.html',
  styleUrls: ['./response.component.scss']
})
export class ResponseComponent {

  public response: string;

  constructor(public planningService: PlanningService) {
    this.planningService.onAddResponse().subscribe(response => this.updateResponse(response));
    this.planningService.onrequestMade().subscribe(response => this.requestMade());
  }

  private updateResponse(response: string) {
    this.response = response;
  }

  private requestMade() {
    this.response = null;
  }

}
