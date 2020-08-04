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
 * The operator of a leg or asset, in case this is not the TO itself but should be shown to the user
 */
@ApiModel(description = "The operator of a leg or asset, in case this is not the TO itself but should be shown to the user")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T14:20:13.675Z[GMT]")


public class Suboperator   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("maasId")
  private String maasId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("contact")
  private String contact = null;

  public Suboperator name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the operator, could match Content-Language
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the operator, could match Content-Language")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Suboperator maasId(String maasId) {
    this.maasId = maasId;
    return this;
  }

  /**
   * the maasId from the operator
   * @return maasId
  **/
  @ApiModelProperty(value = "the maasId from the operator")
  
    public String getMaasId() {
    return maasId;
  }

  public void setMaasId(String maasId) {
    this.maasId = maasId;
  }

  public Suboperator description(String description) {
    this.description = description;
    return this;
  }

  /**
   * short description of the operator, should match Content-Language
   * @return description
  **/
  @ApiModelProperty(value = "short description of the operator, should match Content-Language")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Suboperator contact(String contact) {
    this.contact = contact;
    return this;
  }

  /**
   * contact information, should match Content-Language
   * @return contact
  **/
  @ApiModelProperty(value = "contact information, should match Content-Language")
  
    public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Suboperator suboperator = (Suboperator) o;
    return Objects.equals(this.name, suboperator.name) &&
        Objects.equals(this.maasId, suboperator.maasId) &&
        Objects.equals(this.description, suboperator.description) &&
        Objects.equals(this.contact, suboperator.contact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, maasId, description, contact);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Suboperator {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    maasId: ").append(toIndentedString(maasId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
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
