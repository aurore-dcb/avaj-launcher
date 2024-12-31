package srcs.aircraft;
import srcs.*;
import srcs.aircraft.*;

public class Baloon extends Aircraft implements Flyable {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Baloon";
    }

    // @Override
    // public void WhoAmI() {
    //     // super.WhoAmI();
    //     System.out.println("My name is " + this.name);
    //     System.out.println("My id is " + this.id);
    //     System.out.println("My coordinates are :\n  longitude: " + this.coordinates.getLongitude() + "\n  latitude: " + this.coordinates.getLatitude() + "\n  height: " + this.coordinates.getHeight());
    //     System.out.println("My type is: " + type);
    // }

    public String getType() {
        return type;
    }

    public void updateConditions() {
        System.out.println("B - Update conditions.");
    }
}