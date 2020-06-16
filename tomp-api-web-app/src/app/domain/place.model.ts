import { Coordinates } from './coordinates.model';
import { Address } from './address.model';

export class Place {
  coordinates: Coordinates = new Coordinates();
  name: string;
  stationId: string;
  physicalAddress: Address = null;
}
