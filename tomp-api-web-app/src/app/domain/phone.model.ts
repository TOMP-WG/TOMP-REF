export class Phone {
  /**
   * only one phone in this array can have a true in this property
   */
  preferred?: boolean = false;
  /**
   * phone number. In case of international usage, always provide the country code.
   */
  number?: string = '';
  kind?: Phone.KindEnum = 'LANDLINE';
  type?: Phone.TypeEnum = 'BUSINESS';
}
// tslint:disable-next-line: no-namespace
export namespace Phone {
  export type KindEnum = 'LANDLINE' | 'MOBILE';
  export const KindEnum = {
    LANDLINE: 'LANDLINE' as KindEnum,
    MOBILE: 'MOBILE' as KindEnum
  };
  export type TypeEnum = 'PRIVATE' | 'BUSINESS' | 'OTHER';
  export const TypeEnum = {
    PRIVATE: 'PRIVATE' as TypeEnum,
    BUSINESS: 'BUSINESS' as TypeEnum,
    OTHER: 'OTHER' as TypeEnum
  };
}
