package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Fare;
import io.swagger.model.OperatorLeg;
import io.swagger.model.PlanningResult;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * this leg type should be used when returning multiple legs to fullfil a single request from A to B. For instance handling overlegs or when acting as broker for multiple sub contractors.
 */
@ApiModel(description = "this leg type should be used when returning multiple legs to fullfil a single request from A to B. For instance handling overlegs or when acting as broker for multiple sub contractors.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class CompositeLeg extends PlanningResult implements OneOfplanningResult {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("pricing")
  private Fare pricing = null;

  @JsonProperty("legs")
  @Valid
  private List<OperatorLeg> legs = null;

  @JsonProperty("conditions")
  @Valid
  private List<String> conditions = null;

  public CompositeLeg id(String id) {
    this.id = id;
    return this;
  }

  /**
   * unique ID (TO's perspective) for this option. This ID is used during the complete process booking of a specific asset or an asset of a specific type. If the availability-request is not fired within f.i. 30 minutes, it can savely be removed.
   * @return id
  **/
  @ApiModelProperty(value = "unique ID (TO's perspective) for this option. This ID is used during the complete process booking of a specific asset or an asset of a specific type. If the availability-request is not fired within f.i. 30 minutes, it can savely be removed.")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CompositeLeg pricing(Fare pricing) {
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

  public CompositeLeg legs(List<OperatorLeg> legs) {
    this.legs = legs;
    return this;
  }

  public CompositeLeg addLegsItem(OperatorLeg legsItem) {
    if (this.legs == null) {
      this.legs = new ArrayList<OperatorLeg>();
    }
    this.legs.add(legsItem);
    return this;
  }

  /**
   * Get legs
   * @return legs
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<OperatorLeg> getLegs() {
    return legs;
  }

  public void setLegs(List<OperatorLeg> legs) {
    this.legs = legs;
  }

  public CompositeLeg conditions(List<String> conditions) {
    this.conditions = conditions;
    return this;
  }

  public CompositeLeg addConditionsItem(String conditionsItem) {
    if (this.conditions == null) {
      this.conditions = new ArrayList<String>();
    }
    this.conditions.add(conditionsItem);
    return this;
  }

  /**
   * references to the 'conditions' array (start of this object).
   * @return conditions
  **/
  @ApiModelProperty(value = "references to the 'conditions' array (start of this object).")
  
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
    CompositeLeg compositeLeg = (CompositeLeg) o;
    return Objects.equals(this.id, compositeLeg.id) &&
        Objects.equals(this.pricing, compositeLeg.pricing) &&
        Objects.equals(this.legs, compositeLeg.legs) &&
        Objects.equals(this.conditions, compositeLeg.conditions) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, pricing, legs, conditions, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompositeLeg {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
    sb.append("    legs: ").append(toIndentedString(legs)).append("\n");
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
