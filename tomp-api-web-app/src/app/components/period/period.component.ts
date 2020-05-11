import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import moment, { Moment } from 'moment';

@Component({
  selector: 'app-period',
  templateUrl: './period.component.html',
  styleUrls: ['./period.component.scss']
})
export class PeriodComponent implements OnInit {

  @Input() period: number;
  @Output() updatedPeriod = new EventEmitter();
  public date: Moment;

  constructor() { }

  ngOnInit() {
    this.date = moment.unix(this.period);
  }

  public timeChanged(e: string) {
    const time = moment(e, 'HH:mm');
    this.date.set({h: time.hours(), m: time.minutes(), s: 0});
    this.period = this.date.unix();
    this.updatedPeriod.emit(this.period);
  }

  public dateChanged(e: Moment) {
    this.date.set({year: e.year(), month: e.month(), date: e.date()});
    this.period = this.date.unix();
    this.updatedPeriod.emit(this.period);
  }

}
