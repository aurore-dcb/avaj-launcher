package srcs.aircraft;

import srcs.tower.*;

public abstract interface Flyable { //ne peut pas etre une interface 
    abstract void updateConditions();
    // public void registerTower(WeatherTower p_tower);
    // protected WeatherTower weatherTower;
}