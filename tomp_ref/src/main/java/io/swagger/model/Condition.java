package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Condition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-10T13:55:00.069Z[GMT]")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "conditionType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConditionDeposit.class, name = "conditionDeposit"),
        @JsonSubTypes.Type(value = ConditionPostponedCommit.class, name = "conditionPostponedCommit"),
        @JsonSubTypes.Type(value = ConditionUpfrontPayment.class, name = "conditionUpfrontPayment"),
        @JsonSubTypes.Type(value = ConditionPayWhenFinished.class, name = "conditionPayWhenFinished"),
        @JsonSubTypes.Type(value = ConditionRequireBookingData.class, name = "conditionRequireBookingData"),
        @JsonSubTypes.Type(value = ConditionReturnArea.class, name = "conditionReturnArea"),
})


public class Condition  implements OneOfcondition {
  @JsonTypeId
  private String conditionType = null;

  @JsonProperty("id")
  private String id = null;

  public Condition conditionType(String conditionType) {
    this.conditionType = conditionType;
    return this;
  }

  /**
   * The specific subclass of condition, should match the schema name exactly
   * @return conditionType
  **/
  @ApiModelProperty(required = true, value = "The specific subclass of condition, should match the schema name exactly")
      @NotNull

    public String getConditionType() {
    return conditionType;
  }

  public void setConditionType(String conditionType) {
    this.conditionType = conditionType;
  }

  public Condition id(String id) {
    this.id = id;
    return this;
  }

  /**
   * An identifier for this condition that can be used to refer to this condition
   * @return id
  **/
  @ApiModelProperty(example = "deposit50eu", value = "An identifier for this condition that can be used to refer to this condition")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
    Condition condition = (Condition) o;
    return Objects.equals(this.conditionType, condition.conditionType) &&
        Objects.equals(this.id, condition.id);
	}

	@Override
	public int hashCode() {
    return Objects.hash(conditionType, id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Condition {\n");

    sb.append("    conditionType: ").append(toIndentedString(conditionType)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
