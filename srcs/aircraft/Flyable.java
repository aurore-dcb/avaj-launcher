package srcs.aircraft;

import srcs.tower.*;

public abstract interface Flyable {
    abstract void updateConditions();
    abstract String getType();
    // public void registerTower(WeatherTower p_tower);
    // protected WeatherTower weatherTower;
}