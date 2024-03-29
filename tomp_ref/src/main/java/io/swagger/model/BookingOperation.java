package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * operation on the bookingOption
 */
@Schema(description = "operation on the bookingOption")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-26T08:47:05.979Z[GMT]")


public class BookingOperation   {
  /**
   * Gets or Sets operation
   */
  public enum OperationEnum {
    CANCEL("CANCEL"),
    
    EXPIRE("EXPIRE"),
    
    DENY("DENY"),
    
    COMMIT("COMMIT");

    private String value;

    OperationEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OperationEnum fromValue(String text) {
      for (OperationEnum b : OperationEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("operation")
  private OperationEnum operation = null;

  /**
   * This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking for me); to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending, this field should contain \"MP\". And in case the TO is sending, \"TO\".
   */
  public enum OriginEnum {
    TO("TO"),
    
    MP("MP"),
    
    END_USER("END_USER"),
    
    OTHER("OTHER");

    private String value;

    OriginEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OriginEnum fromValue(String text) {
      for (OriginEnum b : OriginEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("origin")
  private OriginEnum origin = null;

  public BookingOperation operation(OperationEnum operation) {
    this.operation = operation;
    return this;
  }

  /**
   * Get operation
   * @return operation
   **/
  @Schema(required = true, description = "")
      @NotNull

    public OperationEnum getOperation() {
    return operation;
  }

  public void setOperation(OperationEnum operation) {
    this.operation = operation;
  }

  public BookingOperation origin(OriginEnum origin) {
    this.origin = origin;
    return this;
  }

  /**
   * This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking for me); to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending, this field should contain \"MP\". And in case the TO is sending, \"TO\".
   * @return origin
   **/
  @Schema(description = "This operation can be done on behalf of another party. The MP can act on behalf of the END_USER (cancel this booking for me); to override the default origin. In case this field is missing, it must be assumed that the events the MP is sending, this field should contain \"MP\". And in case the TO is sending, \"TO\".")
  
    public OriginEnum getOrigin() {
    return origin;
  }

  public void setOrigin(OriginEnum origin) {
    this.origin = origin;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingOperation bookingOperation = (BookingOperation) o;
    return Objects.equals(this.operation, bookingOperation.operation) &&
        Objects.equals(this.origin, bookingOperation.origin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operation, origin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingOperation {\n");
    
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
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
