package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Coordinate;
import io.swagger.model.Period;
import io.swagger.model.User;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * the request for available assets. User&#x27;s location in comma separated form e.g. 60.123,27.456 (lat/long, WGS84)
 */
@ApiModel(description = "the request for available assets. User's location in comma separated form e.g. 60.123,27.456 (lat/long, WGS84)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
public class PlanningCheck extends Period  {
  @JsonProperty("from")
  private Coordinate from = null;

  @JsonProperty("radius")
  private BigDecimal radius = null;

  @JsonProperty("to")
  private Coordinate to = null;

  @JsonProperty("travellers")
  private BigDecimal travellers = null;

  @JsonProperty("use-asset")
  private String useAsset = null;

  @JsonProperty("provide-ids")
  private Boolean provideIds = null;

  @JsonProperty("users")
  @Valid
  private List<User> users = null;

  public PlanningCheck from(Coordinate from) {
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
    public Coordinate getFrom() {
    return from;
  }

  public void setFrom(Coordinate from) {
    this.from = from;
  }

  public PlanningCheck radius(BigDecimal radius) {
    this.radius = radius;
    return this;
  }

  /**
   * Maximum distance a user wants to travel to reach asset in metres, e.g. 500 metres
   * @return radius
  **/
  @ApiModelProperty(value = "Maximum distance a user wants to travel to reach asset in metres, e.g. 500 metres")
  
    @Valid
    public BigDecimal getRadius() {
    return radius;
  }

  public void setRadius(BigDecimal radius) {
    this.radius = radius;
  }

  public PlanningCheck to(Coordinate to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Coordinate getTo() {
    return to;
  }

  public void setTo(Coordinate to) {
    this.to = to;
  }

  public PlanningCheck travellers(BigDecimal travellers) {
    this.travellers = travellers;
    return this;
  }

  /**
   * the amount of people that have to travel from `from` to `to` [https://github.com/efel85/TOMP-API/issues/56]
   * @return travellers
  **/
  @ApiModelProperty(value = "the amount of people that have to travel from `from` to `to` [https://github.com/efel85/TOMP-API/issues/56]")
  
    @Valid
    public BigDecimal getTravellers() {
    return travellers;
  }

  public void setTravellers(BigDecimal travellers) {
    this.travellers = travellers;
  }

  public PlanningCheck useAsset(String useAsset) {
    this.useAsset = useAsset;
    return this;
  }

  /**
   * when you use the /operator/available-assets and you want to book a displayed asset, you must be able to request o a planning-option for the specific asset (with provide-ids=true), post a booking with the provided id and send directly a commit. This field should contain the asset to book.
   * @return useAsset
  **/
  @ApiModelProperty(value = "when you use the /operator/available-assets and you want to book a displayed asset, you must be able to request o a planning-option for the specific asset (with provide-ids=true), post a booking with the provided id and send directly a commit. This field should contain the asset to book.")
  
    public String getUseAsset() {
    return useAsset;
  }

  public void setUseAsset(String useAsset) {
    this.useAsset = useAsset;
  }

  public PlanningCheck provideIds(Boolean provideIds) {
    this.provideIds = provideIds;
    return this;
  }

  /**
   * default false (during planning phase). Whenever entering the booking phase to present the options to the user, set it to true to refert to this option. The returned ID can be used througout the complete process. [https://github.com/efel85/TOMP-API/issues/57]
   * @return provideIds
  **/
  @ApiModelProperty(value = "default false (during planning phase). Whenever entering the booking phase to present the options to the user, set it to true to refert to this option. The returned ID can be used througout the complete process. [https://github.com/efel85/TOMP-API/issues/57]")
  
    public Boolean isProvideIds() {
    return provideIds;
  }

  public void setProvideIds(Boolean provideIds) {
    this.provideIds = provideIds;
  }

  public PlanningCheck users(List<User> users) {
    this.users = users;
    return this;
  }

  public PlanningCheck addUsersItem(User usersItem) {
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
    PlanningCheck planningCheck = (PlanningCheck) o;
    return Objects.equals(this.from, planningCheck.from) &&
        Objects.equals(this.radius, planningCheck.radius) &&
        Objects.equals(this.to, planningCheck.to) &&
        Objects.equals(this.travellers, planningCheck.travellers) &&
        Objects.equals(this.useAsset, planningCheck.useAsset) &&
        Objects.equals(this.provideIds, planningCheck.provideIds) &&
        Objects.equals(this.users, planningCheck.users) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, radius, to, travellers, useAsset, provideIds, users, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanningCheck {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    radius: ").append(toIndentedString(radius)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    travellers: ").append(toIndentedString(travellers)).append("\n");
    sb.append("    useAsset: ").append(toIndentedString(useAsset)).append("\n");
    sb.append("    provideIds: ").append(toIndentedString(provideIds)).append("\n");
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
