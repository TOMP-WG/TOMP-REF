package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SystempricingplanPricingplan;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemPricingPlan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
public class SystemPricingPlan   {
  @JsonProperty("pricing-plan")
  @Valid
  private List<SystempricingplanPricingplan> pricingPlan = null;

  public SystemPricingPlan pricingPlan(List<SystempricingplanPricingplan> pricingPlan) {
    this.pricingPlan = pricingPlan;
    return this;
  }

  public SystemPricingPlan addPricingPlanItem(SystempricingplanPricingplan pricingPlanItem) {
    if (this.pricingPlan == null) {
      this.pricingPlan = new ArrayList<SystempricingplanPricingplan>();
    }
    this.pricingPlan.add(pricingPlanItem);
    return this;
  }

  /**
   * Get pricingPlan
   * @return pricingPlan
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<SystempricingplanPricingplan> getPricingPlan() {
    return pricingPlan;
  }

  public void setPricingPlan(List<SystempricingplanPricingplan> pricingPlan) {
    this.pricingPlan = pricingPlan;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemPricingPlan systemPricingPlan = (SystemPricingPlan) o;
    return Objects.equals(this.pricingPlan, systemPricingPlan.pricingPlan);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pricingPlan);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemPricingPlan {\n");
    
    sb.append("    pricingPlan: ").append(toIndentedString(pricingPlan)).append("\n");
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
