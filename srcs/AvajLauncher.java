package srcs;
import srcs.aircraft.Helicopter;

class AvajLauncher {
    public static void main (String[] args){
        Coordinates coordinates1 = new Coordinates(654,33,20);
        Helicopter heli = new Helicopter(1, "toto", coordinates1);
        heli.WhoAmI();
    }
}