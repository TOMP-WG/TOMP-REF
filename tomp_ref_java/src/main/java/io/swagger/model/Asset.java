package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Asset;
import io.swagger.model.AssetClass;
import io.swagger.model.KeyValue;
import io.swagger.model.Place;
import io.swagger.model.TypeOfAsset;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Asset
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class Asset extends TypeOfAsset  {
  @JsonProperty("assetId")
  private String assetId = null;

  @JsonProperty("place")
  private Place place = null;

  @JsonProperty("isReserved")
  private Boolean isReserved = null;

  @JsonProperty("isReservedFrom")
  private BigDecimal isReservedFrom = null;

  @JsonProperty("isReservedTo")
  private BigDecimal isReservedTo = null;

  @JsonProperty("isDisabled")
  private Boolean isDisabled = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("rentalUrl")
  private String rentalUrl = null;

  public Asset assetId(String assetId) {
    this.assetId = assetId;
    return this;
  }

  /**
   * unique identifier of an asset
   * @return assetId
  **/
  @ApiModelProperty(required = true, value = "unique identifier of an asset")
      @NotNull

    public String getAssetId() {
    return assetId;
  }

  public void setAssetId(String assetId) {
    this.assetId = assetId;
  }

  public Asset place(Place place) {
    this.place = place;
    return this;
  }

  /**
   * Get place
   * @return place
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Place getPlace() {
    return place;
  }

  public void setPlace(Place place) {
    this.place = place;
  }

  public Asset isReserved(Boolean isReserved) {
    this.isReserved = isReserved;
    return this;
  }

  /**
   * true indicates the bike is currently reserved for someone else
   * @return isReserved
  **/
  @ApiModelProperty(value = "true indicates the bike is currently reserved for someone else")
  
    public Boolean isIsReserved() {
    return isReserved;
  }

  public void setIsReserved(Boolean isReserved) {
    this.isReserved = isReserved;
  }

  public Asset isReservedFrom(BigDecimal isReservedFrom) {
    this.isReservedFrom = isReservedFrom;
    return this;
  }

  /**
   * Get isReservedFrom
   * @return isReservedFrom
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getIsReservedFrom() {
    return isReservedFrom;
  }

  public void setIsReservedFrom(BigDecimal isReservedFrom) {
    this.isReservedFrom = isReservedFrom;
  }

  public Asset isReservedTo(BigDecimal isReservedTo) {
    this.isReservedTo = isReservedTo;
    return this;
  }

  /**
   * Get isReservedTo
   * @return isReservedTo
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getIsReservedTo() {
    return isReservedTo;
  }

  public void setIsReservedTo(BigDecimal isReservedTo) {
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
  @ApiModelProperty(value = "true indicates the asset is currently disabled (broken)")
  
    public Boolean isIsDisabled() {
    return isDisabled;
  }

  public void setIsDisabled(Boolean isDisabled) {
    this.isDisabled = isDisabled;
  }

  public Asset image(String image) {
    this.image = image;
    return this;
  }

  /**
   * specific image, overruling asset-type image
   * @return image
  **/
  @ApiModelProperty(example = "https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg", value = "specific image, overruling asset-type image")
  
    public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Asset rentalUrl(String rentalUrl) {
    this.rentalUrl = rentalUrl;
    return this;
  }

  /**
   * deep-linking option from GBFS+
   * @return rentalUrl
  **/
  @ApiModelProperty(example = "https://www.rentmyfreebike.com/rental", value = "deep-linking option from GBFS+")
  
    public String getRentalUrl() {
    return rentalUrl;
  }

  public void setRentalUrl(String rentalUrl) {
    this.rentalUrl = rentalUrl;
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
    return Objects.equals(this.assetId, asset.assetId) &&
        Objects.equals(this.place, asset.place) &&
        Objects.equals(this.isReserved, asset.isReserved) &&
        Objects.equals(this.isReservedFrom, asset.isReservedFrom) &&
        Objects.equals(this.isReservedTo, asset.isReservedTo) &&
        Objects.equals(this.isDisabled, asset.isDisabled) &&
        Objects.equals(this.image, asset.image) &&
        Objects.equals(this.rentalUrl, asset.rentalUrl) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assetId, place, isReserved, isReservedFrom, isReservedTo, isDisabled, image, rentalUrl, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Asset {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    isReserved: ").append(toIndentedString(isReserved)).append("\n");
    sb.append("    isReservedFrom: ").append(toIndentedString(isReservedFrom)).append("\n");
    sb.append("    isReservedTo: ").append(toIndentedString(isReservedTo)).append("\n");
    sb.append("    isDisabled: ").append(toIndentedString(isDisabled)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    rentalUrl: ").append(toIndentedString(rentalUrl)).append("\n");
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
