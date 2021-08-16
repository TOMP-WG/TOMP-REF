package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.TokenData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * deeplink info
 */
@Schema(description = "deeplink info")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-28T07:34:31.139Z[GMT]")


public class TokenDeeplink extends TokenData  {
  @JsonProperty("url")
  private String url = null;

  @JsonProperty("knownParameters")
  @Valid
  private List<String> knownParameters = null;

  public TokenDeeplink url(String url) {
    this.url = url;
    return this;
  }

  /**
   * the base deeplink url for the MP app. Can be extended by the 'knownParamaters'. Including the scheme.
   * @return url
   **/
  @Schema(example = "mp1.app://something/?auth=sdfkjhrkjsdf003df38=dfsdf", description = "the base deeplink url for the MP app. Can be extended by the 'knownParamaters'. Including the scheme.")
  
    public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public TokenDeeplink knownParameters(List<String> knownParameters) {
    this.knownParameters = knownParameters;
    return this;
  }

  public TokenDeeplink addKnownParametersItem(String knownParametersItem) {
    if (this.knownParameters == null) {
      this.knownParameters = new ArrayList<String>();
    }
    this.knownParameters.add(knownParametersItem);
    return this;
  }

  /**
   * Get knownParameters
   * @return knownParameters
   **/
  @Schema(example = "[\"return-url\",\"error-url\",\"error-code\",\"error-description\"]", description = "")
  
    public List<String> getKnownParameters() {
    return knownParameters;
  }

  public void setKnownParameters(List<String> knownParameters) {
    this.knownParameters = knownParameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenDeeplink tokenDeeplink = (TokenDeeplink) o;
    return Objects.equals(this.url, tokenDeeplink.url) &&
        Objects.equals(this.knownParameters, tokenDeeplink.knownParameters) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, knownParameters, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenDeeplink {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    knownParameters: ").append(toIndentedString(knownParameters)).append("\n");
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
