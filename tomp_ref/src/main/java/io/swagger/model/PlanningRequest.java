package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Place;
import io.swagger.model.Traveler;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A travel planning for which bookable options are requested
 */
@ApiModel(description = "A travel planning for which bookable options are requested")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T14:11:01.002Z[GMT]")


public class PlanningRequest   {
  @JsonProperty("from")
  private Place from = null;

  @JsonProperty("radius")
  private BigDecimal radius = null;

  @JsonProperty("to")
  private Place to = null;

  @JsonProperty("departureTime")
  private OffsetDateTime departureTime = null;

  @JsonProperty("arrivalTime")
  private OffsetDateTime arrivalTime = null;

  @JsonProperty("nrOfTravelers")
  private Integer nrOfTravelers = null;

  @JsonProperty("travelers")
  @Valid
  private List<Traveler> travelers = null;

  @JsonProperty("useAssets")
  @Valid
  private List<String> useAssets = null;

  public PlanningRequest from(Place from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public Place getFrom() {
    return from;
  }

  public void setFrom(Place from) {
    this.from = from;
  }

  public PlanningRequest radius(BigDecimal radius) {
    this.radius = radius;
    return this;
  }

  /**
   * Maximum distance in meters a user wants to travel to reach the travel option
   * @return radius
  **/
  @ApiModelProperty(value = "Maximum distance in meters a user wants to travel to reach the travel option")
  
    @Valid
    public BigDecimal getRadius() {
    return radius;
  }

  public void setRadius(BigDecimal radius) {
    this.radius = radius;
  }

  public PlanningRequest to(Place to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Place getTo() {
    return to;
  }

  public void setTo(Place to) {
    this.to = to;
  }

  public PlanningRequest departureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * The intended departure time. If left out and no arrivalTime is set, the current time should be assumed.
   * @return departureTime
  **/
  @ApiModelProperty(value = "The intended departure time. If left out and no arrivalTime is set, the current time should be assumed.")
  
    @Valid
    public OffsetDateTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
  }

  public PlanningRequest arrivalTime(OffsetDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  /**
   * The intended arrival time, at the to place if set otherwise the time the user intends to stop using the asset.
   * @return arrivalTime
  **/
  @ApiModelProperty(value = "The intended arrival time, at the to place if set otherwise the time the user intends to stop using the asset.")
  
    @Valid
    public OffsetDateTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(OffsetDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
    }

  public PlanningRequest nrOfTravelers(Integer nrOfTravelers) {
    this.nrOfTravelers = nrOfTravelers;
    return this;
  }

  /**
   * The number of people that intend to travel, including the customer.
   * minimum: 1
   * @return nrOfTravelers
  **/
  @ApiModelProperty(value = "The number of people that intend to travel, including the customer.")
  
  @Min(1)  public Integer getNrOfTravelers() {
    return nrOfTravelers;
  }

  public void setNrOfTravelers(Integer nrOfTravelers) {
    this.nrOfTravelers = nrOfTravelers;
  }

  public PlanningRequest travelers(List<Traveler> travelers) {
    this.travelers = travelers;
    return this;
  }

  public PlanningRequest addTravelersItem(Traveler travelersItem) {
    if (this.travelers == null) {
      this.travelers = new ArrayList<Traveler>();
    }
    this.travelers.add(travelersItem);
    return this;
  }

  /**
   * Extra information about the people that intend to travel if relevant, length must be less than or equal to nrOftravelers.
   * @return travelers
  **/
  @ApiModelProperty(value = "Extra information about the people that intend to travel if relevant, length must be less than or equal to nrOftravelers.")
      @Valid
    public List<Traveler> getTravelers() {
    return travelers;
  }

  public void setTravelers(List<Traveler> travelers) {
    this.travelers = travelers;
  }

  public PlanningRequest useAssets(List<String> useAssets) {
    this.useAssets = useAssets;
    return this;
  }

  public PlanningRequest addUseAssetsItem(String useAssetsItem) {
    if (this.useAssets == null) {
      this.useAssets = new ArrayList<String>();
    }
    this.useAssets.add(useAssetsItem);
    return this;
  }

  /**
   * The specific asset(s), the user wishes to receive leg options for
   * @return useAssets
  **/
  @ApiModelProperty(value = "The specific asset(s), the user wishes to receive leg options for")
  
    public List<String> getUseAssets() {
    return useAssets;
  }

  public void setUseAssets(List<String> useAssets) {
    this.useAssets = useAssets;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanningRequest planningRequest = (PlanningRequest) o;
    return Objects.equals(this.from, planningRequest.from) &&
        Objects.equals(this.radius, planningRequest.radius) &&
        Objects.equals(this.to, planningRequest.to) &&
        Objects.equals(this.departureTime, planningRequest.departureTime) &&
        Objects.equals(this.arrivalTime, planningRequest.arrivalTime) &&
        Objects.equals(this.nrOfTravelers, planningRequest.nrOfTravelers) &&
        Objects.equals(this.travelers, planningRequest.travelers) &&
        Objects.equals(this.useAssets, planningRequest.useAssets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, radius, to, departureTime, arrivalTime, nrOfTravelers, travelers, useAssets);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanningRequest {\n");
    
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    radius: ").append(toIndentedString(radius)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("    arrivalTime: ").append(toIndentedString(arrivalTime)).append("\n");
    sb.append("    nrOfTravelers: ").append(toIndentedString(nrOfTravelers)).append("\n");
    sb.append("    travelers: ").append(toIndentedString(travelers)).append("\n");
    sb.append("    useAssets: ").append(toIndentedString(useAssets)).append("\n");
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
