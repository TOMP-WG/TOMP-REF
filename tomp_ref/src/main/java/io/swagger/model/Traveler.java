package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.CardType;
import io.swagger.model.LicenseType;
import io.swagger.model.Requirements;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A generic description of a traveler, not including any identifying information
 */
@ApiModel(description = "A generic description of a traveler, not including any identifying information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T14:20:13.675Z[GMT]")


public class Traveler   {
  @JsonProperty("isValidated")
  private Boolean isValidated = null;

  @JsonProperty("age")
  private Integer age = null;

  @JsonProperty("cardTypes")
  @Valid
  private List<CardType> cardTypes = null;

  @JsonProperty("licenseTypes")
  @Valid
  private List<LicenseType> licenseTypes = null;

  @JsonProperty("requirements")
  private Requirements requirements = null;

  public Traveler isValidated(Boolean isValidated) {
    this.isValidated = isValidated;
    return this;
  }

  /**
   * Whether this traveler's identity and properties have been verified by the MaaS provider
   * @return isValidated
  **/
  @ApiModelProperty(value = "Whether this traveler's identity and properties have been verified by the MaaS provider")
  
    public Boolean isIsValidated() {
    return isValidated;
  }

  public void setIsValidated(Boolean isValidated) {
    this.isValidated = isValidated;
  }

  public Traveler age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Age of the traveler, may be approximate
   * @return age
  **/
  @ApiModelProperty(value = "Age of the traveler, may be approximate")
  
    public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Traveler cardTypes(List<CardType> cardTypes) {
    this.cardTypes = cardTypes;
    return this;
  }

  public Traveler addCardTypesItem(CardType cardTypesItem) {
    if (this.cardTypes == null) {
      this.cardTypes = new ArrayList<CardType>();
    }
    this.cardTypes.add(cardTypesItem);
    return this;
  }

  /**
   * The kind of cards this traveler possesses
   * @return cardTypes
  **/
  @ApiModelProperty(value = "The kind of cards this traveler possesses")
      @Valid
    public List<CardType> getCardTypes() {
    return cardTypes;
  }

  public void setCardTypes(List<CardType> cardTypes) {
    this.cardTypes = cardTypes;
  }

  public Traveler licenseTypes(List<LicenseType> licenseTypes) {
    this.licenseTypes = licenseTypes;
    return this;
  }

  public Traveler addLicenseTypesItem(LicenseType licenseTypesItem) {
    if (this.licenseTypes == null) {
      this.licenseTypes = new ArrayList<LicenseType>();
    }
    this.licenseTypes.add(licenseTypesItem);
    return this;
  }

  /**
   * The kind of licenses this traveler possesses
   * @return licenseTypes
  **/
  @ApiModelProperty(value = "The kind of licenses this traveler possesses")
      @Valid
    public List<LicenseType> getLicenseTypes() {
    return licenseTypes;
  }

  public void setLicenseTypes(List<LicenseType> licenseTypes) {
    this.licenseTypes = licenseTypes;
  }

  public Traveler requirements(Requirements requirements) {
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
    Traveler traveler = (Traveler) o;
    return Objects.equals(this.isValidated, traveler.isValidated) &&
        Objects.equals(this.age, traveler.age) &&
        Objects.equals(this.cardTypes, traveler.cardTypes) &&
        Objects.equals(this.licenseTypes, traveler.licenseTypes) &&
        Objects.equals(this.requirements, traveler.requirements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isValidated, age, cardTypes, licenseTypes, requirements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Traveler {\n");
    
    sb.append("    isValidated: ").append(toIndentedString(isValidated)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    cardTypes: ").append(toIndentedString(cardTypes)).append("\n");
    sb.append("    licenseTypes: ").append(toIndentedString(licenseTypes)).append("\n");
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
