package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Fare;
import io.swagger.model.OptionsLeg;
import io.swagger.model.SimpleLeg;
import io.swagger.model.TypeOfAsset;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OperatorLeg
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class OperatorLeg extends SimpleLeg  {
  @JsonProperty("operatorName")
  private String operatorName = null;

  @JsonProperty("operatorMaasId")
  private String operatorMaasId = null;

  @JsonProperty("operatorDescription")
  private String operatorDescription = null;

  @JsonProperty("operatorContact")
  private String operatorContact = null;

  public OperatorLeg operatorName(String operatorName) {
    this.operatorName = operatorName;
    return this;
  }

  /**
   * Get operatorName
   * @return operatorName
  **/
  @ApiModelProperty(value = "")
  
    public String getOperatorName() {
    return operatorName;
  }

  public void setOperatorName(String operatorName) {
    this.operatorName = operatorName;
  }

  public OperatorLeg operatorMaasId(String operatorMaasId) {
    this.operatorMaasId = operatorMaasId;
    return this;
  }

  /**
   * the maasId from the operator
   * @return operatorMaasId
  **/
  @ApiModelProperty(value = "the maasId from the operator")
  
    public String getOperatorMaasId() {
    return operatorMaasId;
  }

  public void setOperatorMaasId(String operatorMaasId) {
    this.operatorMaasId = operatorMaasId;
  }

  public OperatorLeg operatorDescription(String operatorDescription) {
    this.operatorDescription = operatorDescription;
    return this;
  }

  /**
   * short description of the operator
   * @return operatorDescription
  **/
  @ApiModelProperty(value = "short description of the operator")
  
    public String getOperatorDescription() {
    return operatorDescription;
  }

  public void setOperatorDescription(String operatorDescription) {
    this.operatorDescription = operatorDescription;
  }

  public OperatorLeg operatorContact(String operatorContact) {
    this.operatorContact = operatorContact;
    return this;
  }

  /**
   * contact information
   * @return operatorContact
  **/
  @ApiModelProperty(value = "contact information")
  
    public String getOperatorContact() {
    return operatorContact;
  }

  public void setOperatorContact(String operatorContact) {
    this.operatorContact = operatorContact;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperatorLeg operatorLeg = (OperatorLeg) o;
    return Objects.equals(this.operatorName, operatorLeg.operatorName) &&
        Objects.equals(this.operatorMaasId, operatorLeg.operatorMaasId) &&
        Objects.equals(this.operatorDescription, operatorLeg.operatorDescription) &&
        Objects.equals(this.operatorContact, operatorLeg.operatorContact) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operatorName, operatorMaasId, operatorDescription, operatorContact, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperatorLeg {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    operatorName: ").append(toIndentedString(operatorName)).append("\n");
    sb.append("    operatorMaasId: ").append(toIndentedString(operatorMaasId)).append("\n");
    sb.append("    operatorDescription: ").append(toIndentedString(operatorDescription)).append("\n");
    sb.append("    operatorContact: ").append(toIndentedString(operatorContact)).append("\n");
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
