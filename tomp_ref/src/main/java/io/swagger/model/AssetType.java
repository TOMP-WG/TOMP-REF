package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Asset;
import io.swagger.model.AssetClass;
import io.swagger.model.AssetProperties;
import io.swagger.model.SystemPricingPlan;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AssetType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T07:58:28.459Z[GMT]")


public class AssetType   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("stationId")
  private String stationId = null;

  @JsonProperty("nrAvailable")
  private Integer nrAvailable = null;

  @JsonProperty("assets")
  @Valid
  private List<Asset> assets = null;

  @JsonProperty("assetClass")
  private AssetClass assetClass = null;

  @JsonProperty("assetSubClass")
  private String assetSubClass = null;

  @JsonProperty("sharedProperties")
  private AssetProperties sharedProperties = null;

  @JsonProperty("applicablePricings")
  @Valid
  private List<SystemPricingPlan> applicablePricings = null;

  @JsonProperty("conditions")
  @Valid
  private List<OneOfassetTypeConditionsItems> conditions = null;

  public AssetType id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of an asset type,
   * @return id
   **/
  @Schema(required = true, description = "Unique identifier of an asset type,")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AssetType stationId(String stationId) {
    this.stationId = stationId;
    return this;
  }

  /**
   * If stationId is present, the nrAvailable is expected to find the availability at that particular station
   * @return stationId
   **/
  @Schema(description = "If stationId is present, the nrAvailable is expected to find the availability at that particular station")
  
    public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public AssetType nrAvailable(Integer nrAvailable) {
    this.nrAvailable = nrAvailable;
    return this;
  }

  /**
   * Get nrAvailable
   * @return nrAvailable
   **/
  @Schema(description = "")
  
    public Integer getNrAvailable() {
    return nrAvailable;
  }

  public void setNrAvailable(Integer nrAvailable) {
    this.nrAvailable = nrAvailable;
  }

  public AssetType assets(List<Asset> assets) {
    this.assets = assets;
    return this;
  }

  public AssetType addAssetsItem(Asset assetsItem) {
    if (this.assets == null) {
      this.assets = new ArrayList<Asset>();
    }
    this.assets.add(assetsItem);
    return this;
  }

  /**
   * Get assets
   * @return assets
   **/
  @Schema(description = "")
      @Valid
    public List<Asset> getAssets() {
    return assets;
  }

  public void setAssets(List<Asset> assets) {
    this.assets = assets;
  }

  public AssetType assetClass(AssetClass assetClass) {
    this.assetClass = assetClass;
    return this;
  }

  /**
   * Get assetClass
   * @return assetClass
   **/
  @Schema(description = "")
  
    @Valid
    public AssetClass getAssetClass() {
    return assetClass;
  }

  public void setAssetClass(AssetClass assetClass) {
    this.assetClass = assetClass;
  }

  public AssetType assetSubClass(String assetSubClass) {
    this.assetSubClass = assetSubClass;
    return this;
  }

  /**
   * a more precise classification of the asset, like 'cargo bike', 'public bus', 'coach bus', 'office bus', 'water taxi',  'segway'. This is mandatory when using 'OTHER' as class.
   * @return assetSubClass
   **/
  @Schema(description = "a more precise classification of the asset, like 'cargo bike', 'public bus', 'coach bus', 'office bus', 'water taxi',  'segway'. This is mandatory when using 'OTHER' as class.")
  
    public String getAssetSubClass() {
    return assetSubClass;
  }

  public void setAssetSubClass(String assetSubClass) {
    this.assetSubClass = assetSubClass;
  }

  public AssetType sharedProperties(AssetProperties sharedProperties) {
    this.sharedProperties = sharedProperties;
    return this;
  }

  /**
   * Get sharedProperties
   * @return sharedProperties
   **/
  @Schema(description = "")
  
    @Valid
    public AssetProperties getSharedProperties() {
    return sharedProperties;
  }

  public void setSharedProperties(AssetProperties sharedProperties) {
    this.sharedProperties = sharedProperties;
  }

  public AssetType applicablePricings(List<SystemPricingPlan> applicablePricings) {
    this.applicablePricings = applicablePricings;
    return this;
  }

  public AssetType addApplicablePricingsItem(SystemPricingPlan applicablePricingsItem) {
    if (this.applicablePricings == null) {
      this.applicablePricings = new ArrayList<SystemPricingPlan>();
    }
    this.applicablePricings.add(applicablePricingsItem);
    return this;
  }

  /**
   * pricing plans that can be applicable for this assetType. Business logic to determine the final pricing plan is not exposed. Just call the plannings endpoint (v1.2) or the inquiries endpoint (v.1.3)
   * @return applicablePricings
   **/
  @Schema(description = "pricing plans that can be applicable for this assetType. Business logic to determine the final pricing plan is not exposed. Just call the plannings endpoint (v1.2) or the inquiries endpoint (v.1.3)")
      @Valid
    public List<SystemPricingPlan> getApplicablePricings() {
    return applicablePricings;
  }

  public void setApplicablePricings(List<SystemPricingPlan> applicablePricings) {
    this.applicablePricings = applicablePricings;
  }

  public AssetType conditions(List<OneOfassetTypeConditionsItems> conditions) {
    this.conditions = conditions;
    return this;
  }

  public AssetType addConditionsItem(OneOfassetTypeConditionsItems conditionsItem) {
    if (this.conditions == null) {
      this.conditions = new ArrayList<OneOfassetTypeConditionsItems>();
    }
    this.conditions.add(conditionsItem);
    return this;
  }

  /**
   * extra information about the asset type, making it possible to f.x. specifying that booking this car requires a driver license.
   * @return conditions
   **/
  @Schema(description = "extra information about the asset type, making it possible to f.x. specifying that booking this car requires a driver license.")
  
    public List<OneOfassetTypeConditionsItems> getConditions() {
    return conditions;
  }

  public void setConditions(List<OneOfassetTypeConditionsItems> conditions) {
    this.conditions = conditions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssetType assetType = (AssetType) o;
    return Objects.equals(this.id, assetType.id) &&
        Objects.equals(this.stationId, assetType.stationId) &&
        Objects.equals(this.nrAvailable, assetType.nrAvailable) &&
        Objects.equals(this.assets, assetType.assets) &&
        Objects.equals(this.assetClass, assetType.assetClass) &&
        Objects.equals(this.assetSubClass, assetType.assetSubClass) &&
        Objects.equals(this.sharedProperties, assetType.sharedProperties) &&
        Objects.equals(this.applicablePricings, assetType.applicablePricings) &&
        Objects.equals(this.conditions, assetType.conditions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, stationId, nrAvailable, assets, assetClass, assetSubClass, sharedProperties, applicablePricings, conditions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    nrAvailable: ").append(toIndentedString(nrAvailable)).append("\n");
    sb.append("    assets: ").append(toIndentedString(assets)).append("\n");
    sb.append("    assetClass: ").append(toIndentedString(assetClass)).append("\n");
    sb.append("    assetSubClass: ").append(toIndentedString(assetSubClass)).append("\n");
    sb.append("    sharedProperties: ").append(toIndentedString(sharedProperties)).append("\n");
    sb.append("    applicablePricings: ").append(toIndentedString(applicablePricings)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
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
