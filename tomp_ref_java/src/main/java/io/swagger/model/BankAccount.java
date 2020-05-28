package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BankAccount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class BankAccount   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("number")
  private String number = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("bankIdentification")
  private String bankIdentification = null;

  public BankAccount name(String name) {
    this.name = name;
    return this;
  }

  /**
   * account name
   * @return name
  **/
  @ApiModelProperty(value = "account name")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankAccount number(String number) {
    this.number = number;
    return this;
  }

  /**
   * account number
   * @return number
  **/
  @ApiModelProperty(value = "account number")
  
    public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public BankAccount country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(value = "")
  
  @Size(min=2,max=2)   public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public BankAccount bankIdentification(String bankIdentification) {
    this.bankIdentification = bankIdentification;
    return this;
  }

  /**
   * bank identification, like BIC code
   * @return bankIdentification
  **/
  @ApiModelProperty(value = "bank identification, like BIC code")
  
    public String getBankIdentification() {
    return bankIdentification;
  }

  public void setBankIdentification(String bankIdentification) {
    this.bankIdentification = bankIdentification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankAccount bankAccount = (BankAccount) o;
    return Objects.equals(this.name, bankAccount.name) &&
        Objects.equals(this.number, bankAccount.number) &&
        Objects.equals(this.country, bankAccount.country) &&
        Objects.equals(this.bankIdentification, bankAccount.bankIdentification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, number, country, bankIdentification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankAccount {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    bankIdentification: ").append(toIndentedString(bankIdentification)).append("\n");
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
