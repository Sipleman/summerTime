package controller.view;

import controller.MainApp;
import controller.model.Child;
import controller.model.utils.DateUtil;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Ilias on 08.03.2016.
 */
public class membersOverview {
    @FXML
    private TableView<Child> table;
    @FXML
    private TableColumn<Child, String> firstNameColumn;
    @FXML
    private TableColumn<Child, String> lastNameColumn;


    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label adressLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label contactLabel;
    @FXML
    private Label parentContact;


    private MainApp mainApp;

    @FXML
    private void initialize(){
        firstNameColumn.setCellValueFactory(cell -> cell.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cell -> cell.getValue().lastNameProperty());

        showPersonDetails(null);

        table.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));

    }

    private void showPersonDetails(Child person){
        if (person != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));

            // TODO: We need a way to convert the birthday into a String!
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText(" ");
            lastNameLabel.setText(" ");
            birthdayLabel.setText(" ");
        }
    }

    public void setMainApp(MainApp m){
        mainApp = m;
        table.setItems(m.getList());
    }

    public void setList(ObservableList<Child> list){
        table.setItems(list);
    }

}
