package controller;

import java.util.*;
import java.io.*;

import lib.CSV;
import model.Student;

/** 
 * A class with high-level methods to manipulate the list of subjects.
 *
 * @author Pablo Donato
 */
public class StudentController extends EntityController<Student>
{
    /**
     * Default constructor, loading the list of students from the CSV file.
     */
    public StudentController()
    {
        super("data/etudiants2014_2015.csv");
    }

    /**
     * Constuctor initializing the path to the CSV file containing the students.
     * 
     * @param csvPath The path to the CSV file containing the students.
     */
    public StudentController(String csvPath)
    {
        super(csvPath);
    }
}
