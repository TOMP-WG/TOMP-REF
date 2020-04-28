package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Condition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T15:19:29.217Z[GMT]")
public class Condition  implements OneOfcondition {
  @JsonProperty("conditionType")
  private String conditionType = null;

  @JsonProperty("name")
  private String name = null;

  public Condition conditionType(String conditionType) {
    this.conditionType = conditionType;
    return this;
  }

  /**
   * The specific subclass of condition, should match the schema name exactly
   * @return conditionType
  **/
  @ApiModelProperty(required = true, value = "The specific subclass of condition, should match the schema name exactly")
      @NotNull

    public String getConditionType() {
    return conditionType;
  }

  public void setConditionType(String conditionType) {
    this.conditionType = conditionType;
  }

  public Condition name(String name) {
    this.name = name;
    return this;
  }

  /**
   * TODO
   * @return name
  **/
  @ApiModelProperty(value = "TODO")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Condition condition = (Condition) o;
    return Objects.equals(this.conditionType, condition.conditionType) &&
        Objects.equals(this.name, condition.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conditionType, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Condition {\n");
    
    sb.append("    conditionType: ").append(toIndentedString(conditionType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
