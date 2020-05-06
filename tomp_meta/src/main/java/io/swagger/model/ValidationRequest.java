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
 * ValidationRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-06T06:58:30.612Z[GMT]")
public class ValidationRequest   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("validationToken")
  private String validationToken = null;

  @JsonProperty("registrationResultUrl")
  private String registrationResultUrl = null;

  public ValidationRequest id(String id) {
    this.id = id;
    return this;
  }

  /**
   * the maasId to validate
   * @return id
  **/
  @ApiModelProperty(value = "the maasId to validate")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ValidationRequest validationToken(String validationToken) {
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

  public ValidationRequest registrationResultUrl(String registrationResultUrl) {
    this.registrationResultUrl = registrationResultUrl;
    return this;
  }

  /**
   * webhook url to post results to
   * @return registrationResultUrl
  **/
  @ApiModelProperty(value = "webhook url to post results to")
  
    public String getRegistrationResultUrl() {
    return registrationResultUrl;
  }

  public void setRegistrationResultUrl(String registrationResultUrl) {
    this.registrationResultUrl = registrationResultUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidationRequest validationRequest = (ValidationRequest) o;
    return Objects.equals(this.id, validationRequest.id) &&
        Objects.equals(this.validationToken, validationRequest.validationToken) &&
        Objects.equals(this.registrationResultUrl, validationRequest.registrationResultUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, validationToken, registrationResultUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    validationToken: ").append(toIndentedString(validationToken)).append("\n");
    sb.append("    registrationResultUrl: ").append(toIndentedString(registrationResultUrl)).append("\n");
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
