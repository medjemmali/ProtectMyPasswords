package protectmypasswords.controller;

import com.github.cliftonlabs.json_simple.JsonException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import protectmypasswords.module.JsonModule;
import protectmypasswords.module.UserData;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Menu1Controller implements Initializable {


    @FXML
    private TableView<UserData> tableview ;
    @FXML
    private TableColumn<UserData,String> addressUrl ;
    @FXML
    private TableColumn<UserData,String> username ;
    @FXML
    private TableColumn<UserData,String> password;
    public void startPanel(BorderPane mainPane){

        MenuLoaderController menuLoader = new MenuLoaderController();
        Pane view = menuLoader.getPage("menuVue1");
        mainPane.setCenter(view);
    }

    ObservableList<UserData> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String masterPassword = Singleton.getMasterPassword();
        String fileName = Singleton.getFilename();

        // Asking for jsonfile data from JsonModule class
        List<UserData>  data;
        try {
              data =  JsonModule.jsonFileToList(fileName, masterPassword);
        } catch (JsonException e) {
            throw new RuntimeException(e);
        }

        // copy data to observableList so it can be pushed to tablePanel
        for (UserData value : data) {
            System.out.println(data);
            observableList.add(value);
        }

        addressUrl.setCellValueFactory(new PropertyValueFactory<UserData,String>("addressUrl"));
        username.setCellValueFactory(new PropertyValueFactory<UserData,String>("userName"));
        password.setCellValueFactory(new PropertyValueFactory<UserData,String>("password"));
        tableview.setItems( observableList);
    }
}
