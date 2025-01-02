package srcs;
import java.io.BufferedReader;
import java.io.FileReader;

class AvajLauncher {

    public static boolean verifyInputFirstLine(String line) {
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

    public static boolean verifyInputLineContent(String line) {
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
            Integer.parseInt(splitLine[2]);
            Integer.parseInt(splitLine[3]);
            int height = Integer.parseInt(splitLine[4]);
            if (height <= 0 || height > 100)
                return true;
        } catch (Exception e) {
            return true;
        }
        // stocker ?
        return false;
    }

    public static void Parser (String file) throws Exception {
        int nb_line = 0;
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();

        while (line != null && !line.isEmpty()) {
            if (nb_line == 0) {
                if (verifyInputFirstLine(line) == true) {
                    throw new Exception("wrong format line " + (nb_line + 1) + ".");
                 }
            } else {
               if (verifyInputLineContent(line) == true) {
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
        try {
            Parser(args[0]);
            System.out.println("Parsing OK");
        } catch (Exception e) {
            System.err.println("parse error: " + e.getMessage()); 
            System.exit(1);
        }
        // Coordinates coordinates1 = new Coordinates(654,33,20);
        // AircraftFactory factory = AircraftFactory.getInstance();
        // Flyable heli = factory.newAircraft("Helicopter", "H1", coordinates1);
        // System.out.println("type: " +  heli.getType());
        // Flyable B1 = factory.newAircraft("Baloon", "B1", coordinates1);
        // System.out.println("type: " +  B1.getType());
    }
}