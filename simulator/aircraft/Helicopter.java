package simulator.aircraft;

import simulator.*;

public class Helicopter extends Aircraft {

    private Logger logger = Logger.getInstance();

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Helicopter";
    }

    @Override
    public void updateConditions() {

        String weather = this.weatherTower.getWeather(this.coordinates);
        int new_height = 0;
        String message;

        switch (weather) {
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                new_height = this.coordinates.getHeight() + 2;
                if (new_height > 100) { 
                    this.coordinates.setHeight(100);
                } else {
                    this.coordinates.setHeight(new_height);
                }
                message = this.type + "#" + this.name + "(" + this.id + "): This is hot.";
                logger.writeLog(message);
                break;
            case "RAIN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                message = this.type + "#" + this.name + "(" + this.id + "): It's rainning.";
                logger.writeLog(message);
                break;
            case "FOG":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                message = this.type + "#" + this.name + "(" + this.id + "): There's fog here.";
                logger.writeLog(message);
                break;
            case "SNOW":
                message = this.type + "#" + this.name + "(" + this.id + "): My rotor is going to freeze!";
                logger.writeLog(message);
                new_height = this.coordinates.getHeight() + 12;
                if (new_height > 100) {
                    this.coordinates.setHeight(100);
                } else {
                    this.coordinates.setHeight(new_height);
                }
                break;
            default:
                throw new AssertionError(); // créer un erreur
        }
    }
}