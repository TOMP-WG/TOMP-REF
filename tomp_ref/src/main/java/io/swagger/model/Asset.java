package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AssetProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Asset
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T11:36:21.130Z[GMT]")


public class Asset   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("isReserved")
  private Boolean isReserved = null;

  @JsonProperty("isReservedFrom")
  private OffsetDateTime isReservedFrom = null;

  @JsonProperty("isReservedTo")
  private OffsetDateTime isReservedTo = null;

  @JsonProperty("isDisabled")
  private Boolean isDisabled = null;

  @JsonProperty("rentalUrl")
  private String rentalUrl = null;

  @JsonProperty("rentalUrlAndroid")
  private String rentalUrlAndroid = null;

  @JsonProperty("rentalUrlIOS")
  private String rentalUrlIOS = null;

  @JsonProperty("mileage")
  private Float mileage = null;

  @JsonProperty("licensePlate")
  private String licensePlate = null;

  @JsonProperty("overriddenProperties")
  private AssetProperties overriddenProperties = null;

  public Asset id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of an asset. Whenever used in Operator Information changed after every trip (GDPR).
   * @return id
   **/
  @Schema(required = true, description = "Identifier of an asset. Whenever used in Operator Information changed after every trip (GDPR).")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Asset isReserved(Boolean isReserved) {
    this.isReserved = isReserved;
    return this;
  }

  /**
   * true indicates the bike is currently reserved for someone else
   * @return isReserved
   **/
  @Schema(description = "true indicates the bike is currently reserved for someone else")
  
    public Boolean isIsReserved() {
    return isReserved;
  }

  public void setIsReserved(Boolean isReserved) {
    this.isReserved = isReserved;
  }

  public Asset isReservedFrom(OffsetDateTime isReservedFrom) {
    this.isReservedFrom = isReservedFrom;
    return this;
  }

  /**
   * optional addition to determine if an asset is reserved in the future
   * @return isReservedFrom
   **/
  @Schema(description = "optional addition to determine if an asset is reserved in the future")
  
    @Valid
    public OffsetDateTime getIsReservedFrom() {
    return isReservedFrom;
  }

  public void setIsReservedFrom(OffsetDateTime isReservedFrom) {
    this.isReservedFrom = isReservedFrom;
  }

  public Asset isReservedTo(OffsetDateTime isReservedTo) {
    this.isReservedTo = isReservedTo;
    return this;
  }

  /**
   * optional addition to determine when asset is available in the future
   * @return isReservedTo
   **/
  @Schema(description = "optional addition to determine when asset is available in the future")
  
    @Valid
    public OffsetDateTime getIsReservedTo() {
    return isReservedTo;
  }

  public void setIsReservedTo(OffsetDateTime isReservedTo) {
    this.isReservedTo = isReservedTo;
  }

  public Asset isDisabled(Boolean isDisabled) {
    this.isDisabled = isDisabled;
    return this;
  }

  /**
   * true indicates the asset is currently disabled (broken)
   * @return isDisabled
   **/
  @Schema(description = "true indicates the asset is currently disabled (broken)")
  
    public Boolean isIsDisabled() {
    return isDisabled;
  }

  public void setIsDisabled(Boolean isDisabled) {
    this.isDisabled = isDisabled;
  }

  public Asset rentalUrl(String rentalUrl) {
    this.rentalUrl = rentalUrl;
    return this;
  }

  /**
   * deep-linking option from GBFS+. Only added to be consistent with GBFS 2.0
   * @return rentalUrl
   **/
  @Schema(example = "https://www.rentmyfreebike.com/app?sid=1234567890", description = "deep-linking option from GBFS+. Only added to be consistent with GBFS 2.0")
  
    public String getRentalUrl() {
    return rentalUrl;
  }

  public void setRentalUrl(String rentalUrl) {
    this.rentalUrl = rentalUrl;
  }

  public Asset rentalUrlAndroid(String rentalUrlAndroid) {
    this.rentalUrlAndroid = rentalUrlAndroid;
    return this;
  }

  /**
   * deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0
   * @return rentalUrlAndroid
   **/
  @Schema(example = "https://www.rentmyfreebike.com/app?sid=1234567890&platform=android", description = "deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0")
  
    public String getRentalUrlAndroid() {
    return rentalUrlAndroid;
  }

  public void setRentalUrlAndroid(String rentalUrlAndroid) {
    this.rentalUrlAndroid = rentalUrlAndroid;
  }

  public Asset rentalUrlIOS(String rentalUrlIOS) {
    this.rentalUrlIOS = rentalUrlIOS;
    return this;
  }

  /**
   * deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0
   * @return rentalUrlIOS
   **/
  @Schema(example = "https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios", description = "deep-linking option from GBFS 2.0. Only added to be consistent with GBFS 2.0")
  
    public String getRentalUrlIOS() {
    return rentalUrlIOS;
  }

  public void setRentalUrlIOS(String rentalUrlIOS) {
    this.rentalUrlIOS = rentalUrlIOS;
  }

  public Asset mileage(Float mileage) {
    this.mileage = mileage;
    return this;
  }

  /**
   * the current mileage of the asset
   * minimum: 0
   * @return mileage
   **/
  @Schema(description = "the current mileage of the asset")
  
  @DecimalMin("0")  public Float getMileage() {
    return mileage;
  }

  public void setMileage(Float mileage) {
    this.mileage = mileage;
  }

  public Asset licensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
    return this;
  }

  /**
   * the usage of this field requires a secure environment. When assets are published in available-assets, this field can be used to track assets. Be aware of this.
   * @return licensePlate
   **/
  @Schema(description = "the usage of this field requires a secure environment. When assets are published in available-assets, this field can be used to track assets. Be aware of this.")
  
    public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public Asset overriddenProperties(AssetProperties overriddenProperties) {
    this.overriddenProperties = overriddenProperties;
    return this;
  }

  /**
   * Get overriddenProperties
   * @return overriddenProperties
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AssetProperties getOverriddenProperties() {
    return overriddenProperties;
  }

  public void setOverriddenProperties(AssetProperties overriddenProperties) {
    this.overriddenProperties = overriddenProperties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Asset asset = (Asset) o;
    return Objects.equals(this.id, asset.id) &&
        Objects.equals(this.isReserved, asset.isReserved) &&
        Objects.equals(this.isReservedFrom, asset.isReservedFrom) &&
        Objects.equals(this.isReservedTo, asset.isReservedTo) &&
        Objects.equals(this.isDisabled, asset.isDisabled) &&
        Objects.equals(this.rentalUrl, asset.rentalUrl) &&
        Objects.equals(this.rentalUrlAndroid, asset.rentalUrlAndroid) &&
        Objects.equals(this.rentalUrlIOS, asset.rentalUrlIOS) &&
        Objects.equals(this.mileage, asset.mileage) &&
        Objects.equals(this.licensePlate, asset.licensePlate) &&
        Objects.equals(this.overriddenProperties, asset.overriddenProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isReserved, isReservedFrom, isReservedTo, isDisabled, rentalUrl, rentalUrlAndroid, rentalUrlIOS, mileage, licensePlate, overriddenProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Asset {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isReserved: ").append(toIndentedString(isReserved)).append("\n");
    sb.append("    isReservedFrom: ").append(toIndentedString(isReservedFrom)).append("\n");
    sb.append("    isReservedTo: ").append(toIndentedString(isReservedTo)).append("\n");
    sb.append("    isDisabled: ").append(toIndentedString(isDisabled)).append("\n");
    sb.append("    rentalUrl: ").append(toIndentedString(rentalUrl)).append("\n");
    sb.append("    rentalUrlAndroid: ").append(toIndentedString(rentalUrlAndroid)).append("\n");
    sb.append("    rentalUrlIOS: ").append(toIndentedString(rentalUrlIOS)).append("\n");
    sb.append("    mileage: ").append(toIndentedString(mileage)).append("\n");
    sb.append("    licensePlate: ").append(toIndentedString(licensePlate)).append("\n");
    sb.append("    overriddenProperties: ").append(toIndentedString(overriddenProperties)).append("\n");
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
