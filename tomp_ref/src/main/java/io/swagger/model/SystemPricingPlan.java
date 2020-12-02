package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Fare;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemPricingPlan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class SystemPricingPlan   {
  @JsonProperty("planId")
  private String planId = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("stationId")
  private String stationId = null;

  @JsonProperty("regionId")
  private String regionId = null;

  @JsonProperty("fare")
  private Fare fare = null;

  @JsonProperty("isTaxable")
  private Boolean isTaxable = null;

  @JsonProperty("description")
  private String description = null;

  public SystemPricingPlan planId(String planId) {
    this.planId = planId;
    return this;
  }

  /**
   * a unique identifier for this plan in the system
   * @return planId
   **/
  @Schema(example = "freeplan1", required = true, description = "a unique identifier for this plan in the system")
      @NotNull

    public String getPlanId() {
    return planId;
  }

  public void setPlanId(String planId) {
    this.planId = planId;
  }

  public SystemPricingPlan url(String url) {
    this.url = url;
    return this;
  }

  /**
   * a fully qualified URL where the customer can learn more about this particular scheme
   * @return url
   **/
  @Schema(example = "https://www.rentmyfreebike.com/freeplan", description = "a fully qualified URL where the customer can learn more about this particular scheme")
  
    public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public SystemPricingPlan name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of this pricing scheme, could match Content-Language
   * @return name
   **/
  @Schema(example = "Free Plan", required = true, description = "name of this pricing scheme, could match Content-Language")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SystemPricingPlan stationId(String stationId) {
    this.stationId = stationId;
    return this;
  }

  /**
   * pricing plan for a specific station
   * @return stationId
   **/
  @Schema(description = "pricing plan for a specific station")
  
    public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public SystemPricingPlan regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

  /**
   * pricing plan for a specific region
   * @return regionId
   **/
  @Schema(description = "pricing plan for a specific region")
  
    public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public SystemPricingPlan fare(Fare fare) {
    this.fare = fare;
    return this;
  }

  /**
   * Get fare
   * @return fare
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Fare getFare() {
    return fare;
  }

  public void setFare(Fare fare) {
    this.fare = fare;
  }

  public SystemPricingPlan isTaxable(Boolean isTaxable) {
    this.isTaxable = isTaxable;
    return this;
  }

  /**
   * false indicates that no additional tax will be added (either because tax is not charged, or because it is included) true indicates that tax will be added to the base price
   * @return isTaxable
   **/
  @Schema(required = true, description = "false indicates that no additional tax will be added (either because tax is not charged, or because it is included) true indicates that tax will be added to the base price")
      @NotNull

    public Boolean isIsTaxable() {
    return isTaxable;
  }

  public void setIsTaxable(Boolean isTaxable) {
    this.isTaxable = isTaxable;
  }

  public SystemPricingPlan description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Text field describing the particular pricing plan in human readable terms. This should include the duration, price, conditions, etc. that the publisher would like users to see. This is intended to be a human-readable description and should not be used for automatic calculations, should match Content-Language
   * @return description
   **/
  @Schema(example = "Unlimited plan for free bikes, as long as you don't break them!", required = true, description = "Text field describing the particular pricing plan in human readable terms. This should include the duration, price, conditions, etc. that the publisher would like users to see. This is intended to be a human-readable description and should not be used for automatic calculations, should match Content-Language")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemPricingPlan systemPricingPlan = (SystemPricingPlan) o;
    return Objects.equals(this.planId, systemPricingPlan.planId) &&
        Objects.equals(this.url, systemPricingPlan.url) &&
        Objects.equals(this.name, systemPricingPlan.name) &&
        Objects.equals(this.stationId, systemPricingPlan.stationId) &&
        Objects.equals(this.regionId, systemPricingPlan.regionId) &&
        Objects.equals(this.fare, systemPricingPlan.fare) &&
        Objects.equals(this.isTaxable, systemPricingPlan.isTaxable) &&
        Objects.equals(this.description, systemPricingPlan.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planId, url, name, stationId, regionId, fare, isTaxable, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemPricingPlan {\n");
    
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    fare: ").append(toIndentedString(fare)).append("\n");
    sb.append("    isTaxable: ").append(toIndentedString(isTaxable)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
