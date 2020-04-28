package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class SystemInformation   {
  @JsonProperty("systemId")
  private String systemId = null;

  @JsonProperty("language")
  private String language = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("shortName")
  private String shortName = null;

  @JsonProperty("operator")
  private String operator = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("purchaseUrl")
  private String purchaseUrl = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("timezone")
  private String timezone = null;

  @JsonProperty("licenseUrl")
  private String licenseUrl = null;

  /**
   * Describes the type of system
   */
  public enum TypeOfSystemEnum {
    FREE_FLOATING("FREE_FLOATING"),
    
    STATION_BASED("STATION_BASED"),
    
    VIRTUAL_STATION_BASED("VIRTUAL_STATION_BASED");

    private String value;

    TypeOfSystemEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeOfSystemEnum fromValue(String text) {
      for (TypeOfSystemEnum b : TypeOfSystemEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("typeOfSystem")
  private TypeOfSystemEnum typeOfSystem = null;

  @JsonProperty("conditions")
  private String conditions = null;

  public SystemInformation systemId(String systemId) {
    this.systemId = systemId;
    return this;
  }

  /**
   * identifier for this transport system. This should be globally unique (even between different systems)
   * @return systemId
  **/
  @ApiModelProperty(example = "XXTO0001", required = true, value = "identifier for this transport system. This should be globally unique (even between different systems)")
      @NotNull

    public String getSystemId() {
    return systemId;
  }

  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }

  public SystemInformation language(String language) {
    this.language = language;
    return this;
  }

  /**
   * An IETF language tag indicating the language that will be used throughout the rest of the files. This is a string that defines a single language tag only.
   * @return language
  **/
  @ApiModelProperty(example = "eng", required = true, value = "An IETF language tag indicating the language that will be used throughout the rest of the files. This is a string that defines a single language tag only.")
      @NotNull

    public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public SystemInformation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Full name of the system to be displayed to customers
   * @return name
  **/
  @ApiModelProperty(example = "FreeBike", required = true, value = "Full name of the system to be displayed to customers")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SystemInformation shortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  /**
   * Optional abbreviation for a system
   * @return shortName
  **/
  @ApiModelProperty(example = "FB", value = "Optional abbreviation for a system")
  
    public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public SystemInformation operator(String operator) {
    this.operator = operator;
    return this;
  }

  /**
   * Name of the operator of the system
   * @return operator
  **/
  @ApiModelProperty(example = "FreeBike", value = "Name of the operator of the system")
  
    public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public SystemInformation url(String url) {
    this.url = url;
    return this;
  }

  /**
   * The URL of the transport operator. The value must be a fully qualified URL that includes http:// or https://, and any special characters in the URL must be correctly escaped.
   * @return url
  **/
  @ApiModelProperty(example = "https://www.rentmyfreebike.com", value = "The URL of the transport operator. The value must be a fully qualified URL that includes http:// or https://, and any special characters in the URL must be correctly escaped.")
  
    public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public SystemInformation purchaseUrl(String purchaseUrl) {
    this.purchaseUrl = purchaseUrl;
    return this;
  }

  /**
   * A fully qualified URL where a customer can purchase a membership or learn more about purchasing memberships
   * @return purchaseUrl
  **/
  @ApiModelProperty(example = "https://www.rentmyfreebike.com/purchase", value = "A fully qualified URL where a customer can purchase a membership or learn more about purchasing memberships")
  
    public String getPurchaseUrl() {
    return purchaseUrl;
  }

  public void setPurchaseUrl(String purchaseUrl) {
    this.purchaseUrl = purchaseUrl;
  }

  public SystemInformation startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public SystemInformation phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * A single voice telephone number for the specified system. This field is a string value that presents the telephone number as typical for the system's service area. It can and should contain punctuation marks to group the digits of the number.
   * @return phoneNumber
  **/
  @ApiModelProperty(example = "555-12345", value = "A single voice telephone number for the specified system. This field is a string value that presents the telephone number as typical for the system's service area. It can and should contain punctuation marks to group the digits of the number.")
  
    public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public SystemInformation email(String email) {
    this.email = email;
    return this;
  }

  /**
   * A single contact email address for customers to address questions about the system
   * @return email
  **/
  @ApiModelProperty(example = "rent@freebike.com", value = "A single contact email address for customers to address questions about the system")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SystemInformation timezone(String timezone) {
    this.timezone = timezone;
    return this;
  }

  /**
   * The time zone where the system is located. Time zone names never contain the space character but may contain an underscore. Please refer to the \"TZ\" value in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones for a list of valid values
   * @return timezone
  **/
  @ApiModelProperty(example = "IST", required = true, value = "The time zone where the system is located. Time zone names never contain the space character but may contain an underscore. Please refer to the \"TZ\" value in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones for a list of valid values")
      @NotNull

    public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public SystemInformation licenseUrl(String licenseUrl) {
    this.licenseUrl = licenseUrl;
    return this;
  }

  /**
   * A fully qualified URL of a page that defines the license terms for the GBFS data for this system, as well as any other license terms the system would like to define (including the use of corporate trademarks, etc)
   * @return licenseUrl
  **/
  @ApiModelProperty(example = "https://www.rentmyfreebike.com/license", value = "A fully qualified URL of a page that defines the license terms for the GBFS data for this system, as well as any other license terms the system would like to define (including the use of corporate trademarks, etc)")
  
    public String getLicenseUrl() {
    return licenseUrl;
  }

  public void setLicenseUrl(String licenseUrl) {
    this.licenseUrl = licenseUrl;
  }

  public SystemInformation typeOfSystem(TypeOfSystemEnum typeOfSystem) {
    this.typeOfSystem = typeOfSystem;
    return this;
  }

  /**
   * Describes the type of system
   * @return typeOfSystem
  **/
  @ApiModelProperty(example = "FREE_FLOATING", required = true, value = "Describes the type of system")
      @NotNull

    public TypeOfSystemEnum getTypeOfSystem() {
    return typeOfSystem;
  }

  public void setTypeOfSystem(TypeOfSystemEnum typeOfSystem) {
    this.typeOfSystem = typeOfSystem;
  }

  public SystemInformation conditions(String conditions) {
    this.conditions = conditions;
    return this;
  }

  /**
   * Added to include possibility to communicatie general rental conditions like minimum age, max. reservation time etc. [amended]
   * @return conditions
  **/
  @ApiModelProperty(value = "Added to include possibility to communicatie general rental conditions like minimum age, max. reservation time etc. [amended]")
  
    public String getConditions() {
    return conditions;
  }

  public void setConditions(String conditions) {
    this.conditions = conditions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInformation systemInformation = (SystemInformation) o;
    return Objects.equals(this.systemId, systemInformation.systemId) &&
        Objects.equals(this.language, systemInformation.language) &&
        Objects.equals(this.name, systemInformation.name) &&
        Objects.equals(this.shortName, systemInformation.shortName) &&
        Objects.equals(this.operator, systemInformation.operator) &&
        Objects.equals(this.url, systemInformation.url) &&
        Objects.equals(this.purchaseUrl, systemInformation.purchaseUrl) &&
        Objects.equals(this.startDate, systemInformation.startDate) &&
        Objects.equals(this.phoneNumber, systemInformation.phoneNumber) &&
        Objects.equals(this.email, systemInformation.email) &&
        Objects.equals(this.timezone, systemInformation.timezone) &&
        Objects.equals(this.licenseUrl, systemInformation.licenseUrl) &&
        Objects.equals(this.typeOfSystem, systemInformation.typeOfSystem) &&
        Objects.equals(this.conditions, systemInformation.conditions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(systemId, language, name, shortName, operator, url, purchaseUrl, startDate, phoneNumber, email, timezone, licenseUrl, typeOfSystem, conditions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInformation {\n");
    
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    shortName: ").append(toIndentedString(shortName)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    purchaseUrl: ").append(toIndentedString(purchaseUrl)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
    sb.append("    licenseUrl: ").append(toIndentedString(licenseUrl)).append("\n");
    sb.append("    typeOfSystem: ").append(toIndentedString(typeOfSystem)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
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
