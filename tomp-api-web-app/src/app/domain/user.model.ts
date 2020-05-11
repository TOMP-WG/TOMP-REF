import { Card } from './card.model';
import { License } from './license.model';
import { Requirements } from './requirements.model';

export class User {
  validated?: boolean = true;
  age?: number = 20;
  licenses?: Array<License> = [new License()];
  cards?: Array<Card> = [new Card()];
  requirements?: Requirements = new Requirements();
}
