package protectmypasswords.vue;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MenuView {

    public void menuView() throws IOException {
        URL location = getClass().getResource("/protectmypasswords/menu.fxml");
        AnchorPane menuWindow = (AnchorPane)FXMLLoader.load(location);
        Scene scene = new Scene(menuWindow, 1000, 600);
        Stage menuStage = new Stage();
       // menuStage.initStyle(StageStyle.UNDECORATED);
        menuStage.setResizable(false);
        menuStage.setTitle("Hello!");
        menuStage.setScene(scene);
        menuStage.show();
    }

}
