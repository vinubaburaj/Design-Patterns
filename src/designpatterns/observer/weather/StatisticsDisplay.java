package designpatterns.observer.weather;

public class StatisticsDisplay implements Observer, DisplayElement{

    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float sumTemp = 0.0f;
    private int numReadings = 0;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        sumTemp += temp;
        numReadings++;

        if(temp > maxTemp) {
            maxTemp = temp;
        }
        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }

    public void display() {
        System.out.println("Weather Statistics");
        System.out.println("Max temp: " + this.maxTemp);
        System.out.println("Min temp: " + this.minTemp);
    }

}
