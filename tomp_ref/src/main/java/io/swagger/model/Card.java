package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AssetClass;
import io.swagger.model.CardType;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Any kind of card that isn&#x27;t a license, only provide the cards that are required
 */
@ApiModel(description = "Any kind of card that isn't a license, only provide the cards that are required")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T14:20:13.675Z[GMT]")


public class Card extends CardType  {
  @JsonProperty("cardDescription")
  private String cardDescription = null;

  @JsonProperty("cardNumber")
  private String cardNumber = null;

  @JsonProperty("cardAdditionalNumber")
  private String cardAdditionalNumber = null;

  @JsonProperty("validUntil")
  private LocalDate validUntil = null;

  @JsonProperty("country")
  private String country = null;

  public Card cardDescription(String cardDescription) {
    this.cardDescription = cardDescription;
    return this;
  }

  /**
   * description of the card
   * @return cardDescription
  **/
  @ApiModelProperty(value = "description of the card")
  
    public String getCardDescription() {
    return cardDescription;
  }

  public void setCardDescription(String cardDescription) {
    this.cardDescription = cardDescription;
  }

  public Card cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  /**
   * number of the card, like ID number, credit card or bank account number
   * @return cardNumber
  **/
  @ApiModelProperty(required = true, value = "number of the card, like ID number, credit card or bank account number")
      @NotNull

    public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public Card cardAdditionalNumber(String cardAdditionalNumber) {
    this.cardAdditionalNumber = cardAdditionalNumber;
    return this;
  }

  /**
   * additional number, like CVC code or IBAN code
   * @return cardAdditionalNumber
  **/
  @ApiModelProperty(value = "additional number, like CVC code or IBAN code")
  
    public String getCardAdditionalNumber() {
    return cardAdditionalNumber;
  }

  public void setCardAdditionalNumber(String cardAdditionalNumber) {
    this.cardAdditionalNumber = cardAdditionalNumber;
  }

  public Card validUntil(LocalDate validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * Get validUntil
   * @return validUntil
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public LocalDate getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(LocalDate validUntil) {
    this.validUntil = validUntil;
  }

  public Card country(String country) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(this.cardDescription, card.cardDescription) &&
        Objects.equals(this.cardNumber, card.cardNumber) &&
        Objects.equals(this.cardAdditionalNumber, card.cardAdditionalNumber) &&
        Objects.equals(this.validUntil, card.validUntil) &&
        Objects.equals(this.country, card.country) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardDescription, cardNumber, cardAdditionalNumber, validUntil, country, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    cardDescription: ").append(toIndentedString(cardDescription)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    cardAdditionalNumber: ").append(toIndentedString(cardAdditionalNumber)).append("\n");
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
