package simulator.aircraft;

import simulator.tower.WeatherTower;
import simulator.exceptions.CustomException;

public interface Flyable {
    public abstract void updateConditions() throws CustomException;
    public abstract void registerTower(WeatherTower p_tower);
    public abstract String getName();
    public abstract long getId();
    public abstract String getType();
    public abstract void unregisterTower();
    public abstract void Land();
}