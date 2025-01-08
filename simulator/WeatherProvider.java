package simulator;

import java.util.Random;


public class WeatherProvider {

    private static WeatherProvider instance = null;
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
    // private static int roll_seed = 0;

    public static WeatherProvider getInstance() {

        if (instance == null)
        {
            instance =  new WeatherProvider();
        }

        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        Random r = new Random();
        int n = r.nextInt(4);
        // roll_seed = (roll_seed + 1) % 365;
        // System.out.println("Rool Seed: " + roll_seed);
        int seed = p_coordinates.getLatitude() + p_coordinates.getLongitude() + p_coordinates.getHeight();
        // System.out.println("Seed: " + seed);
        int change = (seed + n); 
        String res = this.weather[change % 4];
        return res; 
    }
}