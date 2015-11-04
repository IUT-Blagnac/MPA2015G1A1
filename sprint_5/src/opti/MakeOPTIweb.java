package opti;

import java.util.*;
import java.io.*;

public class MakeOPTIweb {
    public static String generatePage(String projectsPath, String subjectsPath, String studentsPath, String contributorsPath) {
        HashMap<String, String> csvPaths = new HashMap<String, String>();
        csvPaths.put("projects", projectsPath);
        csvPaths.put("subjects", subjectsPath);
        csvPaths.put("students", studentsPath);
        csvPaths.put("contributors", contributorsPath);

        String html = "<!DOCTYPE html><html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><meta name='viewport' content='width=device-width, initial-scale=1'><meta name='generator' content='OPTIweb VOPTIweb' /><title>0.1 - V0.1</title><link rel='stylesheet' href='http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css' /><link rel='stylesheet' href='http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css' /><script src='http://code.jquery.com/jquery-1.9.1.min.js'></script><script src='http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js'></script><style type='text/css'>@media all and (orientation:portrait) { .landscape {display: none;} }@media all and (orientation:landscape) { .landscape {display: inline;} }</style></head><body>";
        html += new Home().generatePage();
        html += new Projects(csvPaths).generatePage();
        html += new Subjects(csvPaths).generatePage();
        html += new Students(csvPaths).generatePage();
        html += new Contributors(csvPaths).generatePage();
        html += new Credits().generatePage();
        html += "<script> $( 'li[data-find]' ).on( 'click',function(event){  $('#autocomplete-input-projet').val($(this).attr('data-find')).trigger('change'); });</script></body></html>";
        return html;
    }

    public static void main(String[] args) throws Exception {
    	String projectsPath = "test/projets2014_2015.csv";
    	String subjectsPath = "test/sujets2014_2015.csv";
    	String studentsPath = "test/etudiants2014_2015.csv";
    	String contributorsPath = "test/intervenants2014_2015.csv";
    	
    	int gui = 0;
    	int reachDefault = 0;
    	switch(args.length) {
    	case 0:
            gui = 1;
            System.out.println("No GUI found");
    		break;
    	case 1:
    		if(!args[0].equals("-nogui")) {
                System.out.println("Usage : veuillez entrer les arguments nécéssaires.");
                System.out.println("0 arguments : lance le programme avec une interface graphique");
                System.out.println("1 argument : si vous voulez utiliser les chemins par défaut sans interface graphique, utilisez l'option -nogui");
                System.out.println("4 arguments : les chemins des différents fichiers CSV, séparés par un espace");
        		reachDefault = 1;
    		}
    		break;
    	case 4:
    		projectsPath = args[0];
    		subjectsPath = args[1];
    		studentsPath = args[2];
    		contributorsPath = args[3];
    		break;
    	default :
    		System.out.println("Usage : Veuillez entrer les arguments nécéssaires.");
            System.out.println("0 arguments : lance le programme avec une interface graphique");
            System.out.println("1 argument : si vous voulez utiliser les chemins par défaut sans interface graphique, utilisez l'option -nogui");
            System.out.println("4 arguments : les chemins des différents fichiers CSV, séparés par un espace");
    		reachDefault = 1;
    		break;
    	}
    	
    	if(gui == 0 && reachDefault == 0) {
            PrintWriter bw = new PrintWriter("test/OPTIweb.html");
            bw.println(generatePage(projectsPath, subjectsPath, studentsPath, contributorsPath));
            bw.close();
    	}
    }
}
