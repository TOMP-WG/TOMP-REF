package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProcessIdentifiers
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-30T14:11:18.823Z[GMT]")
public class ProcessIdentifiers   {
  @JsonProperty("operatorInformation")
  @Valid
  private List<String> operatorInformation = new ArrayList<String>();

  @JsonProperty("planning")
  @Valid
  private List<String> planning = new ArrayList<String>();

  @JsonProperty("booking")
  @Valid
  private List<String> booking = new ArrayList<String>();

  @JsonProperty("tripExecution")
  @Valid
  private List<String> tripExecution = new ArrayList<String>();

  @JsonProperty("support")
  @Valid
  private List<String> support = new ArrayList<String>();

  @JsonProperty("payment")
  @Valid
  private List<String> payment = new ArrayList<String>();

  @JsonProperty("general")
  @Valid
  private List<String> general = new ArrayList<String>();

  public ProcessIdentifiers operatorInformation(List<String> operatorInformation) {
    this.operatorInformation = operatorInformation;
    return this;
  }

  public ProcessIdentifiers addOperatorInformationItem(String operatorInformationItem) {
    this.operatorInformation.add(operatorInformationItem);
    return this;
  }

  /**
   * Get operatorInformation
   * @return operatorInformation
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public List<String> getOperatorInformation() {
    return operatorInformation;
  }

  public void setOperatorInformation(List<String> operatorInformation) {
    this.operatorInformation = operatorInformation;
  }

  public ProcessIdentifiers planning(List<String> planning) {
    this.planning = planning;
    return this;
  }

  public ProcessIdentifiers addPlanningItem(String planningItem) {
    this.planning.add(planningItem);
    return this;
  }

  /**
   * Get planning
   * @return planning
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public List<String> getPlanning() {
    return planning;
  }

  public void setPlanning(List<String> planning) {
    this.planning = planning;
  }

  public ProcessIdentifiers booking(List<String> booking) {
    this.booking = booking;
    return this;
  }

  public ProcessIdentifiers addBookingItem(String bookingItem) {
    this.booking.add(bookingItem);
    return this;
  }

  /**
   * Get booking
   * @return booking
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public List<String> getBooking() {
    return booking;
  }

  public void setBooking(List<String> booking) {
    this.booking = booking;
  }

  public ProcessIdentifiers tripExecution(List<String> tripExecution) {
    this.tripExecution = tripExecution;
    return this;
  }

  public ProcessIdentifiers addTripExecutionItem(String tripExecutionItem) {
    this.tripExecution.add(tripExecutionItem);
    return this;
  }

  /**
   * Get tripExecution
   * @return tripExecution
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public List<String> getTripExecution() {
    return tripExecution;
  }

  public void setTripExecution(List<String> tripExecution) {
    this.tripExecution = tripExecution;
  }

  public ProcessIdentifiers support(List<String> support) {
    this.support = support;
    return this;
  }

  public ProcessIdentifiers addSupportItem(String supportItem) {
    this.support.add(supportItem);
    return this;
  }

  /**
   * Get support
   * @return support
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public List<String> getSupport() {
    return support;
  }

  public void setSupport(List<String> support) {
    this.support = support;
  }

  public ProcessIdentifiers payment(List<String> payment) {
    this.payment = payment;
    return this;
  }

  public ProcessIdentifiers addPaymentItem(String paymentItem) {
    this.payment.add(paymentItem);
    return this;
  }

  /**
   * Get payment
   * @return payment
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public List<String> getPayment() {
    return payment;
  }

  public void setPayment(List<String> payment) {
    this.payment = payment;
  }

  public ProcessIdentifiers general(List<String> general) {
    this.general = general;
    return this;
  }

  public ProcessIdentifiers addGeneralItem(String generalItem) {
    this.general.add(generalItem);
    return this;
  }

  /**
   * Get general
   * @return general
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public List<String> getGeneral() {
    return general;
  }

  public void setGeneral(List<String> general) {
    this.general = general;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessIdentifiers processIdentifiers = (ProcessIdentifiers) o;
    return Objects.equals(this.operatorInformation, processIdentifiers.operatorInformation) &&
        Objects.equals(this.planning, processIdentifiers.planning) &&
        Objects.equals(this.booking, processIdentifiers.booking) &&
        Objects.equals(this.tripExecution, processIdentifiers.tripExecution) &&
        Objects.equals(this.support, processIdentifiers.support) &&
        Objects.equals(this.payment, processIdentifiers.payment) &&
        Objects.equals(this.general, processIdentifiers.general);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operatorInformation, planning, booking, tripExecution, support, payment, general);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessIdentifiers {\n");
    
    sb.append("    operatorInformation: ").append(toIndentedString(operatorInformation)).append("\n");
    sb.append("    planning: ").append(toIndentedString(planning)).append("\n");
    sb.append("    booking: ").append(toIndentedString(booking)).append("\n");
    sb.append("    tripExecution: ").append(toIndentedString(tripExecution)).append("\n");
    sb.append("    support: ").append(toIndentedString(support)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    general: ").append(toIndentedString(general)).append("\n");
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
