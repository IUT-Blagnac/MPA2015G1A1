package opti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import model.EntityComparator;

import model.Student;
import controller.StudentController;

public class Students extends EntityPageGenerator {
    public Students(HashMap<String, String> csvPaths) {
        super(csvPaths);
    }

    public String generatePage() {
       	// Beginning

       	String html = "\n<!-- DEBUT page etudiants -->\n";
       	html+="<div data-role=\"page\" id=\"etudiants\" data-title=\"OPTIweb - V0.1\">";
       	html+="<div data-role=\"header\" data-add-back-btn=\"true\">";
       	html+="<h1>Etudiants 2014-2015</h1>";
       	html+="</div>";
       	
       	// Content    

       	html+="<div data-role=\"content\">";
        html+="<form class=\"ui-filterable\"><input id=\"autocomplete-input-etudiant\" name=\"etudiant\" data-type=\"search\" placeholder=\"Etudiant ou Groupe X\"></form><ol id=\"listeetudiants\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-etudiant\" data-divider-theme=\"b\"><li data-role=\"list-divider\">Etudiant<span class=\"ui-li-count\" title=\"Groupe\" style=\"right: 40px !important;\">Groupe</span></li>";

       	StudentController stc = new StudentController(csvPaths.get("students"));

       	ArrayList<Student> students = stc.getList();
        Collections.sort(students, new EntityComparator("lastName"));

       	for(int i = 0; i < students.size(); i++) {
       		html+="<li data-find=\"" + students.get(i).get("firstName") + " " + students.get(i).get("lastName") + "\"><a href=\"#projets\">" + students.get(i).get("lastName") + " " + students.get(i).get("firstName") + "<span class=\"ui-li-count\" title=\"Groupe\">Groupe " + students.get(i).get("team") + "</span></a></li>";     		
       	}

       	html += "</ol></div>";

       	// Ending
       	
       	html+="<div data-role=\"footer\">";
       	html+="<h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-group fa-2x\"></i></h4>"; 
       	html+=" </div>";
       	html+=" </div>";
       	html += "<!-- FIN page etudiants -->";
       	return html;
   }
}
