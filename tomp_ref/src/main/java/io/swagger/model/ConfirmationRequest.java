package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * the TO can ask permission to do something to the MP, as the MP is financially responsible.
 */
@Schema(description = "the TO can ask permission to do something to the MP, as the MP is financially responsible.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-08T10:25:25.468Z[GMT]")


public class ConfirmationRequest   {
  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    REPLACE_ASSET("REPLACE_ASSET"),
    
    START_LEG("START_LEG");

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

  @JsonProperty("assetTypeId")
  private String assetTypeId = null;

  public ConfirmationRequest type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(description = "")
  
    public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ConfirmationRequest assetTypeId(String assetTypeId) {
    this.assetTypeId = assetTypeId;
    return this;
  }

  /**
   * reference to the assetType in /operator/available-assets, this property can be set when replacing an asset (for another type). In case of a succesfull replacement, the /legs/{id}/events - ASSIGN_ASSET should be send to the MP to inform a change of asset has been made.
   * @return assetTypeId
   **/
  @Schema(description = "reference to the assetType in /operator/available-assets, this property can be set when replacing an asset (for another type). In case of a succesfull replacement, the /legs/{id}/events - ASSIGN_ASSET should be send to the MP to inform a change of asset has been made.")
  
    public String getAssetTypeId() {
    return assetTypeId;
  }

  public void setAssetTypeId(String assetTypeId) {
    this.assetTypeId = assetTypeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfirmationRequest confirmationRequest = (ConfirmationRequest) o;
    return Objects.equals(this.type, confirmationRequest.type) &&
        Objects.equals(this.assetTypeId, confirmationRequest.assetTypeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, assetTypeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfirmationRequest {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    assetTypeId: ").append(toIndentedString(assetTypeId)).append("\n");
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
