package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Booking;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A travel planning with bookable options that fulfil the constraints of the planning
 */
@ApiModel(description = "A travel planning with bookable options that fulfil the constraints of the planning")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T14:11:01.002Z[GMT]")


public class Planning   {
  @JsonProperty("validUntil")
  private OffsetDateTime validUntil = null;

  @JsonProperty("options")
  @Valid
  private List<Booking> options = new ArrayList<Booking>();

  public Planning validUntil(OffsetDateTime validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * The time until which the presented options are (likely) available
   * @return validUntil
  **/
  @ApiModelProperty(required = true, value = "The time until which the presented options are (likely) available")
      @NotNull

    @Valid
    public OffsetDateTime getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(OffsetDateTime validUntil) {
    this.validUntil = validUntil;
  }

  public Planning options(List<Booking> options) {
    this.options = options;
    return this;
  }

  public Planning addOptionsItem(Booking optionsItem) {
    this.options.add(optionsItem);
    return this;
  }

  /**
   * Get options
   * @return options
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull
    @Valid
    public List<Booking> getOptions() {
    return options;
  }

  public void setOptions(List<Booking> options) {
    this.options = options;
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
        Objects.equals(this.options, planning.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validUntil, options);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Planning {\n");
    
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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
