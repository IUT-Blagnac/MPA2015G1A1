package opti;

public class Credits implements PageGenerator {
    public String generatePage() {
        String html = "<!-- DEBUT page credits --><div data-role='page' id='credits' data-title='OPTIweb - V0.1 - Crédits'><div data-role='header' data-add-back-btn='true'>    <!-- 1 --><h1>Crédits</h1></div><div data-role='content'><p>Cette application a été réalisée dans le cadre du module M3301/MPA du DUT Informatique à l'IUT de Blagnac.</p><ul data-role='listview' data-inset='true' id='contacts' data-theme='a' data-divider-theme='b'>    <li data-role='list-divider'>Product Owner</li>    <li>Fly Rocket</li>    <li>Université Toulouse 2 - IUT de Blagnac    <br/>Département INFORMATIQUE</li></ul><ul data-role='listview' data-inset='true' id='listecredits' data-theme='a' data-divider-theme='b'><li data-role='list-divider'>Membres de l'équipe de développement</li><li>Rémi CROS</li><li>Alex FABRE</li><li>Damien DUMAS</li><li>Pablo DONATO</li><li>Vincent FOUGERAS</li></ul><ul data-role='listview' data-inset='true' id='listepowered' data-theme='a' data-divider-theme='b'><li data-role='list-divider'>Propulsé par</li><li><a href='http://jquerymobile.com/' target='autrePage'>http://jquerymobile.com/</a></li><li><a href='http://fortawesome.github.io/Font-Awesome/' target='autrePage'>http://fortawesome.github.io/Font-Awesome/</a></li></ul></div><div data-role='footer'><h4>OPTIweb V<span class='landscape'>ersion </span>0.1 <i class='fa fa- fa-2x'></i></h4></div></div><!-- FIN page credits -->";
        return html;
    }
}
