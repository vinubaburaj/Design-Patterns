package designpatterns.observer.weather;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement{
    Observable observable;
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable){
        this.observable = observable;
        this.observable.addObserver(this);
    }

    public void display() {
        if(currentPressure > lastPressure)
            System.out.println("Improving weather on the way");
        else if (currentPressure == lastPressure)
            System.out.println("Weather is the same");
        else
            System.out.println("Watch out for cooler rainy weather");
    }

    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }
}
