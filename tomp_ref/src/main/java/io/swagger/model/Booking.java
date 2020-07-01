package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BookingRequest;
import io.swagger.model.BookingState;
import io.swagger.model.Customer;
import io.swagger.model.Fare;
import io.swagger.model.Leg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The booking information describing the state and details of an agreed upon trip
 */
@ApiModel(description = "The booking information describing the state and details of an agreed upon trip")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-30T14:11:18.823Z[GMT]")
public class Booking extends BookingRequest  {
  @JsonProperty("state")
  private BookingState state = null;

  @JsonProperty("legs")
  @Valid
  private List<Leg> legs = new ArrayList<Leg>();

  @JsonProperty("pricing")
  private Fare pricing = null;

  @JsonProperty("extraData")
  @Valid
  private Map<String, Object> extraData = null;

  public Booking state(BookingState state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")

    @Valid
    public BookingState getState() {
    return state;
  }

  public void setState(BookingState state) {
    this.state = state;
  }

  public Booking legs(List<Leg> legs) {
    this.legs = legs;
    return this;
  }

  public Booking addLegsItem(Leg legsItem) {
    this.legs.add(legsItem);
    return this;
  }

  /**
   * The legs of this booking, generally just one for simple legs, in order of how they will be travelled
   * @return legs
  **/
  @ApiModelProperty(required = true, value = "The legs of this booking, generally just one for simple legs, in order of how they will be travelled")
      @NotNull
    @Valid
    public List<Leg> getLegs() {
    return legs;
  }

  public void setLegs(List<Leg> legs) {
    this.legs = legs;
  }

  public Booking pricing(Fare pricing) {
    this.pricing = pricing;
    return this;
  }

  /**
   * Get pricing
   * @return pricing
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Fare getPricing() {
    return pricing;
  }

  public void setPricing(Fare pricing) {
    this.pricing = pricing;
  }

  public Booking extraData(Map<String, Object> extraData) {
    this.extraData = extraData;
    return this;
  }

  public Booking putExtraDataItem(String key, Object extraDataItem) {
    if (this.extraData == null) {
      this.extraData = new HashMap<String, Object>();
    }
    this.extraData.put(key, extraDataItem);
    return this;
  }

  /**
   * Arbitrary information that a TO can add
   * @return extraData
  **/
  @ApiModelProperty(value = "Arbitrary information that a TO can add")
  
    public Map<String, Object> getExtraData() {
    return extraData;
  }

  public void setExtraData(Map<String, Object> extraData) {
    this.extraData = extraData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return Objects.equals(this.state, booking.state) &&
        Objects.equals(this.legs, booking.legs) &&
        Objects.equals(this.pricing, booking.pricing) &&
        Objects.equals(this.extraData, booking.extraData) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, legs, pricing, extraData, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    legs: ").append(toIndentedString(legs)).append("\n");
    sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
    sb.append("    extraData: ").append(toIndentedString(extraData)).append("\n");
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
