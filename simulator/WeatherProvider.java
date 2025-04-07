package simulator;

import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider instance = null;
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        if (instance == null){
            instance =  new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        Random r = new Random();
        int random_num = r.nextInt(4);
        int seed = p_coordinates.getLatitude() + p_coordinates.getLongitude() + p_coordinates.getHeight();
        String res = this.weather[(seed + random_num) % 4];
        return res; 
    }
}