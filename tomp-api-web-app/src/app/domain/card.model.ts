import { AssetClass } from './asset-class.model';
import { Country } from './country.model';

/**
 * card object. Only provide the cards that are requested.
 * The asset type property is only allowed for the DISCOUNT card in combination with certain card-acceptors.
 */
export class Card {
  cardType: Card.CardTypeEnum = 'BANK';
  /**
   * mandatory in case of OTHER. Can be used in bilateral agreements.
   */
  cardSubType?: string = '';
  /**
   * description of the card
   */
  cardDescription?: string = '';
  /**
   * references to maas-ids of accepting parties. Only if applicable (DISCOUNT).
   */
  cardAcceptors?: Array<string> = [''];
  /**
   * number of the card, like ID number, credit card or bank account number
   */
  cardNumber: string = '';
  /**
   * additional number, like CVC code or IBAN code
   */
  cardAdditionalNumber?: string = '';
  validUntil: string = '';
  country?: Country = '';
  assetClass?: AssetClass = 'CAR';
}
// tslint:disable-next-line: no-namespace
export namespace Card {
  export type CardTypeEnum = 'ID' | 'DISCOUNT' | 'TRAVEL' | 'BANK' | 'CREDIT' | 'PASSPORT' | 'OTHER';
  export const CardTypeEnum = {
    ID: 'ID' as CardTypeEnum,
    DISCOUNT: 'DISCOUNT' as CardTypeEnum,
    TRAVEL: 'TRAVEL' as CardTypeEnum,
    BANK: 'BANK' as CardTypeEnum,
    CREDIT: 'CREDIT' as CardTypeEnum,
    PASSPORT: 'PASSPORT' as CardTypeEnum,
    OTHER: 'OTHER' as CardTypeEnum
  };
}
