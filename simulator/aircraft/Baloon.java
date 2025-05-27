package simulator.aircraft;

import simulator.Coordinates;
import simulator.exceptions.CustomException;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Baloon";
    }

    @Override
    public void updateConditions() throws CustomException {

        String weather = this.weatherTower.getWeather(this.coordinates);
        int new_height = 0;
        String message;

        switch (weather) {
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                new_height = this.coordinates.getHeight() + 4;
                if (new_height > 100) { 
                    this.coordinates.setHeight(100);
                } else {
                    this.coordinates.setHeight(new_height);
                }
                message = this.type + "#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.";
                logger.writeLog(message);
                break;
            case "RAIN":
                message = this.type + "#" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon.";
                logger.writeLog(message);
                new_height = this.coordinates.getHeight() - 5;
                if (new_height <= 0) {
                    Land();
                } else {
                    this.coordinates.setHeight(new_height);
                }
                break;
            case "FOG":
                message = this.type + "#" + this.name + "(" + this.id + "): There's fog, can't see anything.";
                logger.writeLog(message);
                new_height = this.coordinates.getHeight() - 3;
                if (new_height <= 0) {
                    Land();
                } else {
                    this.coordinates.setHeight(new_height);
                }
                break;
            case "SNOW":
                message = this.type + "#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.";
                logger.writeLog(message);
                new_height = this.coordinates.getHeight() - 15;
                if (new_height <= 0) {
                    Land();
                } else {
                    this.coordinates.setHeight(new_height);
                }
                break;
            default:
                throw new CustomException("An unknown weather condition has been detected. Not doing anything.");
        }
    }
}