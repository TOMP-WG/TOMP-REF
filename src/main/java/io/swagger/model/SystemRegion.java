package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Polygon;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemRegion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class SystemRegion   {
  @JsonProperty("regionId")
  private String regionId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("serviceArea")
  private Polygon serviceArea = null;

  public SystemRegion regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

  /**
   * Unique identifier for this region
   * @return regionId
  **/
  @ApiModelProperty(example = "BikeRegion", required = true, value = "Unique identifier for this region")
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
   * Public name for this region
   * @return name
  **/
  @ApiModelProperty(example = "BikeTown", required = true, value = "Public name for this region")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SystemRegion serviceArea(Polygon serviceArea) {
    this.serviceArea = serviceArea;
    return this;
  }

  /**
   * Get serviceArea
   * @return serviceArea
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Polygon getServiceArea() {
    return serviceArea;
  }

  public void setServiceArea(Polygon serviceArea) {
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
