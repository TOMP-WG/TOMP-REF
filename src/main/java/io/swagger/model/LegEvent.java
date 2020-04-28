package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Asset;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * event for the leg
 */
@ApiModel(description = "event for the leg")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class LegEvent   {
  @JsonProperty("time")
  private BigDecimal time = null;

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

  public LegEvent time(BigDecimal time) {
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
    public BigDecimal getTime() {
    return time;
  }

  public void setTime(BigDecimal time) {
    this.time = time;
  }

  public LegEvent event(EventEnum event) {
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

  public LegEvent comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * free text
   * @return comment
  **/
  @ApiModelProperty(value = "free text")
  
    public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public LegEvent asset(Asset asset) {
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
    LegEvent legEvent = (LegEvent) o;
    return Objects.equals(this.time, legEvent.time) &&
        Objects.equals(this.event, legEvent.event) &&
        Objects.equals(this.comment, legEvent.comment) &&
        Objects.equals(this.asset, legEvent.asset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, event, comment, asset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LegEvent {\n");
    
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
