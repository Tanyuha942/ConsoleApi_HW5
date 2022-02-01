package org.goit.service;

import com.google.gson.Gson;
import io.netty.handler.codec.http.HttpMethod;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.goit.api_response.ApiResponse;
import org.goit.model.user.User;

public class UserService {

  private static final String URL = "https://petstore.swagger.io/v2/user";
  private static HttpPost httpPost;
  private static HttpGet httpGet;
  private static final Gson GSON = new Gson();
  private static final User user = new User();

  public static String getBody(long id, String userName, String firstName, String lastName,
      String email, String password, String phone, int status) {
    user.setId(id);
    user.setUserName(userName);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setEmail(email);
    user.setPassword(password);
    user.setPhone(phone);
    user.setUserStatus(status);
    return GSON.toJson(user);
  }

  public static ApiResponse createUser(long id, String userName, String firstName, String lastName,
      String email, String password, String phone, int status) throws IOException, HttpException {
    httpPost = (HttpPost) HttpApiService
        .methodOfHttp(new URL(URL), HttpMethod.POST);
    String json = getBody(id, userName, firstName, lastName, email, password, phone, status);
    httpPost.setEntity(new StringEntity(json));
    return GSON.fromJson(HttpApiService.getRequest(httpPost), ApiResponse.class);
  }

  public static User getUserByName(String userName) throws IOException, HttpException {
    httpGet = (HttpGet) HttpApiService
        .methodOfHttp(new URL(URL + "/" + userName), HttpMethod.GET);
    return GSON.fromJson(HttpApiService.getRequest(httpGet), User.class);
  }

  public static ApiResponse updateUser(long id, String userName, String firstName, String lastName,
      String email, String password, String phone, int status) throws IOException, HttpException {
    HttpPut httpPut = (HttpPut) HttpApiService
        .methodOfHttp(new URL(URL + "/" + userName), HttpMethod.PUT);
    String json = getBody(id, userName, firstName, lastName, email, password, phone, status);
    httpPut.setEntity(new StringEntity(json));
    return GSON.fromJson(HttpApiService.getRequest(httpPut), ApiResponse.class);
  }

  public static ApiResponse deleteUser(String userName) throws IOException, HttpException {
    HttpDelete httpDelete = (HttpDelete) HttpApiService
        .methodOfHttp(new URL(URL + "/" + userName), HttpMethod.DELETE);
    return GSON.fromJson(HttpApiService.getRequest(httpDelete), ApiResponse.class);
  }

  public static ApiResponse userLogin(String userName, String password)
      throws IOException, HttpException {
    httpGet = (HttpGet) HttpApiService
        .methodOfHttp(new URL(URL+ "/login?username=" + userName + "&password=" + password), HttpMethod.GET);
    return GSON.fromJson(HttpApiService.getRequest(httpGet), ApiResponse.class);
  }

  public static ApiResponse userLogout() throws IOException, HttpException {
    httpGet = (HttpGet) HttpApiService
        .methodOfHttp(new URL(URL+ "/logout"), HttpMethod.GET);
    return GSON.fromJson(HttpApiService.getRequest(httpGet), ApiResponse.class);
  }

  public static ApiResponse createWithList(List<User> users) throws IOException, HttpException {
    httpPost = (HttpPost) HttpApiService.methodOfHttp(new URL(URL + "/createWithList"), HttpMethod.POST);
    httpPost.setEntity(new StringEntity(GSON.toJson(users)));
    return GSON.fromJson(HttpApiService.getRequest(httpPost), ApiResponse.class);
  }
}