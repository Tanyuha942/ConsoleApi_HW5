package org.goit.model.store;

import com.google.gson.annotations.SerializedName;

public class Store {

  @SerializedName("id")
  private Integer id = 0;

  @SerializedName("petId")
  private Integer petId = 0;

  @SerializedName("quantity")
  private Integer quantity = 0;

  @SerializedName("shipDate")
  private String shipDate;

  @SerializedName("status")
  private final String status = "placed";

  @SerializedName("complete")
  private final boolean complete = true;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPetId() {
    return petId;
  }

  public void setPetId(Integer petId) {
    this.petId = petId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public String getShipDate() {
    return shipDate;
  }

  public void setShipDate(String shipDate) {
    this.shipDate = shipDate;
  }

  public String getStatus() {
    return status;
  }

  public boolean isComplete() {
    return complete;
  }
}
