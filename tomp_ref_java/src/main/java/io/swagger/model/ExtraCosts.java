package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AmountOfMoney;
import io.swagger.model.BankAccount;
import io.swagger.model.JournalCategory;
import io.swagger.model.KeyValue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Costs that the TO is charging the MP; credits are negative
 */
@ApiModel(description = "Costs that the TO is charging the MP; credits are negative")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class ExtraCosts extends AmountOfMoney  {
  @JsonProperty("category")
  private JournalCategory category = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("number")
  private BigDecimal number = null;

  /**
   * Gets or Sets numberType
   */
  public enum NumberTypeEnum {
    LITER("LITER"),
    
    KILOWATTHOUR("KILOWATTHOUR"),
    
    CO2_COMPENSATION("CO2_COMPENSATION"),
    
    OTHER("OTHER");

    private String value;

    NumberTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NumberTypeEnum fromValue(String text) {
      for (NumberTypeEnum b : NumberTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("numberType")
  private NumberTypeEnum numberType = null;

  @JsonProperty("account")
  private BankAccount account = null;

  @JsonProperty("meta")
  @Valid
  private List<KeyValue> meta = null;

  public ExtraCosts category(JournalCategory category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public JournalCategory getCategory() {
    return category;
  }

  public void setCategory(JournalCategory category) {
    this.category = category;
  }

  public ExtraCosts description(String description) {
    this.description = description;
    return this;
  }

  /**
   * free text to describe the extra costs. Mandatory in case of 'OTHER'
   * @return description
  **/
  @ApiModelProperty(required = true, value = "free text to describe the extra costs. Mandatory in case of 'OTHER'")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ExtraCosts number(BigDecimal number) {
    this.number = number;
    return this;
  }

  /**
   * e.g. number of litres, number of kilowatthour, etc
   * @return number
  **/
  @ApiModelProperty(value = "e.g. number of litres, number of kilowatthour, etc")
  
    @Valid
    public BigDecimal getNumber() {
    return number;
  }

  public void setNumber(BigDecimal number) {
    this.number = number;
  }

  public ExtraCosts numberType(NumberTypeEnum numberType) {
    this.numberType = numberType;
    return this;
  }

  /**
   * Get numberType
   * @return numberType
  **/
  @ApiModelProperty(value = "")
  
    public NumberTypeEnum getNumberType() {
    return numberType;
  }

  public void setNumberType(NumberTypeEnum numberType) {
    this.numberType = numberType;
  }

  public ExtraCosts account(BankAccount account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   * @return account
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BankAccount getAccount() {
    return account;
  }

  public void setAccount(BankAccount account) {
    this.account = account;
  }

  public ExtraCosts meta(List<KeyValue> meta) {
    this.meta = meta;
    return this;
  }

  public ExtraCosts addMetaItem(KeyValue metaItem) {
    if (this.meta == null) {
      this.meta = new ArrayList<KeyValue>();
    }
    this.meta.add(metaItem);
    return this;
  }

  /**
   * Arbitrary metadata that a TO can add, like voucher codes
   * @return meta
  **/
  @ApiModelProperty(value = "Arbitrary metadata that a TO can add, like voucher codes")
      @Valid
    public List<KeyValue> getMeta() {
    return meta;
  }

  public void setMeta(List<KeyValue> meta) {
    this.meta = meta;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtraCosts extraCosts = (ExtraCosts) o;
    return Objects.equals(this.category, extraCosts.category) &&
        Objects.equals(this.description, extraCosts.description) &&
        Objects.equals(this.number, extraCosts.number) &&
        Objects.equals(this.numberType, extraCosts.numberType) &&
        Objects.equals(this.account, extraCosts.account) &&
        Objects.equals(this.meta, extraCosts.meta) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, description, number, numberType, account, meta, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtraCosts {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    numberType: ").append(toIndentedString(numberType)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
