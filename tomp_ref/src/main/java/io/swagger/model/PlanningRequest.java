package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Place;
import io.swagger.model.Traveler;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A travel planning for which bookable options are requested
 */
@Schema(description = "A travel planning for which bookable options are requested")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T11:36:21.130Z[GMT]")


public class PlanningRequest   {
  @JsonProperty("from")
  private Place from = null;

  @JsonProperty("radius")
  private Integer radius = null;

  @JsonProperty("to")
  private Place to = null;

  @JsonProperty("estimatedDistance")
  private Integer estimatedDistance = null;

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

  @JsonProperty("userGroups")
  @Valid
  private List<String> userGroups = null;

  @JsonProperty("useAssetTypes")
  @Valid
  private List<String> useAssetTypes = null;

  public PlanningRequest from(Place from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Place getFrom() {
    return from;
  }

  public void setFrom(Place from) {
    this.from = from;
  }

  public PlanningRequest radius(Integer radius) {
    this.radius = radius;
    return this;
  }

  /**
   * Maximum distance in meters a user wants to travel to reach the travel option
   * minimum: 0
   * @return radius
   **/
  @Schema(description = "Maximum distance in meters a user wants to travel to reach the travel option")
  
  @Min(0)  public Integer getRadius() {
    return radius;
  }

  public void setRadius(Integer radius) {
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
  @Schema(description = "")
  
    @Valid
    public Place getTo() {
    return to;
  }

  public void setTo(Place to) {
    this.to = to;
  }

  public PlanningRequest estimatedDistance(Integer estimatedDistance) {
    this.estimatedDistance = estimatedDistance;
    return this;
  }

  /**
   * instead of using the from/to construct, it is also possible to give an indication of the distance to travel. The process identifier 'USE_ESTIMATED_DISTANCE' is used to indicate this scenario. Also in meters
   * minimum: 0
   * @return estimatedDistance
   **/
  @Schema(description = "instead of using the from/to construct, it is also possible to give an indication of the distance to travel. The process identifier 'USE_ESTIMATED_DISTANCE' is used to indicate this scenario. Also in meters")
  
  @Min(0)  public Integer getEstimatedDistance() {
    return estimatedDistance;
  }

  public void setEstimatedDistance(Integer estimatedDistance) {
    this.estimatedDistance = estimatedDistance;
  }

  public PlanningRequest departureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * The intended departure time. If left out and no arrivalTime is set, the current time should be assumed.
   * @return departureTime
   **/
  @Schema(description = "The intended departure time. If left out and no arrivalTime is set, the current time should be assumed.")
  
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
  @Schema(description = "The intended arrival time, at the to place if set otherwise the time the user intends to stop using the asset.")
  
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
  @Schema(description = "The number of people that intend to travel, including the customer.")
  
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
  @Schema(description = "Extra information about the people that intend to travel if relevant, length must be less than or equal to nrOftravelers.")
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
   * The specific asset(s) the user wishes to receive leg options for
   * @return useAssets
   **/
  @Schema(description = "The specific asset(s) the user wishes to receive leg options for")
  
    public List<String> getUseAssets() {
    return useAssets;
  }

  public void setUseAssets(List<String> useAssets) {
    this.useAssets = useAssets;
  }

  public PlanningRequest userGroups(List<String> userGroups) {
    this.userGroups = userGroups;
    return this;
  }

  public PlanningRequest addUserGroupsItem(String userGroupsItem) {
    if (this.userGroups == null) {
      this.userGroups = new ArrayList<String>();
    }
    this.userGroups.add(userGroupsItem);
    return this;
  }

  /**
   * Id(s) of user groups that the user belongs to. This provides access to exclusive assets that are hidden to the public. Id's are agreed upon by TO and MP.
   * @return userGroups
   **/
  @Schema(description = "Id(s) of user groups that the user belongs to. This provides access to exclusive assets that are hidden to the public. Id's are agreed upon by TO and MP.")
  
    public List<String> getUserGroups() {
    return userGroups;
  }

  public void setUserGroups(List<String> userGroups) {
    this.userGroups = userGroups;
  }

  public PlanningRequest useAssetTypes(List<String> useAssetTypes) {
    this.useAssetTypes = useAssetTypes;
    return this;
  }

  public PlanningRequest addUseAssetTypesItem(String useAssetTypesItem) {
    if (this.useAssetTypes == null) {
      this.useAssetTypes = new ArrayList<String>();
    }
    this.useAssetTypes.add(useAssetTypesItem);
    return this;
  }

  /**
   * The specific asset type(s) the user wishes to receive leg options for
   * @return useAssetTypes
   **/
  @Schema(description = "The specific asset type(s) the user wishes to receive leg options for")
  
    public List<String> getUseAssetTypes() {
    return useAssetTypes;
  }

  public void setUseAssetTypes(List<String> useAssetTypes) {
    this.useAssetTypes = useAssetTypes;
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
        Objects.equals(this.estimatedDistance, planningRequest.estimatedDistance) &&
        Objects.equals(this.departureTime, planningRequest.departureTime) &&
        Objects.equals(this.arrivalTime, planningRequest.arrivalTime) &&
        Objects.equals(this.nrOfTravelers, planningRequest.nrOfTravelers) &&
        Objects.equals(this.travelers, planningRequest.travelers) &&
        Objects.equals(this.useAssets, planningRequest.useAssets) &&
        Objects.equals(this.userGroups, planningRequest.userGroups) &&
        Objects.equals(this.useAssetTypes, planningRequest.useAssetTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, radius, to, estimatedDistance, departureTime, arrivalTime, nrOfTravelers, travelers, useAssets, userGroups, useAssetTypes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanningRequest {\n");
    
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    radius: ").append(toIndentedString(radius)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    estimatedDistance: ").append(toIndentedString(estimatedDistance)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("    arrivalTime: ").append(toIndentedString(arrivalTime)).append("\n");
    sb.append("    nrOfTravelers: ").append(toIndentedString(nrOfTravelers)).append("\n");
    sb.append("    travelers: ").append(toIndentedString(travelers)).append("\n");
    sb.append("    useAssets: ").append(toIndentedString(useAssets)).append("\n");
    sb.append("    userGroups: ").append(toIndentedString(userGroups)).append("\n");
    sb.append("    useAssetTypes: ").append(toIndentedString(useAssetTypes)).append("\n");
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
