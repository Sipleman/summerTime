package controller.view;

import controller.Command.Switcher;
import controller.MainApp;
import controller.model.members.Child;
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

import java.io.IOException;


/**
 * Created by Ilias on 3/15/2016.
 */
public class LogWindowHandler {

    boolean failed;

    static MainApp main;

    @FXML private Label action;
    @FXML private TextField loginField;
    @FXML private PasswordField passwordField;

    @FXML
    protected void singIn(ActionEvent event) throws IOException{

      if(Connector.tryLogin(loginField.getText(), passwordField.getText())){
          action.setText("Success");


          Switcher.callMainMenu((Stage) action.getScene().getWindow());

//          Switcher.callReviewOfMembers((Stage) action.getScene().getWindow());





//          Switcher.callLoginWindow((Stage) action.getScene().getWindow());
//          Stage stage;
//          Parent root;
//
//
//          stage = (Stage) action.getScene().getWindow();
//
//          FXMLLoader loader = new FXMLLoader();
//
//          loader.setLocation(MainApp.class.getResource("view/listOfMembers.fxml"));
//
//          root = loader.load();
//
//          membersOverview controller = loader.getController();
//          controller.setMainApp(this.main);
//
//          ObservableList<Child> list = FXCollections.observableArrayList();
//
//          list.add(new Child("Misha", "Litovskiy", "kovalskiy 166, 5", 12, "0951231451", "0931235123", "1999-03-23"));
//          list.add(new Child("Gosha", "Novalenko", "trogan 155, 2", 13, "0951421451", "0931212123", "1999-12-04"));
//          controller.setList(Connector.getChildList());
//
//          Scene scene = new Scene(root);
//          stage.setScene(scene);
//          stage.show();
        }
        else {
          if(failed) {
              action.setText("Failed again!");
              failed = false;
          }
          else {
              action.setText("Failed");
              failed = true;
          }
      }

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
        main = mainApp;
    }

}
