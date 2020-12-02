package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AssetProperties;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Asset
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T14:20:13.675Z[GMT]")


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
  @ApiModelProperty(required = true, value = "Identifier of an asset. Whenever used in Operator Information changed after every trip (GDPR).")
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
  @ApiModelProperty(value = "true indicates the bike is currently reserved for someone else")
  
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
  @ApiModelProperty(value = "optional addition to determine if an asset is reserved in the future")
  
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
  @ApiModelProperty(value = "optional addition to determine when asset is available in the future")
  
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
  @ApiModelProperty(value = "true indicates the asset is currently disabled (broken)")
  
    public Boolean isIsDisabled() {
    return isDisabled;
  }

  public void setIsDisabled(Boolean isDisabled) {
    this.isDisabled = isDisabled;
  }

  public Asset overriddenProperties(AssetProperties overriddenProperties) {
    this.overriddenProperties = overriddenProperties;
    return this;
  }

  /**
   * Get overriddenProperties
   * @return overriddenProperties
  **/
  @ApiModelProperty(value = "")
  
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
        Objects.equals(this.overriddenProperties, asset.overriddenProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isReserved, isReservedFrom, isReservedTo, isDisabled, overriddenProperties);
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
