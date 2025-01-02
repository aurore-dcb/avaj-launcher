package srcs.aircraft;
import srcs.*;
import srcs.aircraft.*;

public class Helicopter extends Aircraft implements Flyable {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Helicopter";
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
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                new_height = this.coordinates.getHeight() + 2;
                if (new_height > 100) { 
                    this.coordinates.setHeight(100);
                } else {
                    this.coordinates.setHeight(new_height);
                }
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): This is hot.");
                break;
            case "RAIN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): It's rainning.");
                break;
            case "FOG":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): There's fog here.");
                break;
            case "SNOW":
                new_height = this.coordinates.getHeight() + 12;
                if (new_height > 100) {
                    this.coordinates.setHeight(100);
                } else {
                    this.coordinates.setHeight(new_height);
                }
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): My rotor is going to freeze!");
                break;
            default:
                throw new AssertionError(); // créer un erreur
        }
    }
}