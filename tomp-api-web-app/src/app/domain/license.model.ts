import { AssetClass } from './asset-class.model';
import { Country } from './country.model';

/**
 * driver or usage license for a specific user.
 * Contains the number and the asset-type you're allowed to operate (e.g. driver license for CAR)
 */
export class License {
  number?: string = '';
  assetClass?: AssetClass = AssetClass.CAR;
  /**
   * in most countries a driver license has also a code.
   * As TO you can exactly verify, based on this code if the license allows to operate it's assets, if the asset-type too generic.
   */
  licenseCode?: string = '';
  country?: Country = '';
  validUntil?: string = '';
}
