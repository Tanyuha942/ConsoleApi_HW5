package org.goit.service;

import com.google.gson.Gson;
import io.netty.handler.codec.http.HttpMethod;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.http.HttpException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.goit.api_response.InventoryResponse;
import org.goit.api_response.ApiResponse;
import org.goit.model.store.Store;

public class StoreService {

  private static final String URL = "https://petstore.swagger.io/v2/store";
  private static HttpGet httpGet;
  private static final Gson GSON = new Gson();
  private static final Store store = new Store();

  private static String getBody(Integer id, Integer petId, Integer quantity) {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    format.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date date = new Date(System.currentTimeMillis());
    store.setId(id);
    store.setPetId(petId);
    store.setQuantity(quantity);
    store.setShipDate(format.format(date));
    return GSON.toJson(store);
  }

  public static InventoryResponse inventory() throws IOException, HttpException {
    httpGet = (HttpGet) HttpApiService.methodOfHttp(new URL(URL + "/inventory"), HttpMethod.GET);
    return GSON.fromJson(HttpApiService.getRequest(httpGet), InventoryResponse.class);
  }

  public static Store orderPet(Integer id, Integer petId, Integer quantity)
      throws IOException, HttpException {
    HttpPost httpPost = (HttpPost) HttpApiService.methodOfHttp(new URL(URL + "/order"),
        HttpMethod.POST);
    String json = getBody(id, petId, quantity);
    httpPost.setEntity(new StringEntity(json));
    return GSON.fromJson(HttpApiService.getRequest(httpPost), Store.class);
  }

  public static ApiResponse findOrderById(Integer id) throws IOException, HttpException {
    httpGet = (HttpGet) HttpApiService.methodOfHttp(new URL(URL + "/order/" + id), HttpMethod.GET);
    return GSON.fromJson(HttpApiService.getRequest(httpGet), ApiResponse.class);
  }

  public static ApiResponse deleteOrderById(Integer id) throws IOException, HttpException {
    HttpDelete httpDelete = (HttpDelete) HttpApiService
        .methodOfHttp(new URL(URL + "/order/" + id), HttpMethod.DELETE);
    return GSON.fromJson(HttpApiService.getRequest(httpDelete), ApiResponse.class);
  }
}