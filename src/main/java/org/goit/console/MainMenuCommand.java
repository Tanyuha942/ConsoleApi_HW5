package org.goit.console;

import java.util.*;
import java.util.function.Consumer;
import org.apache.logging.log4j.*;
import org.goit.console.commands.*;

public class MainMenuCommand implements Command {

  private static final Logger LOGGER = LogManager.getLogger(MainMenuCommand.class);

  Map<String, Command> commands = Map.of(
      "pets", new PetsCommand(),
      "store", new StoreCommand(),
      "users", new UserCommand()
  );

  @Override
  public void handle(String params, Consumer<Command> setActive) {
    Optional<String> commandString = getCommandString(params);
    commandString.map(commands::get)
        .ifPresent(command -> {
          try {
            setActive.accept(command);
            command.handle(params.replace(commandString.get(), "").trim(), setActive);
          } catch (Exception e) {
            LOGGER.error("ParseException error: " + e);
          }
        });
  }

  @Override
  public void printActiveMenu() {
    LOGGER.info("---------------------Main menu---------------------");
    LOGGER.info("Main commands: [main, active, exit]");
    LOGGER.info("Command list: " + this.commands.keySet());
  }
}