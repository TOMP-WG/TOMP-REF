package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Endpoint;
import io.swagger.model.Scenario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EndpointImplementation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-26T11:47:26.599Z[GMT]")
public class EndpointImplementation   {
  @JsonProperty("version")
  private String version = null;

  @JsonProperty("endpoints")
  @Valid
  private List<Endpoint> endpoints = null;

  @JsonProperty("scenarios")
  @Valid
  private List<Scenario> scenarios = null;

  public EndpointImplementation version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  
    public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public EndpointImplementation endpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public EndpointImplementation addEndpointsItem(Endpoint endpointsItem) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList<Endpoint>();
    }
    this.endpoints.add(endpointsItem);
    return this;
  }

  /**
   * Get endpoints
   * @return endpoints
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Endpoint> getEndpoints() {
    return endpoints;
  }

  public void setEndpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
  }

  public EndpointImplementation scenarios(List<Scenario> scenarios) {
    this.scenarios = scenarios;
    return this;
  }

  public EndpointImplementation addScenariosItem(Scenario scenariosItem) {
    if (this.scenarios == null) {
      this.scenarios = new ArrayList<Scenario>();
    }
    this.scenarios.add(scenariosItem);
    return this;
  }

  /**
   * Get scenarios
   * @return scenarios
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Scenario> getScenarios() {
    return scenarios;
  }

  public void setScenarios(List<Scenario> scenarios) {
    this.scenarios = scenarios;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndpointImplementation endpointImplementation = (EndpointImplementation) o;
    return Objects.equals(this.version, endpointImplementation.version) &&
        Objects.equals(this.endpoints, endpointImplementation.endpoints) &&
        Objects.equals(this.scenarios, endpointImplementation.scenarios);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, endpoints, scenarios);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndpointImplementation {\n");
    
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
    sb.append("    scenarios: ").append(toIndentedString(scenarios)).append("\n");
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
