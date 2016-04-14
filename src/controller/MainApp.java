package controller;

import controller.model.Child;
import controller.model.MySqlConnection.Connector;
import controller.view.LogWindowHandler;
import controller.view.membersOverview;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    Stage primaryStage;
    private BorderPane rootPane;

    private ObservableList<Child> list = FXCollections.observableArrayList();
    public ObservableList<Child> getList(){
        return list;
    }

    //public ObservableList<Child> getListFromTable(){
    //}

    private membersOverview memberController;
    public membersOverview getMemberController(){
        if(memberController!=null)
            return memberController;
        else return null;
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SummerApp");
        initRootWindow();
        showLoginWindow();
        //showMemberWindow();
    }

    private void initRootWindow(){
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

    private void showLoginWindow(){
        try{
            FXMLLoader loader = new FXMLLoader();
            FXMLLoader loader2 = new FXMLLoader();

            loader2.setLocation(MainApp.class.getResource("view/listOfMembers.fxml"));

            loader.setLocation(MainApp.class.getResource("view/loginWindow.fxml"));

            AnchorPane anchorPane = new AnchorPane();
            anchorPane = (AnchorPane) loader2.load();
            anchorPane = (AnchorPane) loader.load();


            membersOverview controller = loader2.getController();
            controller.setMainApp(this);
            LogWindowHandler c = loader.getController();
            c.setMainApp(this);
            //anchorPane.getStylesheets().add("view/Stylesheets/loginWindowPreferences.css");

            rootPane.setTop(anchorPane);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void showMemberWindow(){
        try{
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("view/listOfMembers.fxml"));

            membersOverview controller = loader.getController();
            controller.setMainApp(this);

            AnchorPane anchorPane = (AnchorPane) loader.load();

            rootPane.setTop(anchorPane);


        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public MainApp(){
        list.add(new Child("asdasdasd","asdsa"));
        list.add(new Child("asdasdasd","asdsa"));
        list.add(new Child("asdasdasd","asdsa"));
        list.add(new Child("asdasdasd","asdsa"));
        list.add(new Child("asdasdasd","asdsa"));
        list.add(new Child("asdasdasd","asdsa"));
    }
    public static void main(String[] args) {
        launch(args);
    }
}
