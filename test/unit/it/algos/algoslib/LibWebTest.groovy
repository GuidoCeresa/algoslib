package it.algos.algoslib

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 15-8-13
 * Time: 08:31
 */
class LibWebTest extends GroovyTestCase {

    void setUp() {
        // Setup logic here
    } // fine del metodo iniziale

    void tearDown() {
        // Tear down logic here
    } // fine del metodo finale

    /**
     * Legge dal web una pagina.
     * Esegue solo se il domain è valido
     *
     * @param domain URL del sito (pagina)
     * @return testo html della pagina
     */
    void testLegge() {
        String domain = 'http://www.quattroprovince.it/'
        String primaParola = '<html>'
        String secondaParola = '<head>'
        String terzaParola = '<title>www.quattroprovince.it</title>'
        String quartaParola = '</head>'
        String testoPagina
        def ottenuto

        testoPagina = Lib.Web.legge(domain)
        ottenuto = Lib.Array.getWords(testoPagina)
        assert ottenuto != null
        assert ottenuto instanceof ArrayList
        assert ottenuto[0] == primaParola
        assert ottenuto[1] == secondaParola
        assert ottenuto[2] == terzaParola
        assert ottenuto[3] == quartaParola
    }// fine tests

    void testLegge2() {
        String domain = ''
        String testoPagina

        testoPagina = Lib.Web.legge(domain)
        assert testoPagina == ''
    }// fine tests

    void testLegge3() {
        String domain = 'http://it.wikipedia.org/wiki/Utente:Gac/Sandbox4'
        String testoPagina
        def ottenuto

        testoPagina = Lib.Web.legge(domain)
        ottenuto = Lib.Html.getTagsHtml(testoPagina)
        assert ottenuto != null
        assert ottenuto instanceof ArrayList
        assert ottenuto[2] == 'head'
    }// fine tests

    /**
     * Legge una pagina wiki.
     *
     * Esegue solo se il titolo è valido
     *
     * @param titolo wiki della pagina
     * @return testo html della pagina
     */
    void testLeggeWiki() {
        String titolo = 'Utente:Gac/Sandbox4'
        String richiesto = 'venti riga'
        String ottenuto

        ottenuto = Lib.Web.leggeItWiki(titolo)
        assert ottenuto == richiesto
    }// fine tests


} // fine della classe
