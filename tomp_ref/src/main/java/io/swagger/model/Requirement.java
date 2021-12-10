package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * describes an (dis)ability or ancillary.
 */
@Schema(description = "describes an (dis)ability or ancillary.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T11:36:21.130Z[GMT]")


public class Requirement   {
  @JsonProperty("source")
  private String source = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("number")
  private String number = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("memo")
  private String memo = null;

  @JsonProperty("variable-number")
  private Integer variableNumber = null;

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

  public Requirement source(String source) {
    this.source = source;
    return this;
  }

  /**
   * if obsolete, it is referencing the travelers' dictionary (https://github.com/TOMP-WG/TOMP-API/blob/master/documents/CROW%20passenger%20characteristics.xlsx)
   * @return source
   **/
  @Schema(description = "if obsolete, it is referencing the travelers' dictionary (https://github.com/TOMP-WG/TOMP-API/blob/master/documents/CROW%20passenger%20characteristics.xlsx)")
  
    public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Requirement category(String category) {
    this.category = category;
    return this;
  }

  /**
   * references to the first column of the specification initial values [ HR, AV, HV, AB, AER, K, ZR, RR ]
   * @return category
   **/
  @Schema(required = true, description = "references to the first column of the specification initial values [ HR, AV, HV, AB, AER, K, ZR, RR ]")
      @NotNull

    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
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

  public Requirement variableNumber(Integer variableNumber) {
    this.variableNumber = variableNumber;
    return this;
  }

  /**
   * in some requirements there is references to '[variable number]' e.g. of meters (like ZR06)
   * minimum: 0
   * @return variableNumber
   **/
  @Schema(description = "in some requirements there is references to '[variable number]' e.g. of meters (like ZR06)")
  
  @Min(0)  public Integer getVariableNumber() {
    return variableNumber;
  }

  public void setVariableNumber(Integer variableNumber) {
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
    return Objects.equals(this.source, requirement.source) &&
        Objects.equals(this.category, requirement.category) &&
        Objects.equals(this.number, requirement.number) &&
        Objects.equals(this.type, requirement.type) &&
        Objects.equals(this.memo, requirement.memo) &&
        Objects.equals(this.variableNumber, requirement.variableNumber) &&
        Objects.equals(this.applicableDays, requirement.applicableDays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, category, number, type, memo, variableNumber, applicableDays);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Requirement {\n");
    
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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
