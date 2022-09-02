package io.fp.FXMLVorlesung;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class StartPageViewModel implements Initializable {

    @FXML
    private Label dayAndDateLabel;
    @FXML
    private Label timeLabel;

    private volatile static boolean stop = false;
    private Scene scene;
    private Stage stage;
    public String time;
    
    public StartPageViewModel() {
        new CounterViewModel();
        new TimerViewModel();
        dayAndDateLabel = new Label();
        timeLabel = new Label();
    }


    @FXML
    public void handleSwitchToCounterScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CounterUI_2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setTitle("Counter");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleSwitchToTimerScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CounterUI_2_Scene_2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setTitle("Timer");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNewDate() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");                             
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");
        String s = dayFormat.format(new Date()) + " " + dateFormat.format(new Date()) ;
        dayAndDateLabel.setText(s);
    }

    public void setTime() {
        Thread thread = new Thread(()-> {
            SimpleDateFormat timeFormat = new SimpleDateFormat("kk:mm:ss");
            while(!stop) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                   e.printStackTrace();
                }
                final String timeNow = timeFormat.format(new Date());
                Platform.runLater(()-> {
                    timeLabel.setText(timeNow);
                });
            }
        });
        thread.start();
    }

    @FXML
    public void handleSwitchToTextEditorScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TextEditor_Organizer.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setTitle("Text Editor");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
        case C:     //Counter
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CounterUI_2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setTitle("Counter");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
            break;
        case E:     //Text Editor
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TextEditor_Organizer.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setTitle("Text Editor");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
            break;
        case T:     //Timer
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CounterUI_2_Scene_2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setTitle("Timer");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
            break;
        case G:     //Grades
            break;
        case K:     //Calculator
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Calculator_Organ!zer.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setTitle("Timer");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
            break;  
        case L:     //Calendar
            break;

        default:
            break;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void handleSwitchToCalendarScene() {

    }

    @FXML
    public void handleSwitchToGradesScene() {

    }

    @FXML
    public void handleSwitchToCalculatorScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Calculator_Organ!zer.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setTitle("Calculator");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setNewDate();
        setTime();
    }

    //Returs the current status of the Boolean Stop
    public static boolean isStop() {
        return stop;
    }

    //Sets the value of Boolean Stop to "true", so the Thread can be canceled
    public static void setStop() {
        stop = true;
    }
}