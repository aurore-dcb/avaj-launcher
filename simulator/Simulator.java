package simulator;

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

    private void verifyInputFirstLine(String line) throws CustomException {
        try {
            simu_max_runs = Integer.parseInt(line);
        } catch (Exception e) {
            throw new CustomException("Parse Error: Wrong first line format. First line must be an integer between 1 and 100.");
        }
        if (simu_max_runs <= 0 || simu_max_runs > 100) {
            throw new CustomException("Parse Error: Wrong first line format. First line must be an integer between 1 and 100.");
        }
    }

    private void verifyInputLineContent(String line, WeatherTower tower) throws CustomException {

        int longitude, latitude, height;
        String[] splitLine = line.split(" ");

        if (splitLine.length != 5 || splitLine[0].matches("^[a-zA-Z]*$") == false || splitLine[1].matches("^[a-zA-Z0-9]*$") == false) {
            throw new CustomException("Parse Error: Wrong flyable format. Expected format : <String> <String> <PositiveInt> <PositiveInt> <PositiveInt>");
        }
        try {
            longitude = Integer.parseInt(splitLine[2]);
            latitude = Integer.parseInt(splitLine[3]);
            height = Integer.parseInt(splitLine[4]);
        } catch (Exception e) {
            throw new CustomException("Parse Error: Wrong flyable format. Expected format : <String> <String> <PositiveInt> <PositiveInt> <PositiveInt>");
        }
        if (height <= 0 || height > 100 || latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180)
            throw new CustomException("Parse Error: Wrong flyable format. Coordinates must be in the range: longitude [-180, 180], latitude [-90, 90], height [1, 100].");
        
        Coordinates new_coordinates = new Coordinates(longitude, latitude, height);
        try {
            Flyable new_flyable = AircraftFactory.getInstance().newAircraft(splitLine[0], splitLine[1], new_coordinates);
            new_flyable.registerTower(tower);
        } catch (CustomException e) {
            System.out.println(e.getMessage()) ;
        }
    }

    private void Parser (String file, WeatherTower tower) throws CustomException, IOException {
        int nb_line = 0;
        Scanner sc = new Scanner(new File(file));
        String line = "";
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.isEmpty()) {
                continue; // skip empty lines
            }
            if (nb_line == 0) {
                verifyInputFirstLine(line);
            } else {
                verifyInputLineContent(line, tower);
            }
            nb_line++;
        }
        if (nb_line < 2) {
            throw new CustomException("Parse Error: Wrong format input file. The file must contain at least one flyable and the number of simulations.");
        }
        sc.close();
    }
    
    public static void main (String[] args) {

        Simulator simulator = new Simulator();
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory factory = AircraftFactory.getInstance();
        Logger logger = Logger.getInstance();

        try {
            if (args.length != 1) {
                throw new CustomException("Input Error: The program need exactly one argument.");
            }
            simulator.Parser(args[0], weatherTower);
        } catch (CustomException e) {
			System.err.println(e.getMessage());
            System.exit(1);
		} catch (IOException e) {
			System.err.println("File Error: Can't find or read the file \'" + args[0] + "\'.");
            logger.closeWriter();
            System.exit(1);
		}

        while (simulator.simu_runs < simulator.simu_max_runs) {
            weatherTower.changeWeather();
            simulator.simu_runs++;
        }
        logger.closeWriter();
    }
}