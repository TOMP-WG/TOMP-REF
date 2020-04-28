package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Phone
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class Phone   {
  @JsonProperty("preferred")
  private Boolean preferred = null;

  @JsonProperty("number")
  private String number = null;

  /**
   * Gets or Sets kind
   */
  public enum KindEnum {
    LANDLINE("LANDLINE"),
    
    MOBILE("MOBILE");

    private String value;

    KindEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static KindEnum fromValue(String text) {
      for (KindEnum b : KindEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("kind")
  private KindEnum kind = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    PRIVATE("PRIVATE"),
    
    BUSINESS("BUSINESS"),
    
    OTHER("OTHER");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("type")
  private TypeEnum type = null;

  public Phone preferred(Boolean preferred) {
    this.preferred = preferred;
    return this;
  }

  /**
   * only one phone in this array can have a true in this property
   * @return preferred
  **/
  @ApiModelProperty(value = "only one phone in this array can have a true in this property")
  
    public Boolean isPreferred() {
    return preferred;
  }

  public void setPreferred(Boolean preferred) {
    this.preferred = preferred;
  }

  public Phone number(String number) {
    this.number = number;
    return this;
  }

  /**
   * phone number. In case of international usage, always provide the country code.
   * @return number
  **/
  @ApiModelProperty(example = "+31-48934758 or +(0075)-834923384 or 020 1234 1234", value = "phone number. In case of international usage, always provide the country code.")
  
  @Pattern(regexp="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")   public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Phone kind(KindEnum kind) {
    this.kind = kind;
    return this;
  }

  /**
   * Get kind
   * @return kind
  **/
  @ApiModelProperty(value = "")
  
    public KindEnum getKind() {
    return kind;
  }

  public void setKind(KindEnum kind) {
    this.kind = kind;
  }

  public Phone type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  
    public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Phone phone = (Phone) o;
    return Objects.equals(this.preferred, phone.preferred) &&
        Objects.equals(this.number, phone.number) &&
        Objects.equals(this.kind, phone.kind) &&
        Objects.equals(this.type, phone.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(preferred, number, kind, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Phone {\n");
    
    sb.append("    preferred: ").append(toIndentedString(preferred)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
