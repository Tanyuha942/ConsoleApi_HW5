package org.goit.model.pets;

import com.google.gson.annotations.SerializedName;
import org.goit.model.IObjectToString;

public class Tag implements IObjectToString {

  @SerializedName("id")
  private Long id;

  @SerializedName("name")
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return jsonObjectString().toJson(this);
  }
}