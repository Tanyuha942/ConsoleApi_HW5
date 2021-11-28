package org.goit;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goit.console.CommandHandler;
import org.goit.service.UserService;

public class App 
{
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        LOGGER.debug("Start application");
        runMainApp();
        LOGGER.info("END application");
    }

    public static void runMainApp() throws Exception {

        CommandHandler commandHandler = new CommandHandler();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            commandHandler.handleCommand(scanner.nextLine());
        }
    }
}
