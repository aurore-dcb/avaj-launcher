package srcs.aircraft;
import srcs.*;
import srcs.aircraft.*;

public class JetPlane extends Aircraft implements Flyable {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "JetPlane";
    }

    // @Override
    // public void WhoAmI() {
    //     // super.WhoAmI();
    //     System.out.println("My name is " + this.name);
    //     System.out.println("My id is " + this.id);
    //     System.out.println("My coordinates are :\n  longitude: " + this.coordinates.getLongitude() + "\n  latitude: " + this.coordinates.getLatitude() + "\n  height: " + this.coordinates.getHeight());
    //     System.out.println("My type is: " + type);
    // }

    public void updateConditions() {
        // recuperer la meteo pour la position actuelle
        String weather = "SUN";
        int new_height = 0;
        switch (weather) {
            case "SUN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                new_height = this.coordinates.getHeight() + 2;
                if (new_height > 100) { 
                    this.coordinates.setHeight(100);
                } else {
                    this.coordinates.setHeight(new_height);
                }
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): It's sunny.");
                break;
            case "RAIN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): There's fog.");
                break;
            case "SNOW":
                new_height = this.coordinates.getHeight() - 7;
                if (new_height <= 0) {
                    System.out.println(this.type + "#" + this.name + "(" + this.id + ")" + " landing.");
                    // unregister to weather tower
                } else {
                    this.coordinates.setHeight(new_height);
                }
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): OMG! Winter is coming!");
                break;
            default:
                throw new AssertionError(); // créer un erreur
        }
    }
}