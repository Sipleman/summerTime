package controller.Command.Commands;

import controller.Command.Command;
import controller.MainApp;
import controller.model.MySqlConnection.Connector;
import controller.model.members.Child;
import controller.view.membersOverview;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Ilias on 4/16/2016.
 */
public class CallMembersOverview extends AbstractWindowCaller implements Command {

    public CallMembersOverview(BorderPane borderPane, MainApp mainApp){
        super(borderPane, mainApp);

    }

    @Override
    public void execute(Stage stage) {
        try{
//            FXMLLoader loader = new FXMLLoader();
//
//            loader.setLocation(MainApp.class.getResource("view/listOfMembers.fxml"));
//
//            membersOverview controller = loader.getController();
//            controller.setMainApp((MainApp) mainApp);
//
//            AnchorPane anchorPane = (AnchorPane) loader.load();
//
//            rootPane.setTop(anchorPane);

            Parent root;

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("view/listOfMembers.fxml"));

            root = loader.load();

            membersOverview controller = loader.getController();
            controller.setMainApp((MainApp) this.mainApp);

            ObservableList<Child> list = FXCollections.observableArrayList();

            list.add(new Child("Misha", "Litovskiy", "kovalskiy 166, 5", 12, "0951231451", "0931235123", "1999-03-23", "1"));
            list.add(new Child("Gosha", "Novalenko", "trogan 155, 2", 13, "0951421451", "0931212123", "1999-12-04", "1"));
            controller.setList(Connector.getChildList());

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
