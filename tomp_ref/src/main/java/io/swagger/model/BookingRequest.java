package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A booking requested by the MP
 */
@Schema(description = "A booking requested by the MP")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")

public class BookingRequest {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("from")
	private Place from = null;

	@JsonProperty("to")
	private Place to = null;

	@JsonProperty("customer")
	private Customer customer = null;

	public BookingRequest id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * A unique identifier for the TO to know this booking by
	 * 
	 * @return id
	 **/
	@Schema(description = "A unique identifier for the TO to know this booking by")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BookingRequest from(Place from) {
		this.from = from;
		return this;
	}

	/**
	 * information about the origin, only to supply when requested in the
	 * conditionRequireBookingData
	 * 
	 * @return from
	 **/
	@Schema(description = "information about the origin, only to supply when requested in the conditionRequireBookingData")

	public Place getFrom() {
		return from;
	}

	public void setFrom(Place from) {
		this.from = from;
	}

	public BookingRequest to(Place to) {
		this.to = to;
		return this;
	}

	/**
	 * information about the destination, only to supply when requested in the
	 * conditionRequireBookingData
	 * 
	 * @return to
	 **/
	@Schema(description = "information about the destination, only to supply when requested in the conditionRequireBookingData")

	public Place getTo() {
		return to;
	}

	public void setTo(Place to) {
		this.to = to;
	}

	public BookingRequest customer(Customer customer) {
		this.customer = customer;
		return this;
	}

	/**
	 * The user that wants to make this booking, only to supply when requested in
	 * the conditionRequireBookingData
	 * 
	 * @return customer
	 **/
	@Schema(description = "The user that wants to make this booking, only to supply when requested in the conditionRequireBookingData")

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
		return Objects.equals(this.id, bookingRequest.id) && Objects.equals(this.from, bookingRequest.from)
				&& Objects.equals(this.to, bookingRequest.to) && Objects.equals(this.customer, bookingRequest.customer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, from, to, customer);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BookingRequest {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    from: ").append(toIndentedString(from)).append("\n");
		sb.append("    to: ").append(toIndentedString(to)).append("\n");
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
