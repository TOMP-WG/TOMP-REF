package io.swagger.model;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Arbitrary data the TO may pass along the ticket to the client (e.g. a booking code, base64 encoded binary, QR code), later will be one of several types
 */
@Schema(description = "Arbitrary data the TO may pass along the ticket to the client (e.g. a booking code, base64 encoded binary, QR code), later will be one of several types")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-28T07:34:31.139Z[GMT]")


public class TokenDefault extends HashMap<String, Object> implements OneOftokenTokenData {

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenDefault {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
