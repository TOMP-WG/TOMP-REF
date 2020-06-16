package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Asset;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * event for the execution
 */
@ApiModel(description = "event for the execution")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-10T13:55:00.069Z[GMT]")
public class ExecutionEvent   {
  @JsonProperty("time")
  private OffsetDateTime time = null;

  /**
   * Gets or Sets event
   */
  public enum EventEnum {
    PREPARE("PREPARE"),
    
    ASSIGN_ASSET("ASSIGN_ASSET"),
    
    SET_IN_USE("SET_IN_USE"),
    
    PAUSE("PAUSE"),
    
    START_FINISHING("START_FINISHING"),
    
    FINISH("FINISH"),
    
    ISSUE("ISSUE");

    private String value;

    EventEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EventEnum fromValue(String text) {
      for (EventEnum b : EventEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("event")
  private EventEnum event = null;

  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("asset")
  private Asset asset = null;

  public ExecutionEvent time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public ExecutionEvent event(EventEnum event) {
    this.event = event;
    return this;
  }

  /**
   * Get event
   * @return event
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public EventEnum getEvent() {
    return event;
  }

  public void setEvent(EventEnum event) {
    this.event = event;
  }

  public ExecutionEvent comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * free text, should match Content-Language
   * @return comment
  **/
  @ApiModelProperty(value = "free text, should match Content-Language")
  
    public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public ExecutionEvent asset(Asset asset) {
    this.asset = asset;
    return this;
  }

  /**
   * Get asset
   * @return asset
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Asset getAsset() {
    return asset;
  }

  public void setAsset(Asset asset) {
    this.asset = asset;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExecutionEvent executionEvent = (ExecutionEvent) o;
    return Objects.equals(this.time, executionEvent.time) &&
        Objects.equals(this.event, executionEvent.event) &&
        Objects.equals(this.comment, executionEvent.comment) &&
        Objects.equals(this.asset, executionEvent.asset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, event, comment, asset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExecutionEvent {\n");
    
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
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