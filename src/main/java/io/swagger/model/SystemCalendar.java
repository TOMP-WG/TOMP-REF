package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SystemcalendarPeriods;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemCalendar
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
public class SystemCalendar   {
  @JsonProperty("periods")
  @Valid
  private List<SystemcalendarPeriods> periods = null;

  public SystemCalendar periods(List<SystemcalendarPeriods> periods) {
    this.periods = periods;
    return this;
  }

  public SystemCalendar addPeriodsItem(SystemcalendarPeriods periodsItem) {
    if (this.periods == null) {
      this.periods = new ArrayList<SystemcalendarPeriods>();
    }
    this.periods.add(periodsItem);
    return this;
  }

  /**
   * Get periods
   * @return periods
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<SystemcalendarPeriods> getPeriods() {
    return periods;
  }

  public void setPeriods(List<SystemcalendarPeriods> periods) {
    this.periods = periods;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemCalendar systemCalendar = (SystemCalendar) o;
    return Objects.equals(this.periods, systemCalendar.periods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(periods);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemCalendar {\n");
    
    sb.append("    periods: ").append(toIndentedString(periods)).append("\n");
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
