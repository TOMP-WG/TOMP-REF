package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets maasEnvironmentType
 */
public enum MaasEnvironmentType {
  TO("TO"),
    MP("MP"),
    LOOKUP_SERVICE("LOOKUP_SERVICE"),
    TP("TP"),
    VAULT("VAULT"),
    DATA_DRAIN("DATA_DRAIN");

  private String value;

  MaasEnvironmentType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static MaasEnvironmentType fromValue(String text) {
    for (MaasEnvironmentType b : MaasEnvironmentType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
