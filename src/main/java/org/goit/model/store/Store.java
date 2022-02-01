package org.goit.model.store;

import com.google.gson.annotations.SerializedName;
import org.goit.model.IObjectToString;

public class Store implements IObjectToString {

  @SerializedName("id")
  private Integer id;

  @SerializedName("petId")
  private Integer petId;

  @SerializedName("quantity")
  private Integer quantity;

  @SerializedName("shipDate")
  private String shipDate;

  @SerializedName("status")
  private String status;

  @SerializedName("complete")
  private boolean complete;

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

  @Override
  public String toString() {
    return jsonObjectString().toJson(this);
  }
}
