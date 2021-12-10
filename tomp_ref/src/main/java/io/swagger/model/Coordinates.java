package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * a lon, lat (WGS84, EPSG:4326)
 */
@Schema(description = "a lon, lat (WGS84, EPSG:4326)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T11:36:21.130Z[GMT]")


public class Coordinates   {
  @JsonProperty("lng")
  private Float lng = null;

  @JsonProperty("lat")
  private Float lat = null;

  @JsonProperty("alt")
  private Float alt = null;

  public Coordinates lng(Float lng) {
    this.lng = lng;
    return this;
  }

  /**
   * Get lng
   * minimum: 0
   * @return lng
   **/
  @Schema(example = "6.169639", required = true, description = "")
      @NotNull

  @DecimalMin("0")  public Float getLng() {
    return lng;
  }

  public void setLng(Float lng) {
    this.lng = lng;
  }

  public Coordinates lat(Float lat) {
    this.lat = lat;
    return this;
  }

  /**
   * Get lat
   * minimum: 0
   * @return lat
   **/
  @Schema(example = "52.253279", required = true, description = "")
      @NotNull

  @DecimalMin("0")  public Float getLat() {
    return lat;
  }

  public void setLat(Float lat) {
    this.lat = lat;
  }

  public Coordinates alt(Float alt) {
    this.alt = alt;
    return this;
  }

  /**
   * altitude, in meters above sea level
   * minimum: 0
   * @return alt
   **/
  @Schema(description = "altitude, in meters above sea level")
  
  @DecimalMin("0")  public Float getAlt() {
    return alt;
  }

  public void setAlt(Float alt) {
    this.alt = alt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coordinates coordinates = (Coordinates) o;
    return Objects.equals(this.lng, coordinates.lng) &&
        Objects.equals(this.lat, coordinates.lat) &&
        Objects.equals(this.alt, coordinates.alt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lng, lat, alt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coordinates {\n");
    
    sb.append("    lng: ").append(toIndentedString(lng)).append("\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    alt: ").append(toIndentedString(alt)).append("\n");
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
