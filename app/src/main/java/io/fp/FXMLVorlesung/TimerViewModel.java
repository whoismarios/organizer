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

public class TimerViewModel {
   
    TimerModel model;

    private Stage stage;
    private Scene scene;
    private boolean timerRunns = false;
    private Thread thread;

    @FXML
    private Label timeLabel;

    public TimerViewModel() {
        model = new TimerModel();
    }

    //Updates Timelabel with the current values of the variables "minutes" and "seconds"
    public void updateTimelabel() {
        timeLabel.setText(model.toString());
    }

    //Sets the Timelabel to default value 00:00
    public void resetTimelabel() {
        timeLabel.setText(model.toString());
    }

    //Handles what happens when the "Plus-10-Seconds Button" gets pressed 
    @FXML
    public void handlePlusTenSeconds() {
        model.plusTenSeconds();
        updateTimelabel();
    }
    
    //Handles what happens when the "Minus-10-Seconds Button" gets pressed 
    @FXML
    public void handleMinusTenSeconds() throws Exception { 
        model.minusTenSeconds();
        updateTimelabel();
    }

    //Handles what happens when the "Plus-1-Minute Button" gets pressed 
    @FXML
    public void handlePlusOneMinute() {
        model.plusOneMinute();  //Changes the values
        updateTimelabel();      //Updates the Label to the new values
    }
    
    //Handles what happens when the "Minus-1-Minute Button" gets pressed 
    @FXML
    public void handleMinusOneMinute() throws Exception{
        model.minusOneMinute();
        updateTimelabel();
    }


    //Handles what happens when the "Reset Button" gets pressed 
    @FXML
    public void handleResetTimelabel() {
        model.resetTime();
        resetTimelabel();  
    }
    
    //Handles what happens when the "Start Button" gets pressed // This Method should update the Label in 1000ms Intervalls
    // Points to overwrite: 1: Initialization of the Label in the Constructor?
    //2: When should the Thread start -> at witch point in the source code 
    //3: Check the Loops (while- and for-Loop)
    //4: Bedingungen der Schleifen überprüfen
    //5: Abbruchbedingung der Schleifen prüfen
    public void start() throws InterruptedException{
        timeLabel = new Label();

        int secondsTotal = model.getSeconds() + 60 * model.getMinutes();

        timerRunns = true;

        thread = new Thread(()-> {
        while(timerRunns == true) {

            for(int i = secondsTotal; i > 0; i--) {

            thread.start();
            int seconds = i % 60;
            int minutes = i / 60;
            timeLabel.setText(model.toString2(seconds, minutes));
            timeLabel.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
            timeLabel.setVisible(true);
            timeLabel.setText(minutes + ":" + seconds);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (secondsTotal == 0) {        // == 1 anstatt 0? Variable i wird erst nach Durchlauf der Schleife um eins verkleinert
                timerRunns = false;
            }
        }}
        }); 
    }

    //Recursiv Method-Call for the Start Method of the Timer
    @FXML
    public void handleStart(ActionEvent event)throws InterruptedException {             //TODO: Methode funktioniert nicht richtig
       start();
    }

    //Handles what happens when the "Stop Button" gets pressed 
    @FXML
    public void handleStop() {  
        
        updateTimelabel();
    } 

    //Switch to Counter Scene
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