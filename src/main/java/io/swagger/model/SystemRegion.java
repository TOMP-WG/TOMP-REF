package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SystemregionRegions;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemRegion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
public class SystemRegion   {
  @JsonProperty("regions")
  @Valid
  private List<SystemregionRegions> regions = null;

  public SystemRegion regions(List<SystemregionRegions> regions) {
    this.regions = regions;
    return this;
  }

  public SystemRegion addRegionsItem(SystemregionRegions regionsItem) {
    if (this.regions == null) {
      this.regions = new ArrayList<SystemregionRegions>();
    }
    this.regions.add(regionsItem);
    return this;
  }

  /**
   * Get regions
   * @return regions
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<SystemregionRegions> getRegions() {
    return regions;
  }

  public void setRegions(List<SystemregionRegions> regions) {
    this.regions = regions;
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
    return Objects.equals(this.regions, systemRegion.regions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemRegion {\n");
    
    sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
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
