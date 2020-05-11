import { Address } from './address.model';
import { Phone } from './phone.model';
import { User } from './user.model';

/**
 * a person that wants to travel. Only use the properties that are needed.
 */
export class Customer extends User {
  /**
   * The identifier MaaS uses to identify the customer
   */
  id: string = '';
  initials?: string = '';
  /**
   * First name of the customer
   */
  firstName?: string = '';
  /**
   * Last name of the customer
   */
  lastName?: string = '';
  /**
   * Middle name of the customer
   */
  middleName?: string = '';
  /**
   * prefix of the customer, like titles
   */
  prefix?: string = '';
  /**
   * postfix of the customer, like titles
   */
  postfix?: string = '';
  phones?: Array<Phone> = [];
  /**
   * the email address of the customer
   */
  email?: string = '';
  birthDate?: string = '';
  address?: Address = new Address();
  /**
   * base64 encoded
   */
  photo?: string = '';
}
