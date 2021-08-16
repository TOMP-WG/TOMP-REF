package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.TokenData;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * QR information
 */
@Schema(description = "QR information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-28T07:34:31.139Z[GMT]")


public class TokenQR extends TokenData  {
  @JsonProperty("base64")
  private String base64 = null;

  @JsonProperty("version")
  private String version = null;

  public TokenQR base64(String base64) {
    this.base64 = base64;
    return this;
  }

  /**
   * base 64 QR code
   * @return base64
   **/
  @Schema(required = true, description = "base 64 QR code")
      @NotNull

    public String getBase64() {
    return base64;
  }

  public void setBase64(String base64) {
    this.base64 = base64;
  }

  public TokenQR version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   **/
  @Schema(description = "")
  
    public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenQR tokenQR = (TokenQR) o;
    return Objects.equals(this.base64, tokenQR.base64) &&
        Objects.equals(this.version, tokenQR.version) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(base64, version, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenQR {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    base64: ").append(toIndentedString(base64)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
