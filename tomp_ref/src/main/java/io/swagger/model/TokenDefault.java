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
 * Arbitrary data the TO may pass along the ticket to the client
 */
@Schema(description = "Arbitrary data the TO may pass along the ticket to the client")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T11:36:21.130Z[GMT]")


public class TokenDefault extends TokenData implements OneOftokenTokenData {
  @JsonProperty("url")
  private String url = null;

  public TokenDefault url(String url) {
    this.url = url;
    return this;
  }

  /**
   * download url for html/pdf
   * @return url
   **/
  @Schema(description = "download url for html/pdf")
  
    public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenDefault tokenDefault = (TokenDefault) o;
    return Objects.equals(this.url, tokenDefault.url) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenDefault {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
