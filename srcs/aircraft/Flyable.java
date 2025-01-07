package srcs.aircraft;

import srcs.tower.*;

public abstract interface Flyable {
    abstract void updateConditions();
    abstract String getName();
    abstract long getId();
    abstract String getType();
    abstract void registerTower(WeatherTower p_tower);
    // protected WeatherTower weatherTower;
}