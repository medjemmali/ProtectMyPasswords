package protectmypasswords.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class MenuLoaderController {
    private Pane view;

    public Pane getPage (String fileName) {

        try{
                URL fileUrl = getClass().getResource("/protectmypasswords/" + fileName + ".fxml");
                if (fileUrl == null){
                    throw new java.io.FileNotFoundException("FXML file can't be found");
                }

                   view = new FXMLLoader().load(fileUrl);

        } catch (IOException e) {
                   System. out.println ("No page "+ fileName + "please check MenuLoaderController.");
        }

        return view;
    }

}

