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

    public static PCWeatherData createFromString(String[] contentAsString) {
        PCWeatherData weatherData = null;
        try {
            int dayOfMonth = Integer.parseInt(contentAsString[0]);
            int maxTemp = Integer.parseInt(contentAsString[1]);
            int minTemp = Integer.parseInt(contentAsString[2]);
            weatherData = new PCWeatherData(dayOfMonth, maxTemp, minTemp);
        } catch (NumberFormatException e) {
            System.err.println("wrong format of file for weather data");
            e.printStackTrace();
        }
        return weatherData;
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
