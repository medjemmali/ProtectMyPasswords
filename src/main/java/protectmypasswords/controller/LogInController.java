package protectmypasswords.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import protectmypasswords.module.LogInModule;
import protectmypasswords.vue.MenuView;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LogInController {

    private LogInModule logInModuleObj = new LogInModule();
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField masterPasswordField;
    @FXML
    private Label informationMessage;

    @FXML
    protected void onRegisterButtonClick(ActionEvent e) throws NoSuchAlgorithmException, IOException {

        if (masterPasswordField.getText().isBlank() ) {
            informationMessage.setText("Password is required!");
        } else {
            String encryptedPwd = logInModuleObj.encryptPassword(masterPasswordField.getText());
            // checkUsersFile Method will check if the users file already exist

            if(!logInModuleObj.checkUsersFile(encryptedPwd)) {

                    logInModuleObj.registerNewUser(encryptedPwd);
                    masterPasswordField.setText("");
                    // Alert Message
                    Alert message = new Alert(Alert.AlertType.INFORMATION);
                    message.setContentText("You are now Registered! Please LogIn");
                    message.setTitle("Welcome");
                    message.show();

                    informationMessage.setText("New User registered Successful! Please LogIn!");
            }
            else {
                informationMessage.setText("User Already exist. Please LogIn!");
            }
        }
    }
    @FXML
    protected void onLoginButtonClick(ActionEvent e) throws NoSuchAlgorithmException, IOException {

        if (masterPasswordField.getText().isBlank() ) {
            informationMessage.setText("Password is required!");
        } else {
            // first We Encrypt the password
            String encryptedPwd = logInModuleObj.encryptPassword( masterPasswordField.getText());
            // checkUsersFile Method will check if users file exist
            if(logInModuleObj.checkUsersFile(encryptedPwd)){
                //hide Scene
                loginButton.getScene().getWindow().hide();


                new Singleton(encryptedPwd);
                new MenuView().menuView();
                //informationMessage.setText("Login Successful!");

            }
            else{
                masterPasswordField.setText("");
                informationMessage.setText("Bad Password, try Again Pls");
            }
        }
    }


}