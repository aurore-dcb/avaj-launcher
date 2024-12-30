package srcs.tower;

import srcs.*;
// import srcs.aircraft.*;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates p_coordinates) {
        return "weather";
    }

    public void changeWeather() {
        System.out.println("change weather");
    }
}