import { Coordinate } from './coordinate.model';

export class PlanningOptions {

  startTime: number;
  endTime: number;
  from: Coordinate = new Coordinate();
  to: Coordinate = new Coordinate();
  radius = 1000;
  travellers = 1;
  provideIds = false;
  users = [
    {
    age: 44
    }
  ];
}
