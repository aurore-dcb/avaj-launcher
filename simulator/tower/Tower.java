package simulator.tower;

import simulator.*;
import java.util.*;
import simulator.aircraft.*;

public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> to_unregister = new ArrayList<Flyable>();
    private Logger logger = Logger.getInstance();
    
    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        String message = "Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")" + " registered to weather tower.";
        logger.writeLog(message);
    };
    
    public void unregister(Flyable p_flyable) {
        to_unregister.add(p_flyable);
        String message = "Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")" + " unregistered to weather tower.";
        logger.writeLog(message);
    };

    protected void clear_observers() {
        Iterator<Flyable> it = to_unregister.iterator();
        while (it.hasNext()) {
            observers.remove(it.next());
        }
        to_unregister.clear();
    }

    protected void conditionChanged() {
        System.out.println("\n");
        Iterator<Flyable> it = observers.iterator();
        while (it.hasNext()) {
            it.next().updateConditions();
        }
        clear_observers();
    };

    public void Listing(List<Flyable> list) { // comment
        for (Flyable flyable : list) {
            System.out.println(flyable.getType() + " " + flyable.getName() + " " + flyable.getId() + " " + flyable.getCoordinates());
        }
    }
}