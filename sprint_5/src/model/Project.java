package model;

/**
 * @author Pablo Donato
 */
@SuppressWarnings("serial")
public class Project extends Entity
{
    public Project()
    {
        super("id", "team", "subject", "client", "supervisor", "technicalSupport"); 
    }
}
