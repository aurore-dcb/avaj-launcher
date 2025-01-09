package simulator.aircraft;

import simulator.*;
import simulator.tower.WeatherTower;

abstract class Aircraft implements Flyable {
    protected long          id;
    protected String        name;
    protected Coordinates   coordinates;
    protected String        type;
    protected WeatherTower  weatherTower;
    private Logger logger = Logger.getInstance();

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

    public String getCoordinates() { // comment
        String longitude = Integer.toString(coordinates.getLongitude()) ;
        String latitude = Integer.toString(coordinates.getLatitude());
        String height = Integer.toString(coordinates.getHeight());
        String res = "( " + longitude + " " + latitude + " " + height + " )";
        return res;
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
}