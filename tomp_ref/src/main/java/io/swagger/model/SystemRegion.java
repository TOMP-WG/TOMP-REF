package io.swagger.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * SystemRegion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class SystemRegion   {
  @JsonProperty("regionId")
  private String regionId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("serviceArea")
  private GeojsonPolygon serviceArea = null;

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

  public SystemRegion serviceArea(GeojsonPolygon serviceArea) {
    this.serviceArea = serviceArea;
    return this;
  }

  /**
   * The area served by the region (i.e. where one may travel using the service's assets) as GeoJSON Polygon coordinates
   * @return serviceArea
   **/
  @Schema(description = "The area served by the region (i.e. where one may travel using the service's assets) as GeoJSON Polygon coordinates")
  
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
        Objects.equals(this.serviceArea, systemRegion.serviceArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionId, name, serviceArea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemRegion {\n");
    
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
