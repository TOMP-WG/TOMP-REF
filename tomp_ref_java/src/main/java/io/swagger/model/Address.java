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
 * Address
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class Address   {
  @JsonProperty("streetAddress")
  private String streetAddress = null;

  @JsonProperty("areaReference")
  private String areaReference = null;

  @JsonProperty("postalCode")
  private String postalCode = null;

  @JsonProperty("country")
  private String country = null;

  public Address streetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
    return this;
  }

  /**
   * street address, including number OR PO box number, eventually extended with internal referencce like room number
   * @return streetAddress
  **/
  @ApiModelProperty(example = "example street 18, 2nd floor, 18-B33", value = "street address, including number OR PO box number, eventually extended with internal referencce like room number")
  
    public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public Address areaReference(String areaReference) {
    this.areaReference = areaReference;
    return this;
  }

  /**
   * city or town, principal subdivision such as province, state or county
   * @return areaReference
  **/
  @ApiModelProperty(example = "Smallcity, Pinetree county", value = "city or town, principal subdivision such as province, state or county")
  
    public String getAreaReference() {
    return areaReference;
  }

  public void setAreaReference(String areaReference) {
    this.areaReference = areaReference;
  }

  public Address postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
  **/
  @ApiModelProperty(value = "")
  
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
    Address address = (Address) o;
    return Objects.equals(this.streetAddress, address.streetAddress) &&
        Objects.equals(this.areaReference, address.areaReference) &&
        Objects.equals(this.postalCode, address.postalCode) &&
        Objects.equals(this.country, address.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetAddress, areaReference, postalCode, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    areaReference: ").append(toIndentedString(areaReference)).append("\n");
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
