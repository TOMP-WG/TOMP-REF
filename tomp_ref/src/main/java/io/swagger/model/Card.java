package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AssetClass;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * card object. Only provide the cards that are requested. The asset type property is only allowed for the DISCOUNT card in combination with certain card-acceptors.
 */
@ApiModel(description = "card object. Only provide the cards that are requested. The asset type property is only allowed for the DISCOUNT card in combination with certain card-acceptors.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class Card   {
  /**
   * Gets or Sets cardType
   */
  public enum CardTypeEnum {
    ID("ID"),
    
    DISCOUNT("DISCOUNT"),
    
    TRAVEL("TRAVEL"),
    
    BANK("BANK"),
    
    CREDIT("CREDIT"),
    
    PASSPORT("PASSPORT"),
    
    OTHER("OTHER");

    private String value;

    CardTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CardTypeEnum fromValue(String text) {
      for (CardTypeEnum b : CardTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("cardType")
  private CardTypeEnum cardType = null;

  @JsonProperty("cardSubType")
  private String cardSubType = null;

  @JsonProperty("cardDescription")
  private String cardDescription = null;

  @JsonProperty("cardAcceptors")
  @Valid
  private List<String> cardAcceptors = null;

  @JsonProperty("cardNumber")
  private String cardNumber = null;

  @JsonProperty("cardAdditionalNumber")
  private String cardAdditionalNumber = null;

  @JsonProperty("validUntil")
  private LocalDate validUntil = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("assetClass")
  private AssetClass assetClass = null;

  public Card cardType(CardTypeEnum cardType) {
    this.cardType = cardType;
    return this;
  }

  /**
   * Get cardType
   * @return cardType
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public CardTypeEnum getCardType() {
    return cardType;
  }

  public void setCardType(CardTypeEnum cardType) {
    this.cardType = cardType;
  }

  public Card cardSubType(String cardSubType) {
    this.cardSubType = cardSubType;
    return this;
  }

  /**
   * mandatory in case of OTHER. Can be used in bilateral agreements.
   * @return cardSubType
  **/
  @ApiModelProperty(value = "mandatory in case of OTHER. Can be used in bilateral agreements.")
  
    public String getCardSubType() {
    return cardSubType;
  }

  public void setCardSubType(String cardSubType) {
    this.cardSubType = cardSubType;
  }

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

  public Card cardAcceptors(List<String> cardAcceptors) {
    this.cardAcceptors = cardAcceptors;
    return this;
  }

  public Card addCardAcceptorsItem(String cardAcceptorsItem) {
    if (this.cardAcceptors == null) {
      this.cardAcceptors = new ArrayList<String>();
    }
    this.cardAcceptors.add(cardAcceptorsItem);
    return this;
  }

  /**
   * references to maas-ids of accepting parties. Only if applicable (DISCOUNT).
   * @return cardAcceptors
  **/
  @ApiModelProperty(value = "references to maas-ids of accepting parties. Only if applicable (DISCOUNT).")
  
    public List<String> getCardAcceptors() {
    return cardAcceptors;
  }

  public void setCardAcceptors(List<String> cardAcceptors) {
    this.cardAcceptors = cardAcceptors;
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

  public Card assetClass(AssetClass assetClass) {
    this.assetClass = assetClass;
    return this;
  }

  /**
   * Get assetClass
   * @return assetClass
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public AssetClass getAssetClass() {
    return assetClass;
  }

  public void setAssetClass(AssetClass assetClass) {
    this.assetClass = assetClass;
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
    return Objects.equals(this.cardType, card.cardType) &&
        Objects.equals(this.cardSubType, card.cardSubType) &&
        Objects.equals(this.cardDescription, card.cardDescription) &&
        Objects.equals(this.cardAcceptors, card.cardAcceptors) &&
        Objects.equals(this.cardNumber, card.cardNumber) &&
        Objects.equals(this.cardAdditionalNumber, card.cardAdditionalNumber) &&
        Objects.equals(this.validUntil, card.validUntil) &&
        Objects.equals(this.country, card.country) &&
        Objects.equals(this.assetClass, card.assetClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardType, cardSubType, cardDescription, cardAcceptors, cardNumber, cardAdditionalNumber, validUntil, country, assetClass);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");
    
    sb.append("    cardType: ").append(toIndentedString(cardType)).append("\n");
    sb.append("    cardSubType: ").append(toIndentedString(cardSubType)).append("\n");
    sb.append("    cardDescription: ").append(toIndentedString(cardDescription)).append("\n");
    sb.append("    cardAcceptors: ").append(toIndentedString(cardAcceptors)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    cardAdditionalNumber: ").append(toIndentedString(cardAdditionalNumber)).append("\n");
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    assetClass: ").append(toIndentedString(assetClass)).append("\n");
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
