package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * status of a leg execution
 */
public enum ExecutionState {
  NOT_STARTED("NOT_STARTED"),
    PREPARING("PREPARING"),
    IN_USE("IN_USE"),
    PAUSED("PAUSED"),
    FINISHING("FINISHING"),
    FINISHED("FINISHED"),
    ISSUE_REPORTED("ISSUE_REPORTED");

  private String value;

  ExecutionState(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ExecutionState fromValue(String text) {
    for (ExecutionState b : ExecutionState.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
