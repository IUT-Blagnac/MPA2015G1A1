package opti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

import model.Contributor;
import model.EntityComparator;
import controller.ContributorController;
import controller.ProjectController;

public class Contributors extends EntityPageGenerator {
    public Contributors(HashMap<String, String> csvPaths) {
        super(csvPaths);
    }

    public String generatePage() {
       	// Beginning

       	String html = "\n<!-- DEBUT page intervenants -->\n";
       	html += "<div data-role=\"page\" id=\"intervenants\" data-title=\"OPTIweb - V0.1\">\n<div data-role=\"header\" data-add-back-btn=\"true\">\n";
       	html += "<h1>Intervenants 2014-2015</h1>\n\n</div>\n<div data-role=\"content\">\n";
       	html += "\n\t<form class=\"ui-filterable\"><input id=\"autocomplete-input-intervenant\" name=\"intervenant\" data-type=\"search\" placeholder=\"Intervenant\"></form>\n";
       	html += "<ul id=\"listeintervenants\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-intervenant\" data-divider-theme=\"b\">";
       	html += "<li data-role=\"list-divider\">Intervenant<span class=\"ui-li-count\" style=\"right: 110px !important;\" title=\"Client\">Client</span><span class=\"ui-li-count\" title=\"Superviseur\">Superviseur</span></li>";
       	
       	// Content

       	ContributorController cc = new ContributorController(csvPaths.get("contributors"));
       	ProjectController pc = new ProjectController(csvPaths.get("projects"));

        ArrayList<Contributor> contributors = cc.getList();
        Collections.sort(contributors, new EntityComparator("lastName"));

       	for(Contributor c : contributors) {
       		html += "<li data-find=\"" + c.get("lastName") + " " + c.get("firstName") + "\"><a href=\"#projets\">" + c.get("lastName") + " " + c.get("firstName") + "<span class=\"ui-li-count\" style=\"right: 120px !important;\" title=\"Client\">" + pc.getListByAttr("client", c.get("id")).size() + "</span><span class=\"ui-li-count\" title=\"Superviseur\">" + pc.getListByAttr("supervisor", c.get("id")).size() + "</span></a></li>";
       	}
       	
       	// Ending

       	html += "</ul></div>\n<div data-role=\"footer\">\n<h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-group fa-2x\"></i></h4>\n</div>\n</div>\n";
       	html += "<!-- FIN page intervenants -->";
       	return html;
   }
}
