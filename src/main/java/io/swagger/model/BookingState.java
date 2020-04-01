package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The life-cycle state of the booking (from NEW to FINISHED)
 */
public enum BookingState {
  NEW("NEW"),
    PENDING("PENDING"),
    RELEASED("RELEASED"),
    EXPIRED("EXPIRED"),
    CONDITIONAL_CONFIRMED("CONDITIONAL_CONFIRMED"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED"),
    STARTED("STARTED"),
    FINISHED("FINISHED");

  private String value;

  BookingState(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BookingState fromValue(String text) {
    for (BookingState b : BookingState.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
