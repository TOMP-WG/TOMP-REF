package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Address;
import io.swagger.model.BookingOption;
import io.swagger.model.BookingState;
import io.swagger.model.Condition;
import io.swagger.model.Customer;
import io.swagger.model.KeyValue;
import io.swagger.model.Token;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The booking information describing the state and details of the transaction
 */
@ApiModel(description = "The booking information describing the state and details of the transaction")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class Booking extends BookingOption  {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("state")
  private BookingState state = null;

  @JsonProperty("conditions")
  @Valid
  private List<Condition> conditions = null;

  @JsonProperty("token")
  private Token token = null;

  @JsonProperty("webhook")
  private String webhook = null;

  @JsonProperty("meta")
  @Valid
  private List<KeyValue> meta = null;

  public Booking id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier MaaS will be using to referring to the booking
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The identifier MaaS will be using to referring to the booking")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Booking state(BookingState state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public BookingState getState() {
    return state;
  }

  public void setState(BookingState state) {
    this.state = state;
  }

  public Booking conditions(List<Condition> conditions) {
    this.conditions = conditions;
    return this;
  }

  public Booking addConditionsItem(Condition conditionsItem) {
    if (this.conditions == null) {
      this.conditions = new ArrayList<Condition>();
    }
    this.conditions.add(conditionsItem);
    return this;
  }

  /**
   * Get conditions
   * @return conditions
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Condition> getConditions() {
    return conditions;
  }

  public void setConditions(List<Condition> conditions) {
    this.conditions = conditions;
  }

  public Booking token(Token token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public Token getToken() {
    return token;
  }

  public void setToken(Token token) {
    this.token = token;
  }

  public Booking webhook(String webhook) {
    this.webhook = webhook;
    return this;
  }

  /**
   * in case this field is used, the webhook ``must`` be used to communicate, even though the URL of cancelling or expiring the booking is derivable.
   * @return webhook
  **/
  @ApiModelProperty(example = "https://myserver.com/booking/{id}/events", value = "in case this field is used, the webhook ``must`` be used to communicate, even though the URL of cancelling or expiring the booking is derivable.")
  
    public String getWebhook() {
    return webhook;
  }

  public void setWebhook(String webhook) {
    this.webhook = webhook;
  }

  public Booking meta(List<KeyValue> meta) {
    this.meta = meta;
    return this;
  }

  public Booking addMetaItem(KeyValue metaItem) {
    if (this.meta == null) {
      this.meta = new ArrayList<KeyValue>();
    }
    this.meta.add(metaItem);
    return this;
  }

  /**
   * Arbitrary metadata that a TO can add
   * @return meta
  **/
  @ApiModelProperty(value = "Arbitrary metadata that a TO can add")
      @Valid
    public List<KeyValue> getMeta() {
    return meta;
  }

  public void setMeta(List<KeyValue> meta) {
    this.meta = meta;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return Objects.equals(this.id, booking.id) &&
        Objects.equals(this.state, booking.state) &&
        Objects.equals(this.conditions, booking.conditions) &&
        Objects.equals(this.token, booking.token) &&
        Objects.equals(this.webhook, booking.webhook) &&
        Objects.equals(this.meta, booking.meta) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, state, conditions, token, webhook, meta, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    webhook: ").append(toIndentedString(webhook)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
