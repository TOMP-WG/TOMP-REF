package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TokenEKeyLock
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-26T08:47:05.979Z[GMT]")


public class TokenEKeyLock   {
  @JsonProperty("bdAddress")
  private String bdAddress = null;

  @JsonProperty("deviceName")
  private String deviceName = null;

  public TokenEKeyLock bdAddress(String bdAddress) {
    this.bdAddress = bdAddress;
    return this;
  }

  /**
   * physical address
   * @return bdAddress
   **/
  @Schema(description = "physical address")
  
    public String getBdAddress() {
    return bdAddress;
  }

  public void setBdAddress(String bdAddress) {
    this.bdAddress = bdAddress;
  }

  public TokenEKeyLock deviceName(String deviceName) {
    this.deviceName = deviceName;
    return this;
  }

  /**
   * how it advertises itself
   * @return deviceName
   **/
  @Schema(description = "how it advertises itself")
  
    public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenEKeyLock tokenEKeyLock = (TokenEKeyLock) o;
    return Objects.equals(this.bdAddress, tokenEKeyLock.bdAddress) &&
        Objects.equals(this.deviceName, tokenEKeyLock.deviceName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bdAddress, deviceName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenEKeyLock {\n");
    
    sb.append("    bdAddress: ").append(toIndentedString(bdAddress)).append("\n");
    sb.append("    deviceName: ").append(toIndentedString(deviceName)).append("\n");
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
