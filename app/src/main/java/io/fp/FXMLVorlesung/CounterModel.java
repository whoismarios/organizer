package io.fp.FXMLVorlesung;

public class CounterModel {
   
        private int counter = 0;
        private int totalNumberOfClicks = 0;
    
        public void setCounter(int counter){
            this.counter = counter;
        }
    
        public int getCounter(){
            return counter;
        }

        public int getTotalNumberOfClicks(){
            return totalNumberOfClicks;
        }

        public int resetCounter(){
            return counter = 0;
        }
        public int increaseByOne(){
            totalNumberOfClicks++;  
            return counter++;
        }
        
        public int decreaseCounter(){
            if(counter !=0)
            counter--;
    
            return counter;
        }
        public int resetTotalNumberOfClicks(){
            return totalNumberOfClicks = 0;
        }
}

