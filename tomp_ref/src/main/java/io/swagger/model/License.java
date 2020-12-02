package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AssetClass;
import io.swagger.model.LicenseType;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * driver or usage license for a specific user. Contains the number and the assetType you&#x27;re allowed to operate (e.g. driver license for CAR)
 */
@Schema(description = "driver or usage license for a specific user. Contains the number and the assetType you're allowed to operate (e.g. driver license for CAR)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class License extends LicenseType  {
  @JsonProperty("number")
  private String number = null;

  @JsonProperty("licenseCode")
  private String licenseCode = null;

  @JsonProperty("validUntil")
  private LocalDate validUntil = null;

  public License number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
   **/
  @Schema(example = "1287948792", description = "")
  
    public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public License licenseCode(String licenseCode) {
    this.licenseCode = licenseCode;
    return this;
  }

  /**
   * in most countries a driver license has also a code. As TO you can exactly verify, based on this code if the license allows to operate it's assets, if the assetType too generic.
   * @return licenseCode
   **/
  @Schema(example = "D4", description = "in most countries a driver license has also a code. As TO you can exactly verify, based on this code if the license allows to operate it's assets, if the assetType too generic.")
  
    public String getLicenseCode() {
    return licenseCode;
  }

  public void setLicenseCode(String licenseCode) {
    this.licenseCode = licenseCode;
  }

  public License validUntil(LocalDate validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * Get validUntil
   * @return validUntil
   **/
  @Schema(description = "")
  
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
        Objects.equals(this.licenseCode, license.licenseCode) &&
        Objects.equals(this.validUntil, license.validUntil) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, licenseCode, validUntil, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class License {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    licenseCode: ").append(toIndentedString(licenseCode)).append("\n");
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
