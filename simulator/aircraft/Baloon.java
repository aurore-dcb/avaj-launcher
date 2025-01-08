package simulator.aircraft;
import simulator.Coordinates;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Baloon";
    }

    @Override
    public void updateConditions() {
        // recuperer la meteo pour la position actuelle
        String weather = "SNOW";
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
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon.");
                new_height = this.coordinates.getHeight() - 5;
                if (new_height <= 0) {
                    Land();
                } else {
                    this.coordinates.setHeight(new_height);
                }
                break;
            case "FOG":
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): There's fog, can't see anything.");
                new_height = this.coordinates.getHeight() - 3;
                if (new_height <= 0) {
                    Land();
                } else {
                    this.coordinates.setHeight(new_height);
                }
                break;
            case "SNOW":
                System.out.println(this.type + "#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");
                new_height = this.coordinates.getHeight() - 15;
                if (new_height <= 0) {
                    Land();
                } else {
                    this.coordinates.setHeight(new_height);
                }
                break;
            default:
                throw new AssertionError(); // créer un erreur
        }
    }
}