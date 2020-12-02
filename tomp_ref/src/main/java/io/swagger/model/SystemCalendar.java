package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemCalendar
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class SystemCalendar   {
  @JsonProperty("stationId")
  private String stationId = null;

  @JsonProperty("regionId")
  private String regionId = null;

  @JsonProperty("startMonth")
  private Integer startMonth = null;

  @JsonProperty("startDay")
  private Integer startDay = null;

  @JsonProperty("startYear")
  private Integer startYear = null;

  @JsonProperty("endMonth")
  private Integer endMonth = null;

  @JsonProperty("endDay")
  private Integer endDay = null;

  @JsonProperty("endYear")
  private Integer endYear = null;

  public SystemCalendar stationId(String stationId) {
    this.stationId = stationId;
    return this;
  }

  /**
   * If this parameter is present, it means that start and end prameters correspond to the opening and closing days of the station. (GET /operator/stations)
   * @return stationId
   **/
  @Schema(description = "If this parameter is present, it means that start and end prameters correspond to the opening and closing days of the station. (GET /operator/stations)")
  
    public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public SystemCalendar regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

  /**
   * If this parameter is present, it means that start and end prameters correspond to the opening and closing days for the region. (GET /operator/regions)
   * @return regionId
   **/
  @Schema(description = "If this parameter is present, it means that start and end prameters correspond to the opening and closing days for the region. (GET /operator/regions)")
  
    public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public SystemCalendar startMonth(Integer startMonth) {
    this.startMonth = startMonth;
    return this;
  }

  /**
   * Starting month for the system operations (1-12)
   * minimum: 1
   * maximum: 12
   * @return startMonth
   **/
  @Schema(example = "1", required = true, description = "Starting month for the system operations (1-12)")
      @NotNull

  @Min(1) @Max(12)   public Integer getStartMonth() {
    return startMonth;
  }

  public void setStartMonth(Integer startMonth) {
    this.startMonth = startMonth;
  }

  public SystemCalendar startDay(Integer startDay) {
    this.startDay = startDay;
    return this;
  }

  /**
   * Starting day for the system operations (1-31)
   * minimum: 1
   * maximum: 31
   * @return startDay
   **/
  @Schema(example = "1", required = true, description = "Starting day for the system operations (1-31)")
      @NotNull

  @Min(1) @Max(31)   public Integer getStartDay() {
    return startDay;
  }

  public void setStartDay(Integer startDay) {
    this.startDay = startDay;
  }

  public SystemCalendar startYear(Integer startYear) {
    this.startYear = startYear;
    return this;
  }

  /**
   * Starting year for the system operations
   * @return startYear
   **/
  @Schema(example = "2019", description = "Starting year for the system operations")
  
    public Integer getStartYear() {
    return startYear;
  }

  public void setStartYear(Integer startYear) {
    this.startYear = startYear;
  }

  public SystemCalendar endMonth(Integer endMonth) {
    this.endMonth = endMonth;
    return this;
  }

  /**
   * Ending month for the system operations (1-12)
   * minimum: 1
   * maximum: 12
   * @return endMonth
   **/
  @Schema(example = "12", required = true, description = "Ending month for the system operations (1-12)")
      @NotNull

  @Min(1) @Max(12)   public Integer getEndMonth() {
    return endMonth;
  }

  public void setEndMonth(Integer endMonth) {
    this.endMonth = endMonth;
  }

  public SystemCalendar endDay(Integer endDay) {
    this.endDay = endDay;
    return this;
  }

  /**
   * Ending day for the system operations (1-31)
   * minimum: 1
   * maximum: 31
   * @return endDay
   **/
  @Schema(example = "31", required = true, description = "Ending day for the system operations (1-31)")
      @NotNull

  @Min(1) @Max(31)   public Integer getEndDay() {
    return endDay;
  }

  public void setEndDay(Integer endDay) {
    this.endDay = endDay;
  }

  public SystemCalendar endYear(Integer endYear) {
    this.endYear = endYear;
    return this;
  }

  /**
   * Ending year for the system operations
   * @return endYear
   **/
  @Schema(example = "2099", description = "Ending year for the system operations")
  
    public Integer getEndYear() {
    return endYear;
  }

  public void setEndYear(Integer endYear) {
    this.endYear = endYear;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemCalendar systemCalendar = (SystemCalendar) o;
    return Objects.equals(this.stationId, systemCalendar.stationId) &&
        Objects.equals(this.regionId, systemCalendar.regionId) &&
        Objects.equals(this.startMonth, systemCalendar.startMonth) &&
        Objects.equals(this.startDay, systemCalendar.startDay) &&
        Objects.equals(this.startYear, systemCalendar.startYear) &&
        Objects.equals(this.endMonth, systemCalendar.endMonth) &&
        Objects.equals(this.endDay, systemCalendar.endDay) &&
        Objects.equals(this.endYear, systemCalendar.endYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stationId, regionId, startMonth, startDay, startYear, endMonth, endDay, endYear);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemCalendar {\n");
    
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    startMonth: ").append(toIndentedString(startMonth)).append("\n");
    sb.append("    startDay: ").append(toIndentedString(startDay)).append("\n");
    sb.append("    startYear: ").append(toIndentedString(startYear)).append("\n");
    sb.append("    endMonth: ").append(toIndentedString(endMonth)).append("\n");
    sb.append("    endDay: ").append(toIndentedString(endDay)).append("\n");
    sb.append("    endYear: ").append(toIndentedString(endYear)).append("\n");
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
