package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * To identify the operator
 */
@ApiModel(description = "To identify the operator")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-30T06:13:22.966Z[GMT]")


public class ChamberOfCommerceInfo   {
  @JsonProperty("number")
  private String number = null;

  @JsonProperty("place")
  private String place = null;

  public ChamberOfCommerceInfo number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  **/
  @ApiModelProperty(value = "")
  
    public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ChamberOfCommerceInfo place(String place) {
    this.place = place;
    return this;
  }

  /**
   * Get place
   * @return place
  **/
  @ApiModelProperty(value = "")
  
    public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChamberOfCommerceInfo chamberOfCommerceInfo = (ChamberOfCommerceInfo) o;
    return Objects.equals(this.number, chamberOfCommerceInfo.number) &&
        Objects.equals(this.place, chamberOfCommerceInfo.place);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, place);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChamberOfCommerceInfo {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
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
