package controller;

import junit.framework.TestSuite;
import junit.framework.TestCase;
import java.util.*;
import lib.CSV;
import model.Subject;

public class SubjectControllerTest extends TestCase
{
    static int totalAssertions = 0;
    static int bilanAssertions = 0;

    /* Tests des opÃ©rations */

    public void test_new_SubjectController() throws Exception
    {
        SubjectController sc = new SubjectController();

        totalAssertions++;
        assertEquals("new SubjectController() retourne un SubjectController", "controller.SubjectController", sc.getClass().getName());
        bilanAssertions++;

        CSV csv = new CSV(";");
        try {
            csv.read("data/sujets2014_2015.csv");
        } catch(Exception e) {
            System.out.println(e);
        }

        for(int i = 0; i < csv.getSheet().size(); i++) {
            Subject subject = sc.getList().get(i);

            ArrayList<String> csvLine = csv.getSheet().get(i);
            ArrayList<String> scLine = new ArrayList<String>();
            scLine.add(subject.get("id"));
            scLine.add(subject.get("name"));
            scLine.add(subject.get("title"));

            for(int j = 0; j < csvLine.size(); j++) {
                totalAssertions++;
                assertEquals(scLine.get(j) + " == " + csvLine.get(j), scLine.get(j), csvLine.get(j));
                bilanAssertions++;
            }
        }
    }

    public void test_save_SubjectController() throws Exception
    {
        SubjectController sc = new SubjectController("data/SubjectControllerTestBegin.csv");
        
        ArrayList<Subject> subjectList;
        
        subjectList = sc.getList();
       
       
        subjectList.add(new Subject("90", "ProjectTest","Test"));
        sc.removeByAttr("name", "Carsat");
        sc.setByAttr("name", "Architekt", new Subject("666", "Devil", "title"));
        sc.save("data/SubjectControllerTestChanged.csv");
        
        CSV csv = new CSV(";");
        try {
        csv.read("data/SubjectControllerTestChanged.csv");
        } catch(Exception e) {
            System.out.println(e);
        }
        CSV csv2 = new CSV(";");
        try {
        csv2.read("data/SubjectControllerTestFinal.csv");
        } catch(Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < csv.getSheet().size(); i++){
        	totalAssertions++;
        	assertEquals(csv.getSheet().get(i),csv2.getSheet().get(i));
        	bilanAssertions++;
        }
        
    }
    /* Main */

    public static void main(String[] args)
    {
        System.out.println("Tests de la classe SubjectController");
        junit.textui.TestRunner.run(new TestSuite(SubjectControllerTest.class));
        if(bilanAssertions == totalAssertions) {
            System.out.print("Bravo !");
        } else {
            System.out.print("OUPS !");
        }
        System.out.println(" " + bilanAssertions + "/" + totalAssertions + " assertions verifiées");
    }
}
