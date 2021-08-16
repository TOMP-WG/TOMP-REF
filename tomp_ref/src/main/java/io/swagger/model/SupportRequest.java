package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Place;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * request for support
 */
@Schema(description = "request for support")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class SupportRequest   {
  @JsonProperty("id")
  private String id = null;

  /**
   * Gets or Sets supportType
   */
  public enum SupportTypeEnum {
    BROKEN_DOWN("BROKEN_DOWN"),
    
    NOT_AT_LOCATION("NOT_AT_LOCATION"),
    
    MISSING_AFTER_PAUSE("MISSING_AFTER_PAUSE"),
    
    NOT_CLEAN("NOT_CLEAN"),
    
    NOT_AVAILABLE("NOT_AVAILABLE"),
    
    UNABLE_TO_OPEN("UNABLE_TO_OPEN"),
    
    UNABLE_TO_CLOSE("UNABLE_TO_CLOSE"),
    
    API_TECHNICAL("API_TECHNICAL"),
    
    API_FUNCTIONAL("API_FUNCTIONAL"),
    
    ACCIDENT("ACCIDENT"),
    
    OTHER("OTHER");

    private String value;

    SupportTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SupportTypeEnum fromValue(String text) {
      for (SupportTypeEnum b : SupportTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("supportType")
  private SupportTypeEnum supportType = null;

  @JsonProperty("location")
  private Place location = null;

  @JsonProperty("time")
  private OffsetDateTime time = null;

  /**
   * the priority of the support request.
   */
  public enum PriorityEnum {
    ERROR_CANNOT_CONTINUE("ERROR_CANNOT_CONTINUE"),
    
    ERROR_CAN_CONTINUE("ERROR_CAN_CONTINUE"),
    
    DISTURBING_ISSUE("DISTURBING_ISSUE"),
    
    QUESTION("QUESTION"),
    
    OTHER("OTHER");

    private String value;

    PriorityEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PriorityEnum fromValue(String text) {
      for (PriorityEnum b : PriorityEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("priority")
  private PriorityEnum priority = null;

  @JsonProperty("contactInformationEndUser")
  private String contactInformationEndUser = null;

  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("requestedResponseTime")
  private BigDecimal requestedResponseTime = null;

  public SupportRequest id(String id) {
    this.id = id;
    return this;
  }

  /**
   * the booking id
   * @return id
   **/
  @Schema(description = "the booking id")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SupportRequest supportType(SupportTypeEnum supportType) {
    this.supportType = supportType;
    return this;
  }

  /**
   * Get supportType
   * @return supportType
   **/
  @Schema(description = "")
  
    public SupportTypeEnum getSupportType() {
    return supportType;
  }

  public void setSupportType(SupportTypeEnum supportType) {
    this.supportType = supportType;
  }

  public SupportRequest location(Place location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @Schema(description = "")
  
    @Valid
    public Place getLocation() {
    return location;
  }

  public void setLocation(Place location) {
    this.location = location;
  }

  public SupportRequest time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public SupportRequest priority(PriorityEnum priority) {
    this.priority = priority;
    return this;
  }

  /**
   * the priority of the support request.
   * @return priority
   **/
  @Schema(description = "the priority of the support request.")
  
    public PriorityEnum getPriority() {
    return priority;
  }

  public void setPriority(PriorityEnum priority) {
    this.priority = priority;
  }

  public SupportRequest contactInformationEndUser(String contactInformationEndUser) {
    this.contactInformationEndUser = contactInformationEndUser;
    return this;
  }

  /**
   * contact information of the end user in case of direct response requests, like phone number
   * @return contactInformationEndUser
   **/
  @Schema(description = "contact information of the end user in case of direct response requests, like phone number")
  
    public String getContactInformationEndUser() {
    return contactInformationEndUser;
  }

  public void setContactInformationEndUser(String contactInformationEndUser) {
    this.contactInformationEndUser = contactInformationEndUser;
  }

  public SupportRequest comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Get comment
   * @return comment
   **/
  @Schema(description = "")
  
    public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public SupportRequest requestedResponseTime(BigDecimal requestedResponseTime) {
    this.requestedResponseTime = requestedResponseTime;
    return this;
  }

  /**
   * time to respond in minutes.
   * @return requestedResponseTime
   **/
  @Schema(description = "time to respond in minutes.")
  
    @Valid
    public BigDecimal getRequestedResponseTime() {
    return requestedResponseTime;
  }

  public void setRequestedResponseTime(BigDecimal requestedResponseTime) {
    this.requestedResponseTime = requestedResponseTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SupportRequest supportRequest = (SupportRequest) o;
    return Objects.equals(this.id, supportRequest.id) &&
        Objects.equals(this.supportType, supportRequest.supportType) &&
        Objects.equals(this.location, supportRequest.location) &&
        Objects.equals(this.time, supportRequest.time) &&
        Objects.equals(this.priority, supportRequest.priority) &&
        Objects.equals(this.contactInformationEndUser, supportRequest.contactInformationEndUser) &&
        Objects.equals(this.comment, supportRequest.comment) &&
        Objects.equals(this.requestedResponseTime, supportRequest.requestedResponseTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, supportType, location, time, priority, contactInformationEndUser, comment, requestedResponseTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SupportRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    supportType: ").append(toIndentedString(supportType)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    contactInformationEndUser: ").append(toIndentedString(contactInformationEndUser)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    requestedResponseTime: ").append(toIndentedString(requestedResponseTime)).append("\n");
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
