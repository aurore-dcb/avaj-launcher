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
        // System.out.printf("length: %d\n", splitLine.length);
        if (splitLine.length != 5)
            return true;
        // 1er elem : String
        if (splitLine[0].matches("^[a-zA-Z]*$") == false) {
            // System.out.println("false");
            return true;
        }
        // 2e  elem : Char + Int
        // 3e et 4e elem : int
        try {
            Integer.parseInt(splitLine[2]);
            Integer.parseInt(splitLine[3]);
            int height = Integer.parseInt(splitLine[4]);
            if (height <= 0 || height >= 100)
                return true;
        } catch (Exception e) {
            return true;
        }
        // 5e elem : 0 < int < 100
        // for (String s : splitLine) {
        //     System.out.println(s);
        // }
        return false;
    }

    public static void Parser (String file) {
        int nb_line = 0;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (line != null && !line.isEmpty()) {
                if (nb_line == 0) {
                    if (verifyInputFirstLine(line) == true) {
                        throw new Exception("parse error: wrong format line " + nb_line + ".");
                    }
                } else {
                    if (verifyInputLineContent(line) == true) {
                        throw new Exception("parse error: wrong format line " + nb_line + ".");
                    }
                }
                // System.out.println(line);
                nb_line++;
                line = reader.readLine();
            }

            if (nb_line < 2) {
                throw new Exception("parse error: wrong format input file.");
            }
            reader.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void main (String[] args){
        Parser(args[0]);
        System.out.println("Parsing OK");
        // Coordinates coordinates1 = new Coordinates(654,33,20);
        // AircraftFactory factory = AircraftFactory.getInstance();
        // Flyable heli = factory.newAircraft("Helicopter", "H1", coordinates1);
        // System.out.println("type: " +  heli.getType());
        // Flyable B1 = factory.newAircraft("Baloon", "B1", coordinates1);
        // System.out.println("type: " +  B1.getType());
    }
}