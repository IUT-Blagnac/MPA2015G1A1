package controller;

import java.util.*;
import java.io.*;

import lib.CSV;
import model.Subject;

/** 
 * A class with high-level methods to manipulate the list of subjects.
 *
 * @author Pablo Donato
 */
public class SubjectController extends EntityController<Subject>
{
    /**
     * Default constructor, loading the list of subjects from the CSV file.
     */
    public SubjectController()
    {
        super("data/sujets2014_2015.csv");
    }
    
    /**
     * Constuctor initializing the path to the CSV file containing the subjects.
     * 
     * @param csvPath The path to the CSV file containing the subjects.
     */
    public SubjectController(String csvPath)
    {
    	super(csvPath);
    }
    
    /**
     * Updates Subject.nbSubjects with the size of this controller's subjects list.
     */
    public void updateNbSubjects()
    {
        Subject.nbSubjects = entities.size();
    }
}
