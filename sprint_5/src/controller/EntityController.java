package controller;

import java.util.*;
import java.io.*;
import java.lang.reflect.ParameterizedType;

import lib.CSV;
import model.Entity;

/** 
 * A class with high-level methods to manipulate a list of entities from a CSV file.
 *
 * @author Pablo Donato
 */
public class EntityController<E extends Entity>
{
    /**
     * Allows to instanciate generic class E
     */
    protected final Class<E> entityClass = (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    /**
     * The CSV containing the entities
     */
    protected CSV csv;
    /**
     * The path to the CSV source file
     */
    protected final String csvPath;

    /**
     * The list of entities
     */
    protected ArrayList<E> entities;

    /**
     * Default constructor, loading the list of entities from the CSV file.
     */
    public EntityController(String csvPath)
    {
        this.csvPath = csvPath;
        entities = new ArrayList<E>();

        try {
            csv = new CSV(csvPath, ";");
            ArrayList<ArrayList<String>> sheet = csv.getSheet();
            sheet.remove(0);

            for(int i = 0; i < sheet.size(); i++) {
                ArrayList<String> line = sheet.get(i);

                E entity = entityClass.newInstance();               
                Iterator<String> it = entity.keySet().iterator();
                for(String value : line) {
                    entity.put(it.next(), value);
                }

                entities.add(entity);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Get the list of entities.
     *
     * @return The list of entities
     */
    public ArrayList<E> getList()
    {
        return entities;
    }

    /**
     * Set the list of entities.
     *
     * @param entities The new list of entities
     */
    public void setList(ArrayList<E> entities)
    {
        this.entities = entities;
    }

    /**
     * Get the ID of an entity with a specific attribute value.
     *
     * @param key Entity's attribute key
     * @param value Entity's attribute value
     * @return The entity's ID
     */
    public int getID(String key, String value)
    {
        int i;
        for(i = 0; i < entities.size() && entities.get(i).get(key).compareTo(value) != 0; i++) {}
        if(!entities.get(i).get(key).equals(value)) {
            return -1;
        }
        return i;
    }

    /**
     * Get the IDs of entities with a specific attribute value.
     *
     * @param key Entities attribute key
     * @param value Entities attribute value
     * @return The list of IDs
     */
    public ArrayList<Integer> getIDs(String key, String value)
    {
        ArrayList<Integer> idList = new ArrayList<Integer>();
        for(int i = 0; i < entities.size(); i++) {
            if(entities.get(i).get(key).equals(value)) {
                idList.add(i);
            }
        }
        return idList;
    }

    /**
     * Get an entity with a specific attribute value.
     *
     * @param key Entity's attribute key
     * @param value Entity's attribute value
     * @return The entity
     */
    public E getByAttr(String key, String value)
    {
        int id = getID(key, value);
        if(id == -1) {
            return null;
        }
        return entities.get(id);
    }

    /**
     * Get entities with a specific attribute value.
     *
     * @param key Entities attribute key
     * @param value Entities attribute value
     * @return The list of entities
     */
    public ArrayList<E> getListByAttr(String key, String value)
    {
        ArrayList<E> entities = new ArrayList<E>();
        for(int id : getIDs(key, value)) {
            entities.add(this.entities.get(id));
        }
        return entities;
    }

    /**
     * Replace an entity with a specific attribute value with a new entity.
     *
     * @param key Old entity's attribute key
     * @param value Old entity's attribute value
     * @param newEntity The entity to be replaced with
     */
    public void setByAttr(String key, String value, E newEntity)
    {
        int id = getID(key, value);
        if(id == -1) {
            return;
        }
        entities.set(id, newEntity);
    }

    /**
     * Replace entities with a specific attribute value with a new entity.
     *
     * @param key Old entities attribute key
     * @param value Old entities attribute value
     * @param newEntity The entity to be replaced with
     */
    public void setListByAttr(String key, String value, E newEntity)
    {
        ArrayList<Integer> idList = getIDs(key, value);
        for(int id : getIDs(key, value)) {
            entities.set(id, newEntity);
        }
    }

    /**
     * Remove an entity with a specific attribute value.
     *
     * @param key Entity's attribute key
     * @param value Entity's attribute value
     */
    public void removeByAttr(String key, String value)
    {
        int id = getID(key, value);
        if(id == -1) {
            return;
        }
        entities.remove(id);
    }

    /**
     * Remove entities with a specific attribute value.
     *
     * @param key Entities attribute key
     * @param value Entities attribute value
     */
    public void removeListByAttr(String key, String value)
    {
        for(int id : getIDs(key, value)) {
            entities.remove(id);
        }
    }

    /**
     * Write the list of entities into the default CSV file.
     *
	 * @exception IOException Error when writing to file.
     */
    public void save() throws IOException
    { 
        save(csvPath);
    }

    /**
     * Write the list of entities into the CSV file.
     *
     * @param path Path to the CSV file.
	 * @exception IOException Error when writing to file.
     */
    public void save(String path) throws IOException
    { 
        ArrayList<ArrayList<String>> sheet = new ArrayList<ArrayList<String>>();
        for(E e : entities) {
            sheet.add(new ArrayList<String>(Arrays.asList(e.toString().split(","))));
        }
        csv.setSheet(sheet);
        csv.save(path);
    }
}
