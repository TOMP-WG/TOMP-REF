package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * the class of asset. It's possible to specify it more in the assetSubType in typeOfAsset. These classes are taken from the NeTeX standard, but ALL and UNKNOWN are removed. On the other hand OTHER and PARKING are added.
 */
public enum AssetClass {
  AIR("AIR"),
    BUS("BUS"),
    TROLLEYBUS("TROLLEYBUS"),
    TRAM("TRAM"),
    COACH("COACH"),
    RAIL("RAIL"),
    INTERCITYRAIL("INTERCITYRAIL"),
    URBANRAIL("URBANRAIL"),
    METRO("METRO"),
    WATER("WATER"),
    CABLEWAY("CABLEWAY"),
    FUNICULAR("FUNICULAR"),
    TAXI("TAXI"),
    SELFDRIVE("SELFDRIVE"),
    FOOT("FOOT"),
    BICYCLE("BICYCLE"),
    MOTORCYCLE("MOTORCYCLE"),
    CAR("CAR"),
    SHUTTLE("SHUTTLE"),
    OTHER("OTHER"),
    PARKING("PARKING"),
    MOPED("MOPED"),
    STEP("STEP");

  private String value;

  AssetClass(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AssetClass fromValue(String text) {
    for (AssetClass b : AssetClass.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
