package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Condition;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RequireBookingDataCondition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-03T08:37:12.232Z[GMT]")
public class RequireBookingDataCondition extends Condition implements OneOfcondition {
  /**
   * Gets or Sets requiredFields
   */
  public enum RequiredFieldsEnum {
    FROM_ADDRESS("FROM-ADDRESS"),
    
    TO_ADDRESS("TO-ADDRESS"),
    
    BIRTHDATE("BIRTHDATE"),
    
    EMAIL("EMAIL"),
    
    PERSONAL_ADDRESS("PERSONAL-ADDRESS"),
    
    GENDER("GENDER"),
    
    PHONE_NUMBERS("PHONE-NUMBERS"),
    
    LICENSES("LICENSES"),
    
    BANK_CARDS("BANK-CARDS"),
    
    DISCOUNT_CARDS("DISCOUNT-CARDS"),
    
    TRAVEL_CARDS("TRAVEL-CARDS"),
    
    ID_CARDS("ID-CARDS"),
    
    CREDIT_CARDS("CREDIT-CARDS");

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
  @JsonProperty("required-fields")
  @Valid
  private List<RequiredFieldsEnum> requiredFields = null;

  public RequireBookingDataCondition requiredFields(List<RequiredFieldsEnum> requiredFields) {
    this.requiredFields = requiredFields;
    return this;
  }

  public RequireBookingDataCondition addRequiredFieldsItem(RequiredFieldsEnum requiredFieldsItem) {
    if (this.requiredFields == null) {
      this.requiredFields = new ArrayList<RequiredFieldsEnum>();
    }
    this.requiredFields.add(requiredFieldsItem);
    return this;
  }

  /**
   * Get requiredFields
   * @return requiredFields
  **/
  @ApiModelProperty(value = "")
  
    public List<RequiredFieldsEnum> getRequiredFields() {
    return requiredFields;
  }

  public void setRequiredFields(List<RequiredFieldsEnum> requiredFields) {
    this.requiredFields = requiredFields;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequireBookingDataCondition requireBookingDataCondition = (RequireBookingDataCondition) o;
    return Objects.equals(this.requiredFields, requireBookingDataCondition.requiredFields) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requiredFields, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequireBookingDataCondition {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    requiredFields: ").append(toIndentedString(requiredFields)).append("\n");
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
