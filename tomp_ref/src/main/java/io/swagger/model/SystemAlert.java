package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemAlert
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-10T11:36:21.130Z[GMT]")


public class SystemAlert   {
  @JsonProperty("alertId")
  private String alertId = null;

  /**
   * Gets or Sets alertType
   */
  public enum AlertTypeEnum {
    SYSTEM_CLOSURE("SYSTEM_CLOSURE"),
    
    STATION_CLOSURE("STATION_CLOSURE"),
    
    STATION_MOVE("STATION_MOVE"),
    
    OTHER("OTHER");

    private String value;

    AlertTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AlertTypeEnum fromValue(String text) {
      for (AlertTypeEnum b : AlertTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("alertType")
  private AlertTypeEnum alertType = null;

  @JsonProperty("startAndEndTimes")
  @Valid
  private List<List<OffsetDateTime>> startAndEndTimes = null;

  @JsonProperty("stationIds")
  @Valid
  private List<String> stationIds = null;

  @JsonProperty("regionId")
  @Valid
  private List<String> regionId = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("summary")
  private String summary = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("lastUpdated")
  private OffsetDateTime lastUpdated = null;

  public SystemAlert alertId(String alertId) {
    this.alertId = alertId;
    return this;
  }

  /**
   * a unique identifier for this alert
   * @return alertId
   **/
  @Schema(required = true, description = "a unique identifier for this alert")
      @NotNull

    public String getAlertId() {
    return alertId;
  }

  public void setAlertId(String alertId) {
    this.alertId = alertId;
  }

  public SystemAlert alertType(AlertTypeEnum alertType) {
    this.alertType = alertType;
    return this;
  }

  /**
   * Get alertType
   * @return alertType
   **/
  @Schema(required = true, description = "")
      @NotNull

    public AlertTypeEnum getAlertType() {
    return alertType;
  }

  public void setAlertType(AlertTypeEnum alertType) {
    this.alertType = alertType;
  }

  public SystemAlert startAndEndTimes(List<List<OffsetDateTime>> startAndEndTimes) {
    this.startAndEndTimes = startAndEndTimes;
    return this;
  }

  public SystemAlert addStartAndEndTimesItem(List<OffsetDateTime> startAndEndTimesItem) {
    if (this.startAndEndTimes == null) {
      this.startAndEndTimes = new ArrayList<List<OffsetDateTime>>();
    }
    this.startAndEndTimes.add(startAndEndTimesItem);
    return this;
  }

  /**
   * Array of hashes with the keys \"start\" and \"end\" indicating when the alert is in effect (e.g. when the system or station is actually closed, or when it is scheduled to be moved). If this array is omitted then the alert should be displayed as long as it is in the feed.
   * @return startAndEndTimes
   **/
  @Schema(description = "Array of hashes with the keys \"start\" and \"end\" indicating when the alert is in effect (e.g. when the system or station is actually closed, or when it is scheduled to be moved). If this array is omitted then the alert should be displayed as long as it is in the feed.")
      @Valid
    public List<List<OffsetDateTime>> getStartAndEndTimes() {
    return startAndEndTimes;
  }

  public void setStartAndEndTimes(List<List<OffsetDateTime>> startAndEndTimes) {
    this.startAndEndTimes = startAndEndTimes;
  }

  public SystemAlert stationIds(List<String> stationIds) {
    this.stationIds = stationIds;
    return this;
  }

  public SystemAlert addStationIdsItem(String stationIdsItem) {
    if (this.stationIds == null) {
      this.stationIds = new ArrayList<String>();
    }
    this.stationIds.add(stationIdsItem);
    return this;
  }

  /**
   * Array of strings - If this is an alert that affects one or more stations, include their ids, otherwise omit this field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system
   * @return stationIds
   **/
  @Schema(example = "[\"stationID0001\"]", description = "Array of strings - If this is an alert that affects one or more stations, include their ids, otherwise omit this field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system")
  
    public List<String> getStationIds() {
    return stationIds;
  }

  public void setStationIds(List<String> stationIds) {
    this.stationIds = stationIds;
  }

  public SystemAlert regionId(List<String> regionId) {
    this.regionId = regionId;
    return this;
  }

  public SystemAlert addRegionIdItem(String regionIdItem) {
    if (this.regionId == null) {
      this.regionId = new ArrayList<String>();
    }
    this.regionId.add(regionIdItem);
    return this;
  }

  /**
   * Array of strings - If this system has regions, and if this alert only affects certain regions, include their ids, otherwise, omit this field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system
   * @return regionId
   **/
  @Schema(example = "[\"regionID0001\"]", description = "Array of strings - If this system has regions, and if this alert only affects certain regions, include their ids, otherwise, omit this field. If both stationIDs and regionIDs are omitted, assume this alert affects the entire system")
  
    public List<String> getRegionId() {
    return regionId;
  }

  public void setRegionId(List<String> regionId) {
    this.regionId = regionId;
  }

  public SystemAlert url(String url) {
    this.url = url;
    return this;
  }

  /**
   * URL where the customer can learn more information about this alert, if there is one
   * @return url
   **/
  @Schema(example = "http://www.rentmyfreebike.com/alerts", description = "URL where the customer can learn more information about this alert, if there is one")
  
    public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public SystemAlert summary(String summary) {
    this.summary = summary;
    return this;
  }

  /**
   * A short summary of this alert to be displayed to the customer, should match Content-Language
   * @return summary
   **/
  @Schema(example = "station closed", required = true, description = "A short summary of this alert to be displayed to the customer, should match Content-Language")
      @NotNull

    public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public SystemAlert description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Detailed text description of the alert, should match Content-Language
   * @return description
   **/
  @Schema(example = "station closed indefinitely due to vandalism", description = "Detailed text description of the alert, should match Content-Language")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SystemAlert lastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * Get lastUpdated
   * @return lastUpdated
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
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
    return Objects.equals(this.alertId, systemAlert.alertId) &&
        Objects.equals(this.alertType, systemAlert.alertType) &&
        Objects.equals(this.startAndEndTimes, systemAlert.startAndEndTimes) &&
        Objects.equals(this.stationIds, systemAlert.stationIds) &&
        Objects.equals(this.regionId, systemAlert.regionId) &&
        Objects.equals(this.url, systemAlert.url) &&
        Objects.equals(this.summary, systemAlert.summary) &&
        Objects.equals(this.description, systemAlert.description) &&
        Objects.equals(this.lastUpdated, systemAlert.lastUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alertId, alertType, startAndEndTimes, stationIds, regionId, url, summary, description, lastUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemAlert {\n");
    
    sb.append("    alertId: ").append(toIndentedString(alertId)).append("\n");
    sb.append("    alertType: ").append(toIndentedString(alertType)).append("\n");
    sb.append("    startAndEndTimes: ").append(toIndentedString(startAndEndTimes)).append("\n");
    sb.append("    stationIds: ").append(toIndentedString(stationIds)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
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
