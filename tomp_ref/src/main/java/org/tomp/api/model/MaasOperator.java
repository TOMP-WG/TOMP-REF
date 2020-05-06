package org.tomp.api.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Polygon;

/**
 * MaasOperator
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-06T06:58:30.612Z[GMT]")
public class MaasOperator {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("type")
	private MaasEnvironmentType type = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("url")
	private String url = null;

	@JsonProperty("version")
	private String version = null;

	@JsonProperty("validationToken")
	private String validationToken = null;

	@JsonProperty("servicedArea")
	private Polygon servicedArea = null;

	public MaasOperator id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MaasOperator type(MaasEnvironmentType type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 * 
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
	 * 
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
	 * 
	 * @return url
	 **/
	@ApiModelProperty(value = "")

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MaasOperator version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * Get version
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "")

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public MaasOperator validationToken(String validationToken) {
		this.validationToken = validationToken;
		return this;
	}

	/**
	 * can be a thumbprint of a certificate
	 * 
	 * @return validationToken
	 **/
	@ApiModelProperty(value = "can be a thumbprint of a certificate")

	public String getValidationToken() {
		return validationToken;
	}

	public void setValidationToken(String validationToken) {
		this.validationToken = validationToken;
	}

	public MaasOperator servicedArea(Polygon servicedArea) {
		this.servicedArea = servicedArea;
		return this;
	}

	/**
	 * Get servicedArea
	 * 
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
		return Objects.equals(this.id, maasOperator.id) && Objects.equals(this.type, maasOperator.type)
				&& Objects.equals(this.name, maasOperator.name) && Objects.equals(this.url, maasOperator.url)
				&& Objects.equals(this.version, maasOperator.version)
				&& Objects.equals(this.validationToken, maasOperator.validationToken)
				&& Objects.equals(this.servicedArea, maasOperator.servicedArea);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type, name, url, version, validationToken, servicedArea);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MaasOperator {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    url: ").append(toIndentedString(url)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    validationToken: ").append(toIndentedString(validationToken)).append("\n");
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
