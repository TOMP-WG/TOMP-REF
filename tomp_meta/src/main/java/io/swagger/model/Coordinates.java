package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * a lon, lat (WGS84, EPSG:4326)
 */
@ApiModel(description = "a lon, lat (WGS84, EPSG:4326)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-24T07:16:19.146Z[GMT]")
public class Coordinates   {
  @JsonProperty("lng")
  private BigDecimal lng = null;

  @JsonProperty("lat")
  private BigDecimal lat = null;

  public Coordinates lng(BigDecimal lng) {
    this.lng = lng;
    return this;
  }

  /**
   * Get lng
   * @return lng
  **/
  @ApiModelProperty(example = "6.169639", value = "")
  
    @Valid
    public BigDecimal getLng() {
    return lng;
  }

  public void setLng(BigDecimal lng) {
    this.lng = lng;
  }

  public Coordinates lat(BigDecimal lat) {
    this.lat = lat;
    return this;
  }

  /**
   * Get lat
   * @return lat
  **/
  @ApiModelProperty(example = "52.253279", value = "")
  
    @Valid
    public BigDecimal getLat() {
    return lat;
  }

  public void setLat(BigDecimal lat) {
    this.lat = lat;
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
        Objects.equals(this.lat, coordinates.lat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lng, lat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coordinates {\n");
    
    sb.append("    lng: ").append(toIndentedString(lng)).append("\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
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
