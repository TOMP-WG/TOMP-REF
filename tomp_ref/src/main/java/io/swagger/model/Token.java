package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.KeyValue;
import io.swagger.model.Period;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The validity token (such as booking ID, travel ticket etc.) that MaaS clients will display to validate the leg when starting the leg.
 */
@ApiModel(description = "The validity token (such as booking ID, travel ticket etc.) that MaaS clients will display to validate the leg when starting the leg.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class Token extends Period  {
  @JsonProperty("meta")
  @Valid
  private List<KeyValue> meta = null;

  public Token meta(List<KeyValue> meta) {
    this.meta = meta;
    return this;
  }

  public Token addMetaItem(KeyValue metaItem) {
    if (this.meta == null) {
      this.meta = new ArrayList<KeyValue>();
    }
    this.meta.add(metaItem);
    return this;
  }

  /**
   * Arbitrary metadata the TO may pass along the ticket to the client (e.g. a booking code, base64 encoded binary)
   * @return meta
  **/
  @ApiModelProperty(value = "Arbitrary metadata the TO may pass along the ticket to the client (e.g. a booking code, base64 encoded binary)")
      @Valid
    public List<KeyValue> getMeta() {
    return meta;
  }

  public void setMeta(List<KeyValue> meta) {
    this.meta = meta;
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
    return Objects.equals(this.meta, token.meta) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meta, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
