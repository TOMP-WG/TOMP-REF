package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TokenEKeyEkey
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-26T08:47:05.979Z[GMT]")


public class TokenEKeyEkey   {
  @JsonProperty("key")
  private String key = null;

  @JsonProperty("passkey")
  private String passkey = null;

  public TokenEKeyEkey key(String key) {
    this.key = key;
    return this;
  }

  /**
   * certificate
   * @return key
   **/
  @Schema(description = "certificate")
  
    public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public TokenEKeyEkey passkey(String passkey) {
    this.passkey = passkey;
    return this;
  }

  /**
   * one time pass key
   * @return passkey
   **/
  @Schema(description = "one time pass key")
  
    public String getPasskey() {
    return passkey;
  }

  public void setPasskey(String passkey) {
    this.passkey = passkey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenEKeyEkey tokenEKeyEkey = (TokenEKeyEkey) o;
    return Objects.equals(this.key, tokenEKeyEkey.key) &&
        Objects.equals(this.passkey, tokenEKeyEkey.passkey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, passkey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenEKeyEkey {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    passkey: ").append(toIndentedString(passkey)).append("\n");
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
