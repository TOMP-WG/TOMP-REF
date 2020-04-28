package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Coordinates;
import io.swagger.model.Period;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OptionsLeg
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class OptionsLeg extends Period  {
  @JsonProperty("from")
  private Coordinates from = null;

  @JsonProperty("to")
  private Coordinates to = null;

  public OptionsLeg from(Coordinates from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Coordinates getFrom() {
    return from;
  }

  public void setFrom(Coordinates from) {
    this.from = from;
  }

  public OptionsLeg to(Coordinates to) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OptionsLeg optionsLeg = (OptionsLeg) o;
    return Objects.equals(this.from, optionsLeg.from) &&
        Objects.equals(this.to, optionsLeg.to) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OptionsLeg {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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
