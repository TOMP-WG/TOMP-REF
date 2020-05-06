import moment, { Moment } from 'moment';

export class PlanningOptions {

  startTime: Moment = moment();
  endTime: Moment = moment();
  from: GeoJSON.Position;
  to: GeoJSON.Position;
  radius = 1000;
  travellers = 1;
  provideIds = false;
  users: [
    {
    age: 44;
    }
  ];
}
