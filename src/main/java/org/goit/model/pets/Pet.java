package org.goit.model.pets;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.goit.model.IObjectToString;

public class Pet implements IObjectToString {

  @SerializedName("id")
  private Long id;

  @SerializedName("category")
  private Category category;

  @SerializedName("name")
  private String name;

  @SerializedName("photoUrls")
  private List<String> photoUrls;

  @SerializedName("tags")
  private List<Tag> tags;

  @SerializedName("status")
  private String status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return jsonObjectString().toJson(this);
  }
}