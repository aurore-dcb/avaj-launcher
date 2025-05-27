package simulator.aircraft;

import simulator.Coordinates;
import simulator.exceptions.CustomException;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "JetPlane";
    }

    @Override
    public void updateConditions() throws CustomException {
        
        String weather = this.weatherTower.getWeather(this.coordinates);
        int new_height = 0;
        String message;

        switch (weather) {
            case "SUN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                new_height = this.coordinates.getHeight() + 2;
                if (new_height > 100) { 
                    this.coordinates.setHeight(100);
                } else {
                    this.coordinates.setHeight(new_height);
                }
                message = this.type + "#" + this.name + "(" + this.id + "): It's sunny.";
                logger.writeLog(message);
                break;
            case "RAIN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                message = this.type + "#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.";
                logger.writeLog(message);
                break;
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                message = this.type + "#" + this.name + "(" + this.id + "): There's fog.";
                logger.writeLog(message);
                break;
            case "SNOW":
                message = this.type + "#" + this.name + "(" + this.id + "): OMG! Winter is coming!";
                logger.writeLog(message);
                new_height = this.coordinates.getHeight() - 7;
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