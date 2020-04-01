package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SysteminformationInformation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
public class SystemInformation   {
  @JsonProperty("information")
  @Valid
  private List<SysteminformationInformation> information = null;

  public SystemInformation information(List<SysteminformationInformation> information) {
    this.information = information;
    return this;
  }

  public SystemInformation addInformationItem(SysteminformationInformation informationItem) {
    if (this.information == null) {
      this.information = new ArrayList<SysteminformationInformation>();
    }
    this.information.add(informationItem);
    return this;
  }

  /**
   * Get information
   * @return information
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<SysteminformationInformation> getInformation() {
    return information;
  }

  public void setInformation(List<SysteminformationInformation> information) {
    this.information = information;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInformation systemInformation = (SystemInformation) o;
    return Objects.equals(this.information, systemInformation.information);
  }

  @Override
  public int hashCode() {
    return Objects.hash(information);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInformation {\n");
    
    sb.append("    information: ").append(toIndentedString(information)).append("\n");
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
