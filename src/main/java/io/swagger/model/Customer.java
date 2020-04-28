package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Address;
import io.swagger.model.Card;
import io.swagger.model.License;
import io.swagger.model.Phone;
import io.swagger.model.Requirements;
import io.swagger.model.User;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * a person that wants to travel. Only use the properties that are needed.
 */
@ApiModel(description = "a person that wants to travel. Only use the properties that are needed.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class Customer extends User  {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("initials")
  private String initials = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("prefix")
  private String prefix = null;

  @JsonProperty("postfix")
  private String postfix = null;

  @JsonProperty("phones")
  @Valid
  private List<Phone> phones = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("birthDate")
  private LocalDate birthDate = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("photo")
  private byte[] photo = null;

  public Customer id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier MaaS uses to identify the customer
   * @return id
  **/
  @ApiModelProperty(example = "A0-123456", required = true, value = "The identifier MaaS uses to identify the customer")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Customer initials(String initials) {
    this.initials = initials;
    return this;
  }

  /**
   * Get initials
   * @return initials
  **/
  @ApiModelProperty(value = "")
  
    public String getInitials() {
    return initials;
  }

  public void setInitials(String initials) {
    this.initials = initials;
  }

  public Customer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name of the customer
   * @return firstName
  **/
  @ApiModelProperty(example = "John", value = "First name of the customer")
  
    public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Customer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name of the customer
   * @return lastName
  **/
  @ApiModelProperty(example = "Doe", value = "Last name of the customer")
  
    public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Customer middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Middle name of the customer
   * @return middleName
  **/
  @ApiModelProperty(example = "von", value = "Middle name of the customer")
  
    public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public Customer prefix(String prefix) {
    this.prefix = prefix;
    return this;
  }

  /**
   * prefix of the customer, like titles
   * @return prefix
  **/
  @ApiModelProperty(value = "prefix of the customer, like titles")
  
    public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public Customer postfix(String postfix) {
    this.postfix = postfix;
    return this;
  }

  /**
   * postfix of the customer, like titles
   * @return postfix
  **/
  @ApiModelProperty(value = "postfix of the customer, like titles")
  
    public String getPostfix() {
    return postfix;
  }

  public void setPostfix(String postfix) {
    this.postfix = postfix;
  }

  public Customer phones(List<Phone> phones) {
    this.phones = phones;
    return this;
  }

  public Customer addPhonesItem(Phone phonesItem) {
    if (this.phones == null) {
      this.phones = new ArrayList<Phone>();
    }
    this.phones.add(phonesItem);
    return this;
  }

  /**
   * Get phones
   * @return phones
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  public Customer email(String email) {
    this.email = email;
    return this;
  }

  /**
   * the email address of the customer
   * @return email
  **/
  @ApiModelProperty(value = "the email address of the customer")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Customer birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * @return birthDate
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Customer address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Customer photo(byte[] photo) {
    this.photo = photo;
    return this;
  }

  /**
   * base64 encoded
   * @return photo
  **/
  @ApiModelProperty(value = "base64 encoded")
  
    public byte[] getPhoto() {
    return photo;
  }

  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.id, customer.id) &&
        Objects.equals(this.initials, customer.initials) &&
        Objects.equals(this.firstName, customer.firstName) &&
        Objects.equals(this.lastName, customer.lastName) &&
        Objects.equals(this.middleName, customer.middleName) &&
        Objects.equals(this.prefix, customer.prefix) &&
        Objects.equals(this.postfix, customer.postfix) &&
        Objects.equals(this.phones, customer.phones) &&
        Objects.equals(this.email, customer.email) &&
        Objects.equals(this.birthDate, customer.birthDate) &&
        Objects.equals(this.address, customer.address) &&
        Objects.equals(this.photo, customer.photo) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, initials, firstName, lastName, middleName, prefix, postfix, phones, email, birthDate, address, photo, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    initials: ").append(toIndentedString(initials)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
    sb.append("    postfix: ").append(toIndentedString(postfix)).append("\n");
    sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
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
