package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Fare;
import io.swagger.model.OptionsLeg;
import io.swagger.model.PlanningResult;
import io.swagger.model.TypeOfAsset;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SimpleLeg
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class SimpleLeg extends PlanningResult implements OneOfplanningResult {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("leg")
  private OptionsLeg leg = null;

  @JsonProperty("typeOfAsset")
  private TypeOfAsset typeOfAsset = null;

  @JsonProperty("pricing")
  private Fare pricing = null;

  @JsonProperty("conditions")
  @Valid
  private List<String> conditions = null;

  public SimpleLeg id(String id) {
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

  public SimpleLeg leg(OptionsLeg leg) {
    this.leg = leg;
    return this;
  }

  /**
   * Get leg
   * @return leg
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public OptionsLeg getLeg() {
    return leg;
  }

  public void setLeg(OptionsLeg leg) {
    this.leg = leg;
  }

  public SimpleLeg typeOfAsset(TypeOfAsset typeOfAsset) {
    this.typeOfAsset = typeOfAsset;
    return this;
  }

  /**
   * Get typeOfAsset
   * @return typeOfAsset
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public TypeOfAsset getTypeOfAsset() {
    return typeOfAsset;
  }

  public void setTypeOfAsset(TypeOfAsset typeOfAsset) {
    this.typeOfAsset = typeOfAsset;
  }

  public SimpleLeg pricing(Fare pricing) {
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

  public SimpleLeg conditions(List<String> conditions) {
    this.conditions = conditions;
    return this;
  }

  public SimpleLeg addConditionsItem(String conditionsItem) {
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
    SimpleLeg simpleLeg = (SimpleLeg) o;
    return Objects.equals(this.id, simpleLeg.id) &&
        Objects.equals(this.leg, simpleLeg.leg) &&
        Objects.equals(this.typeOfAsset, simpleLeg.typeOfAsset) &&
        Objects.equals(this.pricing, simpleLeg.pricing) &&
        Objects.equals(this.conditions, simpleLeg.conditions) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, leg, typeOfAsset, pricing, conditions, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimpleLeg {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    leg: ").append(toIndentedString(leg)).append("\n");
    sb.append("    typeOfAsset: ").append(toIndentedString(typeOfAsset)).append("\n");
    sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
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
