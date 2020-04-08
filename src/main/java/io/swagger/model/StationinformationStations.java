package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Address;
import io.swagger.model.Coordinate;
import io.swagger.model.Polygon;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StationinformationStations
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-03T08:37:12.232Z[GMT]")
public class StationinformationStations   {
  @JsonProperty("station-id")
  private String stationId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("coordinate")
  private Coordinate coordinate = null;

  @JsonProperty("physical-address")
  private Address physicalAddress = null;

  @JsonProperty("cross-street")
  private String crossStreet = null;

  @JsonProperty("region-id")
  private String regionId = null;

  @JsonProperty("service-area")
  private Polygon serviceArea = null;

  /**
   * Gets or Sets rentalMethods
   */
  public enum RentalMethodsEnum {
    KEY("KEY"),
    
    CREDITCARD("CREDITCARD"),
    
    PAYPASS("PAYPASS"),
    
    APPLEPAY("APPLEPAY"),
    
    ANDROIDPAY("ANDROIDPAY"),
    
    TRANSITCARD("TRANSITCARD"),
    
    ACCOUNTNUMBER("ACCOUNTNUMBER"),
    
    PHONE("PHONE"),
    
    OTHER("OTHER");

    private String value;

    RentalMethodsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RentalMethodsEnum fromValue(String text) {
      for (RentalMethodsEnum b : RentalMethodsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("rental-methods")
  @Valid
  private List<RentalMethodsEnum> rentalMethods = null;

  @JsonProperty("rental-url")
  private String rentalUrl = null;

  @JsonProperty("num-bikes-available")
  private Integer numBikesAvailable = null;

  @JsonProperty("num-bikes-disabled")
  private Integer numBikesDisabled = null;

  @JsonProperty("num-docks-available")
  private Integer numDocksAvailable = null;

  @JsonProperty("num-docks-disabled")
  private Integer numDocksDisabled = null;

  @JsonProperty("is-installed")
  private Boolean isInstalled = null;

  @JsonProperty("is-renting")
  private Boolean isRenting = null;

  @JsonProperty("is-returning")
  private Boolean isReturning = null;

  @JsonProperty("last-reported")
  private BigDecimal lastReported = null;

  public StationinformationStations stationId(String stationId) {
    this.stationId = stationId;
    return this;
  }

  /**
   * unique identifier of a station
   * @return stationId
  **/
  @ApiModelProperty(example = "XX:Y:12345678", required = true, value = "unique identifier of a station")
      @NotNull

    public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public StationinformationStations name(String name) {
    this.name = name;
    return this;
  }

  /**
   * public name of the station
   * @return name
  **/
  @ApiModelProperty(example = "Island Central", required = true, value = "public name of the station")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StationinformationStations coordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
    return this;
  }

  /**
   * Get coordinate
   * @return coordinate
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public Coordinate getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  public StationinformationStations physicalAddress(Address physicalAddress) {
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

  public StationinformationStations crossStreet(String crossStreet) {
    this.crossStreet = crossStreet;
    return this;
  }

  /**
   * Cross street of where the station is located. This field is intended to be a descriptive field for human consumption. In cities, this would be a cross street, but could also be a description of a location in a park, etc.
   * @return crossStreet
  **/
  @ApiModelProperty(example = "on the corner with Secondary Road", value = "Cross street of where the station is located. This field is intended to be a descriptive field for human consumption. In cities, this would be a cross street, but could also be a description of a location in a park, etc.")
  
    public String getCrossStreet() {
    return crossStreet;
  }

  public void setCrossStreet(String crossStreet) {
    this.crossStreet = crossStreet;
  }

  public StationinformationStations regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

  /**
   * ID of the region where the station is located (see \"system-regions\")
   * @return regionId
  **/
  @ApiModelProperty(value = "ID of the region where the station is located (see \"system-regions\")")
  
    public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public StationinformationStations serviceArea(Polygon serviceArea) {
    this.serviceArea = serviceArea;
    return this;
  }

  /**
   * Get serviceArea
   * @return serviceArea
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Polygon getServiceArea() {
    return serviceArea;
  }

  public void setServiceArea(Polygon serviceArea) {
    this.serviceArea = serviceArea;
  }

  public StationinformationStations rentalMethods(List<RentalMethodsEnum> rentalMethods) {
    this.rentalMethods = rentalMethods;
    return this;
  }

  public StationinformationStations addRentalMethodsItem(RentalMethodsEnum rentalMethodsItem) {
    if (this.rentalMethods == null) {
      this.rentalMethods = new ArrayList<RentalMethodsEnum>();
    }
    this.rentalMethods.add(rentalMethodsItem);
    return this;
  }

  /**
   * Array of enumerables containing the payment methods accepted at this station.
   * @return rentalMethods
  **/
  @ApiModelProperty(example = "[\"CREDITCARD\",\"PAYPASS\",\"APPLEPAY\"]", value = "Array of enumerables containing the payment methods accepted at this station.")
  
    public List<RentalMethodsEnum> getRentalMethods() {
    return rentalMethods;
  }

  public void setRentalMethods(List<RentalMethodsEnum> rentalMethods) {
    this.rentalMethods = rentalMethods;
  }

  public StationinformationStations rentalUrl(String rentalUrl) {
    this.rentalUrl = rentalUrl;
    return this;
  }

  /**
   * Get rentalUrl
   * @return rentalUrl
  **/
  @ApiModelProperty(example = "https://www.rentmyfreebike.com", value = "")
  
    public String getRentalUrl() {
    return rentalUrl;
  }

  public void setRentalUrl(String rentalUrl) {
    this.rentalUrl = rentalUrl;
  }

  public StationinformationStations numBikesAvailable(Integer numBikesAvailable) {
    this.numBikesAvailable = numBikesAvailable;
    return this;
  }

  /**
   * Get numBikesAvailable
   * minimum: 0
   * @return numBikesAvailable
  **/
  @ApiModelProperty(value = "")
  
  @Min(0)  public Integer getNumBikesAvailable() {
    return numBikesAvailable;
  }

  public void setNumBikesAvailable(Integer numBikesAvailable) {
    this.numBikesAvailable = numBikesAvailable;
  }

  public StationinformationStations numBikesDisabled(Integer numBikesDisabled) {
    this.numBikesDisabled = numBikesDisabled;
    return this;
  }

  /**
   * Get numBikesDisabled
   * minimum: 0
   * @return numBikesDisabled
  **/
  @ApiModelProperty(value = "")
  
  @Min(0)  public Integer getNumBikesDisabled() {
    return numBikesDisabled;
  }

  public void setNumBikesDisabled(Integer numBikesDisabled) {
    this.numBikesDisabled = numBikesDisabled;
  }

  public StationinformationStations numDocksAvailable(Integer numDocksAvailable) {
    this.numDocksAvailable = numDocksAvailable;
    return this;
  }

  /**
   * Get numDocksAvailable
   * minimum: 0
   * @return numDocksAvailable
  **/
  @ApiModelProperty(value = "")
  
  @Min(0)  public Integer getNumDocksAvailable() {
    return numDocksAvailable;
  }

  public void setNumDocksAvailable(Integer numDocksAvailable) {
    this.numDocksAvailable = numDocksAvailable;
  }

  public StationinformationStations numDocksDisabled(Integer numDocksDisabled) {
    this.numDocksDisabled = numDocksDisabled;
    return this;
  }

  /**
   * Get numDocksDisabled
   * minimum: 0
   * @return numDocksDisabled
  **/
  @ApiModelProperty(value = "")
  
  @Min(0)  public Integer getNumDocksDisabled() {
    return numDocksDisabled;
  }

  public void setNumDocksDisabled(Integer numDocksDisabled) {
    this.numDocksDisabled = numDocksDisabled;
  }

  public StationinformationStations isInstalled(Boolean isInstalled) {
    this.isInstalled = isInstalled;
    return this;
  }

  /**
   * Get isInstalled
   * @return isInstalled
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsInstalled() {
    return isInstalled;
  }

  public void setIsInstalled(Boolean isInstalled) {
    this.isInstalled = isInstalled;
  }

  public StationinformationStations isRenting(Boolean isRenting) {
    this.isRenting = isRenting;
    return this;
  }

  /**
   * Get isRenting
   * @return isRenting
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsRenting() {
    return isRenting;
  }

  public void setIsRenting(Boolean isRenting) {
    this.isRenting = isRenting;
  }

  public StationinformationStations isReturning(Boolean isReturning) {
    this.isReturning = isReturning;
    return this;
  }

  /**
   * Get isReturning
   * @return isReturning
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsReturning() {
    return isReturning;
  }

  public void setIsReturning(Boolean isReturning) {
    this.isReturning = isReturning;
  }

  public StationinformationStations lastReported(BigDecimal lastReported) {
    this.lastReported = lastReported;
    return this;
  }

  /**
   * Get lastReported
   * @return lastReported
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getLastReported() {
    return lastReported;
  }

  public void setLastReported(BigDecimal lastReported) {
    this.lastReported = lastReported;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StationinformationStations stationinformationStations = (StationinformationStations) o;
    return Objects.equals(this.stationId, stationinformationStations.stationId) &&
        Objects.equals(this.name, stationinformationStations.name) &&
        Objects.equals(this.coordinate, stationinformationStations.coordinate) &&
        Objects.equals(this.physicalAddress, stationinformationStations.physicalAddress) &&
        Objects.equals(this.crossStreet, stationinformationStations.crossStreet) &&
        Objects.equals(this.regionId, stationinformationStations.regionId) &&
        Objects.equals(this.serviceArea, stationinformationStations.serviceArea) &&
        Objects.equals(this.rentalMethods, stationinformationStations.rentalMethods) &&
        Objects.equals(this.rentalUrl, stationinformationStations.rentalUrl) &&
        Objects.equals(this.numBikesAvailable, stationinformationStations.numBikesAvailable) &&
        Objects.equals(this.numBikesDisabled, stationinformationStations.numBikesDisabled) &&
        Objects.equals(this.numDocksAvailable, stationinformationStations.numDocksAvailable) &&
        Objects.equals(this.numDocksDisabled, stationinformationStations.numDocksDisabled) &&
        Objects.equals(this.isInstalled, stationinformationStations.isInstalled) &&
        Objects.equals(this.isRenting, stationinformationStations.isRenting) &&
        Objects.equals(this.isReturning, stationinformationStations.isReturning) &&
        Objects.equals(this.lastReported, stationinformationStations.lastReported);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stationId, name, coordinate, physicalAddress, crossStreet, regionId, serviceArea, rentalMethods, rentalUrl, numBikesAvailable, numBikesDisabled, numDocksAvailable, numDocksDisabled, isInstalled, isRenting, isReturning, lastReported);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StationinformationStations {\n");
    
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    coordinate: ").append(toIndentedString(coordinate)).append("\n");
    sb.append("    physicalAddress: ").append(toIndentedString(physicalAddress)).append("\n");
    sb.append("    crossStreet: ").append(toIndentedString(crossStreet)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    serviceArea: ").append(toIndentedString(serviceArea)).append("\n");
    sb.append("    rentalMethods: ").append(toIndentedString(rentalMethods)).append("\n");
    sb.append("    rentalUrl: ").append(toIndentedString(rentalUrl)).append("\n");
    sb.append("    numBikesAvailable: ").append(toIndentedString(numBikesAvailable)).append("\n");
    sb.append("    numBikesDisabled: ").append(toIndentedString(numBikesDisabled)).append("\n");
    sb.append("    numDocksAvailable: ").append(toIndentedString(numDocksAvailable)).append("\n");
    sb.append("    numDocksDisabled: ").append(toIndentedString(numDocksDisabled)).append("\n");
    sb.append("    isInstalled: ").append(toIndentedString(isInstalled)).append("\n");
    sb.append("    isRenting: ").append(toIndentedString(isRenting)).append("\n");
    sb.append("    isReturning: ").append(toIndentedString(isReturning)).append("\n");
    sb.append("    lastReported: ").append(toIndentedString(lastReported)).append("\n");
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
