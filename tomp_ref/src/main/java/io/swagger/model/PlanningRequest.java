package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Period;
import io.swagger.model.Place;
import io.swagger.model.User;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The data for requesting available leg options
 */
@ApiModel(description = "The data for requesting available leg options")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-10T13:55:00.069Z[GMT]")
public class PlanningRequest extends Period  {
  @JsonProperty("from")
  private Place from = null;

  @JsonProperty("radius")
  private BigDecimal radius = null;

  @JsonProperty("to")
  private Place to = null;

  @JsonProperty("travelers")
  private BigDecimal travelers = null;

  @JsonProperty("useAssets")
  @Valid
  private List<String> useAssets = null;

  @JsonProperty("users")
  @Valid
  private List<User> users = null;

  public PlanningRequest from(Place from) {
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

  public PlanningRequest radius(BigDecimal radius) {
    this.radius = radius;
    return this;
  }

  /**
   * Maximum distance in meters a user wants to travel to reach the travel option
   * @return radius
  **/
  @ApiModelProperty(value = "Maximum distance in meters a user wants to travel to reach the travel option")
  
    @Valid
    public BigDecimal getRadius() {
    return radius;
  }

  public void setRadius(BigDecimal radius) {
    this.radius = radius;
  }

  public PlanningRequest to(Place to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Place getTo() {
    return to;
  }

  public void setTo(Place to) {
    this.to = to;
  }

  public PlanningRequest travelers(BigDecimal travelers) {
    this.travelers = travelers;
    return this;
  }

  /**
   * The number of people that want to travel
   * @return travelers
  **/
  @ApiModelProperty(value = "The number of people that want to travel")
  
    @Valid
    public BigDecimal getTravelers() {
    return travelers;
  }

  public void setTravelers(BigDecimal travelers) {
    this.travelers = travelers;
  }

  public PlanningRequest useAssets(List<String> useAssets) {
    this.useAssets = useAssets;
    return this;
  }

  public PlanningRequest addUseAssetsItem(String useAssetsItem) {
    if (this.useAssets == null) {
      this.useAssets = new ArrayList<String>();
    }
    this.useAssets.add(useAssetsItem);
    return this;
  }

  /**
   * The specific asset(s), the user wishes to receive leg options for
   * @return useAssets
  **/
  @ApiModelProperty(value = "The specific asset(s), the user wishes to receive leg options for")
  
    public List<String> getUseAssets() {
    return useAssets;
  }

  public void setUseAssets(List<String> useAssets) {
    this.useAssets = useAssets;
  }

  public PlanningRequest users(List<User> users) {
    this.users = users;
    return this;
  }

  public PlanningRequest addUsersItem(User usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<User>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanningRequest planningRequest = (PlanningRequest) o;
    return Objects.equals(this.from, planningRequest.from) &&
        Objects.equals(this.radius, planningRequest.radius) &&
        Objects.equals(this.to, planningRequest.to) &&
        Objects.equals(this.travelers, planningRequest.travelers) &&
        Objects.equals(this.useAssets, planningRequest.useAssets) &&
        Objects.equals(this.users, planningRequest.users) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, radius, to, travelers, useAssets, users, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanningRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    radius: ").append(toIndentedString(radius)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    travelers: ").append(toIndentedString(travelers)).append("\n");
    sb.append("    useAssets: ").append(toIndentedString(useAssets)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
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
