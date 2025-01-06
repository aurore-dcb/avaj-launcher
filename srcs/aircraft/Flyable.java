package srcs.aircraft;

public abstract interface Flyable { //ne peut pas etre une interface 
    abstract void updateConditions();
    abstract String getName();
    abstract long getId();
    abstract String getType();
    // public void registerTower(WeatherTower p_tower);
    // protected WeatherTower weatherTower = null;
}