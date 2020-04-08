package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AssetClass;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * driver or usage license for a specific user. Contains the number and the asset-type you&#x27;re allowed to operate (e.g. driver license for CAR)
 */
@ApiModel(description = "driver or usage license for a specific user. Contains the number and the asset-type you're allowed to operate (e.g. driver license for CAR)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-03T08:37:12.232Z[GMT]")
public class License   {
  @JsonProperty("number")
  private String number = null;

  @JsonProperty("asset-type")
  private AssetClass assetType = null;

  @JsonProperty("license-code")
  private String licenseCode = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("valid-until")
  private LocalDate validUntil = null;

  public License number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  **/
  @ApiModelProperty(example = "1287948792", value = "")
  
    public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public License assetType(AssetClass assetType) {
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

  public License licenseCode(String licenseCode) {
    this.licenseCode = licenseCode;
    return this;
  }

  /**
   * in most countries a driver license has also a code. As TO you can exactly verify, based on this code if the license allows to operate it's assets, if the asset-type too generic.
   * @return licenseCode
  **/
  @ApiModelProperty(example = "D4", value = "in most countries a driver license has also a code. As TO you can exactly verify, based on this code if the license allows to operate it's assets, if the asset-type too generic.")
  
    public String getLicenseCode() {
    return licenseCode;
  }

  public void setLicenseCode(String licenseCode) {
    this.licenseCode = licenseCode;
  }

  public License country(String country) {
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

  public License validUntil(LocalDate validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * Get validUntil
   * @return validUntil
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public LocalDate getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(LocalDate validUntil) {
    this.validUntil = validUntil;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    License license = (License) o;
    return Objects.equals(this.number, license.number) &&
        Objects.equals(this.assetType, license.assetType) &&
        Objects.equals(this.licenseCode, license.licenseCode) &&
        Objects.equals(this.country, license.country) &&
        Objects.equals(this.validUntil, license.validUntil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, assetType, licenseCode, country, validUntil);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class License {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
    sb.append("    licenseCode: ").append(toIndentedString(licenseCode)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
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
