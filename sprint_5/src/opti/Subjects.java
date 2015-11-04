package opti;

import java.util.ArrayList;
import java.util.HashMap;

import model.Subject;
import model.Project;
import controller.ProjectController;
import controller.SubjectController;

public class Subjects extends EntityPageGenerator {
	public Subjects(HashMap<String, String> csvPaths) {
		super(csvPaths);
	}
	
    public String generatePage() {
    	//Begining
        String html = "\n<!-- DEBUT page sujets -->\n";
        html += "<div data-role=\"page\" id=\"sujets\" data-title=\"OPTIweb - V0.1\">";
        html += "<div data-role=\"header\" data-add-back-btn=\"true\">";
        html += "<h1>Sujets 2014-2015</h1>";
        html += "</div>";
        
        
        //Content
        html += "<div data-role=\"content\">";        
        html += "<form class=\"ui-filterable\"><input id=\"autocomplete-input-sujet\" name=\"sujet\" data-type=\"search\" placeholder=\"Vous cherchez ?\"></form><ol id=\"listesujets\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-sujet\" data-divider-theme=\"b\" data-count-theme=\"a\"><li data-role=\"list-divider\">Sujet<span class=\"ui-li-count\" title=\"Groupe\" style=\"right: 40px !important;\">Groupe</span></li>";
        SubjectController sbc = new SubjectController(csvPaths.get("subjects"));
        ProjectController pc = new ProjectController(csvPaths.get("projects"));
    	for(Subject s : sbc.getList()){
    		html += "<li data-find=[" + s.get("name") + "]><a href=\"#projets\">[" + s.get("name") + "]<br/><div style=\"white-space:normal;\"><span><b>" + s.get("title") + "</b></span><span class=\"ui-li-count\">";
            for(Project p : pc.getListByAttr("subject", s.get("id"))) {
                html += p.get("team") + " ";
            }
            html += "</span></div></a></li>";
        }
    	
    	//Ending
    	html += "</div>";
    	html += "<div data-role=\"footer\">" ;
    	html += "<h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-copy fa-2x\"></i></h4>";
    	html += "</div>";
    	html += "</div>";
    	html += "<!-- FIN page sujets -->";
        return html;
    }
}
