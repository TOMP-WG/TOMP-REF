package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TokenData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-08T10:25:25.468Z[GMT]")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tokenType", visible = true )
@JsonSubTypes({
        @JsonSubTypes.Type(value = TokenDeeplink.class, name = "tokenDeeplink"),
        @JsonSubTypes.Type(value = TokenDefault.class, name = "tokenDefault"),
        @JsonSubTypes.Type(value = TokenQR.class, name = "tokenQR"),
        @JsonSubTypes.Type(value = TokenEKey.class, name = "tokenEKey"),
})


public class TokenData extends HashMap<String, Object>  {
  @JsonTypeId
  private String tokenType = null;

  public TokenData tokenType(String tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * Get tokenType
   * @return tokenType
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenData tokenData = (TokenData) o;
    return Objects.equals(this.tokenType, tokenData.tokenType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenType, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenData {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
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
