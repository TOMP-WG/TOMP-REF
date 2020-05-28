package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Condition;
import io.swagger.model.Coordinates;
import io.swagger.model.Polygon;
import io.swagger.model.SystemHours;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * a return area. In the condition list there can be multiple return area&#x27;s.
 */
@ApiModel(description = "a return area. In the condition list there can be multiple return area's.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T15:19:29.217Z[GMT]")
public class ConditionReturnArea extends Condition implements OneOfcondition {
  @JsonProperty("stationId")
  private String stationId = null;

  @JsonProperty("returnArea")
  private Polygon returnArea = null;

  @JsonProperty("coordinates")
  private Coordinates coordinates = null;

  @JsonProperty("returnHours")
  @Valid
  private List<SystemHours> returnHours = null;

  public ConditionReturnArea stationId(String stationId) {
    this.stationId = stationId;
    return this;
  }

  /**
   * station to which the asset should be returned
   * @return stationId
  **/
  @ApiModelProperty(value = "station to which the asset should be returned")
  
    public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public ConditionReturnArea returnArea(Polygon returnArea) {
    this.returnArea = returnArea;
    return this;
  }

  /**
   * Get returnArea
   * @return returnArea
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Polygon getReturnArea() {
    return returnArea;
  }

  public void setReturnArea(Polygon returnArea) {
    this.returnArea = returnArea;
  }

  public ConditionReturnArea coordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  /**
   * Get coordinates
   * @return coordinates
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public ConditionReturnArea returnHours(List<SystemHours> returnHours) {
    this.returnHours = returnHours;
    return this;
  }

  public ConditionReturnArea addReturnHoursItem(SystemHours returnHoursItem) {
    if (this.returnHours == null) {
      this.returnHours = new ArrayList<SystemHours>();
    }
    this.returnHours.add(returnHoursItem);
    return this;
  }

  /**
   * the return hours of the facility (if different from operating-hours)
   * @return returnHours
  **/
  @ApiModelProperty(value = "the return hours of the facility (if different from operating-hours)")
      @Valid
    public List<SystemHours> getReturnHours() {
    return returnHours;
  }

  public void setReturnHours(List<SystemHours> returnHours) {
    this.returnHours = returnHours;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConditionReturnArea conditionReturnArea = (ConditionReturnArea) o;
    return Objects.equals(this.stationId, conditionReturnArea.stationId) &&
        Objects.equals(this.returnArea, conditionReturnArea.returnArea) &&
        Objects.equals(this.coordinates, conditionReturnArea.coordinates) &&
        Objects.equals(this.returnHours, conditionReturnArea.returnHours) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stationId, returnArea, coordinates, returnHours, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConditionReturnArea {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    returnArea: ").append(toIndentedString(returnArea)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("    returnHours: ").append(toIndentedString(returnHours)).append("\n");
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
