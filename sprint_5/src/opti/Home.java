package opti;

public class Home implements PageGenerator {
    public String generatePage() {
        String html = "<!-- DEBUT page accueil --><div data-role='page' id='accueil' data-title='OPTIweb - V0.1'><div data-role='header' data-add-back-btn='true'><h1>P<span class='landscape'>rojets </span>tut<span class='landscape'>orés</span> 2014-2015<br/>Département INFO<span class='landscape'>RMATIQUE</span><br/>IUT de Blagnac</h1><a href='#credits' data-theme='b' class='ui-btn-right'>Crédits</a>   <!-- 1 --></div><div data-role='content'><ul data-role='listview' data-inset='true' id='listeSources'>  <li><a href='#projets'><i class='fa fa-tasks'></i> Projets</a></li>   <!-- 1 -->  <li><a href='#sujets'><i class='fa fa-copy'></i> Sujets</a></li>   <!-- 1 -->  <li><a href='#etudiants'><i class='fa fa-group'></i> Etudiants</a></li>   <!-- 1 -->  <li><a href='#intervenants'><i class='fa fa-group'></i> Intervenants</a></li>   <!-- 1 --></ul></div><div data-role='footer'> <h4>OPTIweb V<span class='landscape'>ersion </span>0.1 <i class='fa fa- fa-2x'></i></h4></div></div><!-- FIN page accueil -->";
        return html;
    }
}
