package simulator.aircraft;

import simulator.tower.WeatherTower;

public interface Flyable {
    abstract void updateConditions();
    abstract String getName();
    abstract long getId();
    abstract String getType();
    abstract void registerTower(WeatherTower p_tower);
    abstract String getCoordinates();
    abstract void unregisterTower();
    abstract void Land();
}