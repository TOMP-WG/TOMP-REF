package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.AssetClass;
import io.swagger.model.ChamberOfCommerceInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class SystemInformation   {
  @JsonProperty("systemId")
  private String systemId = null;

  @JsonProperty("language")
  @Valid
  private List<String> language = new ArrayList<String>();

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

  @JsonProperty("discoveryUriAndroid")
  private String discoveryUriAndroid = null;

  @JsonProperty("discoveryUriIOS")
  private String discoveryUriIOS = null;

  @JsonProperty("storeUriAndroid")
  private String storeUriAndroid = null;

  @JsonProperty("storeUriIOS")
  private String storeUriIOS = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("feedContactEmail")
  private String feedContactEmail = null;

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

  @JsonProperty("chamberOfCommerceInfo")
  private ChamberOfCommerceInfo chamberOfCommerceInfo = null;

  @JsonProperty("conditions")
  private String conditions = null;

  /**
   * the type of product offered. SHARING should also be used for public transport.
   */
  public enum ProductTypeEnum {
    RENTAL("RENTAL"),
    
    SHARING("SHARING"),
    
    PARKING("PARKING"),
    
    CHARGING("CHARGING");

    private String value;

    ProductTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProductTypeEnum fromValue(String text) {
      for (ProductTypeEnum b : ProductTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("productType")
  private ProductTypeEnum productType = null;

  @JsonProperty("assetClasses")
  @Valid
  private List<AssetClass> assetClasses = null;

  public SystemInformation systemId(String systemId) {
    this.systemId = systemId;
    return this;
  }

  /**
   * identifier for this transport system. This should be globally unique (even between different systems)
   * @return systemId
   **/
  @Schema(example = "XXTO0001", required = true, description = "identifier for this transport system. This should be globally unique (even between different systems)")
      @NotNull

    public String getSystemId() {
    return systemId;
  }

  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }

  public SystemInformation language(List<String> language) {
    this.language = language;
    return this;
  }

  public SystemInformation addLanguageItem(String languageItem) {
    this.language.add(languageItem);
    return this;
  }

  /**
   * The languages supported by this operator for user-facing text. These can be requested using the Accept-Language header and should then be returned in Content-Language
   * @return language
   **/
  @Schema(required = true, description = "The languages supported by this operator for user-facing text. These can be requested using the Accept-Language header and should then be returned in Content-Language")
      @NotNull

    public List<String> getLanguage() {
    return language;
  }

  public void setLanguage(List<String> language) {
    this.language = language;
  }

  public SystemInformation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Full name of the system to be displayed to customers, could match Content-Language
   * @return name
   **/
  @Schema(example = "FreeBike", required = true, description = "Full name of the system to be displayed to customers, could match Content-Language")
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
  @Schema(example = "FB", description = "Optional abbreviation for a system")
  
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
   * Name of the operator of the system, could match Content-Language
   * @return operator
   **/
  @Schema(example = "FreeBike", description = "Name of the operator of the system, could match Content-Language")
  
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
  @Schema(example = "https://www.rentmyfreebike.com", description = "The URL of the transport operator. The value must be a fully qualified URL that includes http:// or https://, and any special characters in the URL must be correctly escaped.")
  
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
  @Schema(example = "https://www.rentmyfreebike.com/purchase", description = "A fully qualified URL where a customer can purchase a membership or learn more about purchasing memberships")
  
    public String getPurchaseUrl() {
    return purchaseUrl;
  }

  public void setPurchaseUrl(String purchaseUrl) {
    this.purchaseUrl = purchaseUrl;
  }

  public SystemInformation discoveryUriAndroid(String discoveryUriAndroid) {
    this.discoveryUriAndroid = discoveryUriAndroid;
    return this;
  }

  /**
   * Uri to detect if the app is available at the mobile.
   * @return discoveryUriAndroid
   **/
  @Schema(description = "Uri to detect if the app is available at the mobile.")
  
    public String getDiscoveryUriAndroid() {
    return discoveryUriAndroid;
  }

  public void setDiscoveryUriAndroid(String discoveryUriAndroid) {
    this.discoveryUriAndroid = discoveryUriAndroid;
  }

  public SystemInformation discoveryUriIOS(String discoveryUriIOS) {
    this.discoveryUriIOS = discoveryUriIOS;
    return this;
  }

  /**
   * Uri to detect if the app is available at the mobile.
   * @return discoveryUriIOS
   **/
  @Schema(description = "Uri to detect if the app is available at the mobile.")
  
    public String getDiscoveryUriIOS() {
    return discoveryUriIOS;
  }

  public void setDiscoveryUriIOS(String discoveryUriIOS) {
    this.discoveryUriIOS = discoveryUriIOS;
  }

  public SystemInformation storeUriAndroid(String storeUriAndroid) {
    this.storeUriAndroid = storeUriAndroid;
    return this;
  }

  /**
   * Uri to the app in the store.
   * @return storeUriAndroid
   **/
  @Schema(example = "https://play.google.com/store/apps/details?id=com.rentmyfreebike.android", description = "Uri to the app in the store.")
  
    public String getStoreUriAndroid() {
    return storeUriAndroid;
  }

  public void setStoreUriAndroid(String storeUriAndroid) {
    this.storeUriAndroid = storeUriAndroid;
  }

  public SystemInformation storeUriIOS(String storeUriIOS) {
    this.storeUriIOS = storeUriIOS;
    return this;
  }

  /**
   * Uri to the app in the store.
   * @return storeUriIOS
   **/
  @Schema(example = "itms-apps://itunes.apple.com/app/idcom.rentmyfreebike.ios", description = "Uri to the app in the store.")
  
    public String getStoreUriIOS() {
    return storeUriIOS;
  }

  public void setStoreUriIOS(String storeUriIOS) {
    this.storeUriIOS = storeUriIOS;
  }

  public SystemInformation startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
   **/
  @Schema(description = "")
  
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
  @Schema(example = "555-12345", description = "A single voice telephone number for the specified system. This field is a string value that presents the telephone number as typical for the system's service area. It can and should contain punctuation marks to group the digits of the number.")
  
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
  @Schema(example = "rent@freebike.com", description = "A single contact email address for customers to address questions about the system")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SystemInformation feedContactEmail(String feedContactEmail) {
    this.feedContactEmail = feedContactEmail;
    return this;
  }

  /**
   * A single contact email address for consumers of this feed to report technical issues.
   * @return feedContactEmail
   **/
  @Schema(description = "A single contact email address for consumers of this feed to report technical issues.")
  
    public String getFeedContactEmail() {
    return feedContactEmail;
  }

  public void setFeedContactEmail(String feedContactEmail) {
    this.feedContactEmail = feedContactEmail;
  }

  public SystemInformation timezone(String timezone) {
    this.timezone = timezone;
    return this;
  }

  /**
   * The time zone where the system is located. Time zone names never contain the space character but may contain an underscore. Please refer to the \"TZ\" value in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones for a list of valid values
   * @return timezone
   **/
  @Schema(example = "IST", required = true, description = "The time zone where the system is located. Time zone names never contain the space character but may contain an underscore. Please refer to the \"TZ\" value in https://en.wikipedia.org/wiki/List_of_tz_database_time_zones for a list of valid values")
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
  @Schema(example = "https://www.rentmyfreebike.com/license", description = "A fully qualified URL of a page that defines the license terms for the GBFS data for this system, as well as any other license terms the system would like to define (including the use of corporate trademarks, etc)")
  
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
  @Schema(example = "FREE_FLOATING", required = true, description = "Describes the type of system")
      @NotNull

    public TypeOfSystemEnum getTypeOfSystem() {
    return typeOfSystem;
  }

  public void setTypeOfSystem(TypeOfSystemEnum typeOfSystem) {
    this.typeOfSystem = typeOfSystem;
  }

  public SystemInformation chamberOfCommerceInfo(ChamberOfCommerceInfo chamberOfCommerceInfo) {
    this.chamberOfCommerceInfo = chamberOfCommerceInfo;
    return this;
  }

  /**
   * Get chamberOfCommerceInfo
   * @return chamberOfCommerceInfo
   **/
  @Schema(description = "")
  
    @Valid
    public ChamberOfCommerceInfo getChamberOfCommerceInfo() {
    return chamberOfCommerceInfo;
  }

  public void setChamberOfCommerceInfo(ChamberOfCommerceInfo chamberOfCommerceInfo) {
    this.chamberOfCommerceInfo = chamberOfCommerceInfo;
  }

  public SystemInformation conditions(String conditions) {
    this.conditions = conditions;
    return this;
  }

  /**
   * Added to include possibility to communicatie general rental conditions like minimum age, max. reservation time etc. [amended]
   * @return conditions
   **/
  @Schema(description = "Added to include possibility to communicatie general rental conditions like minimum age, max. reservation time etc. [amended]")
  
    public String getConditions() {
    return conditions;
  }

  public void setConditions(String conditions) {
    this.conditions = conditions;
  }

  public SystemInformation productType(ProductTypeEnum productType) {
    this.productType = productType;
    return this;
  }

  /**
   * the type of product offered. SHARING should also be used for public transport.
   * @return productType
   **/
  @Schema(description = "the type of product offered. SHARING should also be used for public transport.")
  
    public ProductTypeEnum getProductType() {
    return productType;
  }

  public void setProductType(ProductTypeEnum productType) {
    this.productType = productType;
  }

  public SystemInformation assetClasses(List<AssetClass> assetClasses) {
    this.assetClasses = assetClasses;
    return this;
  }

  public SystemInformation addAssetClassesItem(AssetClass assetClassesItem) {
    if (this.assetClasses == null) {
      this.assetClasses = new ArrayList<AssetClass>();
    }
    this.assetClasses.add(assetClassesItem);
    return this;
  }

  /**
   * Get assetClasses
   * @return assetClasses
   **/
  @Schema(description = "")
      @Valid
    public List<AssetClass> getAssetClasses() {
    return assetClasses;
  }

  public void setAssetClasses(List<AssetClass> assetClasses) {
    this.assetClasses = assetClasses;
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
        Objects.equals(this.discoveryUriAndroid, systemInformation.discoveryUriAndroid) &&
        Objects.equals(this.discoveryUriIOS, systemInformation.discoveryUriIOS) &&
        Objects.equals(this.storeUriAndroid, systemInformation.storeUriAndroid) &&
        Objects.equals(this.storeUriIOS, systemInformation.storeUriIOS) &&
        Objects.equals(this.startDate, systemInformation.startDate) &&
        Objects.equals(this.phoneNumber, systemInformation.phoneNumber) &&
        Objects.equals(this.email, systemInformation.email) &&
        Objects.equals(this.feedContactEmail, systemInformation.feedContactEmail) &&
        Objects.equals(this.timezone, systemInformation.timezone) &&
        Objects.equals(this.licenseUrl, systemInformation.licenseUrl) &&
        Objects.equals(this.typeOfSystem, systemInformation.typeOfSystem) &&
        Objects.equals(this.chamberOfCommerceInfo, systemInformation.chamberOfCommerceInfo) &&
        Objects.equals(this.conditions, systemInformation.conditions) &&
        Objects.equals(this.productType, systemInformation.productType) &&
        Objects.equals(this.assetClasses, systemInformation.assetClasses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(systemId, language, name, shortName, operator, url, purchaseUrl, discoveryUriAndroid, discoveryUriIOS, storeUriAndroid, storeUriIOS, startDate, phoneNumber, email, feedContactEmail, timezone, licenseUrl, typeOfSystem, chamberOfCommerceInfo, conditions, productType, assetClasses);
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
    sb.append("    discoveryUriAndroid: ").append(toIndentedString(discoveryUriAndroid)).append("\n");
    sb.append("    discoveryUriIOS: ").append(toIndentedString(discoveryUriIOS)).append("\n");
    sb.append("    storeUriAndroid: ").append(toIndentedString(storeUriAndroid)).append("\n");
    sb.append("    storeUriIOS: ").append(toIndentedString(storeUriIOS)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    feedContactEmail: ").append(toIndentedString(feedContactEmail)).append("\n");
    sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
    sb.append("    licenseUrl: ").append(toIndentedString(licenseUrl)).append("\n");
    sb.append("    typeOfSystem: ").append(toIndentedString(typeOfSystem)).append("\n");
    sb.append("    chamberOfCommerceInfo: ").append(toIndentedString(chamberOfCommerceInfo)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    assetClasses: ").append(toIndentedString(assetClasses)).append("\n");
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
