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
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A generic description of a card, asset class and acceptors is only allowed for DISCOUNT/TRAVEL/OTHER cards
 */
@ApiModel(description = "A generic description of a card, asset class and acceptors is only allowed for DISCOUNT/TRAVEL/OTHER cards")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T14:20:13.675Z[GMT]")


public class CardType   {
  /**
   * The broad category of card
   */
  public enum TypeEnum {
    ID("ID"),
    
    DISCOUNT("DISCOUNT"),
    
    TRAVEL("TRAVEL"),
    
    BANK("BANK"),
    
    CREDIT("CREDIT"),
    
    PASSPORT("PASSPORT"),
    
    OTHER("OTHER");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("subType")
  private String subType = null;

  @JsonProperty("assetClass")
  private AssetClass assetClass = null;

  @JsonProperty("acceptors")
  @Valid
  private List<String> acceptors = null;

  public CardType type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The broad category of card
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The broad category of card")
      @NotNull

    public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public CardType subType(String subType) {
    this.subType = subType;
    return this;
  }

  /**
   * For use in case of OTHER. Can be used in bilateral agreements.
   * @return subType
  **/
  @ApiModelProperty(value = "For use in case of OTHER. Can be used in bilateral agreements.")
  
    public String getSubType() {
    return subType;
  }

  public void setSubType(String subType) {
    this.subType = subType;
  }

  public CardType assetClass(AssetClass assetClass) {
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

  public CardType acceptors(List<String> acceptors) {
    this.acceptors = acceptors;
    return this;
  }

  public CardType addAcceptorsItem(String acceptorsItem) {
    if (this.acceptors == null) {
      this.acceptors = new ArrayList<String>();
    }
    this.acceptors.add(acceptorsItem);
    return this;
  }

  /**
   * references to accepting parties, only if applicable
   * @return acceptors
  **/
  @ApiModelProperty(value = "references to accepting parties, only if applicable")
  
    public List<String> getAcceptors() {
    return acceptors;
  }

  public void setAcceptors(List<String> acceptors) {
    this.acceptors = acceptors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardType cardType = (CardType) o;
    return Objects.equals(this.type, cardType.type) &&
        Objects.equals(this.subType, cardType.subType) &&
        Objects.equals(this.assetClass, cardType.assetClass) &&
        Objects.equals(this.acceptors, cardType.acceptors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, subType, assetClass, acceptors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardType {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    subType: ").append(toIndentedString(subType)).append("\n");
    sb.append("    assetClass: ").append(toIndentedString(assetClass)).append("\n");
    sb.append("    acceptors: ").append(toIndentedString(acceptors)).append("\n");
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
