package srcs.tower;

import java.util.*;
import srcs.aircraft.*;

public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")" + " registered to weather tower.");
    };
    
    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        System.out.println("Tower says: " + "type" + "#" + p_flyable.getName() + "(id)" + " unregistered from weather tower.");
    };

    protected void conditionChanged() {
        System.out.println("Condition changed");
        Iterator<Flyable> it = observers.iterator();
        while (it.hasNext()) {
            it.next().updateConditions();
        }
    };

    public void Listing() {
        Iterator<Flyable> it = observers.iterator();
        System.out.println("List observers :");
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
    }
}