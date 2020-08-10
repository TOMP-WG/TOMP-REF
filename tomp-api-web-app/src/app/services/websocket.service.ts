import { Injectable } from '@angular/core';
import { StompService, StompConfig, StompState } from '@stomp/ng2-stompjs';
import { Message } from '@stomp/stompjs';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  private messages: Observable<Message>;
  private stompService: StompService;

  connect(socketUrl: string) {
    socketUrl = this.formatWsUrl(socketUrl);

    const stompConfig: StompConfig = {
      url: socketUrl,
      headers: {
        login: '',
        passcode: ''
      },
      heartbeat_in: 0,
      heartbeat_out: 20000,
      reconnect_delay: 5000,
      debug: true
    };

    if (this.stompService) {
      this.stompService.disconnect();
    }

    this.stompService = new StompService(stompConfig);
    this.messages = this.stompService.subscribe('/topic/backend');
  }

  formatWsUrl(url: string): string {
    url = url.replace('http', 'ws');
    if (url.endsWith('/')) {
      url = url.substring(0, url.length - 1);
    }
    url += '/ws2';
    return url;
  }


  public stream(): Observable<Message> {
    return this.messages;
  }

  public send(url: string, message: any) {
    return this.stompService.publish(url, JSON.stringify(message));
  }
}
