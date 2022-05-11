package protectmypasswords.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MenuController  {


    @FXML
    private static BorderPane mainPane;

//    // MenuVue1 Variables
//    @FXML
//    private TableView<UserData> tableview ;
//    @FXML
//    private TableColumn<UserData,String> addressUrl ;
//    @FXML
//    private TableColumn<UserData,String> username ;
//    @FXML
//    private TableColumn<UserData,String> password;
@FXML
    // MenuVue2 Variables
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
//
//    ObservableList<UserData> observableList = FXCollections.observableArrayList();
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        String masterPassword = Singleton.getMasterPassword();
//        String fileName = Singleton.getFilename();
//
//        UserData obj = new UserData( "firtstringOne", "String2", "String3");
//        observableList.add(obj);
//        addressUrl.setCellValueFactory(new PropertyValueFactory<UserData,String>("addressUrl"));
//        username.setCellValueFactory(new PropertyValueFactory<UserData,String>("userName"));
//        password.setCellValueFactory(new PropertyValueFactory<UserData,String>("password"));
//        tableview.setItems( observableList);
//    }
//
//    public static List<UserData> observableList() throws JsonException {
//        String password = Singleton.getMasterPassword();
//        String fileName = Singleton.getFilename();
//        return new JsonModule().jsonFileToList(fileName,password );
//
//    }
}
