package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Fare;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystempricingplanPricingplan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
public class SystempricingplanPricingplan   {
  @JsonProperty("plan-id")
  private String planId = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("fare")
  private Fare fare = null;

  @JsonProperty("is-taxable")
  private Boolean isTaxable = null;

  @JsonProperty("description")
  private String description = null;

  public SystempricingplanPricingplan planId(String planId) {
    this.planId = planId;
    return this;
  }

  /**
   * a unique identifier for this plan in the system
   * @return planId
  **/
  @ApiModelProperty(example = "freeplan1", required = true, value = "a unique identifier for this plan in the system")
      @NotNull

    public String getPlanId() {
    return planId;
  }

  public void setPlanId(String planId) {
    this.planId = planId;
  }

  public SystempricingplanPricingplan url(String url) {
    this.url = url;
    return this;
  }

  /**
   * a fully qualified URL where the customer can learn more about this particular scheme
   * @return url
  **/
  @ApiModelProperty(example = "https://www.rentmyfreebike.com/freeplan", value = "a fully qualified URL where the customer can learn more about this particular scheme")
  
    public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public SystempricingplanPricingplan name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of this pricing scheme
   * @return name
  **/
  @ApiModelProperty(example = "Free Plan", required = true, value = "name of this pricing scheme")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SystempricingplanPricingplan fare(Fare fare) {
    this.fare = fare;
    return this;
  }

  /**
   * Get fare
   * @return fare
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Fare getFare() {
    return fare;
  }

  public void setFare(Fare fare) {
    this.fare = fare;
  }

  public SystempricingplanPricingplan isTaxable(Boolean isTaxable) {
    this.isTaxable = isTaxable;
    return this;
  }

  /**
   * false indicates that no additional tax will be added (either because tax is not charged, or because it is included) true indicates that tax will be added to the base price
   * @return isTaxable
  **/
  @ApiModelProperty(value = "false indicates that no additional tax will be added (either because tax is not charged, or because it is included) true indicates that tax will be added to the base price")
  
    public Boolean isIsTaxable() {
    return isTaxable;
  }

  public void setIsTaxable(Boolean isTaxable) {
    this.isTaxable = isTaxable;
  }

  public SystempricingplanPricingplan description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Text field describing the particular pricing plan in human readable terms. This should include the duration, price, conditions, etc. that the publisher would like users to see. This is intended to be a human-readable description and should not be used for automatic calculations
   * @return description
  **/
  @ApiModelProperty(example = "Unlimited plan for free bikes, as long as you don't break them!", required = true, value = "Text field describing the particular pricing plan in human readable terms. This should include the duration, price, conditions, etc. that the publisher would like users to see. This is intended to be a human-readable description and should not be used for automatic calculations")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystempricingplanPricingplan systempricingplanPricingplan = (SystempricingplanPricingplan) o;
    return Objects.equals(this.planId, systempricingplanPricingplan.planId) &&
        Objects.equals(this.url, systempricingplanPricingplan.url) &&
        Objects.equals(this.name, systempricingplanPricingplan.name) &&
        Objects.equals(this.fare, systempricingplanPricingplan.fare) &&
        Objects.equals(this.isTaxable, systempricingplanPricingplan.isTaxable) &&
        Objects.equals(this.description, systempricingplanPricingplan.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planId, url, name, fare, isTaxable, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystempricingplanPricingplan {\n");
    
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fare: ").append(toIndentedString(fare)).append("\n");
    sb.append("    isTaxable: ").append(toIndentedString(isTaxable)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
