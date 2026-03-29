package designpatterns.observer.weather;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement{
    Observable observable;
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float sumTemp = 0.0f;
    private int numReadings = 0;
    private float temperature;

    public StatisticsDisplay(Observable observable){
        this.observable = observable;
        this.observable.addObserver(this);
    }

    public void display() {
        System.out.println("Max temp: " + this.maxTemp +
                " Min temp: " + this.minTemp +
                " Average temp: " + (sumTemp/numReadings));
    }

    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            this.temperature = weatherData.getTemperature();
            this.calculateTemperatureStatistics(this.temperature);
            this.display();
        }
    }

    private void calculateTemperatureStatistics(float temp){
        this.sumTemp += temp;
        this.numReadings++;

        if (temp > this.maxTemp)
            maxTemp = temp;
        if (temp < minTemp)
            minTemp = temp;
    }

}
