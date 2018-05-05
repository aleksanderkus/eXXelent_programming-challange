package de.exxcellent.challenge.data;

/**
 * data holder class for csv data
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public class PCWeatherData implements PCData {

    private int dayOfMonth;
    private int maxTemp;
    private int minTemp;

    public PCWeatherData(int dayOfMonth, int maxTemp, int minTemp) {
        this.dayOfMonth = dayOfMonth;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }


    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }
}
