package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Fare;
import io.swagger.model.LegState;
import io.swagger.model.Place;
import io.swagger.model.Token;
import io.swagger.model.TypeOfAsset;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A OpenlegPlanner compatible definition of a leg (see OpenlegPlanner docs for reference)
 */
@ApiModel(description = "A OpenlegPlanner compatible definition of a leg (see OpenlegPlanner docs for reference)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class Leg   {
  @JsonProperty("from")
  private Place from = null;

  @JsonProperty("to")
  private Place to = null;

  @JsonProperty("startTime")
  private BigDecimal startTime = null;

  @JsonProperty("endTime")
  private BigDecimal endTime = null;

  @JsonProperty("mode")
  private TypeOfAsset mode = null;

  @JsonProperty("state")
  private LegState state = null;

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

  public Leg from(Place from) {
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

  public Leg to(Place to) {
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

  public Leg startTime(BigDecimal startTime) {
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
    public BigDecimal getStartTime() {
    return startTime;
  }

  public void setStartTime(BigDecimal startTime) {
    this.startTime = startTime;
  }

  public Leg endTime(BigDecimal endTime) {
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
    public BigDecimal getEndTime() {
    return endTime;
  }

  public void setEndTime(BigDecimal endTime) {
    this.endTime = endTime;
  }

  public Leg mode(TypeOfAsset mode) {
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

  public Leg state(LegState state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public LegState getState() {
    return state;
  }

  public void setState(LegState state) {
    this.state = state;
  }

  public Leg departureDelay(Integer departureDelay) {
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

  public Leg arrivalDelay(Integer arrivalDelay) {
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

  public Leg distance(Integer distance) {
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

  public Leg fare(Fare fare) {
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

  public Leg route(String route) {
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

  public Leg routeShortName(String routeShortName) {
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

  public Leg routeLongName(String routeLongName) {
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

  public Leg agencyId(String agencyId) {
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

  public Leg legGeometry(String legGeometry) {
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

  public Leg assetAccessData(Token assetAccessData) {
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
    Leg leg = (Leg) o;
    return Objects.equals(this.from, leg.from) &&
        Objects.equals(this.to, leg.to) &&
        Objects.equals(this.startTime, leg.startTime) &&
        Objects.equals(this.endTime, leg.endTime) &&
        Objects.equals(this.mode, leg.mode) &&
        Objects.equals(this.state, leg.state) &&
        Objects.equals(this.departureDelay, leg.departureDelay) &&
        Objects.equals(this.arrivalDelay, leg.arrivalDelay) &&
        Objects.equals(this.distance, leg.distance) &&
        Objects.equals(this.fare, leg.fare) &&
        Objects.equals(this.route, leg.route) &&
        Objects.equals(this.routeShortName, leg.routeShortName) &&
        Objects.equals(this.routeLongName, leg.routeLongName) &&
        Objects.equals(this.agencyId, leg.agencyId) &&
        Objects.equals(this.legGeometry, leg.legGeometry) &&
        Objects.equals(this.assetAccessData, leg.assetAccessData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, startTime, endTime, mode, state, departureDelay, arrivalDelay, distance, fare, route, routeShortName, routeLongName, agencyId, legGeometry, assetAccessData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Leg {\n");
    
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
