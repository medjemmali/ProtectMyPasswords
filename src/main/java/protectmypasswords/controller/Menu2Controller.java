package protectmypasswords.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Menu2Controller implements Initializable {


    @FXML
    private TextField urlAddressField;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField masterPasswordField;

    @FXML
    private Button saveButton;
    @FXML
    private Label informationMessage;

    public void startPanel(BorderPane mainPane){

        MenuLoaderController menuLoader = new MenuLoaderController();
        Pane view = menuLoader.getPage("menuVue2");
        mainPane.setCenter(view);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onLoginButtonClick(ActionEvent actionEvent) {
    }
}
