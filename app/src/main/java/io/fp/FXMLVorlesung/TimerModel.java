package io.fp.FXMLVorlesung;

public class TimerModel {
   
    private int seconds;
    private int minutes;

    public TimerModel() {
        minutes = 0;
        seconds = 0;
    }

    //Returns seconds
    public int getSeconds() {
        return seconds;
    }

    //Returns minutes
    public int getMinutes() {
        return minutes;
    }

    //Resets the values of the variables to the default value
    public void resetTime() {
        minutes = 0;
        seconds = 0;
    }

    //Adds ten seconds to the Timer
    public void plusTenSeconds() {
        seconds = seconds + 10;
        if(seconds == 60){
            seconds = 0;
            minutes++;}  
        if(seconds > 60){
            seconds = seconds -60;
            minutes++;}
    }

    //Substracs ten seconds from the Timer, if the calculated Timer-value is 0 or greater than 0
    public void minusTenSeconds()throws Exception {
        if(seconds < 0 && minutes == 0)
            throw new Exception("Please choose a valid Value!");
            else{
                seconds = seconds -10;

        if(seconds < 0 && minutes != 0){
            minutes--;
            seconds = 60 + seconds;}
        
        if(seconds < 0 && minutes == 0){
            resetTime();
            throw new Exception("Please choose a valid Value!");
            }

            }
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void timePasses(int seconds, int minutes)throws Exception {

        this.seconds = seconds;
        this.minutes = minutes;

        int totalTimeInSeconds = seconds + (minutes*60); 

        System.out.println(totalTimeInSeconds);
        TimerViewModel timerViewModel = new TimerViewModel();
        timerViewModel.model.toString2(seconds = totalTimeInSeconds % 60, minutes = totalTimeInSeconds/ 60);

    }

    public long calculateToMs() {
        long secondsInMs = seconds * 1000;
        long minutesInMs = minutes * (1000 * 60);
        long msInTotal = secondsInMs + minutesInMs;
        return msInTotal;
    }

    //Adds one minute to the Timer
    public void plusOneMinute() {
        minutes = minutes + 1;
    }

    //Substracts one minute from the Timer, if the calculated Timer-value is 0 or greater than 0
    public void minusOneMinute() throws Exception {
        if(minutes > 0) {
            minutes--;
        }
        else {
            throw new Exception("Please choose a valid Value!");
        } 
    }

    @Override
    public String toString() {
        return String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
    }

    public String toString2(int seconds, int minutes) {
        return String.format("%02d", minutes) + ":" + String.format("%02d", seconds); 
    }
    
    // This Method stops the Thread
    public void stop() {
        // TODO: Stop Methode Schreiben mit Referenz zum ViewModel-Klasse
    }

    // This Method starts the Thread and the Countdown
    public void start() {

    }
}
