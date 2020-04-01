package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Condition;
import io.swagger.model.Period;
import io.swagger.model.Polygon;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * a return area. In the condition list there can be multiple return area&#x27;s. In case the return area is a building, it&#x27;s allowed to put a single point in the geometry.
 */
@ApiModel(description = "a return area. In the condition list there can be multiple return area's. In case the return area is a building, it's allowed to put a single point in the geometry.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
public class ReturnAreaCondition extends Condition implements OneOfcondition {
  @JsonProperty("station-id")
  private String stationId = null;

  @JsonProperty("geometry")
  private Polygon geometry = null;

  @JsonProperty("opening-times")
  @Valid
  private List<Period> openingTimes = null;

  public ReturnAreaCondition stationId(String stationId) {
    this.stationId = stationId;
    return this;
  }

  /**
   * optional station id (see static information)
   * @return stationId
  **/
  @ApiModelProperty(value = "optional station id (see static information)")
  
    public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public ReturnAreaCondition geometry(Polygon geometry) {
    this.geometry = geometry;
    return this;
  }

  /**
   * Get geometry
   * @return geometry
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Polygon getGeometry() {
    return geometry;
  }

  public void setGeometry(Polygon geometry) {
    this.geometry = geometry;
  }

  public ReturnAreaCondition openingTimes(List<Period> openingTimes) {
    this.openingTimes = openingTimes;
    return this;
  }

  public ReturnAreaCondition addOpeningTimesItem(Period openingTimesItem) {
    if (this.openingTimes == null) {
      this.openingTimes = new ArrayList<Period>();
    }
    this.openingTimes.add(openingTimesItem);
    return this;
  }

  /**
   * the opening times of the facility
   * @return openingTimes
  **/
  @ApiModelProperty(value = "the opening times of the facility")
      @Valid
    public List<Period> getOpeningTimes() {
    return openingTimes;
  }

  public void setOpeningTimes(List<Period> openingTimes) {
    this.openingTimes = openingTimes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReturnAreaCondition returnAreaCondition = (ReturnAreaCondition) o;
    return Objects.equals(this.stationId, returnAreaCondition.stationId) &&
        Objects.equals(this.geometry, returnAreaCondition.geometry) &&
        Objects.equals(this.openingTimes, returnAreaCondition.openingTimes) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stationId, geometry, openingTimes, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReturnAreaCondition {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    geometry: ").append(toIndentedString(geometry)).append("\n");
    sb.append("    openingTimes: ").append(toIndentedString(openingTimes)).append("\n");
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
