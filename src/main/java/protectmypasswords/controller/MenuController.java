package protectmypasswords.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private BorderPane mainPane;
    @FXML
    public void menuButtonOneAction(ActionEvent actionEvent) {

        MenuLoaderController menuLoader = new MenuLoaderController();
        Pane view = menuLoader.getPage("menuVue1");
        mainPane.setCenter(view);
    }
    @FXML
    public void menuButtonTwoAction(ActionEvent actionEvent) {
        MenuLoaderController menuLoader = new MenuLoaderController();
        Pane view = menuLoader.getPage("menuVue2");
        mainPane.setCenter(view);
    }
    @FXML
    public void menuButtonThreeAction(ActionEvent actionEvent) {
        MenuLoaderController menuLoader = new MenuLoaderController();
        Pane view = menuLoader.getPage("menuVue3");
        mainPane.setCenter(view);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
