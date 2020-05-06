package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.MaasEnvironmentType;
import io.swagger.model.MaasOperator;
import io.swagger.model.Polygon;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Body
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-06T06:58:30.612Z[GMT]")
public class Body extends MaasOperator  {
  @JsonProperty("registrationresult")
  private String registrationresult = null;

  public Body registrationresult(String registrationresult) {
    this.registrationresult = registrationresult;
    return this;
  }

  /**
   * Get registrationresult
   * @return registrationresult
  **/
  @ApiModelProperty(value = "")
  
    public String getRegistrationresult() {
    return registrationresult;
  }

  public void setRegistrationresult(String registrationresult) {
    this.registrationresult = registrationresult;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body body = (Body) o;
    return Objects.equals(this.registrationresult, body.registrationresult) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registrationresult, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    registrationresult: ").append(toIndentedString(registrationresult)).append("\n");
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
