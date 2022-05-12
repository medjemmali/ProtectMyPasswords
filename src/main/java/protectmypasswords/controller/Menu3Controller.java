package protectmypasswords.controller;

import com.github.cliftonlabs.json_simple.JsonException;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import protectmypasswords.module.JsonModule;
import protectmypasswords.module.LogInModule;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class Menu3Controller implements Initializable {

    public TextField oldMasterPasswordField;
    public PasswordField newMasterPasswordField;
    public JFXButton UpdatePasswordButton;
    public Label informationMessage3;

    public void startPanel(BorderPane mainPane){

        MenuLoaderController menuLoader = new MenuLoaderController();
        Pane view = menuLoader.getPage("menuVue3");
        mainPane.setCenter(view);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onLoginButtonClick(ActionEvent actionEvent) throws NoSuchAlgorithmException, IOException, JsonException {

            // Check if old password is correct
            String oldPassword = oldMasterPasswordField.getText();
            String newPassword = newMasterPasswordField.getText();


            LogInModule loginOnj = new LogInModule();
            oldPassword = loginOnj.encryptPassword(oldPassword);
            newPassword = loginOnj.encryptPassword(newPassword);

            String oldFilename = Singleton.getFilename();
            if(Singleton.changeMasterPassword(oldPassword, newPassword)){

                JsonModule objTmp = new JsonModule();
                if(objTmp.changeFileName(oldFilename, Singleton.getFilename(),oldPassword, newPassword )) {
                    informationMessage3.setText("Password Has been changed successfully");
                }else{
                    Singleton.changeMasterPassword(newPassword, oldPassword);
                }
            }
            else
                informationMessage3.setText("Wrong Password!");

    }
}
