package simulator;

import java.io.BufferedReader;
import java.io.FileReader;

import simulator.aircraft.AircraftFactory;
import simulator.aircraft.Flyable;
import simulator.tower.WeatherTower;

class Simulator {

    public static boolean verifyInputFirstLine(String line, WeatherTower tower) {
        int nb_weather_change;
        try {
            nb_weather_change = Integer.parseInt(line);
        } catch (Exception e) {
            return true;
        }
        if (nb_weather_change <= 0 || nb_weather_change > 100) {
            return true;
        }
        // stocker ?
        // System.out.println("nb = " + Integer.toString(nb_weather_change));
        return false;
    }

    public static boolean verifyInputLineContent(String line, WeatherTower tower) {

        String[] splitLine = line.split(" ");
        if (splitLine.length != 5)
            return true;
        if (splitLine[0].matches("^[a-zA-Z]*$") == false) {
            return true;
        }
         if (splitLine[1].matches("^[A-Z0-9]*$") == false) {
            return true;
        }
        try {
            int longitude = Integer.parseInt(splitLine[2]);
            int latitude = Integer.parseInt(splitLine[3]);
            int height = Integer.parseInt(splitLine[4]);
            if (height <= 0 || height > 100)
                return true;
            Coordinates new_coordinates = new Coordinates(longitude, latitude, height);
            Flyable new_flyable = AircraftFactory.getInstance().newAircraft(splitLine[0], splitLine[1], new_coordinates);
            new_flyable.registerTower(tower);
        } catch (Exception e) {
            return true;
        }
        // stocker ?
        return false;
    }

    public static void Parser (String file, WeatherTower tower) throws Exception {
        int nb_line = 0;
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();

        while (line != null && !line.isEmpty()) {
            if (nb_line == 0) {
                if (verifyInputFirstLine(line, tower) == true) {
                    throw new Exception("wrong format line " + (nb_line + 1) + ".");
                 }
            } else {
               if (verifyInputLineContent(line, tower) == true) {
                   throw new Exception("wrong format line " + (nb_line + 1) + ".");
                }
            }
            nb_line++;
            line = reader.readLine();
        }

        if (nb_line < 2) {
            throw new Exception("wrong format input file.");
        }
        reader.close();
    }
    public static void main (String[] args) {

        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory factory = AircraftFactory.getInstance();

        try {
            Parser(args[0], weatherTower);
            // System.out.println("Parsing OK");
        } catch (Exception e) {
            System.err.println("parse error: " + e.getMessage()); 
            System.exit(1);
        }

        Coordinates test_coor = new Coordinates(100,100,10);
        Flyable test_fly = factory.newAircraft("Baloon", "B0", test_coor);
        test_fly.registerTower(weatherTower);
        test_fly.updateConditions();
    }
}