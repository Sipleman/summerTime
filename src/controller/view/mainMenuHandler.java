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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.SwipeEvent;
import javafx.stage.Stage;

/**
 * Created by Ilias on 4/17/2016.
 */
public class mainMenuHandler {


    @FXML private Label stateLabel;

    @FXML private Button addNewChildButton;

    @FXML private Button reviewChildsButton;

    @FXML private Button addNewEmployeeButton;

    @FXML private Button reviewEmployersButton;

    @FXML private Button reviewScheduleButton;

//    @FXML private Button addNewEmployeeButton;
//
//    @FXML private Button addNewEmployeeButton;



    @FXML
    private void showChildOverview(){
        Switcher.callReviewOfMembers((Stage) reviewChildsButton.getScene().getWindow());
    }


    @FXML
    void initialize(){

    }
}
