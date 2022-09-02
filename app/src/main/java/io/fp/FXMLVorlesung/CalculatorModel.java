package io.fp.FXMLVorlesung;

public class CalculatorModel {

    private double firstNumber = 0;
    private double secondNumber = 0;
    private double sumDouble = 0;

    public CalculatorModel() {

    }

     
   
    public double getSum() {
        return sumDouble;
    }



    public void setSum(double sum) {
        this.sumDouble = sum;
    }



    @Override
    public String toString() {
        return "" + sumDouble;
    }



    public double getFirstNumber() {
        return firstNumber;
    }



    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }



    public double getSecondNumber() {
        return secondNumber;
    }



    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }



    public String add(double firstNumber, double secondNumber) {

        System.out.println("String add Methode wurde aufgerufen!");
        sumDouble = firstNumber + secondNumber;
        String sum = Double.toString(sumDouble);
        return sum;

    }

    public String subtract(double firstNumber, double secondNumber) {

        System.out.println("String substract Methode wurde aufgerufen!");
        sumDouble = firstNumber - secondNumber;
        String sum = Double.toString(sumDouble);
        return sum;

    }

    public String multiply(double firstNumber, double secondNumber) {
        System.out.println("String multiply Methode wurde aufgerufen!");
        sumDouble = firstNumber * secondNumber;
        String sum = Double.toString(sumDouble);
        return sum;

    }

    public String divide(double firstNumber, double secondNumber) throws ArithmeticException {

        if (secondNumber != 0) {
            sumDouble = firstNumber / secondNumber;
            String sum = Double.toString(sumDouble);
            return sum;
        } else {
            throw new ArithmeticException("You cannot divide by 0!");
        }
    }

    public void inPercent() {
            //TODO: Methode fertig schreiben und genaue Logik recherchieren
    }

    public void ac() {
        firstNumber = 0;
        secondNumber = 0;

    }

    public void changeSign() {

    }

    public void calcultate() {
        
    }



    public void resetVariables() {
        firstNumber = 0;
        secondNumber = 0;
        sumDouble = 0;      //An dieser Stelle könnte man die Variable NICHT auf 0 setzen und mit dem Ergebnis weiter Rechenoperationen durchführen 
                            //--> Anpassung der if-else-Bedingungen für das setzen neuer Zahlen wäre notwendig
    }
}
