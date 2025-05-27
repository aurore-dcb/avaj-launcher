package simulator.tower;

import java.util.*;
import simulator.Logger;
import simulator.aircraft.*;
import simulator.exceptions.*;

public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> to_unregister = new ArrayList<Flyable>();
    protected Logger logger = Logger.getInstance();
    
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
        Iterator<Flyable> it = observers.iterator();
        while (it.hasNext()) {
            try {
                it.next().updateConditions();
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        }
        clear_observers();
    };
}