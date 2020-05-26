package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Endpoint;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RegistrationResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-26T11:47:26.599Z[GMT]")
public class RegistrationResult   {
  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    ACCEPTED("ACCEPTED"),
    
    REJECTED("REJECTED");

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

  @JsonProperty("maasId")
  private String maasId = null;

  @JsonProperty("country")
  private Endpoint country = null;

  @JsonProperty("reason")
  private String reason = null;

  public RegistrationResult status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public RegistrationResult maasId(String maasId) {
    this.maasId = maasId;
    return this;
  }

  /**
   * the maas ID for the operator
   * @return maasId
  **/
  @ApiModelProperty(value = "the maas ID for the operator")
  
    public String getMaasId() {
    return maasId;
  }

  public void setMaasId(String maasId) {
    this.maasId = maasId;
  }

  public RegistrationResult country(Endpoint country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Endpoint getCountry() {
    return country;
  }

  public void setCountry(Endpoint country) {
    this.country = country;
  }

  public RegistrationResult reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Get reason
   * @return reason
  **/
  @ApiModelProperty(value = "")
  
    public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationResult registrationResult = (RegistrationResult) o;
    return Objects.equals(this.status, registrationResult.status) &&
        Objects.equals(this.maasId, registrationResult.maasId) &&
        Objects.equals(this.country, registrationResult.country) &&
        Objects.equals(this.reason, registrationResult.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, maasId, country, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrationResult {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    maasId: ").append(toIndentedString(maasId)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
