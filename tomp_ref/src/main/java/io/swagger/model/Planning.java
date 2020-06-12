package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Condition;
import io.swagger.model.Leg;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Available option matching the query.
 */
@ApiModel(description = "Available option matching the query.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-10T13:55:00.069Z[GMT]")
public class Planning   {
  @JsonProperty("validUntil")
  private OffsetDateTime validUntil = null;

  @JsonProperty("conditions")
  @Valid
  private List<Condition> conditions = new ArrayList<Condition>();

  @JsonProperty("legOptions")
  @Valid
  private List<Leg> legOptions = new ArrayList<Leg>();

  public Planning validUntil(OffsetDateTime validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * Get validUntil
   * @return validUntil
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public OffsetDateTime getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(OffsetDateTime validUntil) {
    this.validUntil = validUntil;
  }

  public Planning conditions(List<Condition> conditions) {
    this.conditions = conditions;
    return this;
  }

  public Planning addConditionsItem(Condition conditionsItem) {
    this.conditions.add(conditionsItem);
    return this;
  }

  /**
   * An array of the conditions that apply to at least one of the leg options
   * @return conditions
  **/
  @ApiModelProperty(required = true, value = "An array of the conditions that apply to at least one of the leg options")
      @NotNull
    @Valid
    public List<Condition> getConditions() {
    return conditions;
  }

  public void setConditions(List<Condition> conditions) {
    this.conditions = conditions;
  }

  public Planning legOptions(List<Leg> legOptions) {
    this.legOptions = legOptions;
    return this;
  }

  public Planning addLegOptionsItem(Leg legOptionsItem) {
    this.legOptions.add(legOptionsItem);
    return this;
  }

  /**
   * Legs the TO has found that match the planning request
   * @return legOptions
  **/
  @ApiModelProperty(required = true, value = "Legs the TO has found that match the planning request")
      @NotNull
    @Valid
    public List<Leg> getLegOptions() {
    return legOptions;
  }

  public void setLegOptions(List<Leg> legOptions) {
    this.legOptions = legOptions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Planning planning = (Planning) o;
    return Objects.equals(this.validUntil, planning.validUntil) &&
        Objects.equals(this.conditions, planning.conditions) &&
        Objects.equals(this.legOptions, planning.legOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validUntil, conditions, legOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Planning {\n");
    
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("    legOptions: ").append(toIndentedString(legOptions)).append("\n");
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
