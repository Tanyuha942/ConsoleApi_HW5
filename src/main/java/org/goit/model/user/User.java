package org.goit.model.user;

import com.google.gson.annotations.SerializedName;

public class User {

  @SerializedName("id")
  private Integer id = 0;

  @SerializedName("username")
  private String userName = "string";

  @SerializedName("firstname")
  private String firstName = "string";

  @SerializedName("lastname")
  private String lastName = "string";

  @SerializedName("email")
  private String email = "string";

  @SerializedName("password")
  private String password = "string";

  @SerializedName("phone")
  private String phone = "string";

  @SerializedName("userstatus")
  private Integer userStatus = 0;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Integer userStatus) {
    this.userStatus = userStatus;
  }
}