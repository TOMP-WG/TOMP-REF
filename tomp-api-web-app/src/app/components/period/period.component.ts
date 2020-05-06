import { Component, Input } from '@angular/core';
import moment, { Moment } from 'moment';

@Component({
  selector: 'app-period',
  templateUrl: './period.component.html',
  styleUrls: ['./period.component.scss']
})
export class PeriodComponent {

  @Input() period: Moment;

  constructor() { }

  public timeChanged(e: string) {
    const time = moment(e, 'HH:mm');
    this.period.set({h: time.hours(), m: time.minutes(), s: 0});
  }

  public dateChanged(e: Moment) {
    this.period.set({year: e.year(), month: e.month(), date: e.date()});
  }

}
