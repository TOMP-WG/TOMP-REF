package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Condition;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConditionRequireBookingData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T07:58:28.459Z[GMT]")


public class ConditionRequireBookingData extends Condition implements OneOfassetTypeConditionsItems, OneOflegConditionsItems {
  /**
   * Gets or Sets requiredFields
   */
  public enum RequiredFieldsEnum {
    FROM_ADDRESS("FROM_ADDRESS"),
    
    TO_ADDRESS("TO_ADDRESS"),
    
    BIRTHDATE("BIRTHDATE"),
    
    EMAIL("EMAIL"),
    
    PERSONAL_ADDRESS("PERSONAL_ADDRESS"),
    
    PHONE_NUMBERS("PHONE_NUMBERS"),
    
    LICENSES("LICENSES"),
    
    BANK_CARDS("BANK_CARDS"),
    
    DISCOUNT_CARDS("DISCOUNT_CARDS"),
    
    TRAVEL_CARDS("TRAVEL_CARDS"),
    
    ID_CARDS("ID_CARDS"),
    
    CREDIT_CARDS("CREDIT_CARDS"),
    
    NAME("NAME"),
    
    AGE("AGE"),
    
    BLOCKCHAIN_CLAIMS("BLOCKCHAIN_CLAIMS");

    private String value;

    RequiredFieldsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RequiredFieldsEnum fromValue(String text) {
      for (RequiredFieldsEnum b : RequiredFieldsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("requiredFields")
  @Valid
  private List<RequiredFieldsEnum> requiredFields = new ArrayList<RequiredFieldsEnum>();

  @JsonProperty("claims")
  @Valid
  private List<String> claims = null;

  public ConditionRequireBookingData requiredFields(List<RequiredFieldsEnum> requiredFields) {
    this.requiredFields = requiredFields;
    return this;
  }

  public ConditionRequireBookingData addRequiredFieldsItem(RequiredFieldsEnum requiredFieldsItem) {
    this.requiredFields.add(requiredFieldsItem);
    return this;
  }

  /**
   * Get requiredFields
   * @return requiredFields
   **/
  @Schema(required = true, description = "")
      @NotNull

    public List<RequiredFieldsEnum> getRequiredFields() {
    return requiredFields;
  }

  public void setRequiredFields(List<RequiredFieldsEnum> requiredFields) {
    this.requiredFields = requiredFields;
  }

  public ConditionRequireBookingData claims(List<String> claims) {
    this.claims = claims;
    return this;
  }

  public ConditionRequireBookingData addClaimsItem(String claimsItem) {
    if (this.claims == null) {
      this.claims = new ArrayList<String>();
    }
    this.claims.add(claimsItem);
    return this;
  }

  /**
   * when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. On the WIKI page, the known ones are enlisted, but this list isn't finalized yet. https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials
   * @return claims
   **/
  @Schema(description = "when in the 'requiredFields' array 'BLOCKCHAIN_CLAIMS' is specified, in this array claims can be specified. On the WIKI page, the known ones are enlisted, but this list isn't finalized yet. https://github.com/TOMP-WG/TOMP-API/wiki/Blockchain---Verifiable-credentials")
  
    public List<String> getClaims() {
    return claims;
  }

  public void setClaims(List<String> claims) {
    this.claims = claims;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConditionRequireBookingData conditionRequireBookingData = (ConditionRequireBookingData) o;
    return Objects.equals(this.requiredFields, conditionRequireBookingData.requiredFields) &&
        Objects.equals(this.claims, conditionRequireBookingData.claims) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requiredFields, claims, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConditionRequireBookingData {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    requiredFields: ").append(toIndentedString(requiredFields)).append("\n");
    sb.append("    claims: ").append(toIndentedString(claims)).append("\n");
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
