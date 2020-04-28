package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Card;
import io.swagger.model.License;
import io.swagger.model.Requirements;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class User   {
  @JsonProperty("validated")
  private Boolean validated = null;

  @JsonProperty("age")
  private BigDecimal age = null;

  @JsonProperty("licenses")
  @Valid
  private List<License> licenses = null;

  @JsonProperty("cards")
  @Valid
  private List<Card> cards = null;

  @JsonProperty("requirements")
  private Requirements requirements = null;

  public User validated(Boolean validated) {
    this.validated = validated;
    return this;
  }

  /**
   * for anonymous usage this property should be false.
   * @return validated
  **/
  @ApiModelProperty(value = "for anonymous usage this property should be false.")
  
    public Boolean isValidated() {
    return validated;
  }

  public void setValidated(Boolean validated) {
    this.validated = validated;
  }

  public User age(BigDecimal age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getAge() {
    return age;
  }

  public void setAge(BigDecimal age) {
    this.age = age;
  }

  public User licenses(List<License> licenses) {
    this.licenses = licenses;
    return this;
  }

  public User addLicensesItem(License licensesItem) {
    if (this.licenses == null) {
      this.licenses = new ArrayList<License>();
    }
    this.licenses.add(licensesItem);
    return this;
  }

  /**
   * Get licenses
   * @return licenses
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<License> getLicenses() {
    return licenses;
  }

  public void setLicenses(List<License> licenses) {
    this.licenses = licenses;
  }

  public User cards(List<Card> cards) {
    this.cards = cards;
    return this;
  }

  public User addCardsItem(Card cardsItem) {
    if (this.cards == null) {
      this.cards = new ArrayList<Card>();
    }
    this.cards.add(cardsItem);
    return this;
  }

  /**
   * Get cards
   * @return cards
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  public User requirements(Requirements requirements) {
    this.requirements = requirements;
    return this;
  }

  /**
   * Get requirements
   * @return requirements
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Requirements getRequirements() {
    return requirements;
  }

  public void setRequirements(Requirements requirements) {
    this.requirements = requirements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.validated, user.validated) &&
        Objects.equals(this.age, user.age) &&
        Objects.equals(this.licenses, user.licenses) &&
        Objects.equals(this.cards, user.cards) &&
        Objects.equals(this.requirements, user.requirements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validated, age, licenses, cards, requirements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    validated: ").append(toIndentedString(validated)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    licenses: ").append(toIndentedString(licenses)).append("\n");
    sb.append("    cards: ").append(toIndentedString(cards)).append("\n");
    sb.append("    requirements: ").append(toIndentedString(requirements)).append("\n");
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
