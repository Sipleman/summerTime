package controller.Command.Commands;

import controller.Command.Command;
import controller.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Ilias on 4/16/2016.
 */
public class InitRootPane implements Command {

    Stage primaryStage;
    BorderPane rootPane;

    public InitRootPane(BorderPane rootPane, Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.rootPane = rootPane;

    }

    @Override
    public void execute(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("view/rootWindow.fxml"));

            rootPane = (BorderPane) loader.load();

            Scene scene = new Scene(rootPane);
            scene.getStylesheets().add(MainApp.class.getResource("view/Stylesheets/loginWindowPreferences.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
