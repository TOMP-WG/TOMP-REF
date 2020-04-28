package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * the current status of support
 */
@ApiModel(description = "the current status of support")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class SupportStatus   {
  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PROCESSING("PROCESSING"),
    
    UPDATE_REQUESTED("UPDATE_REQUESTED"),
    
    RESOLVED("RESOLVED"),
    
    CANCELLED("CANCELLED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("timeToResolution")
  private Integer timeToResolution = null;

  public SupportStatus status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(example = "PROCESSING", value = "")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public SupportStatus timeToResolution(Integer timeToResolution) {
    this.timeToResolution = timeToResolution;
    return this;
  }

  /**
   * time in minutes to expected resolution of support request
   * @return timeToResolution
  **/
  @ApiModelProperty(example = "9", value = "time in minutes to expected resolution of support request")
  
    public Integer getTimeToResolution() {
    return timeToResolution;
  }

  public void setTimeToResolution(Integer timeToResolution) {
    this.timeToResolution = timeToResolution;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SupportStatus supportStatus = (SupportStatus) o;
    return Objects.equals(this.status, supportStatus.status) &&
        Objects.equals(this.timeToResolution, supportStatus.timeToResolution);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, timeToResolution);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SupportStatus {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    timeToResolution: ").append(toIndentedString(timeToResolution)).append("\n");
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
