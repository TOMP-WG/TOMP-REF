package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Requirement
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-26T08:47:05.979Z[GMT]")


public class Requirement   {
  /**
   * references to the first column of the specification
   */
  public enum CategoryEnum {
    HR("HR"),
    
    AV("AV"),
    
    HV("HV"),
    
    AB("AB"),
    
    AER("AER"),
    
    K("K"),
    
    ZR("ZR"),
    
    RR("RR");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String text) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("category")
  private CategoryEnum category = null;

  @JsonProperty("number")
  private String number = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("memo")
  private String memo = null;

  @JsonProperty("variable-number")
  private BigDecimal variableNumber = null;

  /**
   * Gets or Sets applicableDays
   */
  public enum ApplicableDaysEnum {
    MO("MO"),
    
    TU("TU"),
    
    WE("WE"),
    
    TH("TH"),
    
    FR("FR"),
    
    SA("SA"),
    
    SU("SU");

    private String value;

    ApplicableDaysEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ApplicableDaysEnum fromValue(String text) {
      for (ApplicableDaysEnum b : ApplicableDaysEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("applicable-days")
  @Valid
  private List<ApplicableDaysEnum> applicableDays = null;

  public Requirement category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * references to the first column of the specification
   * @return category
   **/
  @Schema(required = true, description = "references to the first column of the specification")
      @NotNull

    public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  public Requirement number(String number) {
    this.number = number;
    return this;
  }

  /**
   * references to the second column of the specification
   * @return number
   **/
  @Schema(required = true, description = "references to the second column of the specification")
      @NotNull

  @Size(min=2,max=2)   public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Requirement type(String type) {
    this.type = type;
    return this;
  }

  /**
   * conditionally extra information, referencing to the 3th column
   * @return type
   **/
  @Schema(description = "conditionally extra information, referencing to the 3th column")
  
    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Requirement memo(String memo) {
    this.memo = memo;
    return this;
  }

  /**
   * extra field for detailed information, not standardized
   * @return memo
   **/
  @Schema(description = "extra field for detailed information, not standardized")
  
    public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Requirement variableNumber(BigDecimal variableNumber) {
    this.variableNumber = variableNumber;
    return this;
  }

  /**
   * in some requirements there is references to '[variable number]' e.g. of meters (like ZR06)
   * @return variableNumber
   **/
  @Schema(description = "in some requirements there is references to '[variable number]' e.g. of meters (like ZR06)")
  
    @Valid
    public BigDecimal getVariableNumber() {
    return variableNumber;
  }

  public void setVariableNumber(BigDecimal variableNumber) {
    this.variableNumber = variableNumber;
  }

  public Requirement applicableDays(List<ApplicableDaysEnum> applicableDays) {
    this.applicableDays = applicableDays;
    return this;
  }

  public Requirement addApplicableDaysItem(ApplicableDaysEnum applicableDaysItem) {
    if (this.applicableDays == null) {
      this.applicableDays = new ArrayList<ApplicableDaysEnum>();
    }
    this.applicableDays.add(applicableDaysItem);
    return this;
  }

  /**
   * days of week that are applicable
   * @return applicableDays
   **/
  @Schema(description = "days of week that are applicable")
  
    public List<ApplicableDaysEnum> getApplicableDays() {
    return applicableDays;
  }

  public void setApplicableDays(List<ApplicableDaysEnum> applicableDays) {
    this.applicableDays = applicableDays;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Requirement requirement = (Requirement) o;
    return Objects.equals(this.category, requirement.category) &&
        Objects.equals(this.number, requirement.number) &&
        Objects.equals(this.type, requirement.type) &&
        Objects.equals(this.memo, requirement.memo) &&
        Objects.equals(this.variableNumber, requirement.variableNumber) &&
        Objects.equals(this.applicableDays, requirement.applicableDays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, number, type, memo, variableNumber, applicableDays);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Requirement {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    variableNumber: ").append(toIndentedString(variableNumber)).append("\n");
    sb.append("    applicableDays: ").append(toIndentedString(applicableDays)).append("\n");
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
