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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-30T14:11:18.823Z[GMT]")
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

  @JsonProperty("properties")
  private AssetProperties properties = null;

  public Asset id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of an asset
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of an asset")
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

  public Asset properties(AssetProperties properties) {
    this.properties = properties;
    return this;
  }

  /**
   * Get properties
   * @return properties
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull
  
    @Valid
    public AssetProperties getProperties() {
    return properties;
  }

  public void setProperties(AssetProperties properties) {
    this.properties = properties;
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
        Objects.equals(this.properties, asset.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isReserved, isReservedFrom, isReservedTo, isDisabled, properties);
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
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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
