import { Coordinates } from './coordinates.model';
import { Place } from './place.model';

export class Plannings {
  startTime: string;
  endTime: string;
  from: Place = new Place();
  to: Place = new Place();

  departureTime: string;
  arrivalTime: string;
}
