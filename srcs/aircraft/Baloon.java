package srcs.aircraft;
import srcs.*;
import srcs.tower.*;

public class Baloon extends Aircraft implements Flyable {

    protected WeatherTower weatherTower;

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Baloon";
    }

    public void updateConditions() {
        // recuperer la meteo pour la position actuelle
        String weather = "SUN";
        int new_height = 0;
        switch (weather) {
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                new_height = this.coordinates.getHeight() + 4;
                if (new_height > 100) { 
                    this.coordinates.setHeight(100);
                } else {
                    this.coordinates.setHeight(new_height);
                }
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                new_height = this.coordinates.getHeight() - 5;
                if (new_height <= 0) {
                    System.out.println(this.type + "#" + this.name + "(" + this.id + ")" + " landing.");
                    // unregister to weather tower
                } else {
                    this.coordinates.setHeight(new_height);
                }
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                System.out.println("There's fog here.");
                new_height = this.coordinates.getHeight() - 3;
                if (new_height <= 0) {
                    System.out.println(this.type + "#" + this.name + "(" + this.id + ")" + " landing.");
                    // unregister to weather tower
                } else {
                    this.coordinates.setHeight(new_height);
                }
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): There's fog, can't see anything.");
                break;
            case "SNOW":
                new_height = this.coordinates.getHeight() - 15;
                if (new_height <= 0) {
                    System.out.println(this.type + "#" + this.name + "(" + this.id + ")" + " landing.");
                    // unregister to weather tower
                } else {
                    this.coordinates.setHeight(new_height);
                }
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");
                break;
            default:
                throw new AssertionError(); // créer un erreur
        }
    }

    // public String getName() {
    //     return this.name;
    // }
}