package io.fp.FXMLVorlesung;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
       try {
       Parent root = FXMLLoader.load(getClass().getResource("/fxml/StartPage_Organizer.fxml"));
       Scene scene = new Scene(root);

       stage.setTitle("Organizer"); 
       stage.getIcons().add(new Image("/images/organ!zer.png"));
       stage.setScene(scene);
       stage.show();
       }
       catch(IOException e) {
         e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        StartPageViewModel.setStop();
        System.out.println("The Time Thread is stopped: " + StartPageViewModel.isStop() );
    }
}
