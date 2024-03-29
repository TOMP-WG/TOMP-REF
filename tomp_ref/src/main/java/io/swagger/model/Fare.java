package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.FarePart;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * the total fare is the sum of all parts, except for the &#x27;MAX&#x27; farePart. This one descripes the maximum price for the complete leg.
 */
@Schema(description = "the total fare is the sum of all parts, except for the 'MAX' farePart. This one descripes the maximum price for the complete leg.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-19T12:10:17.865Z[GMT]")


public class Fare   {
  @JsonProperty("estimated")
  private Boolean estimated = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("class")
  private String propertyClass = null;

  @JsonProperty("parts")
  @Valid
  private List<FarePart> parts = new ArrayList<FarePart>();

  public Fare estimated(Boolean estimated) {
    this.estimated = estimated;
    return this;
  }

  /**
   * is this fare an estimation?
   * @return estimated
   **/
  @Schema(required = true, description = "is this fare an estimation?")
      @NotNull

    public Boolean isEstimated() {
    return estimated;
  }

  public void setEstimated(Boolean estimated) {
    this.estimated = estimated;
  }

  public Fare description(String description) {
    this.description = description;
    return this;
  }

  /**
   * user friendly description of the fare (e.g. 'full fare'), should match Content-Language
   * @return description
   **/
  @Schema(description = "user friendly description of the fare (e.g. 'full fare'), should match Content-Language")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Fare propertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
    return this;
  }

  /**
   * in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.
   * @return propertyClass
   **/
  @Schema(description = "in the future we'll set up an enumeration of possible \"fare classes\". For now it's free format.")
  
    public String getPropertyClass() {
    return propertyClass;
  }

  public void setPropertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
  }

  public Fare parts(List<FarePart> parts) {
    this.parts = parts;
    return this;
  }

  public Fare addPartsItem(FarePart partsItem) {
    this.parts.add(partsItem);
    return this;
  }

  /**
   * Get parts
   * @return parts
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<FarePart> getParts() {
    return parts;
  }

  public void setParts(List<FarePart> parts) {
    this.parts = parts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fare fare = (Fare) o;
    return Objects.equals(this.estimated, fare.estimated) &&
        Objects.equals(this.description, fare.description) &&
        Objects.equals(this.propertyClass, fare.propertyClass) &&
        Objects.equals(this.parts, fare.parts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(estimated, description, propertyClass, parts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fare {\n");
    
    sb.append("    estimated: ").append(toIndentedString(estimated)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    parts: ").append(toIndentedString(parts)).append("\n");
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
