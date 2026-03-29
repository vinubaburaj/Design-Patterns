package designpatterns.observer.weather;


import java.util.ArrayList;

public class WeatherData implements Subject{
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<Observer>();
    }
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for(Observer observer: observers){
            observer.update(temperature, pressure,humidity);
        }
    }

    public void measurementsChanged(){
        this.notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();

    }

    public float getTemperature(){
        return this.temperature;
    }

    public float getHumidity(){
        return this.humidity;
    }

    public float getPressure(){
        return this.pressure;
    }
}
