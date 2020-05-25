package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Endpoint;
import io.swagger.model.EndpointImplementation;
import io.swagger.model.MaasEnvironmentType;
import io.swagger.model.Polygon;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MaasOperator
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-18T13:09:36.434Z[GMT]")
public class MaasOperator   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("nation")
  private Endpoint nation = null;

  @JsonProperty("type")
  private MaasEnvironmentType type = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("supportedVersions")
  @Valid
  private List<EndpointImplementation> supportedVersions = null;

  @JsonProperty("validationToken")
  private String validationToken = null;

  @JsonProperty("transactionProvider")
  private String transactionProvider = null;

  @JsonProperty("servicedArea")
  private Polygon servicedArea = null;

  public MaasOperator id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MaasOperator nation(Endpoint nation) {
    this.nation = nation;
    return this;
  }

  /**
   * Get nation
   * @return nation
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Endpoint getNation() {
    return nation;
  }

  public void setNation(Endpoint nation) {
    this.nation = nation;
  }

  public MaasOperator type(MaasEnvironmentType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public MaasEnvironmentType getType() {
    return type;
  }

  public void setType(MaasEnvironmentType type) {
    this.type = type;
  }

  public MaasOperator name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MaasOperator url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")
  
    public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public MaasOperator supportedVersions(List<EndpointImplementation> supportedVersions) {
    this.supportedVersions = supportedVersions;
    return this;
  }

  public MaasOperator addSupportedVersionsItem(EndpointImplementation supportedVersionsItem) {
    if (this.supportedVersions == null) {
      this.supportedVersions = new ArrayList<EndpointImplementation>();
    }
    this.supportedVersions.add(supportedVersionsItem);
    return this;
  }

  /**
   * Get supportedVersions
   * @return supportedVersions
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<EndpointImplementation> getSupportedVersions() {
    return supportedVersions;
  }

  public void setSupportedVersions(List<EndpointImplementation> supportedVersions) {
    this.supportedVersions = supportedVersions;
  }

  public MaasOperator validationToken(String validationToken) {
    this.validationToken = validationToken;
    return this;
  }

  /**
   * can be a thumbprint of a certificate.
   * @return validationToken
  **/
  @ApiModelProperty(value = "can be a thumbprint of a certificate.")
  
    public String getValidationToken() {
    return validationToken;
  }

  public void setValidationToken(String validationToken) {
    this.validationToken = validationToken;
  }

  public MaasOperator transactionProvider(String transactionProvider) {
    this.transactionProvider = transactionProvider;
    return this;
  }

  /**
   * the transactionprocessor of this operator
   * @return transactionProvider
  **/
  @ApiModelProperty(value = "the transactionprocessor of this operator")
  
    public String getTransactionProvider() {
    return transactionProvider;
  }

  public void setTransactionProvider(String transactionProvider) {
    this.transactionProvider = transactionProvider;
  }

  public MaasOperator servicedArea(Polygon servicedArea) {
    this.servicedArea = servicedArea;
    return this;
  }

  /**
   * Get servicedArea
   * @return servicedArea
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Polygon getServicedArea() {
    return servicedArea;
  }

  public void setServicedArea(Polygon servicedArea) {
    this.servicedArea = servicedArea;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MaasOperator maasOperator = (MaasOperator) o;
    return Objects.equals(this.id, maasOperator.id) &&
        Objects.equals(this.nation, maasOperator.nation) &&
        Objects.equals(this.type, maasOperator.type) &&
        Objects.equals(this.name, maasOperator.name) &&
        Objects.equals(this.url, maasOperator.url) &&
        Objects.equals(this.supportedVersions, maasOperator.supportedVersions) &&
        Objects.equals(this.validationToken, maasOperator.validationToken) &&
        Objects.equals(this.transactionProvider, maasOperator.transactionProvider) &&
        Objects.equals(this.servicedArea, maasOperator.servicedArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nation, type, name, url, supportedVersions, validationToken, transactionProvider, servicedArea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MaasOperator {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nation: ").append(toIndentedString(nation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    supportedVersions: ").append(toIndentedString(supportedVersions)).append("\n");
    sb.append("    validationToken: ").append(toIndentedString(validationToken)).append("\n");
    sb.append("    transactionProvider: ").append(toIndentedString(transactionProvider)).append("\n");
    sb.append("    servicedArea: ").append(toIndentedString(servicedArea)).append("\n");
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
