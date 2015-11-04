package model;

import java.util.Comparator;

/**
 * A class to compare two CSV entities by a specific attribute, mostly used to sort lists of entities.
 *
 * @author Pablo Donato
 */
public class EntityComparator implements Comparator<Entity> {
    private String attr;

    public EntityComparator(String attr) {
        this.attr = attr;
    }

    public int compare(Entity e1, Entity e2) {
        return e1.get(attr).compareTo(e2.get(attr));
    }
}
