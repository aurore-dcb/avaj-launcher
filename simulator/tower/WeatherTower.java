package simulator.tower;

import simulator.Coordinates;
import simulator.aircraft.*;
import simulator.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates p_coordinates) {
        String weather = WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
        return weather;
    }

    @Override
    public void register(Flyable p_flyable) {
        super.register(p_flyable);
        String message = "Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower.";
        logger.writeLog(message);
    }

    @Override
    public void unregister(Flyable p_flyable) {
        super.unregister(p_flyable);
        String message = "Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") unregistered from weather tower.";
        logger.writeLog(message);
    }

    public void changeWeather() {
        this.conditionChanged();
    }
}