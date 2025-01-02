package srcs;
import java.util.Random;


public class WeatherProvider {

    private static WeatherProvider instance = null;
    private String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    public static WeatherProvider getInstance() {

        if (instance == null)
        {
            instance =  new WeatherProvider();
        }

        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        Random r = new Random();
        int n = r.nextInt(3);
        String res = this.weather[n];
        return res; 
    }
}