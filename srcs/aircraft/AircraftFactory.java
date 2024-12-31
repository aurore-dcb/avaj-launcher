package srcs.aircraft;

import srcs.*;

public class AircraftFactory {

    private static AircraftFactory instance = null;   
    private int id_max;

    private AircraftFactory() {
        id_max = -1;
    }

    public static AircraftFactory getInstance() {

        if (instance == null)
        {
            instance =  new AircraftFactory();
        }

        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        Flyable newFlyable;
        switch (p_type) {
            case "Helicopter":
                newFlyable = new Helicopter(id_max + 1, p_name, p_coordinates);
                break;
            case "JetPlane":
                newFlyable = new JetPlane(id_max + 1, p_name, p_coordinates);
                break;
            case "Baloon":
                newFlyable = new Baloon(id_max + 1, p_name, p_coordinates);
                break;
            default:
                throw new AssertionError(); // créer une erreur 'type d'aircraft inconnu'
        }
        id_max++;
        return newFlyable;
    }
}