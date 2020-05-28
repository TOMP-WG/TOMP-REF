package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Period
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class Period   {
  @JsonProperty("startTime")
  private BigDecimal startTime = null;

  @JsonProperty("endTime")
  private BigDecimal endTime = null;

  public Period startTime(BigDecimal startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getStartTime() {
    return startTime;
  }

  public void setStartTime(BigDecimal startTime) {
    this.startTime = startTime;
  }

  public Period endTime(BigDecimal endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getEndTime() {
    return endTime;
  }

  public void setEndTime(BigDecimal endTime) {
    this.endTime = endTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Period period = (Period) o;
    return Objects.equals(this.startTime, period.startTime) &&
        Objects.equals(this.endTime, period.endTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startTime, endTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Period {\n");
    
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
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
