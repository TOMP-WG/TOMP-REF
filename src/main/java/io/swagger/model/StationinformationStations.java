package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Address;
import io.swagger.model.Coordinate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StationinformationStations
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
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
        Objects.equals(this.rentalMethods, stationinformationStations.rentalMethods) &&
        Objects.equals(this.rentalUrl, stationinformationStations.rentalUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stationId, name, coordinate, physicalAddress, crossStreet, regionId, rentalMethods, rentalUrl);
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
    sb.append("    rentalMethods: ").append(toIndentedString(rentalMethods)).append("\n");
    sb.append("    rentalUrl: ").append(toIndentedString(rentalUrl)).append("\n");
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
