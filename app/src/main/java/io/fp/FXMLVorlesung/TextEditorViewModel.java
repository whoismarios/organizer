package io.fp.FXMLVorlesung;

import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class TextEditorViewModel {

    private Stage stage;
    private Scene scene;
   
    @FXML
    public void handleSwitchToStartPageScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/StartPage_Organizer.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setTitle("Counter");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Switch to the Homescreen if "H" is pressed 
    @FXML
    public void keyPressed(KeyEvent event) {
        switch(event.getCode()) {
            case H:
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/StartPage_Organizer.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    
                scene = new Scene(root);
    
                stage.setTitle("Counter");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
                break;
            default:
                break;
        }
    }
}
