package srcs.aircraft;
import srcs.*;

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

    // public abstract void WhoAmI();
}