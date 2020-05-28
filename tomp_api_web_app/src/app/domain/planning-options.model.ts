import { Coordinates } from './coordinates.model';

export class PlanningOptions {

  startTime: number;
  endTime: number;
  from: Coordinates = new Coordinates();
  to: Coordinates = new Coordinates();
}
