package org.goit.model.user;

import com.google.gson.annotations.SerializedName;
import org.goit.model.IObjectToString;

public class User implements IObjectToString {

  @SerializedName("id")
  private long id;

  @SerializedName("username")
  private String userName;

  @SerializedName("firstname")
  private String firstName;

  @SerializedName("lastname")
  private String lastName;

  @SerializedName("email")
  private String email;

  @SerializedName("password")
  private String password;

  @SerializedName("phone")
  private String phone;

  @SerializedName("userstatus")
  private int userStatus;

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public int getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(int userStatus) {
    this.userStatus = userStatus;
  }

  @Override
  public String toString() {
    return jsonObjectString().toJson(this);
  }
}