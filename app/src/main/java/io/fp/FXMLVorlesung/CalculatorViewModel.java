package io.fp.FXMLVorlesung;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class CalculatorViewModel implements Initializable{
 
    private char operator;
    private CalculatorModel model;
    private Stage stage;
    private Scene scene;
    @FXML
    private Label label;

    public CalculatorViewModel() {
        model = new CalculatorModel();
        label = new Label("0");
    }

    //Switches to Homescreen when clicked
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
            case DIGIT0:
                    zeroPressed();
                break;

             case DIGIT1:
                    onePressed();
                break; 

            case DIGIT2:
                    twoPressed();
                break; 

            case DIGIT3:
                    threePressed();
                break;

            case DIGIT4:
                    fourPressed();
                break;

            case DIGIT5:
                    fivePressed();
                break;

            case DIGIT6:
                    sixPressed();
                break;

            case DIGIT7:
                    sevenPressed();
                break;

            case DIGIT8:
                    eightPressed();
                break;

            case DIGIT9:
                    ninePressed();
                break;
            case DELETE:
                    acPressed();
                break;
            case ENTER:
                        
                break;
             
            default:
                break;
        }
        
    }

    //Switches to Compounded Interest
    @FXML
    public void handleSwitchToCompoundedInterestScene(ActionEvent event) {

    }   

    public void onePressed() {
        String s = "1";

        if (label.getText() != null && Double.parseDouble(label.getText()) != 0) {

            label.setText(label.getText() + s);
               
        } else {
            label.setText(s);
        }
    }
    
    @FXML
    public void handle1Pressed(ActionEvent event) throws NumberFormatException {
        onePressed();
    }

    public void twoPressed() {
        String s = "2";

        if (label.getText() != null && Double.parseDouble(label.getText()) != 0) {

            label.setText(label.getText() + s);

        } else {
            label.setText(s);
        }
    }
    
    @FXML
    public void handle2Pressed(ActionEvent event) throws NumberFormatException {
        twoPressed();
    }

    public void threePressed() {
        String s = "3";

        if (label.getText() != null && Double.parseDouble(label.getText()) != 0) {

            label.setText(label.getText() + s);

        } else {
            label.setText(s);
        }
    }

    @FXML
    public void handle3Pressed(ActionEvent event) throws NumberFormatException {
        threePressed();
    }

    public void fourPressed() {
        String s = "4";

        if (label.getText() != null && Double.parseDouble(label.getText()) != 0) {

            label.setText(label.getText() + s);

        } else {
            label.setText(s);
        }
    }
    @FXML
    public void handle4Pressed(ActionEvent event) throws NumberFormatException {
        fourPressed();
    }

    public void fivePressed() {
        String s = "5";

        if (label.getText() != null && Double.parseDouble(label.getText()) != 0) {

            label.setText(label.getText() + s);

        } else {
            label.setText(s);
        }
    }

    @FXML
    public void handle5Pressed(ActionEvent event) throws NumberFormatException {
        fivePressed();
    }

    public void sixPressed() {
        String s = "6";

        if (label.getText() != null && Double.parseDouble(label.getText()) != 0) {

            label.setText(label.getText() + s);

        } else {
            label.setText(s);
        }
    }

    @FXML
    public void handle6Pressed(ActionEvent event) throws NumberFormatException {
        sixPressed();
    }

    public void sevenPressed() {
        String s = "7";

        if (label.getText() != null && Double.parseDouble(label.getText()) != 0) {

            label.setText(label.getText() + s);

        } else {
            label.setText(s);
        }
    }

    @FXML
    public void handle7Pressed(ActionEvent event) throws NumberFormatException {
        sevenPressed();
    }

    public void eightPressed() {
        String s = "8";

        if (label.getText() != null && Double.parseDouble(label.getText()) != 0) {

            label.setText(label.getText() + s);

        } else {
            label.setText(s);
        }
    }
    
    @FXML
    public void handle8Pressed(ActionEvent event) throws NumberFormatException {
        eightPressed();
    }

    public void ninePressed() {
        String s = "9";

       if (Double.parseDouble(label.getText()) == 0. || label.getText() == "0.0" || label.getText() == "0.00" || label.getText() == "0.000" ) {

            label.setText(label.getText() + s);     //TODO: Die verkackten Bedingungen sind immer noch falsch!!

       } else {                                     //Nach erfolgreichem Beheben auch in den anderen Methoden übernehmen! -> 1-8 oder 0-8
        throw new ArithmeticException("Please enter a valid number");
       }
    }

    @FXML
    public void handle9Pressed(ActionEvent event) throws NumberFormatException {
        ninePressed();
    }

    public void zeroPressed() throws ArithmeticException{
        String s = "0";
        if (    label.getText() == "0."
            ||   label.getText() == "0.0"        //TODO: Bedingungen sind fehlerhaft
            || label.getText() == "0.00"
            || label.getText() == "0.000"
            || label.getText() == "0.0000") {
                label.setText(label.getText() + s);
        } else {
            throw new ArithmeticException("Please enter a valid Number or a ',' after the zero-Token!");
        }
    }
    
    @FXML
    public void handle0Pressed(ActionEvent event) throws NumberFormatException {
        zeroPressed();
    }

    public void acPressed() {
        String s = "0";

        model.ac();
        label.setText(s); 
    }
    @FXML
    public void handleAcPressed(ActionEvent event) {
        acPressed();
    }

    @FXML
    public void changeSign(ActionEvent event) {
        double d = Double.parseDouble(label.getText());
        d = d * (-1);
        label.setText( "" + d);
    }

    @FXML
    public void handleKommaPressed (ActionEvent event) {

        String s = ".";

        if (label.getText() != null)
        label.setText(label.getText() + s);
    }

    @FXML
    public void handlePlusPressed() {
        String s = "0";
        operator = '+';

        model.setFirstNumber(Double.parseDouble(label.getText()));

        label.setText(s);
    }

    @FXML
    public void handleMinusPressed() {
        String s = "0";
        operator = '-';

        model.setFirstNumber(Double.parseDouble(label.getText()));

        label.setText(s); 
    }

    @FXML
    public void handleMultiplyPressed() {
        String s = "0";
        operator = '*';

        model.setFirstNumber(Double.parseDouble(label.getText()));

        label.setText(s); 
    }

    @FXML
    public void handleDividePressed() {
        String s = "0";
        operator = '/';

        model.setFirstNumber(Double.parseDouble(label.getText()));

        label.setText(s); 
    }

    @FXML
    public void handleToPercentPressed(ActionEvent event) {             //TODO: handleToPercent Methode fertig schreiben! -> Genaue Logik recherchieren
        
    }

    public void equalsPressed() {
        model.setSecondNumber(Double.parseDouble(label.getText())); 
        System.out.println(" = Methode aufgerufen!");
                                     
            switch(operator) {
                case '+':   //Addition
                    label.setText(model.add(model.getFirstNumber(), model.getSecondNumber()));
                    model.resetVariables();
                    break;
                case '-':   //Substraction
                    label.setText(model.subtract(model.getFirstNumber(), model.getSecondNumber()));
                    model.resetVariables();
                    break;
                case '*':   //Multiplication
                    label.setText(model.multiply(model.getFirstNumber(), model.getSecondNumber()));
                    model.resetVariables();
                    break;
                case '/':   //Division
                    try {
                    label.setText(model.divide(model.getFirstNumber(), model.getSecondNumber()));
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    model.resetVariables();
                    break;
                default:
                    break;    
            }  
    }
   
    public void handleEqualsPressed() {  
        equalsPressed();
    }       
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
}
