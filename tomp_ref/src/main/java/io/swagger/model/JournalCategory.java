package io.swagger.model;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * ALL and FARE are not allowed to use in the journalEntry object. They are there for filtering purposes in the journal entry endpoint.
 */
public enum JournalCategory {
  ALL("ALL"),
    DAMAGE("DAMAGE"),
    LOSS("LOSS"),
    STOLEN("STOLEN"),
    EXTRA_USAGE("EXTRA_USAGE"),
    REFUND("REFUND"),
    FINE("FINE"),
    OTHER_ASSET_USED("OTHER_ASSET_USED"),
    CREDIT("CREDIT"),
    VOUCHER("VOUCHER"),
    DEPOSIT("DEPOSIT"),
    OTHER("OTHER"),
    FARE("FARE");

  private String value;

  JournalCategory(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static JournalCategory fromValue(String text) {
    for (JournalCategory b : JournalCategory.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
