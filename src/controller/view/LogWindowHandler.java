package controller.view;

import com.sun.javafx.collections.ObservableListWrapper;
import controller.MainApp;
import controller.model.Child;
import controller.model.MySqlConnection.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

import java.io.IOException;


/**
 * Created by Ilias on 3/15/2016.
 */
public class LogWindowHandler {

    MainApp main;

    @FXML private Label action;
    @FXML private TextField loginField;
    @FXML private PasswordField passwordField;

    @FXML
    protected void singIn(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
      if(Connector.tryLogin(loginField.getText(), passwordField.getText())){
          action.setText("Success");
          stage = (Stage) action.getScene().getWindow();

          FXMLLoader loader = new FXMLLoader();

          loader.setLocation(MainApp.class.getResource("view/listOfMembers.fxml"));

          root= loader.load();

          membersOverview controller = loader.getController();
          controller.setMainApp(this.main);

          ObservableList<Child> list = FXCollections.observableArrayList();
          list.add(new Child("name", "zaebalo"));
          list.add(new Child("zaebalo", "prosto"));
          controller.setList(Connector.getChildList());

          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
        }
        else action.setText("Failed");
    }
    @FXML
    private void initialize(){
    }
    public String getLogin(){
        return loginField.getText();
    }

    public String getPasswordField() {
        return passwordField.getText();
    }
    public void setMainApp(MainApp mainApp){
        this.main = mainApp;
    }
}
