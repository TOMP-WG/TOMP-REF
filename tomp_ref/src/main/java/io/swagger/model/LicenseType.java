package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AssetClass;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A category of license to use a certain asset class
 */
@Schema(description = "A category of license to use a certain asset class")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class LicenseType   {
  @JsonProperty("assetClass")
  private AssetClass assetClass = null;

  @JsonProperty("issuingCountry")
  private String issuingCountry = null;

  public LicenseType assetClass(AssetClass assetClass) {
    this.assetClass = assetClass;
    return this;
  }

  /**
   * Get assetClass
   * @return assetClass
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AssetClass getAssetClass() {
    return assetClass;
  }

  public void setAssetClass(AssetClass assetClass) {
    this.assetClass = assetClass;
  }

  public LicenseType issuingCountry(String issuingCountry) {
    this.issuingCountry = issuingCountry;
    return this;
  }

  /**
   * Get issuingCountry
   * @return issuingCountry
   **/
  @Schema(description = "")
  
  @Size(min=2,max=2)   public String getIssuingCountry() {
    return issuingCountry;
  }

  public void setIssuingCountry(String issuingCountry) {
    this.issuingCountry = issuingCountry;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LicenseType licenseType = (LicenseType) o;
    return Objects.equals(this.assetClass, licenseType.assetClass) &&
        Objects.equals(this.issuingCountry, licenseType.issuingCountry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assetClass, issuingCountry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LicenseType {\n");
    
    sb.append("    assetClass: ").append(toIndentedString(assetClass)).append("\n");
    sb.append("    issuingCountry: ").append(toIndentedString(issuingCountry)).append("\n");
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
