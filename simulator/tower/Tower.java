package simulator.tower;

import java.util.*;
import simulator.aircraft.*;

public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> to_unregister = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")" + " registered to weather tower.");
    };
    
    public void unregister(Flyable p_flyable) {
        // unregister a la fin de la boucle des Aircrafts
        to_unregister.add(p_flyable);
        System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")" + " unregistered to weather tower.");
    };

    protected void conditionChanged() {
        System.out.println("\n");
        Iterator<Flyable> it = observers.iterator();
        while (it.hasNext()) {
            it.next().updateConditions();
        }
        to_unregister.clear();
    };

    public void Listing() {
        for (Flyable flyable : observers) {
            System.out.println(flyable.getType() + " " + flyable.getName() + " " + flyable.getId() + " " + flyable.getCoordinates());
        }
    }
}