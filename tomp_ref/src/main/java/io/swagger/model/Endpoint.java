package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * a formal description of an endpoint.
 */
@ApiModel(description = "a formal description of an endpoint.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T14:20:13.675Z[GMT]")


public class Endpoint   {
  /**
   * Gets or Sets method
   */
  public enum MethodEnum {
    POST("POST"),
    
    PUT("PUT"),
    
    GET("GET"),
    
    DELETE("DELETE"),
    
    PATCH("PATCH");

    private String value;

    MethodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MethodEnum fromValue(String text) {
      for (MethodEnum b : MethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("method")
  private MethodEnum method = null;

  @JsonProperty("path")
  private String path = null;

  /**
   * in case the path is ending in /events, the event type/operator enum should be added here.
   */
  public enum EventTypeEnum {
    PREPARE("PREPARE"),
    
    ASSIGN_ASSET("ASSIGN_ASSET"),
    
    SET_IN_USE("SET_IN_USE"),
    
    PAUSE("PAUSE"),
    
    START_FINISHING("START_FINISHING"),
    
    FINISH("FINISH"),
    
    ISSUE("ISSUE"),
    
    CANCEL("CANCEL"),
    
    EXPIRE("EXPIRE"),
    
    DENY("DENY"),
    
    COMMIT("COMMIT");

    private String value;

    EventTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EventTypeEnum fromValue(String text) {
      for (EventTypeEnum b : EventTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("eventType")
  private EventTypeEnum eventType = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    NOT_IMPLEMENTED("NOT_IMPLEMENTED"),
    
    DIALECT("DIALECT"),
    
    IMPLEMENTED("IMPLEMENTED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  public Endpoint method(MethodEnum method) {
    this.method = method;
    return this;
  }

  /**
   * Get method
   * @return method
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public MethodEnum getMethod() {
    return method;
  }

  public void setMethod(MethodEnum method) {
    this.method = method;
  }

  public Endpoint path(String path) {
    this.path = path;
    return this;
  }

  /**
   * the exact path of the endpoint, starting after the base URL
   * @return path
  **/
  @ApiModelProperty(example = "/planning-options/", required = true, value = "the exact path of the endpoint, starting after the base URL")
      @NotNull

    public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Endpoint eventType(EventTypeEnum eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * in case the path is ending in /events, the event type/operator enum should be added here.
   * @return eventType
  **/
  @ApiModelProperty(value = "in case the path is ending in /events, the event type/operator enum should be added here.")
  
    public EventTypeEnum getEventType() {
    return eventType;
  }

  public void setEventType(EventTypeEnum eventType) {
    this.eventType = eventType;
  }

  public Endpoint status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Endpoint endpoint = (Endpoint) o;
    return Objects.equals(this.method, endpoint.method) &&
        Objects.equals(this.path, endpoint.path) &&
        Objects.equals(this.eventType, endpoint.eventType) &&
        Objects.equals(this.status, endpoint.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, path, eventType, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Endpoint {\n");
    
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
