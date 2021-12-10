package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Requirement;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Requirements from the end user side.
 */
@Schema(description = "Requirements from the end user side.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-26T08:47:05.979Z[GMT]")


public class Requirements extends HashMap<String, Object>  {
  @JsonProperty("abilities")
  @Valid
  private List<Requirement> abilities = null;

  @JsonProperty("bringAlong")
  @Valid
  private List<Requirement> bringAlong = null;

  public Requirements abilities(List<Requirement> abilities) {
    this.abilities = abilities;
    return this;
  }

  public Requirements addAbilitiesItem(Requirement abilitiesItem) {
    if (this.abilities == null) {
      this.abilities = new ArrayList<Requirement>();
    }
    this.abilities.add(abilitiesItem);
    return this;
  }

  /**
   * Get abilities
   * @return abilities
   **/
  @Schema(description = "")
      @Valid
    public List<Requirement> getAbilities() {
    return abilities;
  }

  public void setAbilities(List<Requirement> abilities) {
    this.abilities = abilities;
  }

  public Requirements bringAlong(List<Requirement> bringAlong) {
    this.bringAlong = bringAlong;
    return this;
  }

  public Requirements addBringAlongItem(Requirement bringAlongItem) {
    if (this.bringAlong == null) {
      this.bringAlong = new ArrayList<Requirement>();
    }
    this.bringAlong.add(bringAlongItem);
    return this;
  }

  /**
   * Get bringAlong
   * @return bringAlong
   **/
  @Schema(description = "")
      @Valid
    public List<Requirement> getBringAlong() {
    return bringAlong;
  }

  public void setBringAlong(List<Requirement> bringAlong) {
    this.bringAlong = bringAlong;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Requirements requirements = (Requirements) o;
    return Objects.equals(this.abilities, requirements.abilities) &&
        Objects.equals(this.bringAlong, requirements.bringAlong) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(abilities, bringAlong, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Requirements {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    abilities: ").append(toIndentedString(abilities)).append("\n");
    sb.append("    bringAlong: ").append(toIndentedString(bringAlong)).append("\n");
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
