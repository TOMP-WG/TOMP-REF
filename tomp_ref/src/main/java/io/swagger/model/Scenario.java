package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets scenario
 */
public enum Scenario {
  POSTPONED_COMMIT("POSTPONED_COMMIT"),
    DEPOSIT("DEPOSIT"),
    PAY_WHEN_FINISHED("PAY_WHEN_FINISHED"),
    REQUIRE_BOOKING_DATA("REQUIRE_BOOKING_DATA"),
    RETURN_AREA("RETURN_AREA"),
    UPFRONT_PAYMENT("UPFRONT_PAYMENT");

  private String value;

  Scenario(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Scenario fromValue(String text) {
    for (Scenario b : Scenario.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
