import { Country } from './country.model';

export class Address {
  /**
   * street address, including number OR PO box number, eventually extended with internal referencce like room number
   */
  streetAddress?: string = '';
  /**
   * city or town, principal subdivision such as province, state or county
   */
  areaReference?: string = '';
  postalCode?: string = '';
  country?: Country = '';
}
