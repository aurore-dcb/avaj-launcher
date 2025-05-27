package simulator.aircraft;

import simulator.Logger;
import simulator.Coordinates;
import simulator.tower.WeatherTower;
import simulator.exceptions.CustomException;

public abstract class Aircraft implements Flyable {
    protected long          id;
    protected String        name;
    protected Coordinates   coordinates;
    protected String        type;
    protected WeatherTower  weatherTower;
    protected Logger logger = Logger.getInstance();

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
        this.type = "Aircraft";
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public long getId() {
        return this.id;
    }

    public void registerTower(WeatherTower p_tower) {
        p_tower.register(this);
        this.weatherTower = p_tower;
    }

    public void unregisterTower() {
        this.weatherTower.unregister(this);
    }

    public void Land() {

        String message = this.type + "#" + this.name + "(" + this.id + ")" + " landing.";
        logger.writeLog(message);
        this.unregisterTower();
    }

    @Override
    public abstract void updateConditions() throws CustomException;
}