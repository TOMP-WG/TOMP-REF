package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Condition;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConditionPostponedCommit
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T15:19:29.217Z[GMT]")
public class ConditionPostponedCommit extends Condition implements OneOfcondition {
  @JsonProperty("ultimateResponseTime")
  private BigDecimal ultimateResponseTime = null;

  public ConditionPostponedCommit ultimateResponseTime(BigDecimal ultimateResponseTime) {
    this.ultimateResponseTime = ultimateResponseTime;
    return this;
  }

  /**
   * Get ultimateResponseTime
   * @return ultimateResponseTime
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public BigDecimal getUltimateResponseTime() {
    return ultimateResponseTime;
  }

  public void setUltimateResponseTime(BigDecimal ultimateResponseTime) {
    this.ultimateResponseTime = ultimateResponseTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConditionPostponedCommit conditionPostponedCommit = (ConditionPostponedCommit) o;
    return Objects.equals(this.ultimateResponseTime, conditionPostponedCommit.ultimateResponseTime) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ultimateResponseTime, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConditionPostponedCommit {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    ultimateResponseTime: ").append(toIndentedString(ultimateResponseTime)).append("\n");
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
