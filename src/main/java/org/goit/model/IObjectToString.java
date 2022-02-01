package org.goit.model;

import com.google.gson.*;

public interface IObjectToString {

  default Gson jsonObjectString() {
    GsonBuilder builder = new GsonBuilder();
    return builder.create();
  }
}