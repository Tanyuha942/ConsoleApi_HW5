package org.goit.service;

import com.google.gson.Gson;
import io.netty.handler.codec.http.HttpMethod;
import java.io.IOException;
import java.net.URL;
import org.apache.http.HttpException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.goit.model.user.User;

public class UserService {

  private static final String URL = "https://petstore.swagger.io/v2/user";
  private static HttpPost httpPost;
  private static HttpGet httpGet;
  private static final Gson GSON = new Gson();
  private static final User user = new User();

  public static String getBody(Integer id, String userName, String firstName, String lastName,
      String email, String password, String phone, Integer status) {

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

  public static  String createUser(Integer id, String userName, String firstName, String lastName,
      String email, String password, String phone, Integer status) throws IOException, HttpException {
    httpPost = (HttpPost) HttpApiService
        .methodOfHttp(new URL(URL), HttpMethod.POST);
    String json = getBody(id, userName, firstName, lastName, email, password, phone, status);
    httpPost.setEntity(new StringEntity(json));
    return HttpApiService.getRequest(httpPost);
  }

  public static  String createUser() throws HttpException, IOException {
    return createUser(user.getId(), user.getUserName(), user.getFirstName(), user.getLastName(),
        user.getEmail(), user.getPassword(), user.getPhone(), user.getUserStatus());
  }

  public static String getUserByName(String userName) throws IOException, HttpException {
    httpGet = (HttpGet) HttpApiService
        .methodOfHttp(new URL(URL + "/" + userName), HttpMethod.GET);
    return HttpApiService.getRequest(httpGet);
  }

  public static String updateUser(Integer id, String userName, String firstName, String lastName,
      String email, String password, String phone, Integer status) throws IOException, HttpException {
    HttpPut httpPut = (HttpPut) HttpApiService
        .methodOfHttp(new URL(URL + "/" + userName), HttpMethod.PUT);
    String json = getBody(id, userName, firstName, lastName, email, password, phone, status);
    httpPut.setEntity(new StringEntity(json));
    return HttpApiService.getRequest(httpPut);
  }

  public static String updateUser(String userName) throws IOException, HttpException {
    return updateUser(user.getId(), userName, user.getFirstName(), user.getLastName(),
        user.getEmail(), user.getPassword(), user.getPhone(), user.getUserStatus());
  }

  public static String deleteUser(String userName) throws IOException, HttpException {
    HttpDelete httpDelete = (HttpDelete) HttpApiService
        .methodOfHttp(new URL(URL + "/" + userName), HttpMethod.DELETE);
    return HttpApiService.getRequest(httpDelete);
  }

  public static String userLogin(String userName, String password)
      throws IOException, HttpException {
    httpGet = (HttpGet) HttpApiService
        .methodOfHttp(new URL(URL+ "/login?username=" + userName + "&password=" + password), HttpMethod.GET);
    return HttpApiService.getRequest(httpGet);
  }

  public static String userLogout() throws IOException, HttpException {
    httpGet = (HttpGet) HttpApiService
        .methodOfHttp(new URL(URL+ "/logout"), HttpMethod.GET);
    return HttpApiService.getRequest(httpGet);
  }
}