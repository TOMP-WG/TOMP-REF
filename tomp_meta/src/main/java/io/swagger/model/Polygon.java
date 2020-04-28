package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Coordinates;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Polygon
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-24T07:16:19.146Z[GMT]")
public class Polygon   {
  @JsonProperty("points")
  @Valid
  private List<Coordinates> points = null;

  public Polygon points(List<Coordinates> points) {
    this.points = points;
    return this;
  }

  public Polygon addPointsItem(Coordinates pointsItem) {
    if (this.points == null) {
      this.points = new ArrayList<Coordinates>();
    }
    this.points.add(pointsItem);
    return this;
  }

  /**
   * Get points
   * @return points
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Coordinates> getPoints() {
    return points;
  }

  public void setPoints(List<Coordinates> points) {
    this.points = points;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Polygon polygon = (Polygon) o;
    return Objects.equals(this.points, polygon.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(points);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Polygon {\n");
    
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
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
