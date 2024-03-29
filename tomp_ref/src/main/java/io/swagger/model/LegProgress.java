package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Coordinates;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * provides current asset location &amp; duration and distance of the current leg
 */
@Schema(description = "provides current asset location & duration and distance of the current leg")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class LegProgress   {
  @JsonProperty("coordinates")
  private Coordinates coordinates = null;

  @JsonProperty("duration")
  private Integer duration = null;

  @JsonProperty("distance")
  private Integer distance = null;

  public LegProgress coordinates(Coordinates coordinates) {
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

  public LegProgress duration(Integer duration) {
    this.duration = duration;
    return this;
  }

  /**
   * A duration of some time (relative to a time) in milliseconds
   * minimum: 0
   * maximum: 2147483647
   * @return duration
   **/
  @Schema(example = "11112", description = "A duration of some time (relative to a time) in milliseconds")
  
  @Min(0) @Max(2147483647)   public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public LegProgress distance(Integer distance) {
    this.distance = distance;
    return this;
  }

  /**
   * The estimated distance travelled in the leg (in meters)
   * minimum: 0
   * @return distance
   **/
  @Schema(example = "7250", description = "The estimated distance travelled in the leg (in meters)")
  
  @Min(0)  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LegProgress legProgress = (LegProgress) o;
    return Objects.equals(this.coordinates, legProgress.coordinates) &&
        Objects.equals(this.duration, legProgress.duration) &&
        Objects.equals(this.distance, legProgress.distance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coordinates, duration, distance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LegProgress {\n");
    
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
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
