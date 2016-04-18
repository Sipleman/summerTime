package controller.Command.Commands;

import controller.Command.Command;
import controller.MainApp;
import controller.model.members.Child;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Ilias on 4/17/2016.
 */
public class CallMainMenuWindow extends AbstractWindowCaller implements Command {

    public CallMainMenuWindow(BorderPane rootPane, MainApp mainApp) {
        super(rootPane, mainApp);
    }

    @Override
    public void execute(Stage stage) {
        try{
            Parent root;

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("view/MainMenuBar.fxml"));

            root = loader.load();

            //membersOverview controller = loader.getController();
            //controller.setMainApp((MainApp) this.mainApp);

            //ObservableList<Child> list = FXCollections.observableArrayList();

            //list.add(new Child("Misha", "Litovskiy", "kovalskiy 166, 5", 12, "0951231451", "0931235123", "1999-03-23"));
            //list.add(new Child("Gosha", "Novalenko", "trogan 155, 2", 13, "0951421451", "0931212123", "1999-12-04"));
            //controller.setList(Connector.getChildList());

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
