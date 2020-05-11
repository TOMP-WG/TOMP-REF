/**
 * the class of asset. It's possible to specify it more in the assetSubType in typeOfAsset.
 * These classes are taken from the NeTeX standard, but ALL and UNKNOWN are removed. On the other hand OTHER and PARKING are added.
 */
export type AssetClass = 'AIR' | 'BUS' | 'TROLLEYBUS' | 'TRAM' | 'COACH' | 'RAIL' | 'INTERCITYRAIL' | 'URBANRAIL' | 'METRO' | 'WATER' | 'CABLEWAY' | 'FUNICULAR' | 'TAXI' | 'SELFDRIVE' | 'FOOT' | 'BICYCLE' | 'MOTORCYCLE' | 'CAR' | 'SHUTTLE' | 'OTHER' | 'PARKING' | 'MOPED' | 'STEP';

export const AssetClass = {
    AIR: 'AIR' as AssetClass,
    BUS: 'BUS' as AssetClass,
    TROLLEYBUS: 'TROLLEYBUS' as AssetClass,
    TRAM: 'TRAM' as AssetClass,
    COACH: 'COACH' as AssetClass,
    RAIL: 'RAIL' as AssetClass,
    INTERCITYRAIL: 'INTERCITYRAIL' as AssetClass,
    URBANRAIL: 'URBANRAIL' as AssetClass,
    METRO: 'METRO' as AssetClass,
    WATER: 'WATER' as AssetClass,
    CABLEWAY: 'CABLEWAY' as AssetClass,
    FUNICULAR: 'FUNICULAR' as AssetClass,
    TAXI: 'TAXI' as AssetClass,
    SELFDRIVE: 'SELFDRIVE' as AssetClass,
    FOOT: 'FOOT' as AssetClass,
    BICYCLE: 'BICYCLE' as AssetClass,
    MOTORCYCLE: 'MOTORCYCLE' as AssetClass,
    CAR: 'CAR' as AssetClass,
    SHUTTLE: 'SHUTTLE' as AssetClass,
    OTHER: 'OTHER' as AssetClass,
    PARKING: 'PARKING' as AssetClass,
    MOPED: 'MOPED' as AssetClass,
    STEP: 'STEP' as AssetClass
};
