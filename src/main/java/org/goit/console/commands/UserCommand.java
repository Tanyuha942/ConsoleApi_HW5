package org.goit.console.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.apache.http.HttpException;
import org.apache.logging.log4j.LogManager;
import org.goit.console.Command;
import org.goit.model.user.User;
import org.goit.service.UserService;

public class UserCommand implements Command {

  private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(
      UserCommand.class);
  private String[] paramsArray = new String[0];

  @Override
  public void handle(String params, Consumer<Command> setActive) throws Exception {
    paramsArray = params.split(" ");
    String subParams = String.join(" ", params.replace(paramsArray[0] + " ", ""));
    switch (paramsArray[0]) {
      case "createUser":
        createUser(subParams);
        break;
      case "getUserByName":
        getUserByName(subParams);
        break;
      case "updateUser":
        updateUser(subParams);
        break;
      case "deleteUser":
        deleteUser(subParams);
        break;
      case "userLogin":
        userLogin(subParams);
        break;
      case "userLogout":
        userLogout();
        break;
      case "createWithList":
        createWithList(subParams);
        break;
    }
  }

  private void createUser(String params) throws HttpException, IOException {
    paramsArray = params.split(" ");
    if (paramsArray.length > 1) {
      System.out.println(UserService.createUser(
          Long.parseLong(paramsArray[0]),
          paramsArray[1],
          paramsArray[2],
          paramsArray[3],
          paramsArray[4],
          paramsArray[5],
          paramsArray[6],
          Integer.parseInt(paramsArray[7])));
    }
  }

  private void getUserByName(String params) throws HttpException, IOException {
    paramsArray = params.split(" ");
    System.out.println(UserService.getUserByName(paramsArray[0]));
  }

  private void updateUser(String params) throws HttpException, IOException {
    paramsArray = params.split(" ");
    if (paramsArray.length == 8) {
      System.out.println(UserService
          .updateUser(Long.parseLong(paramsArray[0]),
              paramsArray[1],
              paramsArray[2],
              paramsArray[3],
              paramsArray[4],
              paramsArray[5],
              paramsArray[6],
              Integer.parseInt(paramsArray[7])));
  }

}

  private void deleteUser(String params) throws HttpException, IOException {
    paramsArray = params.split(" ");
    System.out.println(UserService.deleteUser(paramsArray[0]));
  }

  private void userLogin(String params) throws HttpException, IOException {
    paramsArray = params.split(" ");
    System.out.println(UserService.userLogin(paramsArray[0],
                                             paramsArray[1]));
  }

  private void userLogout() throws HttpException, IOException {
    System.out.println(UserService.userLogout());
  }

  public static void createWithList(String params) throws HttpException, IOException {
    List<User> users = new ArrayList<>();
    List<String> userList = List.of(params.split(";"));
    for (String s : userList) {
      if (s.split(" ").length != 0) {
        List<String> str = List.of(s.split(" "));
        User user = new User();
        user.setId(Long.parseLong(str.get(0)));
        user.setUserName(str.get(1));
        user.setFirstName(str.get(2));
        user.setLastName(str.get(3));
        user.setEmail(str.get(4));
        user.setPassword(str.get(5));
        user.setPhone(str.get(6));
        user.setUserStatus(Integer.parseInt(str.get(7)));
        users.add(user);
      }
    }
//    System.out.println(users);
    System.out.println(UserService.createWithList(users));
  }

  @Override
  public void printActiveMenu() {
    LOGGER.info("---------------------User menu---------------------");
    LOGGER.info("Users command list:");
    LOGGER.info("createUser [id] [userName] [firstName] [lastName] [email] [password] [phone] [status(0)]");
    LOGGER.info("getUserByName [username]");
    LOGGER.info("updateUser [id] [userName] [firstName] [lastName] [email] [password] [phone] [status(0)]");
    LOGGER.info("deleteUser [username]");
    LOGGER.info("userLogin [userName] [password]");
    LOGGER.info("createWithList [id] [userName] [firstName] [lastName] [email] [password] [phone] [status(0)];[id] [userName] [firstName] [lastName] [email] [password] [phone] [status(0)]...");
    LOGGER.info("userLogout");
  }
}