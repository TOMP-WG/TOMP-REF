package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AmountOfMoney;
import io.swagger.model.KeyValue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * this describes a part of the fare (or discount). It contains a for instance the startup costs (fixed) or the flex part (e.g. 1.25 EUR per 2.0 MILES). The amount is tax included. In case of discounts, the values are negative. With &#x27;MAX&#x27; you can specify e.g. a maximum of 15 euro per day. Percentage is mainly added for discounts. The &#x60;scale&#x60; properties create the ability to communicate scales (e.g. the first 4 kilometers you&#x27;ve to pay EUR 0.35 per kilometer, the kilometers 4 until 8 EUR 0.50 and above it EUR 0.80 per kilometer).
 */
@ApiModel(description = "this describes a part of the fare (or discount). It contains a for instance the startup costs (fixed) or the flex part (e.g. 1.25 EUR per 2.0 MILES). The amount is tax included. In case of discounts, the values are negative. With 'MAX' you can specify e.g. a maximum of 15 euro per day. Percentage is mainly added for discounts. The `scale` properties create the ability to communicate scales (e.g. the first 4 kilometers you've to pay EUR 0.35 per kilometer, the kilometers 4 until 8 EUR 0.50 and above it EUR 0.80 per kilometer).")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class FarePart extends AmountOfMoney  {
  /**
   * type of fare part
   */
  public enum TypeEnum {
    FIXED("FIXED"),
    
    FLEX("FLEX"),
    
    MAX("MAX");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("type")
  private TypeEnum type = null;

  /**
   * in case of 'FLEX' mandatory. E.g. 0.5 EUR per HOUR
   */
  public enum UnitTypeEnum {
    KM("KM"),
    
    SECOND("SECOND"),
    
    MINUTE("MINUTE"),
    
    HOUR("HOUR"),
    
    MILE("MILE"),
    
    PERCENTAGE("PERCENTAGE");

    private String value;

    UnitTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static UnitTypeEnum fromValue(String text) {
      for (UnitTypeEnum b : UnitTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("unitType")
  private UnitTypeEnum unitType = null;

  @JsonProperty("units")
  private BigDecimal units = null;

  @JsonProperty("scaleFrom")
  private BigDecimal scaleFrom = null;

  @JsonProperty("scaleTo")
  private BigDecimal scaleTo = null;

  /**
   * Gets or Sets scaleType
   */
  public enum ScaleTypeEnum {
    KM("KM"),
    
    MILE("MILE"),
    
    HOUR("HOUR"),
    
    MINUTE("MINUTE");

    private String value;

    ScaleTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ScaleTypeEnum fromValue(String text) {
      for (ScaleTypeEnum b : ScaleTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("scaleType")
  private ScaleTypeEnum scaleType = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("class")
  private String propertyClass = null;

  @JsonProperty("meta")
  @Valid
  private List<KeyValue> meta = null;

  public FarePart type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * type of fare part
   * @return type
  **/
  @ApiModelProperty(value = "type of fare part")
  
    public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public FarePart unitType(UnitTypeEnum unitType) {
    this.unitType = unitType;
    return this;
  }

  /**
   * in case of 'FLEX' mandatory. E.g. 0.5 EUR per HOUR
   * @return unitType
  **/
  @ApiModelProperty(value = "in case of 'FLEX' mandatory. E.g. 0.5 EUR per HOUR")
  
    public UnitTypeEnum getUnitType() {
    return unitType;
  }

  public void setUnitType(UnitTypeEnum unitType) {
    this.unitType = unitType;
  }

  public FarePart units(BigDecimal units) {
    this.units = units;
    return this;
  }

  /**
   * the number of km, seconds etc in the `per` part. In the first example of the description this should be 2.0
   * @return units
  **/
  @ApiModelProperty(value = "the number of km, seconds etc in the `per` part. In the first example of the description this should be 2.0")
  
    @Valid
    public BigDecimal getUnits() {
    return units;
  }

  public void setUnits(BigDecimal units) {
    this.units = units;
  }

  public FarePart scaleFrom(BigDecimal scaleFrom) {
    this.scaleFrom = scaleFrom;
    return this;
  }

  /**
   * Get scaleFrom
   * @return scaleFrom
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getScaleFrom() {
    return scaleFrom;
  }

  public void setScaleFrom(BigDecimal scaleFrom) {
    this.scaleFrom = scaleFrom;
  }

  public FarePart scaleTo(BigDecimal scaleTo) {
    this.scaleTo = scaleTo;
    return this;
  }

  /**
   * Get scaleTo
   * @return scaleTo
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getScaleTo() {
    return scaleTo;
  }

  public void setScaleTo(BigDecimal scaleTo) {
    this.scaleTo = scaleTo;
  }

  public FarePart scaleType(ScaleTypeEnum scaleType) {
    this.scaleType = scaleType;
    return this;
  }

  /**
   * Get scaleType
   * @return scaleType
  **/
  @ApiModelProperty(value = "")
  
    public ScaleTypeEnum getScaleType() {
    return scaleType;
  }

  public void setScaleType(ScaleTypeEnum scaleType) {
    this.scaleType = scaleType;
  }

  public FarePart name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FarePart propertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
    return this;
  }

  /**
   * Get propertyClass
   * @return propertyClass
  **/
  @ApiModelProperty(value = "")
  
    public String getPropertyClass() {
    return propertyClass;
  }

  public void setPropertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
  }

  public FarePart meta(List<KeyValue> meta) {
    this.meta = meta;
    return this;
  }

  public FarePart addMetaItem(KeyValue metaItem) {
    if (this.meta == null) {
      this.meta = new ArrayList<KeyValue>();
    }
    this.meta.add(metaItem);
    return this;
  }

  /**
   * Get meta
   * @return meta
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<KeyValue> getMeta() {
    return meta;
  }

  public void setMeta(List<KeyValue> meta) {
    this.meta = meta;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FarePart farePart = (FarePart) o;
    return Objects.equals(this.type, farePart.type) &&
        Objects.equals(this.unitType, farePart.unitType) &&
        Objects.equals(this.units, farePart.units) &&
        Objects.equals(this.scaleFrom, farePart.scaleFrom) &&
        Objects.equals(this.scaleTo, farePart.scaleTo) &&
        Objects.equals(this.scaleType, farePart.scaleType) &&
        Objects.equals(this.name, farePart.name) &&
        Objects.equals(this.propertyClass, farePart.propertyClass) &&
        Objects.equals(this.meta, farePart.meta) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, unitType, units, scaleFrom, scaleTo, scaleType, name, propertyClass, meta, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FarePart {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    unitType: ").append(toIndentedString(unitType)).append("\n");
    sb.append("    units: ").append(toIndentedString(units)).append("\n");
    sb.append("    scaleFrom: ").append(toIndentedString(scaleFrom)).append("\n");
    sb.append("    scaleTo: ").append(toIndentedString(scaleTo)).append("\n");
    sb.append("    scaleType: ").append(toIndentedString(scaleType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
