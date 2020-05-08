import { Component } from '@angular/core';
import { InternalService } from '../../services/internal.service';

@Component({
  selector: 'app-response',
  templateUrl: './response.component.html',
  styleUrls: ['./response.component.scss']
})
export class ResponseComponent {

  public response: string;

  constructor(public internalService: InternalService) {
    this.internalService.onAddResponse().subscribe(response => this.updateResponse(response));
    this.internalService.onrequestMade().subscribe(response => this.requestMade());
  }

  private updateResponse(response: string) {
    this.response = response;
  }

  private requestMade() {
    this.response = null;
  }

}
