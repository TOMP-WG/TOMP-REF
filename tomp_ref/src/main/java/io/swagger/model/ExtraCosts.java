package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.AmountOfMoney;
import io.swagger.model.BankAccount;
import io.swagger.model.JournalCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Costs that the TO is charging the MP; credits are negative. Other amounts should be positive
 */
@Schema(description = "Costs that the TO is charging the MP; credits are negative. Other amounts should be positive")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


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
  private Map<String, Object> meta = null;

  public ExtraCosts category(JournalCategory category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  @Schema(required = true, description = "")
      @NotNull
  
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
   * free text to describe the extra costs. Mandatory in case of 'OTHER', should match Content-Language
   * @return description
   **/
  @Schema(required = true, description = "free text to describe the extra costs. Mandatory in case of 'OTHER', should match Content-Language")
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
  @Schema(description = "e.g. number of litres, number of kilowatthour, etc")
  
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
  @Schema(description = "")
  
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
  @Schema(description = "")
  
    @Valid
    public BankAccount getAccount() {
    return account;
  }

  public void setAccount(BankAccount account) {
    this.account = account;
  }

  public ExtraCosts meta(Map<String, Object> meta) {
    this.meta = meta;
    return this;
  }

  public ExtraCosts putMetaItem(String key, Object metaItem) {
    if (this.meta == null) {
      this.meta = new HashMap<String, Object>();
    }
    this.meta.put(key, metaItem);
    return this;
  }

  /**
   * Arbitrary metadata that a TO can add, like voucher codes
   * @return meta
   **/
  @Schema(description = "Arbitrary metadata that a TO can add, like voucher codes")
  
    public Map<String, Object> getMeta() {
    return meta;
  }

  public void setMeta(Map<String, Object> meta) {
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
