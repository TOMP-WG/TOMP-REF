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
 * SystemregionRegions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-03T08:37:12.232Z[GMT]")
public class SystemregionRegions   {
  @JsonProperty("region-id")
  private String regionId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("area")
  private Polygon area = null;

  public SystemregionRegions regionId(String regionId) {
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

  public SystemregionRegions name(String name) {
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

  public SystemregionRegions area(Polygon area) {
    this.area = area;
    return this;
  }

  /**
   * Get area
   * @return area
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Polygon getArea() {
    return area;
  }

  public void setArea(Polygon area) {
    this.area = area;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemregionRegions systemregionRegions = (SystemregionRegions) o;
    return Objects.equals(this.regionId, systemregionRegions.regionId) &&
        Objects.equals(this.name, systemregionRegions.name) &&
        Objects.equals(this.area, systemregionRegions.area);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionId, name, area);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemregionRegions {\n");
    
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    area: ").append(toIndentedString(area)).append("\n");
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
