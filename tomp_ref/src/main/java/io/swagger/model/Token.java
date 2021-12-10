package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The validity token (such as booking ID, travel ticket etc.) that MaaS clients will display to show their right to travel, or use to access an asset
 */
@Schema(description = "The validity token (such as booking ID, travel ticket etc.) that MaaS clients will display to show their right to travel, or use to access an asset")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T07:58:28.459Z[GMT]")


public class Token   {
  @JsonProperty("validFrom")
  private OffsetDateTime validFrom = null;

  @JsonProperty("validUntil")
  private OffsetDateTime validUntil = null;

  /**
   * The type of data held in this token, will later be an enum
   */
  public enum TokenTypeEnum {
    TOKENDEFAULT("tokenDefault"),
    
    TOKENDEEPLINK("tokenDeeplink"),
    
    TOKENEKEY("tokenEKey"),
    
    TOKENQR("tokenQR");

    private String value;

    TokenTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TokenTypeEnum fromValue(String text) {
      for (TokenTypeEnum b : TokenTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("tokenType")
  private TokenTypeEnum tokenType = null;

  @JsonProperty("tokenData")
  private OneOftokenTokenData tokenData = null;

  public Token validFrom(OffsetDateTime validFrom) {
    this.validFrom = validFrom;
    return this;
  }

  /**
   * Get validFrom
   * @return validFrom
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(OffsetDateTime validFrom) {
    this.validFrom = validFrom;
  }

  public Token validUntil(OffsetDateTime validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * Get validUntil
   * @return validUntil
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(OffsetDateTime validUntil) {
    this.validUntil = validUntil;
  }

  public Token tokenType(TokenTypeEnum tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * The type of data held in this token, will later be an enum
   * @return tokenType
   **/
  @Schema(required = true, description = "The type of data held in this token, will later be an enum")
      @NotNull

    public TokenTypeEnum getTokenType() {
    return tokenType;
  }

  public void setTokenType(TokenTypeEnum tokenType) {
    this.tokenType = tokenType;
  }

  public Token tokenData(OneOftokenTokenData tokenData) {
    this.tokenData = tokenData;
    return this;
  }

  /**
   * Get tokenData
   * @return tokenData
   **/
  @Schema(description = "")
  
    public OneOftokenTokenData getTokenData() {
    return tokenData;
  }

  public void setTokenData(OneOftokenTokenData tokenData) {
    this.tokenData = tokenData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return Objects.equals(this.validFrom, token.validFrom) &&
        Objects.equals(this.validUntil, token.validUntil) &&
        Objects.equals(this.tokenType, token.tokenType) &&
        Objects.equals(this.tokenData, token.tokenData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validFrom, validUntil, tokenType, tokenData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("    validFrom: ").append(toIndentedString(validFrom)).append("\n");
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("    tokenData: ").append(toIndentedString(tokenData)).append("\n");
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
