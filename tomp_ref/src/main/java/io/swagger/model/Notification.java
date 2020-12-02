package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * notifies the MaaS operator of issues with a booking [addendum]
 */
@Schema(description = "notifies the MaaS operator of issues with a booking [addendum]")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class Notification   {
  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    VEHICLE_NOT_AVAILABLE("VEHICLE_NOT_AVAILABLE"),
    
    USER_NO_SHOW("USER_NO_SHOW"),
    
    ETA("ETA"),
    
    MESSAGE_TO_DRIVER("MESSAGE_TO_DRIVER"),
    
    MESSAGE_TO_END_USER("MESSAGE_TO_END_USER"),
    
    OTHER("OTHER");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("minutes")
  private BigDecimal minutes = null;

  @JsonProperty("comment")
  private String comment = null;

  public Notification type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(example = "VEHICLE_NOT_AVAILABLE", required = true, description = "")
      @NotNull

    public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Notification minutes(BigDecimal minutes) {
    this.minutes = minutes;
    return this;
  }

  /**
   * in case of ETA, the number of minutes until arrival at the pickup location
   * @return minutes
   **/
  @Schema(description = "in case of ETA, the number of minutes until arrival at the pickup location")
  
    @Valid
    public BigDecimal getMinutes() {
    return minutes;
  }

  public void setMinutes(BigDecimal minutes) {
    this.minutes = minutes;
  }

  public Notification comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * free text, should match Content-Language
   * @return comment
   **/
  @Schema(description = "free text, should match Content-Language")
  
    public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Notification notification = (Notification) o;
    return Objects.equals(this.type, notification.type) &&
        Objects.equals(this.minutes, notification.minutes) &&
        Objects.equals(this.comment, notification.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, minutes, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notification {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    minutes: ").append(toIndentedString(minutes)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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
