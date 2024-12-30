package srcs.tower;

import java.util.*;
import srcs.aircraft.*;

public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        System.out.println("Tower says: " + "type" + "#" + "name" + "(id)" + " registered to weather tower");
    };
    
    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        System.out.println("Tower says: " + "type" + "#" + "name" + "(id)" + " unregistered from weather tower.");
    };

    protected void conditionChanged() {
        System.out.println("Condition changed");
    };
}