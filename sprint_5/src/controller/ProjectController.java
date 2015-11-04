package controller;

import model.Project;

/** 
 * A class with high-level methods to manipulate the list of subjects.
 *
 * @author Pablo Donato
 */
public class ProjectController extends EntityController<Project>
{
    /**
     * Default constructor, loading the list of students from the CSV file.
     */
    public ProjectController()
    {
        super("test/projets2014_2015.csv");
    }

    /**
     * Constuctor initializing the path to the CSV file containing the projects.
     * 
     * @param csvPath The path to the CSV file containing the subjects.
     */
    public ProjectController(String csvPath)
    {
        super(csvPath);
    }
}
