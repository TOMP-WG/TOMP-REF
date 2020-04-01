package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SystemalertAlerts;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemAlert
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-27T13:22:30.099Z[GMT]")
public class SystemAlert   {
  @JsonProperty("alerts")
  @Valid
  private List<SystemalertAlerts> alerts = null;

  public SystemAlert alerts(List<SystemalertAlerts> alerts) {
    this.alerts = alerts;
    return this;
  }

  public SystemAlert addAlertsItem(SystemalertAlerts alertsItem) {
    if (this.alerts == null) {
      this.alerts = new ArrayList<SystemalertAlerts>();
    }
    this.alerts.add(alertsItem);
    return this;
  }

  /**
   * Get alerts
   * @return alerts
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<SystemalertAlerts> getAlerts() {
    return alerts;
  }

  public void setAlerts(List<SystemalertAlerts> alerts) {
    this.alerts = alerts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemAlert systemAlert = (SystemAlert) o;
    return Objects.equals(this.alerts, systemAlert.alerts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alerts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemAlert {\n");
    
    sb.append("    alerts: ").append(toIndentedString(alerts)).append("\n");
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
