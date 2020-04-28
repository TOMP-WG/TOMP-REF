package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AmountOfMoney
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class AmountOfMoney   {
  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("amountExVat")
  private BigDecimal amountExVat = null;

  @JsonProperty("currencyCode")
  private String currencyCode = null;

  @JsonProperty("vatRate")
  private BigDecimal vatRate = null;

  @JsonProperty("vatCountryCode")
  private String vatCountryCode = null;

  public AmountOfMoney amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT
   * @return amount
  **/
  @ApiModelProperty(example = "9.95", value = "This should be in the base unit as defined by the ISO 4217 currency code with the appropriate number of decimal places and omitting the currency symbol. e.g. if the price is in US Dollars the price would be 9.95. This is inclusive VAT")
  
    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public AmountOfMoney amountExVat(BigDecimal amountExVat) {
    this.amountExVat = amountExVat;
    return this;
  }

  /**
   * Get amountExVat
   * @return amountExVat
  **/
  @ApiModelProperty(example = "8.95", value = "")
  
    @Valid
    public BigDecimal getAmountExVat() {
    return amountExVat;
  }

  public void setAmountExVat(BigDecimal amountExVat) {
    this.amountExVat = amountExVat;
  }

  public AmountOfMoney currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * ISO 4217 currency code
   * @return currencyCode
  **/
  @ApiModelProperty(value = "ISO 4217 currency code")
  
  @Size(min=3,max=3)   public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public AmountOfMoney vatRate(BigDecimal vatRate) {
    this.vatRate = vatRate;
    return this;
  }

  /**
   * value added tax rate (percentage of amount)
   * @return vatRate
  **/
  @ApiModelProperty(example = "21", value = "value added tax rate (percentage of amount)")
  
    @Valid
    public BigDecimal getVatRate() {
    return vatRate;
  }

  public void setVatRate(BigDecimal vatRate) {
    this.vatRate = vatRate;
  }

  public AmountOfMoney vatCountryCode(String vatCountryCode) {
    this.vatCountryCode = vatCountryCode;
    return this;
  }

  /**
   * Get vatCountryCode
   * @return vatCountryCode
  **/
  @ApiModelProperty(value = "")
  
  @Size(min=2,max=2)   public String getVatCountryCode() {
    return vatCountryCode;
  }

  public void setVatCountryCode(String vatCountryCode) {
    this.vatCountryCode = vatCountryCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmountOfMoney amountOfMoney = (AmountOfMoney) o;
    return Objects.equals(this.amount, amountOfMoney.amount) &&
        Objects.equals(this.amountExVat, amountOfMoney.amountExVat) &&
        Objects.equals(this.currencyCode, amountOfMoney.currencyCode) &&
        Objects.equals(this.vatRate, amountOfMoney.vatRate) &&
        Objects.equals(this.vatCountryCode, amountOfMoney.vatCountryCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, amountExVat, currencyCode, vatRate, vatCountryCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmountOfMoney {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    amountExVat: ").append(toIndentedString(amountExVat)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    vatRate: ").append(toIndentedString(vatRate)).append("\n");
    sb.append("    vatCountryCode: ").append(toIndentedString(vatCountryCode)).append("\n");
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
