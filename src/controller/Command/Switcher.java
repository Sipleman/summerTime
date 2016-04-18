package controller.Command;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilias on 4/16/2016.
 */
//invoker class for calling new windows of JavaFX application

public final class Switcher {
    private static Command logWindow;
    private static Command listOfMembers;
    private static Command initRootPane;

    public static void callMainMenu(Stage stage) {
        mainMenu.execute(stage);
    }

    private static Command mainMenu;

    public static void initCommands(Command log, Command listofM, Command initRootPane){
        logWindow = log;
        listOfMembers = listofM;
        initRootPane = initRootPane;
    }

    private Switcher(){

    }

    public static void initCommands(List<Command> listOfCommands){
        logWindow = listOfCommands.get(0);
        listOfMembers = listOfCommands.get(1);
        mainMenu = listOfCommands.get(2);
        initRootPane = listOfCommands.get(listOfCommands.size()-1);
    }

    public static void callLoginWindow(Stage stage){
        logWindow.execute(stage);
    }

    public static void initRootpane(Stage stage){
        initRootPane.execute(stage);
    }
    public static void callReviewOfMembers(Stage stage){
        listOfMembers.execute(stage);
    }

}
