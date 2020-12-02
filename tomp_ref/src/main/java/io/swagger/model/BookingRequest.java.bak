package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Customer;
import io.swagger.model.Place;
import io.swagger.model.PlanningRequest;
import io.swagger.model.Traveler;
import java.math.BigDecimal;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A booking requested by the MP
 */
@ApiModel(description = "A booking requested by the MP")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T14:11:01.002Z[GMT]")


public class BookingRequest extends PlanningRequest  {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("customer")
  private Customer customer = null;

  public BookingRequest id(String id) {
    this.id = id;
    return this;
  }

  /**
   * A unique identifier for the TO to know this booking by, required from the point on where booking-intent is true
   * @return id
  **/
  @ApiModelProperty(value = "A unique identifier for the TO to know this booking by, required from the point on where booking-intent is true")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BookingRequest customer(Customer customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(value = "")

    @Valid
    public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingRequest bookingRequest = (BookingRequest) o;
    return Objects.equals(this.id, bookingRequest.id) &&
        Objects.equals(this.customer, bookingRequest.customer) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customer, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
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
