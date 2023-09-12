public class APCSAProblemSet1A{
    public static void main (String[] args) {
        MySolution mySoluti1 = new MySolution();
        mySoluti1.celciusToFahrenheit();
        mySoluti1.elapsedTime();
        mySoluti1.secondsToHMS();
    }
}

class MySolution {
    public void celciusToFahrenheit () {
        double Celecius = 30.0;
        double Fahrenheit = Celecius * 9/5 + 32;
        System.out.println(Celecius + "\u00B0C = " + Fahrenheit + "\u00B0F");
    }

    public void elapsedTime() {  
        int T = 43200;
        int hr = (T/3600) % 24;
        int min = (T/60) % 60;
        int sec = T % 60;
        double pct = (double) T / (double) 86400 * 100;
        int secLeft = 86400 - T;
        System.out.println("The current time is " + hr + ":" + min + ":" + sec + ". It has been " + T + " seconds since the day began.");
        System.out.println("There are " + secLeft + " seconds left in the day.");
        System.out.println("The day is " + pct + "% done.");
    }
    
    public void secondsToHMS() {  
        int T = 5000;
        int hr = (T/3600) % 24;
        int min = (T/60) % 60;
        int sec = T % 60;
        System.out.println(T + " seconds = " + hr + " hours, " + min + " minutes, and " + sec + " seconds.");
    }	
    
}