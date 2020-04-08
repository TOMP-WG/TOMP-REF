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
 * PostponedCommitCondition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-03T08:37:12.232Z[GMT]")
public class PostponedCommitCondition extends Condition implements OneOfcondition {
  @JsonProperty("ultimate-response-time")
  private BigDecimal ultimateResponseTime = null;

  public PostponedCommitCondition ultimateResponseTime(BigDecimal ultimateResponseTime) {
    this.ultimateResponseTime = ultimateResponseTime;
    return this;
  }

  /**
   * Get ultimateResponseTime
   * @return ultimateResponseTime
  **/
  @ApiModelProperty(value = "")
  
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
    PostponedCommitCondition postponedCommitCondition = (PostponedCommitCondition) o;
    return Objects.equals(this.ultimateResponseTime, postponedCommitCondition.ultimateResponseTime) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ultimateResponseTime, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostponedCommitCondition {\n");
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
