package protectmypasswords.controller;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Menu3Controller implements Initializable {

    public void startPanel(BorderPane mainPane){

        MenuLoaderController menuLoader = new MenuLoaderController();
        Pane view = menuLoader.getPage("menuVue3");
        mainPane.setCenter(view);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
