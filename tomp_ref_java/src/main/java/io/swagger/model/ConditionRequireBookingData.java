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
 * ConditionRequireBookingData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T15:19:29.217Z[GMT]")
public class ConditionRequireBookingData extends Condition implements OneOfcondition {
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
    
    CREDIT_CARDS("CREDIT_CARDS");

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
  @ApiModelProperty(required = true, value = "")
      @NotNull

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
    ConditionRequireBookingData conditionRequireBookingData = (ConditionRequireBookingData) o;
    return Objects.equals(this.requiredFields, conditionRequireBookingData.requiredFields) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requiredFields, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConditionRequireBookingData {\n");
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
