import { Component, Renderer2, ViewChild, ElementRef } from '@angular/core';
import { InternalService } from '../../services/internal.service';
import { WebsocketService } from '../../services/websocket.service';

@Component({
  selector: 'app-response',
  templateUrl: './response.component.html',
  styleUrls: ['./response.component.scss']
})
export class ResponseComponent {

  @ViewChild('divMessages', { static: true }) private divMessages: ElementRef<HTMLInputElement>;

  public response: string = null;
  public receivedMessage = '';

  constructor(public internalService: InternalService, public websocket: WebsocketService, private renderer: Renderer2) {
    this.internalService.onAddResponse().subscribe(response => this.updateResponse(response));
    this.internalService.onrequestMade().subscribe(response => this.requestMade());
    this.internalService.onReceivedMessage().subscribe(message =>
      this.addMessage(message)
    );
  }

  private addMessage(message: string) {
    if (message.startsWith('http')) {
      let link: HTMLAnchorElement;
      link = this.renderer.createElement('a');
      link.setAttribute('href', message);
      link.setAttribute('target', '_blank');
      link.setAttribute('class', 'response-link');
      const text = this.renderer.createText(message);
      link.appendChild(text);
      this.renderer.appendChild(this.divMessages.nativeElement, link);
    }
    else {
      const text = this.renderer.createText(message);
      this.renderer.appendChild(this.divMessages.nativeElement, text);
    }
    this.renderer.appendChild(this.divMessages.nativeElement, this.renderer.createElement('br'));
  }

  private updateResponse(response: string) {
    this.response = response;
  }

  private requestMade() {
    this.response = null;
  }

  public clear() {
    this.receivedMessage = '';
    this.divMessages.nativeElement.innerHTML = '';
  }
}
