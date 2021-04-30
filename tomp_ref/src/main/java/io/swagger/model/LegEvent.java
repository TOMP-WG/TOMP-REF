package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Asset;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * event for the execution
 */
@Schema(description = "event for the execution")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-26T08:47:05.979Z[GMT]")


public class LegEvent   {
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
    
    TIME_EXTEND("TIME_EXTEND"),
    
    TIME_POSTPONE("TIME_POSTPONE"),
    
    CANCEL("CANCEL");

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

  @JsonProperty("url")
  @Valid
  private List<String> url = null;

  @JsonProperty("asset")
  private Asset asset = null;

  public LegEvent time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
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
  @Schema(required = true, description = "")
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

  public LegEvent url(List<String> url) {
    this.url = url;
    return this;
  }

  public LegEvent addUrlItem(String urlItem) {
    if (this.url == null) {
      this.url = new ArrayList<String>();
    }
    this.url.add(urlItem);
    return this;
  }

  /**
   * urls to support the event e.g. pictures justifying the exit conditions
   * @return url
   **/
  @Schema(description = "urls to support the event e.g. pictures justifying the exit conditions")
  
    public List<String> getUrl() {
    return url;
  }

  public void setUrl(List<String> url) {
    this.url = url;
  }

  public LegEvent asset(Asset asset) {
    this.asset = asset;
    return this;
  }

  /**
   * Get asset
   * @return asset
   **/
  @Schema(description = "")
  
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
        Objects.equals(this.url, legEvent.url) &&
        Objects.equals(this.asset, legEvent.asset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, event, comment, url, asset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LegEvent {\n");
    
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
