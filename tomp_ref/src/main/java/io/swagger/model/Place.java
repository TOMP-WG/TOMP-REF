package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Address;
import io.swagger.model.Coordinates;
import io.swagger.model.StopReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * a origin or destination of a leg, non 3D. lon/lat in WGS84.
 */
@ApiModel(description = "a origin or destination of a leg, non 3D. lon/lat in WGS84.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T14:20:13.675Z[GMT]")


public class Place   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("stopReference")
  @Valid
  private List<StopReference> stopReference = null;

  @JsonProperty("stationId")
  private String stationId = null;

  @JsonProperty("coordinates")
  private Coordinates coordinates = null;

  @JsonProperty("physicalAddress")
  private Address physicalAddress = null;

  @JsonProperty("extraInfo")
  @Valid
  private Map<String, Object> extraInfo = null;

  public Place name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Human readable name of the place, could match Content-Language
   * @return name
  **/
  @ApiModelProperty(value = "Human readable name of the place, could match Content-Language")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Place stopReference(List<StopReference> stopReference) {
    this.stopReference = stopReference;
    return this;
  }

  public Place addStopReferenceItem(StopReference stopReferenceItem) {
    if (this.stopReference == null) {
      this.stopReference = new ArrayList<StopReference>();
    }
    this.stopReference.add(stopReferenceItem);
    return this;
  }

  /**
   * Get stopReference
   * @return stopReference
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<StopReference> getStopReference() {
    return stopReference;
  }

  public void setStopReference(List<StopReference> stopReference) {
    this.stopReference = stopReference;
  }

  public Place stationId(String stationId) {
    this.stationId = stationId;
    return this;
  }

  /**
   * reference to /operator/stations
   * @return stationId
  **/
  @ApiModelProperty(value = "reference to /operator/stations")
  
    public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public Place coordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  /**
   * Get coordinates
   * @return coordinates
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public Place physicalAddress(Address physicalAddress) {
    this.physicalAddress = physicalAddress;
    return this;
  }

  /**
   * Get physicalAddress
   * @return physicalAddress
  **/
  @ApiModelProperty(value = "")
  
      @Valid
    public Address getPhysicalAddress() {
    return physicalAddress;
  }

  public void setPhysicalAddress(Address physicalAddress) {
    this.physicalAddress = physicalAddress;
  }

  public Place extraInfo(Map<String, Object> extraInfo) {
    this.extraInfo = extraInfo;
    return this;
  }

  public Place putExtraInfoItem(String key, Object extraInfoItem) {
    if (this.extraInfo == null) {
      this.extraInfo = new HashMap<String, Object>();
    }
    this.extraInfo.put(key, extraInfoItem);
    return this;
  }

  /**
   * Get extraInfo
   * @return extraInfo
  **/
  @ApiModelProperty(value = "")
  
    public Map<String, Object> getExtraInfo() {
    return extraInfo;
  }

  public void setExtraInfo(Map<String, Object> extraInfo) {
    this.extraInfo = extraInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Place place = (Place) o;
    return Objects.equals(this.name, place.name) &&
        Objects.equals(this.stopReference, place.stopReference) &&
        Objects.equals(this.stationId, place.stationId) &&
        Objects.equals(this.coordinates, place.coordinates) &&
        Objects.equals(this.physicalAddress, place.physicalAddress) &&
        Objects.equals(this.extraInfo, place.extraInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, stopReference, stationId, coordinates, physicalAddress, extraInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Place {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    stopReference: ").append(toIndentedString(stopReference)).append("\n");
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("    physicalAddress: ").append(toIndentedString(physicalAddress)).append("\n");
    sb.append("    extraInfo: ").append(toIndentedString(extraInfo)).append("\n");
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
