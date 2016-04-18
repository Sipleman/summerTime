package controller.Command.Commands;

import controller.Command.Command;
import controller.MainApp;
import controller.view.LogWindowHandler;
import controller.view.membersOverview;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Ilias on 4/16/2016.
 */
public class CallLoginWindowCommand extends AbstractWindowCaller implements Command{


    public CallLoginWindowCommand(BorderPane rootPane, MainApp mainApp){
        super(rootPane, mainApp);
}

    @Override
    public void execute(Stage stage) {
        try{
            FXMLLoader loader = new FXMLLoader();


            loader.setLocation(MainApp.class.getResource("view/loginWindow.fxml"));

            AnchorPane anchorPane = new AnchorPane();
            anchorPane = (AnchorPane) loader.load();

            LogWindowHandler c = loader.getController();

            //anchorPane.getStylesheets().add("view/Stylesheets/loginWindowPreferences.css");

            rootPane.setTop(anchorPane);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
