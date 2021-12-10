package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * street address, including number OR PO box number, eventually extended with internal reference like room number, could match Content-Language
 */
@Schema(description = "street address, including number OR PO box number, eventually extended with internal reference like room number, could match Content-Language")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-08T10:19:00.171Z[GMT]")


public class Address   {
  @JsonProperty("streetAddress")
  private String streetAddress = null;

  @JsonProperty("street")
  private String street = null;

  @JsonProperty("houseNumber")
  private Integer houseNumber = null;

  @JsonProperty("houseNumberAddition")
  private String houseNumberAddition = null;

  @JsonProperty("addressAdditionalInfo")
  private String addressAdditionalInfo = null;

  @JsonProperty("areaReference")
  private String areaReference = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("province")
  private String province = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("postalCode")
  private String postalCode = null;

  @JsonProperty("country")
  private String country = null;

  public Address streetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
    return this;
  }

  /**
   * Get streetAddress
   * @return streetAddress
   **/
  @Schema(example = "example street 18, 2nd floor, 18-B33", required = true, description = "")
      @NotNull

    public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public Address street(String street) {
    this.street = street;
    return this;
  }

  /**
   * street, consistent with streetAddress
   * @return street
   **/
  @Schema(description = "street, consistent with streetAddress")
  
    public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Address houseNumber(Integer houseNumber) {
    this.houseNumber = houseNumber;
    return this;
  }

  /**
   * house number, consistent with streetAddress
   * minimum: 0
   * @return houseNumber
   **/
  @Schema(description = "house number, consistent with streetAddress")
  
  @Min(0)  public Integer getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(Integer houseNumber) {
    this.houseNumber = houseNumber;
  }

  public Address houseNumberAddition(String houseNumberAddition) {
    this.houseNumberAddition = houseNumberAddition;
    return this;
  }

  /**
   * the additional part of the house number (f.x. 13bis, where 'bis' is the additional part), consistent with streetAddress
   * @return houseNumberAddition
   **/
  @Schema(description = "the additional part of the house number (f.x. 13bis, where 'bis' is the additional part), consistent with streetAddress")
  
    public String getHouseNumberAddition() {
    return houseNumberAddition;
  }

  public void setHouseNumberAddition(String houseNumberAddition) {
    this.houseNumberAddition = houseNumberAddition;
  }

  public Address addressAdditionalInfo(String addressAdditionalInfo) {
    this.addressAdditionalInfo = addressAdditionalInfo;
    return this;
  }

  /**
   * additional information to find the address (f.x. just around the corner)
   * @return addressAdditionalInfo
   **/
  @Schema(description = "additional information to find the address (f.x. just around the corner)")
  
    public String getAddressAdditionalInfo() {
    return addressAdditionalInfo;
  }

  public void setAddressAdditionalInfo(String addressAdditionalInfo) {
    this.addressAdditionalInfo = addressAdditionalInfo;
  }

  public Address areaReference(String areaReference) {
    this.areaReference = areaReference;
    return this;
  }

  /**
   * city or town, principal subdivision such as province, state or county, could match Content-Language
   * @return areaReference
   **/
  @Schema(example = "Smallcity, Pinetree county", required = true, description = "city or town, principal subdivision such as province, state or county, could match Content-Language")
      @NotNull

    public String getAreaReference() {
    return areaReference;
  }

  public void setAreaReference(String areaReference) {
    this.areaReference = areaReference;
  }

  public Address city(String city) {
    this.city = city;
    return this;
  }

  /**
   * specified city or town, consistent with areaReference
   * @return city
   **/
  @Schema(description = "specified city or town, consistent with areaReference")
  
    public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Address province(String province) {
    this.province = province;
    return this;
  }

  /**
   * province or region, consistent with areaReference
   * @return province
   **/
  @Schema(description = "province or region, consistent with areaReference")
  
    public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public Address state(String state) {
    this.state = state;
    return this;
  }

  /**
   * state, consistent with areaReference
   * @return state
   **/
  @Schema(description = "state, consistent with areaReference")
  
    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Address postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
   **/
  @Schema(description = "")
  
    public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public Address country(String country) {
    this.country = country;
    return this;
  }

  /**
   * two-letter country codes according to ISO 3166-1
   * @return country
   **/
  @Schema(example = "NL", description = "two-letter country codes according to ISO 3166-1")
  
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
    Address address = (Address) o;
    return Objects.equals(this.streetAddress, address.streetAddress) &&
        Objects.equals(this.street, address.street) &&
        Objects.equals(this.houseNumber, address.houseNumber) &&
        Objects.equals(this.houseNumberAddition, address.houseNumberAddition) &&
        Objects.equals(this.addressAdditionalInfo, address.addressAdditionalInfo) &&
        Objects.equals(this.areaReference, address.areaReference) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.province, address.province) &&
        Objects.equals(this.state, address.state) &&
        Objects.equals(this.postalCode, address.postalCode) &&
        Objects.equals(this.country, address.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetAddress, street, houseNumber, houseNumberAddition, addressAdditionalInfo, areaReference, city, province, state, postalCode, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    houseNumber: ").append(toIndentedString(houseNumber)).append("\n");
    sb.append("    houseNumberAddition: ").append(toIndentedString(houseNumberAddition)).append("\n");
    sb.append("    addressAdditionalInfo: ").append(toIndentedString(addressAdditionalInfo)).append("\n");
    sb.append("    areaReference: ").append(toIndentedString(areaReference)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
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
