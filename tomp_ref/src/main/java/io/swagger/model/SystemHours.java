package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Day;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SystemHours
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")


public class SystemHours   {
  /**
   * This indicates that this set of rental hours applies to either members or non-members only.
   */
  public enum UserTypeEnum {
    MEMBER("MEMBER"),
    
    NON_MEMBERS("NON_MEMBERS");

    private String value;

    UserTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static UserTypeEnum fromValue(String text) {
      for (UserTypeEnum b : UserTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("userType")
  private UserTypeEnum userType = null;

  @JsonProperty("stationId")
  private String stationId = null;

  @JsonProperty("regionId")
  private String regionId = null;

  @JsonProperty("startTime")
  private String startTime = null;

  @JsonProperty("endTime")
  private String endTime = null;

  @JsonProperty("days")
  @Valid
  private List<Day> days = new ArrayList<Day>();

  public SystemHours userType(UserTypeEnum userType) {
    this.userType = userType;
    return this;
  }

  /**
   * This indicates that this set of rental hours applies to either members or non-members only.
   * @return userType
   **/
  @Schema(example = "MEMBER", description = "This indicates that this set of rental hours applies to either members or non-members only.")
  
    public UserTypeEnum getUserType() {
    return userType;
  }

  public void setUserType(UserTypeEnum userType) {
    this.userType = userType;
  }

  public SystemHours stationId(String stationId) {
    this.stationId = stationId;
    return this;
  }

  /**
   * If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours of the station. (GET /operator/stations)
   * @return stationId
   **/
  @Schema(description = "If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours of the station. (GET /operator/stations)")
  
    public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public SystemHours regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

  /**
   * If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours for the region. (GET /operator/regions)
   * @return regionId
   **/
  @Schema(description = "If this parameter is present, it means that startTime and endTime correspond to the opening and closing hours for the region. (GET /operator/regions)")
  
    public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public SystemHours startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public SystemHours endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public SystemHours days(List<Day> days) {
    this.days = days;
    return this;
  }

  public SystemHours addDaysItem(Day daysItem) {
    this.days.add(daysItem);
    return this;
  }

  /**
   * An array of abbreviations (first 3 letters) of English names of the days of the week that this hour object applies to (i.e. [\"mon\", \"tue\"]). Each day can only appear once within all of the hours objects in this feed.
   * @return days
   **/
  @Schema(required = true, description = "An array of abbreviations (first 3 letters) of English names of the days of the week that this hour object applies to (i.e. [\"mon\", \"tue\"]). Each day can only appear once within all of the hours objects in this feed.")
      @NotNull
    @Valid
    public List<Day> getDays() {
    return days;
  }

  public void setDays(List<Day> days) {
    this.days = days;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemHours systemHours = (SystemHours) o;
    return Objects.equals(this.userType, systemHours.userType) &&
        Objects.equals(this.stationId, systemHours.stationId) &&
        Objects.equals(this.regionId, systemHours.regionId) &&
        Objects.equals(this.startTime, systemHours.startTime) &&
        Objects.equals(this.endTime, systemHours.endTime) &&
        Objects.equals(this.days, systemHours.days);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userType, stationId, regionId, startTime, endTime, days);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemHours {\n");
    
    sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    days: ").append(toIndentedString(days)).append("\n");
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
