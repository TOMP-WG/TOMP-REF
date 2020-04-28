package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Condition;
import io.swagger.model.PlanningResult;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Available option matching the query. Optionally including asset information for claiming specific assets. The pricing is also included.
 */
@ApiModel(description = "Available option matching the query. Optionally including asset information for claiming specific assets. The pricing is also included.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class PlanningOptions   {
  @JsonProperty("validUntil")
  private BigDecimal validUntil = null;

  @JsonProperty("conditions")
  @Valid
  private List<Condition> conditions = null;

  @JsonProperty("results")
  @Valid
  private List<PlanningResult> results = null;

  public PlanningOptions validUntil(BigDecimal validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * Get validUntil
   * @return validUntil
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(BigDecimal validUntil) {
    this.validUntil = validUntil;
  }

  public PlanningOptions conditions(List<Condition> conditions) {
    this.conditions = conditions;
    return this;
  }

  public PlanningOptions addConditionsItem(Condition conditionsItem) {
    if (this.conditions == null) {
      this.conditions = new ArrayList<Condition>();
    }
    this.conditions.add(conditionsItem);
    return this;
  }

  /**
   * Get conditions
   * @return conditions
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Condition> getConditions() {
    return conditions;
  }

  public void setConditions(List<Condition> conditions) {
    this.conditions = conditions;
  }

  public PlanningOptions results(List<PlanningResult> results) {
    this.results = results;
    return this;
  }

  public PlanningOptions addResultsItem(PlanningResult resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<PlanningResult>();
    }
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<PlanningResult> getResults() {
    return results;
  }

  public void setResults(List<PlanningResult> results) {
    this.results = results;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanningOptions planningOptions = (PlanningOptions) o;
    return Objects.equals(this.validUntil, planningOptions.validUntil) &&
        Objects.equals(this.conditions, planningOptions.conditions) &&
        Objects.equals(this.results, planningOptions.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validUntil, conditions, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanningOptions {\n");
    
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
