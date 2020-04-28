package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * reference to a stop (can be nation specific). This can help to specific pinpoint a (bus) stop. Extra information about the stop is not supplied; you should find it elsewhere.
 */
@ApiModel(description = "reference to a stop (can be nation specific). This can help to specific pinpoint a (bus) stop. Extra information about the stop is not supplied; you should find it elsewhere.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class StopReference   {
  /**
   * type of external reference (GTFS, CHB).
   */
  public enum TypeEnum {
    GTFS_STOP_ID("GTFS_STOP_ID"),
    
    GTFS_STOP_CODE("GTFS_STOP_CODE"),
    
    GTFS_AREA_ID("GTFS_AREA_ID"),
    
    CHB_STOP_PLACE_CODE("CHB_STOP_PLACE_CODE"),
    
    CHB_QUAY_CODE("CHB_QUAY_CODE"),
    
    NS_CODE("NS_CODE");

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

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("country")
  private String country = null;

  public StopReference type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * type of external reference (GTFS, CHB).
   * @return type
  **/
  @ApiModelProperty(required = true, value = "type of external reference (GTFS, CHB).")
      @NotNull

    public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public StopReference id(String id) {
    this.id = id;
    return this;
  }

  /**
   * this field should contain the complete ID. E.g. NL:S:13121110 or BE:S:79640040
   * @return id
  **/
  @ApiModelProperty(required = true, value = "this field should contain the complete ID. E.g. NL:S:13121110 or BE:S:79640040")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public StopReference country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

  @Size(min=2,max=2)   public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StopReference stopReference = (StopReference) o;
    return Objects.equals(this.type, stopReference.type) &&
        Objects.equals(this.id, stopReference.id) &&
        Objects.equals(this.country, stopReference.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StopReference {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
