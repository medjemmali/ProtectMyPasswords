package protectmypasswords.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;
// Video  for help with the menu architecture: https://www.youtube.com/watch?v=5yQbt6lYRqk
public class MenuController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    public void menuButtonOneAction(ActionEvent actionEvent) {

//        MenuLoaderController menuLoader = new MenuLoaderController();
//        Pane view = menuLoader.getPage("menuVue1");
//        mainPane.setCenter(view);
        new Menu1Controller().startPanel(mainPane);
    }
    @FXML
    public void menuButtonTwoAction(ActionEvent actionEvent) {
        new Menu2Controller().startPanel(mainPane);
    }
    @FXML
    public void menuButtonThreeAction(ActionEvent actionEvent) {
        new Menu3Controller().startPanel(mainPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


}
