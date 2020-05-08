import { Coordinates } from './coordinates.model';

export class PlanningOptions {

  startTime: number;
  endTime: number;
  from: Coordinates = new Coordinates();
  to: Coordinates = new Coordinates();
  radius = 1000;
  travellers = 1;
  provideIds = false;
  users = [
    {
    age: 44
    }
  ];
}
