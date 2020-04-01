package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Condition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "conditionType", visible = true )
@JsonSubTypes({
        @JsonSubTypes.Type(value = DepositCondition.class, name = "deposit-condition"),
        @JsonSubTypes.Type(value = PostponedCommitCondition.class, name = "postponed-commit-condition"),
        @JsonSubTypes.Type(value = PayWhenFinishedCondition.class, name = "pay-when-finished-condition"),
        @JsonSubTypes.Type(value = UpfrontPaymentCondition.class, name = "upfront-payment-condition"),
        @JsonSubTypes.Type(value = RequireBookingDataCondition.class, name = "require-booking-data-condition"),
        @JsonSubTypes.Type(value = ReturnAreaCondition.class, name = "return-area-condition"),
})
public class Condition  implements OneOfcondition {
  @JsonProperty("name")
  private String name = null;

  /**
   * Gets or Sets conditionType
   */
  public enum ConditionTypeEnum {
    POSTPONED_COMMIT("POSTPONED-COMMIT"),
    
    DEPOSIT("DEPOSIT"),
    
    UPFRONT_PAYMENT("UPFRONT-PAYMENT"),
    
    PAY_WHEN_FINISHED("PAY-WHEN-FINISHED"),
    
    RETURN_AREA("RETURN-AREA"),
    
    REQUIRE_BOOKING_DATA("REQUIRE-BOOKING-DATA");

    private String value;

    ConditionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ConditionTypeEnum fromValue(String text) {
      for (ConditionTypeEnum b : ConditionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonTypeId
  private ConditionTypeEnum conditionType = null;

  public Condition name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Condition conditionType(ConditionTypeEnum conditionType) {
    this.conditionType = conditionType;
    return this;
  }

  /**
   * Get conditionType
   * @return conditionType
  **/
  @ApiModelProperty(value = "")
  
    public ConditionTypeEnum getConditionType() {
    return conditionType;
  }

  public void setConditionType(ConditionTypeEnum conditionType) {
    this.conditionType = conditionType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Condition condition = (Condition) o;
    return Objects.equals(this.name, condition.name) &&
        Objects.equals(this.conditionType, condition.conditionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, conditionType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Condition {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    conditionType: ").append(toIndentedString(conditionType)).append("\n");
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
