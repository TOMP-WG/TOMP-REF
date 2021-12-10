package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.GeojsonPolygon;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemRegion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T11:36:21.130Z[GMT]")


public class SystemRegion   {
  @JsonProperty("regionId")
  private String regionId = null;

  @JsonProperty("name")
  private String name = null;

  /**
   * the type of area. Default this is 'OPERATING', but other area's can be published here as well (since 1.3.0). Before 1.3.0, it was only allowed to communicate OPERATING area's.
   */
  public enum TypeEnum {
    OPERATING("OPERATING"),
    
    PROHIBITED_TO_ACCESS("PROHIBITED_TO_ACCESS"),
    
    PROHIBITED_TO_PAUSE("PROHIBITED_TO_PAUSE"),
    
    PARKING("PARKING"),
    
    DISCOUNT("DISCOUNT");

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
  private TypeEnum type = TypeEnum.OPERATING;

  @JsonProperty("serviceArea")
  private GeojsonPolygon serviceArea = new GeojsonPolygon();

  public SystemRegion regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

  /**
   * Unique identifier for this region
   * @return regionId
   **/
  @Schema(example = "BikeRegion", required = true, description = "Unique identifier for this region")
      @NotNull

    public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public SystemRegion name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Public name for this region, could match Content-Language
   * @return name
   **/
  @Schema(example = "BikeTown", required = true, description = "Public name for this region, could match Content-Language")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SystemRegion type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * the type of area. Default this is 'OPERATING', but other area's can be published here as well (since 1.3.0). Before 1.3.0, it was only allowed to communicate OPERATING area's.
   * @return type
   **/
  @Schema(description = "the type of area. Default this is 'OPERATING', but other area's can be published here as well (since 1.3.0). Before 1.3.0, it was only allowed to communicate OPERATING area's.")
  
    public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public SystemRegion serviceArea(GeojsonPolygon serviceArea) {
    this.serviceArea = serviceArea;
    return this;
  }

  /**
   * geojson representation of a polygon. First and last point must be equal. See also https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4. The order should be lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.
   * @return serviceArea
   **/
  @Schema(example = "[[[1,1],[0,1],[0,0],[1,0],[1,1]]]", description = "geojson representation of a polygon. First and last point must be equal. See also https://geojson.org/geojson-spec.html#polygon and example https://geojson.org/geojson-spec.html#id4. The order should be lon, lat [[[lon1, lat1], [lon2,lat2], [lon3,lat3], [lon1,lat1]]], the first point should match the last point.")
  
    @Valid
    public GeojsonPolygon getServiceArea() {
    return serviceArea;
  }

  public void setServiceArea(GeojsonPolygon serviceArea) {
    this.serviceArea = serviceArea;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemRegion systemRegion = (SystemRegion) o;
    return Objects.equals(this.regionId, systemRegion.regionId) &&
        Objects.equals(this.name, systemRegion.name) &&
        Objects.equals(this.type, systemRegion.type) &&
        Objects.equals(this.serviceArea, systemRegion.serviceArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionId, name, type, serviceArea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemRegion {\n");
    
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    serviceArea: ").append(toIndentedString(serviceArea)).append("\n");
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
