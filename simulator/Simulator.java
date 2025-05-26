package simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;
import java.util.Scanner;

import simulator.aircraft.*;
import simulator.tower.WeatherTower;
import simulator.exceptions.*;

public class Simulator {

    private int simu_runs;
    private int simu_max_runs;

    private Simulator() {}

    private boolean verifyInputFirstLine(String line) {
        int nb_weather_change;
        try {
            simu_max_runs = Integer.parseInt(line);
        } catch (Exception e) {
            return true;
        }
        if (simu_max_runs <= 0 || simu_max_runs > 100) {
            return true;
        }
        return false;
    }

    private boolean verifyInputLineContent(String line, WeatherTower tower) {

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
            if (height <= 0 || height > 100 || latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180)
                return true;
            Coordinates new_coordinates = new Coordinates(longitude, latitude, height);
            Flyable new_flyable = AircraftFactory.getInstance().newAircraft(splitLine[0], splitLine[1], new_coordinates);
            if (new_flyable == null) {
                return false;
            }
            new_flyable.registerTower(tower);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    private void Parser (String file, WeatherTower tower) throws Exception {
        int nb_line = 0;
        try {
            Scanner sc = new Scanner(new File(file));

            String line = "";
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (line.isEmpty()) {
                    nb_line++;
                    continue; // skip empty lines
                }
                if (nb_line == 0) {
                    if (verifyInputFirstLine(line) == true) {
                        throw new ParseErrorException("Wrong first line format.");
                    }
                } else {
                    if (verifyInputLineContent(line, tower) == true) {
                        throw new ParseErrorException("Wrong flyable format.");
                    }
                }
                nb_line++;
            }
            if (nb_line < 2) {
                throw new ParseErrorException("Wrong format input file.");
            }
            sc.close();
        }
        catch (IOException e) {
            throw new Exception("Input error: " + e.getMessage());
        }
    }
    
    public static void main (String[] args) {

        Simulator simulator = new Simulator();
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory factory = AircraftFactory.getInstance();
        Logger logger = Logger.getInstance();

        try {
            if (args.length != 1) {
                throw new Exception("Input error: The program need one argument.");
            }
            simulator.Parser(args[0], weatherTower);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        while (simulator.simu_runs < simulator.simu_max_runs) {
            weatherTower.changeWeather();
            simulator.simu_runs++;
        }
        logger.closeWriter(); // absolument close si y'a un probleme et si le logger a ete instancié
    }
}