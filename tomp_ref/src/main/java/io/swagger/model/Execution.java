package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExecutionState;
import io.swagger.model.Fare;
import io.swagger.model.Place;
import io.swagger.model.Token;
import io.swagger.model.TypeOfAsset;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The execution of a booked leg
 */
@ApiModel(description = "The execution of a booked leg")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-10T13:55:00.069Z[GMT]")
public class Execution   {
  @JsonProperty("from")
  private Place from = null;

  @JsonProperty("to")
  private Place to = null;

  @JsonProperty("startTime")
  private OffsetDateTime startTime = null;

  @JsonProperty("endTime")
  private OffsetDateTime endTime = null;

  @JsonProperty("mode")
  private TypeOfAsset mode = null;

  @JsonProperty("state")
  private ExecutionState state = null;

  @JsonProperty("departureDelay")
  private Integer departureDelay = null;

  @JsonProperty("arrivalDelay")
  private Integer arrivalDelay = null;

  @JsonProperty("distance")
  private Integer distance = null;

  @JsonProperty("fare")
  private Fare fare = null;

  @JsonProperty("route")
  private String route = null;

  @JsonProperty("routeShortName")
  private String routeShortName = null;

  @JsonProperty("routeLongName")
  private String routeLongName = null;

  @JsonProperty("agencyId")
  private String agencyId = null;

  @JsonProperty("legGeometry")
  private String legGeometry = null;

  @JsonProperty("assetAccessData")
  private Token assetAccessData = null;

  public Execution from(Place from) {
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

  public Execution to(Place to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public Place getTo() {
    return to;
  }

  public void setTo(Place to) {
    this.to = to;
  }

  public Execution startTime(OffsetDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public Execution endTime(OffsetDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public OffsetDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }

  public Execution mode(TypeOfAsset mode) {
    this.mode = mode;
    return this;
  }

  /**
   * Get mode
   * @return mode
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public TypeOfAsset getMode() {
    return mode;
  }

  public void setMode(TypeOfAsset mode) {
    this.mode = mode;
  }

  public Execution state(ExecutionState state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ExecutionState getState() {
    return state;
  }

  public void setState(ExecutionState state) {
    this.state = state;
  }

  public Execution departureDelay(Integer departureDelay) {
    this.departureDelay = departureDelay;
    return this;
  }

  /**
   * Get departureDelay
   * @return departureDelay
  **/
  @ApiModelProperty(value = "")
  
    public Integer getDepartureDelay() {
    return departureDelay;
  }

  public void setDepartureDelay(Integer departureDelay) {
    this.departureDelay = departureDelay;
  }

  public Execution arrivalDelay(Integer arrivalDelay) {
    this.arrivalDelay = arrivalDelay;
    return this;
  }

  /**
   * Get arrivalDelay
   * @return arrivalDelay
  **/
  @ApiModelProperty(value = "")
  
    public Integer getArrivalDelay() {
    return arrivalDelay;
  }

  public void setArrivalDelay(Integer arrivalDelay) {
    this.arrivalDelay = arrivalDelay;
  }

  public Execution distance(Integer distance) {
    this.distance = distance;
    return this;
  }

  /**
   * Get distance
   * @return distance
  **/
  @ApiModelProperty(value = "")
  
    public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public Execution fare(Fare fare) {
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

  public Execution route(String route) {
    this.route = route;
    return this;
  }

  /**
   * Get route
   * @return route
  **/
  @ApiModelProperty(value = "")
  
    public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  public Execution routeShortName(String routeShortName) {
    this.routeShortName = routeShortName;
    return this;
  }

  /**
   * Get routeShortName
   * @return routeShortName
  **/
  @ApiModelProperty(value = "")
  
    public String getRouteShortName() {
    return routeShortName;
  }

  public void setRouteShortName(String routeShortName) {
    this.routeShortName = routeShortName;
  }

  public Execution routeLongName(String routeLongName) {
    this.routeLongName = routeLongName;
    return this;
  }

  /**
   * Get routeLongName
   * @return routeLongName
  **/
  @ApiModelProperty(value = "")
  
    public String getRouteLongName() {
    return routeLongName;
  }

  public void setRouteLongName(String routeLongName) {
    this.routeLongName = routeLongName;
  }

  public Execution agencyId(String agencyId) {
    this.agencyId = agencyId;
    return this;
  }

  /**
   * Get agencyId
   * @return agencyId
  **/
  @ApiModelProperty(value = "")
  
    public String getAgencyId() {
    return agencyId;
  }

  public void setAgencyId(String agencyId) {
    this.agencyId = agencyId;
  }

  public Execution legGeometry(String legGeometry) {
    this.legGeometry = legGeometry;
    return this;
  }

  /**
   * format as in geojson linestring eg. [[6.169639, 52.253279], .. ] WGS84, [lng,lat]
   * @return legGeometry
  **/
  @ApiModelProperty(value = "format as in geojson linestring eg. [[6.169639, 52.253279], .. ] WGS84, [lng,lat]")
  
    public String getLegGeometry() {
    return legGeometry;
  }

  public void setLegGeometry(String legGeometry) {
    this.legGeometry = legGeometry;
  }

  public Execution assetAccessData(Token assetAccessData) {
    this.assetAccessData = assetAccessData;
    return this;
  }

  /**
   * Get assetAccessData
   * @return assetAccessData
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Token getAssetAccessData() {
    return assetAccessData;
  }

  public void setAssetAccessData(Token assetAccessData) {
    this.assetAccessData = assetAccessData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Execution execution = (Execution) o;
    return Objects.equals(this.from, execution.from) &&
        Objects.equals(this.to, execution.to) &&
        Objects.equals(this.startTime, execution.startTime) &&
        Objects.equals(this.endTime, execution.endTime) &&
        Objects.equals(this.mode, execution.mode) &&
        Objects.equals(this.state, execution.state) &&
        Objects.equals(this.departureDelay, execution.departureDelay) &&
        Objects.equals(this.arrivalDelay, execution.arrivalDelay) &&
        Objects.equals(this.distance, execution.distance) &&
        Objects.equals(this.fare, execution.fare) &&
        Objects.equals(this.route, execution.route) &&
        Objects.equals(this.routeShortName, execution.routeShortName) &&
        Objects.equals(this.routeLongName, execution.routeLongName) &&
        Objects.equals(this.agencyId, execution.agencyId) &&
        Objects.equals(this.legGeometry, execution.legGeometry) &&
        Objects.equals(this.assetAccessData, execution.assetAccessData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, startTime, endTime, mode, state, departureDelay, arrivalDelay, distance, fare, route, routeShortName, routeLongName, agencyId, legGeometry, assetAccessData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Execution {\n");
    
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    departureDelay: ").append(toIndentedString(departureDelay)).append("\n");
    sb.append("    arrivalDelay: ").append(toIndentedString(arrivalDelay)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    fare: ").append(toIndentedString(fare)).append("\n");
    sb.append("    route: ").append(toIndentedString(route)).append("\n");
    sb.append("    routeShortName: ").append(toIndentedString(routeShortName)).append("\n");
    sb.append("    routeLongName: ").append(toIndentedString(routeLongName)).append("\n");
    sb.append("    agencyId: ").append(toIndentedString(agencyId)).append("\n");
    sb.append("    legGeometry: ").append(toIndentedString(legGeometry)).append("\n");
    sb.append("    assetAccessData: ").append(toIndentedString(assetAccessData)).append("\n");
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
