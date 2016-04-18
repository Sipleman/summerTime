package controller.Command.Commands;

import controller.MainApp;
import javafx.scene.layout.BorderPane;

/**
 * Created by Ilias on 4/16/2016.
 */
public abstract class AbstractWindowCaller {
    BorderPane rootPane;
    MainApp mainApp;

    public AbstractWindowCaller(BorderPane rootPane, MainApp mainApp) {
        this.rootPane = rootPane;
        this.mainApp = mainApp;
    }
}
