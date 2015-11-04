package model;

import java.util.*;

/**
 * @author Pablo Donato
 *
 * A class representing an Entity containing fields.
 */
@SuppressWarnings("serial")
public abstract class Entity extends LinkedHashMap<String, String>
{
    /**
     * Constuctor adding the keys from an array.
     *
     * @param keys The array of keys
     */
    public Entity(String... keys)
    {
        super();
        for(String key : keys) {
            put(key, "");
        }
    }
	
    /**
     * Returns a string representing a CSV line version of the Entity.
     *
     * @return The string representing the CSV line version of the Entity
     */
    @Override
    public String toString()
    {
        return values().toString().replace("[", "").replace("]", "").replace(", ", ",");
    }
}
