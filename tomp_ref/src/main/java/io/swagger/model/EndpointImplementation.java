package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Endpoint;
import io.swagger.model.ProcessIdentifiers;
import io.swagger.model.Scenario;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * a complete endpoint description, containing all endpoints, their status, but also the served scenarios and implemented process flows. The identifiers for the process flows can be found at https://github.com/TOMP-WG/TOMP-API/wiki/ProcessIdentifiers
 */
@Schema(description = "a complete endpoint description, containing all endpoints, their status, but also the served scenarios and implemented process flows. The identifiers for the process flows can be found at https://github.com/TOMP-WG/TOMP-API/wiki/ProcessIdentifiers")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class EndpointImplementation   {
  @JsonProperty("version")
  private String version = null;

  @JsonProperty("baseUrl")
  private String baseUrl = null;

  @JsonProperty("endpoints")
  @Valid
  private List<Endpoint> endpoints = new ArrayList<Endpoint>();

  @JsonProperty("scenarios")
  @Valid
  private List<Scenario> scenarios = new ArrayList<Scenario>();

  @JsonProperty("processIdentifiers")
  private ProcessIdentifiers processIdentifiers = null;

  public EndpointImplementation version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public EndpointImplementation baseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
    return this;
  }

  /**
   * Get baseUrl
   * @return baseUrl
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public EndpointImplementation endpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public EndpointImplementation addEndpointsItem(Endpoint endpointsItem) {
    this.endpoints.add(endpointsItem);
    return this;
  }

  /**
   * Get endpoints
   * @return endpoints
   **/
  @Schema(required = true, description = "")
      @NotNull
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
    this.scenarios.add(scenariosItem);
    return this;
  }

  /**
   * Get scenarios
   * @return scenarios
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Scenario> getScenarios() {
    return scenarios;
  }

  public void setScenarios(List<Scenario> scenarios) {
    this.scenarios = scenarios;
  }

  public EndpointImplementation processIdentifiers(ProcessIdentifiers processIdentifiers) {
    this.processIdentifiers = processIdentifiers;
    return this;
  }

  /**
   * Get processIdentifiers
   * @return processIdentifiers
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public ProcessIdentifiers getProcessIdentifiers() {
    return processIdentifiers;
  }

  public void setProcessIdentifiers(ProcessIdentifiers processIdentifiers) {
    this.processIdentifiers = processIdentifiers;
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
        Objects.equals(this.baseUrl, endpointImplementation.baseUrl) &&
        Objects.equals(this.endpoints, endpointImplementation.endpoints) &&
        Objects.equals(this.scenarios, endpointImplementation.scenarios) &&
        Objects.equals(this.processIdentifiers, endpointImplementation.processIdentifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, baseUrl, endpoints, scenarios, processIdentifiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndpointImplementation {\n");
    
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    baseUrl: ").append(toIndentedString(baseUrl)).append("\n");
    sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
    sb.append("    scenarios: ").append(toIndentedString(scenarios)).append("\n");
    sb.append("    processIdentifiers: ").append(toIndentedString(processIdentifiers)).append("\n");
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
