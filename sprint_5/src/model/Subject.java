package model;

/**
 * @author Pablo Donato and Rémi CROS
 */
@SuppressWarnings("serial")
public class Subject extends Entity
{
    /**
     * The total number of subjects
     */
    public static int nbSubjects = 0;
	
	/**
     * Default constructor.
     */
    public Subject()
    {
        super("id", "name", "title");
    }

    /**
     * @param id Subject's ID
     * @param name Subject's name
     * @param title Subject's class group
	 */
    public Subject(String id, String name, String title)
    {
        put("id", id);
        put("name", name);
        put("title", title);
    }
}
