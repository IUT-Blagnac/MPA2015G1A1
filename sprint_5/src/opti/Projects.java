package opti;

import java.util.ArrayList;
import java.util.HashMap;

import model.Project;
import model.Subject;
import model.Contributor;
import model.Student;
import controller.ProjectController;
import controller.SubjectController;
import controller.ContributorController;
import controller.StudentController;

public class Projects extends EntityPageGenerator {
	public Projects(HashMap<String, String> csvPaths) {
		super(csvPaths);
	}

    public String generatePage() {
    	// Beginning

       	String html = "<!-- DEBUT page projets -->\n<div data-role=\"page\" id=\"projets\" data-title=\"OPTIweb - V0.1\">\n<div data-role=\"header\" data-add-back-btn=\"true\">\n<h1>Projets 2014-2015</h1>\n";
       	html += "</div>\n<div data-role=\"content\">\n\n\t<form class=\"ui-filterable\"><input id=\"autocomplete-input-projet\" name=\"projet\" data-type=\"search\" placeholder=\"Vous cherchez ?...\"></form>";
       	html += "<ol id=\"listeprojets\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-projet\">";

       	// Content    

       	ProjectController pc = new ProjectController(csvPaths.get("projects"));
       	SubjectController sbc = new SubjectController(csvPaths.get("subjects"));
       	ContributorController cc = new ContributorController(csvPaths.get("contributors"));
       	StudentController sc = new StudentController(csvPaths.get("students"));

       	for(Project p : pc.getList()) {
            Subject subject = sbc.getByAttr("id", p.get("subject"));
            Contributor client = cc.getByAttr("id", p.get("client"));
            Contributor supervisor = cc.getByAttr("id", p.get("supervisor"));

       		html += "<li><p><b>[" + subject.get("name") + "]</b> " + subject.get("title") + "</p><p><b>Client :</b> " + client.get("lastName") + " " + client.get("firstName") + "</p><p><b>Superviseur :</b> " + supervisor.get("lastName") + " " + supervisor.get("firstName") + "</p><p><b>Groupe " + p.get("team") + " :</b> ";

            for(Student s : sc.getListByAttr("team", p.get("team"))) {
                html += s.get("firstName") + " " + s.get("lastName") + " - ";
            }

            html += "</p></li>";
       	}
       	
       	// Ending

       	html += "</ol></div>\n<div data-role=\"footer\">\n<h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-tasks fa-2x\"></i></h4>\n</div>\n</div>\n<!-- FIN page projets -->";
       	return html;
    }
}
