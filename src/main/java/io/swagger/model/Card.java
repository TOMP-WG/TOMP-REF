package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AssetClass;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Card
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
public class Card   {
  @JsonProperty("card-type")
  private String cardType = null;

  @JsonProperty("card-acceptors")
  @Valid
  private List<String> cardAcceptors = null;

  @JsonProperty("card-number")
  private String cardNumber = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("asset-type")
  private AssetClass assetType = null;

  public Card cardType(String cardType) {
    this.cardType = cardType;
    return this;
  }

  /**
   * Get cardType
   * @return cardType
  **/
  @ApiModelProperty(value = "")
  
    public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
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
   * references to maas-ids of accepting parties
   * @return cardAcceptors
  **/
  @ApiModelProperty(value = "references to maas-ids of accepting parties")
  
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
   * Get cardNumber
   * @return cardNumber
  **/
  @ApiModelProperty(value = "")
  
    public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
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

  public Card assetType(AssetClass assetType) {
    this.assetType = assetType;
    return this;
  }

  /**
   * Get assetType
   * @return assetType
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public AssetClass getAssetType() {
    return assetType;
  }

  public void setAssetType(AssetClass assetType) {
    this.assetType = assetType;
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
        Objects.equals(this.cardAcceptors, card.cardAcceptors) &&
        Objects.equals(this.cardNumber, card.cardNumber) &&
        Objects.equals(this.country, card.country) &&
        Objects.equals(this.assetType, card.assetType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardType, cardAcceptors, cardNumber, country, assetType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");
    
    sb.append("    cardType: ").append(toIndentedString(cardType)).append("\n");
    sb.append("    cardAcceptors: ").append(toIndentedString(cardAcceptors)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
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
