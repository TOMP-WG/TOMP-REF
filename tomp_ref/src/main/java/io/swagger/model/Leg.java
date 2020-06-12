package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Coordinates;
import io.swagger.model.Fare;
import io.swagger.model.Leg;
import io.swagger.model.Suboperator;
import io.swagger.model.TypeOfAsset;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A concrete option for a leg that matches the planning
 */
@ApiModel(description = "A concrete option for a leg that matches the planning")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-10T13:55:00.069Z[GMT]")
public class Leg   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("from")
  private Coordinates from = null;

  @JsonProperty("to")
  private Coordinates to = null;

  @JsonProperty("startTime")
  private OffsetDateTime startTime = null;

  @JsonProperty("endTime")
  private OffsetDateTime endTime = null;

  @JsonProperty("asset")
  private TypeOfAsset asset = null;

  @JsonProperty("pricing")
  private Fare pricing = null;

  @JsonProperty("suboperator")
  private Suboperator suboperator = null;

  @JsonProperty("parts")
  @Valid
  private List<Leg> parts = null;

  @JsonProperty("conditions")
  @Valid
  private List<String> conditions = new ArrayList<String>();

  public Leg id(String id) {
    this.id = id;
    return this;
  }

  /**
   * A unique id which can be referred to when creating a booking, should not be used for sublegs
   * @return id
  **/
  @ApiModelProperty(value = "A unique id which can be referred to when creating a booking, should not be used for sublegs")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Leg from(Coordinates from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public Coordinates getFrom() {
    return from;
  }

  public void setFrom(Coordinates from) {
    this.from = from;
  }

  public Leg to(Coordinates to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Coordinates getTo() {
    return to;
  }

  public void setTo(Coordinates to) {
    this.to = to;
  }

  public Leg startTime(OffsetDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public Leg endTime(OffsetDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public OffsetDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }

  public Leg asset(TypeOfAsset asset) {
    this.asset = asset;
    return this;
  }

  /**
   * Get asset
   * @return asset
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public TypeOfAsset getAsset() {
    return asset;
  }

  public void setAsset(TypeOfAsset asset) {
    this.asset = asset;
  }

  public Leg pricing(Fare pricing) {
    this.pricing = pricing;
    return this;
  }

  /**
   * Get pricing
   * @return pricing
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Fare getPricing() {
    return pricing;
  }

  public void setPricing(Fare pricing) {
    this.pricing = pricing;
  }

  public Leg suboperator(Suboperator suboperator) {
    this.suboperator = suboperator;
    return this;
  }

  /**
   * Get suboperator
   * @return suboperator
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Suboperator getSuboperator() {
    return suboperator;
  }

  public void setSuboperator(Suboperator suboperator) {
    this.suboperator = suboperator;
  }

  public Leg parts(List<Leg> parts) {
    this.parts = parts;
    return this;
  }

  public Leg addPartsItem(Leg partsItem) {
    if (this.parts == null) {
      this.parts = new ArrayList<Leg>();
    }
    this.parts.add(partsItem);
    return this;
  }

  /**
   * The component legs if this leg is composed of multiple legs using different assets
   * @return parts
  **/
  @ApiModelProperty(value = "The component legs if this leg is composed of multiple legs using different assets")
      @Valid
    public List<Leg> getParts() {
    return parts;
  }

  public void setParts(List<Leg> parts) {
    this.parts = parts;
  }

  public Leg conditions(List<String> conditions) {
    this.conditions = conditions;
    return this;
  }

  public Leg addConditionsItem(String conditionsItem) {
    this.conditions.add(conditionsItem);
    return this;
  }

  /**
   * Ids of the conditions in the parent planning that apply to this leg
   * @return conditions
  **/
  @ApiModelProperty(required = true, value = "Ids of the conditions in the parent planning that apply to this leg")
      @NotNull

    public List<String> getConditions() {
    return conditions;
  }

  public void setConditions(List<String> conditions) {
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
    Leg leg = (Leg) o;
    return Objects.equals(this.id, leg.id) &&
        Objects.equals(this.from, leg.from) &&
        Objects.equals(this.to, leg.to) &&
        Objects.equals(this.startTime, leg.startTime) &&
        Objects.equals(this.endTime, leg.endTime) &&
        Objects.equals(this.asset, leg.asset) &&
        Objects.equals(this.pricing, leg.pricing) &&
        Objects.equals(this.suboperator, leg.suboperator) &&
        Objects.equals(this.parts, leg.parts) &&
        Objects.equals(this.conditions, leg.conditions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, from, to, startTime, endTime, asset, pricing, suboperator, parts, conditions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Leg {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
    sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
    sb.append("    suboperator: ").append(toIndentedString(suboperator)).append("\n");
    sb.append("    parts: ").append(toIndentedString(parts)).append("\n");
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
