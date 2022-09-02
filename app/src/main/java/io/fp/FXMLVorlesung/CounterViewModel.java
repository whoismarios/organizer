package io.fp.FXMLVorlesung;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class CounterViewModel {
    
    private CounterModel model;
    private Stage stage = new Stage();
    private Scene scene;

    public CounterViewModel(){
        model = new CounterModel();
    }

    @FXML
    private Label numberOfClicks;

    @FXML
    private Label totalNumberOfClicks;

    public static final String PREFIX = "Total Number of Clicks: "; 
    public static final String ENDE = " ";

    @FXML
    public void handleIncreaseByOne(ActionEvent event) {   
        model.increaseByOne();
        updateNumberOfClicks(model.getCounter());
        updateTotalNumberOfClicks();
    }

    @FXML
    public void handleDecreaseByOne() {
        model.decreaseCounter();
        updateNumberOfClicks(model.getCounter());
    }
    @FXML

    public void handleReset() {
        resetClicks();
    }

    private void updateNumberOfClicks(int counter) {
        numberOfClicks.setText( "" + model.getCounter());
    }

    private void updateTotalNumberOfClicks() {
        totalNumberOfClicks.setText(PREFIX + model.getTotalNumberOfClicks() + ENDE);
    }

    private void resetClicks() {
        model.resetCounter();
        numberOfClicks.setText("" + model.getCounter());
    }

    public void resetTotalNumberOfClicks() {
        model.resetTotalNumberOfClicks();
        totalNumberOfClicks.setText(PREFIX + model.getTotalNumberOfClicks() + ENDE );
    }

    public void closePreviousWindow(Stage stage) {
        stage.close();
    }
    
    @FXML
    public void handleResetTotalNumberOfClicks() {
        resetTotalNumberOfClicks();
    }

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
