package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AssetType;
import io.swagger.model.BookingRequest;
import io.swagger.model.BookingState;
import io.swagger.model.Customer;
import io.swagger.model.Fare;
import io.swagger.model.Leg;
import io.swagger.model.Place;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The booking information describing the state and details of an agreed upon trip
 */
@Schema(description = "The booking information describing the state and details of an agreed upon trip")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-26T08:47:05.979Z[GMT]")


public class Booking extends BookingRequest  {
  @JsonProperty("state")
  private BookingState state = null;

  @JsonProperty("legs")
  @Valid
  private List<Leg> legs = null;

  @JsonProperty("pricing")
  private Fare pricing = null;

  @JsonProperty("departureTime")
  private OffsetDateTime departureTime = null;

  @JsonProperty("arrivalTime")
  private OffsetDateTime arrivalTime = null;

  @JsonProperty("mainAssetType")
  private AssetType mainAssetType = null;

  @JsonProperty("extraData")
  private Map extraData = null;

  public Booking state(BookingState state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   **/
  @Schema(description = "")
  
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
    if (this.legs == null) {
      this.legs = new ArrayList<Leg>();
    }
    this.legs.add(legsItem);
    return this;
  }

  /**
   * The legs of this booking, generally just one for simple legs, in order of how they will be travelled. If this part is not present, it means that there is only one leg. This leg can be constructed * leg[0].id = booking.id * leg[0].departureTime = booking.departureTime * leg[0].arrivalTime = booking.arrivalTime * leg[0].assetType = booking.mainAssetType * leg[0].pricing = booking.pricing This approach is not allowed in the trip execution part
   * @return legs
   **/
  @Schema(description = "The legs of this booking, generally just one for simple legs, in order of how they will be travelled. If this part is not present, it means that there is only one leg. This leg can be constructed * leg[0].id = booking.id * leg[0].departureTime = booking.departureTime * leg[0].arrivalTime = booking.arrivalTime * leg[0].assetType = booking.mainAssetType * leg[0].pricing = booking.pricing This approach is not allowed in the trip execution part")
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
  @Schema(description = "")
  
    @Valid
    public Fare getPricing() {
    return pricing;
  }

  public void setPricing(Fare pricing) {
    this.pricing = pricing;
  }

  public Booking departureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * The initial departure time (over all legs)
   * @return departureTime
   **/
  @Schema(description = "The initial departure time (over all legs)")
  
    @Valid
    public OffsetDateTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
  }

  public Booking arrivalTime(OffsetDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  /**
   * The intended arrival time at the destination of the booking (over all legs)
   * @return arrivalTime
   **/
  @Schema(description = "The intended arrival time at the destination of the booking (over all legs)")
  
    @Valid
    public OffsetDateTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(OffsetDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public Booking mainAssetType(AssetType mainAssetType) {
    this.mainAssetType = mainAssetType;
    return this;
  }

  /**
   * Get mainAssetType
   * @return mainAssetType
   **/
  @Schema(description = "")
  
    @Valid
    public AssetType getMainAssetType() {
    return mainAssetType;
  }

  public void setMainAssetType(AssetType mainAssetType) {
    this.mainAssetType = mainAssetType;
  }

  public Booking extraData(Map extraData) {
    this.extraData = extraData;
    return this;
  }

  /**
   * Get extraData
   * @return extraData
   **/
  @Schema(description = "")
  
    @Valid
    public Map getExtraData() {
    return extraData;
  }

  public void setExtraData(Map extraData) {
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
        Objects.equals(this.departureTime, booking.departureTime) &&
        Objects.equals(this.arrivalTime, booking.arrivalTime) &&
        Objects.equals(this.mainAssetType, booking.mainAssetType) &&
        Objects.equals(this.extraData, booking.extraData) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, legs, pricing, departureTime, arrivalTime, mainAssetType, extraData, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    legs: ").append(toIndentedString(legs)).append("\n");
    sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("    arrivalTime: ").append(toIndentedString(arrivalTime)).append("\n");
    sb.append("    mainAssetType: ").append(toIndentedString(mainAssetType)).append("\n");
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
