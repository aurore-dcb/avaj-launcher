package srcs.aircraft;
import srcs.*;

public class Aircraft {
    protected long          id;
    protected String        name;
    protected Coordinates    coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) { //mettre en protected
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    protected void WhoAmI() {
        System.out.println("My name is " + this.name);
        System.out.println("My id is " + this.id);
        System.out.println("My coordinates are :\n  longitude: " + coordinates.getLongitude() + "\n  latitude: " + coordinates.getLatitude() + "\n  height: " + coordinates.getHeight());
    }
}