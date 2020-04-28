package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AssetClass;
import io.swagger.model.Polygon;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SearchCondition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-24T07:16:19.146Z[GMT]")
public class SearchCondition   {
  @JsonProperty("area")
  private Polygon area = null;

  @JsonProperty("assetClass")
  private AssetClass assetClass = null;

  public SearchCondition area(Polygon area) {
    this.area = area;
    return this;
  }

  /**
   * Get area
   * @return area
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Polygon getArea() {
    return area;
  }

  public void setArea(Polygon area) {
    this.area = area;
  }

  public SearchCondition assetClass(AssetClass assetClass) {
    this.assetClass = assetClass;
    return this;
  }

  /**
   * Get assetClass
   * @return assetClass
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public AssetClass getAssetClass() {
    return assetClass;
  }

  public void setAssetClass(AssetClass assetClass) {
    this.assetClass = assetClass;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchCondition searchCondition = (SearchCondition) o;
    return Objects.equals(this.area, searchCondition.area) &&
        Objects.equals(this.assetClass, searchCondition.assetClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(area, assetClass);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchCondition {\n");
    
    sb.append("    area: ").append(toIndentedString(area)).append("\n");
    sb.append("    assetClass: ").append(toIndentedString(assetClass)).append("\n");
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
