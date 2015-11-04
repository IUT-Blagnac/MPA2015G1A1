package model;

/**
 * @author Pablo Donato and Rémi CROS
 */
@SuppressWarnings("serial")
public class Student extends Entity
{
	
	/**
     * Default constructor.
     */
    public Student()
    {
        super("team", "id", "lastName", "firstName");
    }
    
    /**
     * @param team Student's class team
     * @param id Student's id
     * @param lastName Student's last name
     * @param firstName Student's first name 
	 */
    public Student(String team, String id, String lastName, String firstName)
    {
    	put("team", team);
        put("id", id);
        put("lastName", lastName);
        put("firstName", firstName);
    }
}
