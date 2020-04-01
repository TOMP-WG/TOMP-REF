package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SystemhoursHours;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemHours
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
public class SystemHours   {
  @JsonProperty("hours")
  @Valid
  private List<SystemhoursHours> hours = null;

  public SystemHours hours(List<SystemhoursHours> hours) {
    this.hours = hours;
    return this;
  }

  public SystemHours addHoursItem(SystemhoursHours hoursItem) {
    if (this.hours == null) {
      this.hours = new ArrayList<SystemhoursHours>();
    }
    this.hours.add(hoursItem);
    return this;
  }

  /**
   * Get hours
   * @return hours
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<SystemhoursHours> getHours() {
    return hours;
  }

  public void setHours(List<SystemhoursHours> hours) {
    this.hours = hours;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemHours systemHours = (SystemHours) o;
    return Objects.equals(this.hours, systemHours.hours);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hours);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemHours {\n");
    
    sb.append("    hours: ").append(toIndentedString(hours)).append("\n");
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
