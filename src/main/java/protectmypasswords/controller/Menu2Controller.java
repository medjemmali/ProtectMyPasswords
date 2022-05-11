package protectmypasswords.controller;

import com.github.cliftonlabs.json_simple.JsonException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import protectmypasswords.module.JsonModule;
import protectmypasswords.module.UserData;

import java.io.IOException;
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
    private Label informationMessage2;

    public void startPanel(BorderPane mainPane){

        MenuLoaderController menuLoader = new MenuLoaderController();
        Pane view = menuLoader.getPage("menuVue2");
        mainPane.setCenter(view);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onLoginButtonClick(ActionEvent actionEvent) throws JsonException, IOException {

        String masterPassword = Singleton.getMasterPassword();
        String fileName = Singleton.getFilename();



        if (urlAddressField.getText().isBlank() ) {
            informationMessage2.setText("URL Address is required!");
        } else if(userNameField.getText().isBlank()){
            informationMessage2.setText("UserName is required!");
        } else if(masterPasswordField.getText().isBlank()){
            informationMessage2.setText("Password is required!");
        }else{
            UserData newData = new UserData(urlAddressField.getText(),
                    userNameField.getText(), masterPasswordField.getText());

                if(JsonModule.addNewDataToFile(fileName, masterPassword, newData))
                    informationMessage2.setText("Data Has been saved!");
            }
        }

}
