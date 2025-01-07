package srcs.aircraft;
import srcs.*;
import srcs.tower.*;

public class Aircraft {
    protected long          id;
    protected String        name;
    protected Coordinates   coordinates;
    protected String        type;

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
        System.out.println("Register tower");
    }
}