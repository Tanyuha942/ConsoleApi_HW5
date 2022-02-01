package org.goit.api_response;

import com.google.gson.annotations.SerializedName;
import org.goit.model.IObjectToString;

public class InventoryResponse implements IObjectToString {

  @SerializedName("1")
  public int _1;
  public int sold;
  public int string;
  public int alive;
  public int test;
  @SerializedName("Busy")
  public int busy;
  public int pending;
  public int happy;
  public int available;
  public int avalible;
  @SerializedName("Not Available")
  public int notAvailable;
  @SerializedName("pending ")
  public int pending_;
  @SerializedName("7b")
  public int _7b;
  @SerializedName("Miaooo")
  public int miaooo;
  @SerializedName("AVAILABLE")
  public int aVAILABLE;
  @SerializedName("SOLD")
  public int sOLD;
  @SerializedName("Active")
  public int active;
  public int vendida;
  public int avaliable;
  public int connector_up;
  public int ghoul;
  @SerializedName("Available")
  public int Available;
  @SerializedName("successfully created")
  public int successfullyCreated;
  public int status;

  @Override
  public String toString() {
    return jsonObjectString().toJson(this);
  }
}