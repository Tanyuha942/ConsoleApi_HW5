package org.goit.model;

import com.google.gson.annotations.SerializedName;

public class Pet {

  @SerializedName("id")
  private Integer id;

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

}