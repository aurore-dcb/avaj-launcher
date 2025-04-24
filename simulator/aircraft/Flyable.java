package simulator.aircraft;

import simulator.tower.WeatherTower;

public interface Flyable {
    abstract void updateConditions();
    abstract void registerTower(WeatherTower p_tower);
    abstract String getName();
    abstract long getId();
    abstract String getType();
    abstract String getCoordinates();
    abstract void unregisterTower();
    abstract void Land();
}