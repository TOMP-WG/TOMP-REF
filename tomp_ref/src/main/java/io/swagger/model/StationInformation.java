package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Address;
import io.swagger.model.Coordinates;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StationInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class StationInformation   {
  @JsonProperty("stationId")
  private String stationId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("coordinates")
  private Coordinates coordinates = null;

  @JsonProperty("physicalAddress")
  private Address physicalAddress = null;

  @JsonProperty("crossStreet")
  private String crossStreet = null;

  @JsonProperty("regionId")
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
  @JsonProperty("rentalMethods")
  @Valid
  private List<RentalMethodsEnum> rentalMethods = null;

  @JsonProperty("rentalUrl")
  private String rentalUrl = null;

  @JsonProperty("rentalUrlAndroid")
  private String rentalUrlAndroid = null;

  @JsonProperty("rentalUrlIOS")
  private String rentalUrlIOS = null;

  public StationInformation stationId(String stationId) {
    this.stationId = stationId;
    return this;
  }

  /**
   * unique identifier of a station
   * @return stationId
   **/
  @Schema(example = "XX:Y:12345678", required = true, description = "unique identifier of a station")
      @NotNull

    public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public StationInformation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * public name of the station, could match Content-Language
   * @return name
   **/
  @Schema(example = "Island Central", required = true, description = "public name of the station, could match Content-Language")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StationInformation coordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  /**
   * Get coordinates
   * @return coordinates
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public StationInformation physicalAddress(Address physicalAddress) {
    this.physicalAddress = physicalAddress;
    return this;
  }

  /**
   * Get physicalAddress
   * @return physicalAddress
   **/
  @Schema(description = "")
  
    @Valid
    public Address getPhysicalAddress() {
    return physicalAddress;
  }

  public void setPhysicalAddress(Address physicalAddress) {
    this.physicalAddress = physicalAddress;
  }

  public StationInformation crossStreet(String crossStreet) {
    this.crossStreet = crossStreet;
    return this;
  }

  /**
   * Cross street of where the station is located. This field is intended to be a descriptive field for human consumption. In cities, this would be a cross street, but could also be a description of a location in a park, etc, should match Content-Language
   * @return crossStreet
   **/
  @Schema(example = "on the corner with Secondary Road", description = "Cross street of where the station is located. This field is intended to be a descriptive field for human consumption. In cities, this would be a cross street, but could also be a description of a location in a park, etc, should match Content-Language")
  
    public String getCrossStreet() {
    return crossStreet;
  }

  public void setCrossStreet(String crossStreet) {
    this.crossStreet = crossStreet;
  }

  public StationInformation regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

  /**
   * ID of the region where the station operates (see \"systemRegions\")
   * @return regionId
   **/
  @Schema(description = "ID of the region where the station operates (see \"systemRegions\")")
  
    public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public StationInformation rentalMethods(List<RentalMethodsEnum> rentalMethods) {
    this.rentalMethods = rentalMethods;
    return this;
  }

  public StationInformation addRentalMethodsItem(RentalMethodsEnum rentalMethodsItem) {
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
  @Schema(example = "[\"CREDITCARD\",\"PAYPASS\",\"APPLEPAY\"]", description = "Array of enumerables containing the payment methods accepted at this station.")
  
    public List<RentalMethodsEnum> getRentalMethods() {
    return rentalMethods;
  }

  public void setRentalMethods(List<RentalMethodsEnum> rentalMethods) {
    this.rentalMethods = rentalMethods;
  }

  public StationInformation rentalUrl(String rentalUrl) {
    this.rentalUrl = rentalUrl;
    return this;
  }

  /**
   * web uri for renting assets at this station. Only added to be consistent with GBFS 2.0.
   * @return rentalUrl
   **/
  @Schema(example = "https://www.rentmyfreebike.com", description = "web uri for renting assets at this station. Only added to be consistent with GBFS 2.0.")
  
    public String getRentalUrl() {
    return rentalUrl;
  }

  public void setRentalUrl(String rentalUrl) {
    this.rentalUrl = rentalUrl;
  }

  public StationInformation rentalUrlAndroid(String rentalUrlAndroid) {
    this.rentalUrlAndroid = rentalUrlAndroid;
    return this;
  }

  /**
   * android uri for renting assets at this station. Only added to be consistent with GBFS 2.0.
   * @return rentalUrlAndroid
   **/
  @Schema(example = "https://www.rentmyfreebikecom/app?sid=1234567890&platform=android", description = "android uri for renting assets at this station. Only added to be consistent with GBFS 2.0.")
  
    public String getRentalUrlAndroid() {
    return rentalUrlAndroid;
  }

  public void setRentalUrlAndroid(String rentalUrlAndroid) {
    this.rentalUrlAndroid = rentalUrlAndroid;
  }

  public StationInformation rentalUrlIOS(String rentalUrlIOS) {
    this.rentalUrlIOS = rentalUrlIOS;
    return this;
  }

  /**
   * ios uri for renting assets at this station. Only added to be consistent with GBFS 2.0.
   * @return rentalUrlIOS
   **/
  @Schema(example = "https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios", description = "ios uri for renting assets at this station. Only added to be consistent with GBFS 2.0.")
  
    public String getRentalUrlIOS() {
    return rentalUrlIOS;
  }

  public void setRentalUrlIOS(String rentalUrlIOS) {
    this.rentalUrlIOS = rentalUrlIOS;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StationInformation stationInformation = (StationInformation) o;
    return Objects.equals(this.stationId, stationInformation.stationId) &&
        Objects.equals(this.name, stationInformation.name) &&
        Objects.equals(this.coordinates, stationInformation.coordinates) &&
        Objects.equals(this.physicalAddress, stationInformation.physicalAddress) &&
        Objects.equals(this.crossStreet, stationInformation.crossStreet) &&
        Objects.equals(this.regionId, stationInformation.regionId) &&
        Objects.equals(this.rentalMethods, stationInformation.rentalMethods) &&
        Objects.equals(this.rentalUrl, stationInformation.rentalUrl) &&
        Objects.equals(this.rentalUrlAndroid, stationInformation.rentalUrlAndroid) &&
        Objects.equals(this.rentalUrlIOS, stationInformation.rentalUrlIOS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stationId, name, coordinates, physicalAddress, crossStreet, regionId, rentalMethods, rentalUrl, rentalUrlAndroid, rentalUrlIOS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StationInformation {\n");
    
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("    physicalAddress: ").append(toIndentedString(physicalAddress)).append("\n");
    sb.append("    crossStreet: ").append(toIndentedString(crossStreet)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    rentalMethods: ").append(toIndentedString(rentalMethods)).append("\n");
    sb.append("    rentalUrl: ").append(toIndentedString(rentalUrl)).append("\n");
    sb.append("    rentalUrlAndroid: ").append(toIndentedString(rentalUrlAndroid)).append("\n");
    sb.append("    rentalUrlIOS: ").append(toIndentedString(rentalUrlIOS)).append("\n");
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
