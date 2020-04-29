package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.MaasLocation;
import io.swagger.model.Polygon;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MaasOperator
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-29T06:21:59.965Z[GMT]")
public class MaasOperator extends MaasLocation  {
  @JsonProperty("validationToken")
  private String validationToken = null;

  @JsonProperty("servicedArea")
  private Polygon servicedArea = null;

  public MaasOperator validationToken(String validationToken) {
    this.validationToken = validationToken;
    return this;
  }

  /**
   * can be a thumbprint of a certificate
   * @return validationToken
  **/
  @ApiModelProperty(value = "can be a thumbprint of a certificate")
  
    public String getValidationToken() {
    return validationToken;
  }

  public void setValidationToken(String validationToken) {
    this.validationToken = validationToken;
  }

  public MaasOperator servicedArea(Polygon servicedArea) {
    this.servicedArea = servicedArea;
    return this;
  }

  /**
   * Get servicedArea
   * @return servicedArea
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Polygon getServicedArea() {
    return servicedArea;
  }

  public void setServicedArea(Polygon servicedArea) {
    this.servicedArea = servicedArea;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MaasOperator maasOperator = (MaasOperator) o;
    return Objects.equals(this.validationToken, maasOperator.validationToken) &&
        Objects.equals(this.servicedArea, maasOperator.servicedArea) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validationToken, servicedArea, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaasOperator {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    validationToken: ").append(toIndentedString(validationToken)).append("\n");
    sb.append("    servicedArea: ").append(toIndentedString(servicedArea)).append("\n");
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
