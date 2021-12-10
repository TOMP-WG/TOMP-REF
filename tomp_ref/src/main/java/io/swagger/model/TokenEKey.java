package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.TokenData;
import io.swagger.model.TokenEKeyEkey;
import io.swagger.model.TokenEKeyLock;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Axa EKey information
 */
@Schema(description = "Axa EKey information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T11:36:21.130Z[GMT]")


public class TokenEKey extends TokenData implements OneOftokenTokenData {
  @JsonProperty("ekey")
  private TokenEKeyEkey ekey = null;

  @JsonProperty("lock")
  private TokenEKeyLock lock = null;

  public TokenEKey ekey(TokenEKeyEkey ekey) {
    this.ekey = ekey;
    return this;
  }

  /**
   * Get ekey
   * @return ekey
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TokenEKeyEkey getEkey() {
    return ekey;
  }

  public void setEkey(TokenEKeyEkey ekey) {
    this.ekey = ekey;
  }

  public TokenEKey lock(TokenEKeyLock lock) {
    this.lock = lock;
    return this;
  }

  /**
   * Get lock
   * @return lock
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TokenEKeyLock getLock() {
    return lock;
  }

  public void setLock(TokenEKeyLock lock) {
    this.lock = lock;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenEKey tokenEKey = (TokenEKey) o;
    return Objects.equals(this.ekey, tokenEKey.ekey) &&
        Objects.equals(this.lock, tokenEKey.lock) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ekey, lock, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenEKey {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    ekey: ").append(toIndentedString(ekey)).append("\n");
    sb.append("    lock: ").append(toIndentedString(lock)).append("\n");
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
