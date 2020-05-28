package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AmountOfMoney;
import io.swagger.model.BankAccount;
import io.swagger.model.JournalState;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JournalEntry
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class JournalEntry extends AmountOfMoney  {
  @JsonProperty("journalId")
  private String journalId = null;

  @JsonProperty("journalSequenceId")
  private String journalSequenceId = null;

  @JsonProperty("invoiceId")
  private Object invoiceId = null;

  @JsonProperty("invoiceDate")
  private BigDecimal invoiceDate = null;

  @JsonProperty("state")
  private JournalState state = null;

  @JsonProperty("expirationDate")
  private BigDecimal expirationDate = null;

  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("distance")
  private BigDecimal distance = null;

  /**
   * Gets or Sets distanceType
   */
  public enum DistanceTypeEnum {
    KM("KM"),
    
    MILE("MILE");

    private String value;

    DistanceTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DistanceTypeEnum fromValue(String text) {
      for (DistanceTypeEnum b : DistanceTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("distanceType")
  private DistanceTypeEnum distanceType = null;

  @JsonProperty("usedTime")
  private BigDecimal usedTime = null;

  @JsonProperty("bankAccount")
  private BankAccount bankAccount = null;

  @JsonProperty("details")
  private Object details = null;

  public JournalEntry journalId(String journalId) {
    this.journalId = journalId;
    return this;
  }

  /**
   * id of the entry, leg id can be reused
   * @return journalId
  **/
  @ApiModelProperty(value = "id of the entry, leg id can be reused")
  
    public String getJournalId() {
    return journalId;
  }

  public void setJournalId(String journalId) {
    this.journalId = journalId;
  }

  public JournalEntry journalSequenceId(String journalSequenceId) {
    this.journalSequenceId = journalSequenceId;
    return this;
  }

  /**
   * sequence id of the entry, in combination with journalId unique from TO perspective.
   * @return journalSequenceId
  **/
  @ApiModelProperty(value = "sequence id of the entry, in combination with journalId unique from TO perspective.")
  
    public String getJournalSequenceId() {
    return journalSequenceId;
  }

  public void setJournalSequenceId(String journalSequenceId) {
    this.journalSequenceId = journalSequenceId;
  }

  public JournalEntry invoiceId(Object invoiceId) {
    this.invoiceId = invoiceId;
    return this;
  }

  /**
   * the number of the invoice. Should be filled in when invoiced.
   * @return invoiceId
  **/
  @ApiModelProperty(value = "the number of the invoice. Should be filled in when invoiced.")
  
    public Object getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(Object invoiceId) {
    this.invoiceId = invoiceId;
  }

  public JournalEntry invoiceDate(BigDecimal invoiceDate) {
    this.invoiceDate = invoiceDate;
    return this;
  }

  /**
   * Get invoiceDate
   * @return invoiceDate
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(BigDecimal invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public JournalEntry state(JournalState state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public JournalState getState() {
    return state;
  }

  public void setState(JournalState state) {
    this.state = state;
  }

  public JournalEntry expirationDate(BigDecimal expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  /**
   * Get expirationDate
   * @return expirationDate
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(BigDecimal expirationDate) {
    this.expirationDate = expirationDate;
  }

  public JournalEntry comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Get comment
   * @return comment
  **/
  @ApiModelProperty(value = "")
  
    public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public JournalEntry distance(BigDecimal distance) {
    this.distance = distance;
    return this;
  }

  /**
   * the travelled distance. Only if applicable.
   * @return distance
  **/
  @ApiModelProperty(value = "the travelled distance. Only if applicable.")
  
    @Valid
    public BigDecimal getDistance() {
    return distance;
  }

  public void setDistance(BigDecimal distance) {
    this.distance = distance;
  }

  public JournalEntry distanceType(DistanceTypeEnum distanceType) {
    this.distanceType = distanceType;
    return this;
  }

  /**
   * Get distanceType
   * @return distanceType
  **/
  @ApiModelProperty(value = "")
  
    public DistanceTypeEnum getDistanceType() {
    return distanceType;
  }

  public void setDistanceType(DistanceTypeEnum distanceType) {
    this.distanceType = distanceType;
  }

  public JournalEntry usedTime(BigDecimal usedTime) {
    this.usedTime = usedTime;
    return this;
  }

  /**
   * the time in seconds that the assed is used. Only if applicable.
   * @return usedTime
  **/
  @ApiModelProperty(value = "the time in seconds that the assed is used. Only if applicable.")
  
    @Valid
    public BigDecimal getUsedTime() {
    return usedTime;
  }

  public void setUsedTime(BigDecimal usedTime) {
    this.usedTime = usedTime;
  }

  public JournalEntry bankAccount(BankAccount bankAccount) {
    this.bankAccount = bankAccount;
    return this;
  }

  /**
   * Get bankAccount
   * @return bankAccount
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BankAccount getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(BankAccount bankAccount) {
    this.bankAccount = bankAccount;
  }

  public JournalEntry details(Object details) {
    this.details = details;
    return this;
  }

  /**
   * the specification of the amount; how is it composed.
   * @return details
  **/
  @ApiModelProperty(value = "the specification of the amount; how is it composed.")
  
    public Object getDetails() {
    return details;
  }

  public void setDetails(Object details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JournalEntry journalEntry = (JournalEntry) o;
    return Objects.equals(this.journalId, journalEntry.journalId) &&
        Objects.equals(this.journalSequenceId, journalEntry.journalSequenceId) &&
        Objects.equals(this.invoiceId, journalEntry.invoiceId) &&
        Objects.equals(this.invoiceDate, journalEntry.invoiceDate) &&
        Objects.equals(this.state, journalEntry.state) &&
        Objects.equals(this.expirationDate, journalEntry.expirationDate) &&
        Objects.equals(this.comment, journalEntry.comment) &&
        Objects.equals(this.distance, journalEntry.distance) &&
        Objects.equals(this.distanceType, journalEntry.distanceType) &&
        Objects.equals(this.usedTime, journalEntry.usedTime) &&
        Objects.equals(this.bankAccount, journalEntry.bankAccount) &&
        Objects.equals(this.details, journalEntry.details) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(journalId, journalSequenceId, invoiceId, invoiceDate, state, expirationDate, comment, distance, distanceType, usedTime, bankAccount, details, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JournalEntry {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    journalId: ").append(toIndentedString(journalId)).append("\n");
    sb.append("    journalSequenceId: ").append(toIndentedString(journalSequenceId)).append("\n");
    sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
    sb.append("    invoiceDate: ").append(toIndentedString(invoiceDate)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    distanceType: ").append(toIndentedString(distanceType)).append("\n");
    sb.append("    usedTime: ").append(toIndentedString(usedTime)).append("\n");
    sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
