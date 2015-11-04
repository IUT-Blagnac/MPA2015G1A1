package controller;

import java.util.*;
import java.io.*;

import lib.CSV;
import model.Contributor;

/** 
 * A class with high-level methods to manipulate the list of subjects.
 *
 * @author Pablo Donato
 */
public class ContributorController extends EntityController<Contributor>
{
    /**
     * Default constructor, loading the list of students from the CSV file.
     */
    public ContributorController()
    {
        super("test/intervenants2014_2015.csv");
    }

    /**
     * Constuctor initializing the path to the CSV file containing the subjects.
     * 
     * @param csvPath The path to the CSV file containing the contributors.
     */
    public ContributorController(String csvPath)
    {
        super(csvPath);
    }
}
