package it.algos.algoslib

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 17-7-13
 * Time: 07:22
 */
class LibHtmlTest extends GroovyTestCase {

    void setUp() {
        // Setup logic here
    } // fine del metodo iniziale

    void tearDown() {
        // Tear down logic here
    } // fine del metodo finale

    /**
     * Inserisce tag in testa e coda della stringa.
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se il tag è nullo o vuoto o non stringa, restituisce il testo
     * Elimina spazi vuoti iniziali e finali
     *
     * @param String : stringaIn  in ingresso
     * @param String : tag da aggiungere in testa ed in coda alla stringa
     * @param String : attr attributo da aggiungere dopo l'apertura del tag
     * @return stringa coi tag aggiunti
     */
    void testSetTag() {
        String testo = 'testo qualsiasi'
        String tag = 'div'
        String attr = 'action=pippo'
        String richiesto = '<div>testo qualsiasi</div>'
        String richiestoDue = "<div $attr>testo qualsiasi</div>"
        def ottenuto

        ottenuto = Lib.html.setTag(testo, tag)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.html.setTag(testo, tag, '')
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.html.setTag(testo, tag, attr)
        assert ottenuto instanceof String
        assert ottenuto == richiestoDue

        ottenuto = Lib.html.setTag(null, tag, attr)
        assert ottenuto == null

        ottenuto = Lib.html.setTag(testo, null)
        assert ottenuto == testo

        ottenuto = Lib.html.setTag(testo, '')
        assert ottenuto == testo

        ottenuto = Lib.html.setTag(testo, 17)
        assert ottenuto == testo
    }// fine tests

    /**
     * Inserisce tag form in testa e coda della stringa.
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se il tag è nullo o vuoto o non stringa, restituisce il testo
     * Elimina spazi vuoti iniziali e finali
     *
     * @param String : stringaIn  in ingresso
     * @param String : attr attributo da aggiungere dopo l'apertura del tag
     * @return stringa coi tag aggiunti
     */
    void testSetTagForm() {
        String testo = 'testo qualsiasi'
        String attr = 'action=pippo'
        String richiesto = "<form $attr>testo qualsiasi</form>"
        String richiestoDue = "<form>testo qualsiasi</form>"
        def ottenuto

        ottenuto = Lib.html.setTagForm(testo, attr)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.html.setTagForm(null, attr)
        assert ottenuto == null

        ottenuto = Lib.html.setTagForm(testo, null)
        assert ottenuto == richiestoDue

        ottenuto = Lib.html.setTagForm(testo, '')
        assert ottenuto == richiestoDue

        ottenuto = Lib.html.setTagForm(testo, 17)
        assert ottenuto == richiestoDue
    }// fine tests

    void testColori() {
        String verde = 'verde'
        String blu = 'blu'
        String rosso = 'rosso'
        String ottenuto

        ottenuto = LibHtml.setVerde(verde)
        println(ottenuto)
        ottenuto = LibHtml.setBlu(blu)
        println(ottenuto)
        ottenuto = LibHtml.setRosso(rosso)
        println(ottenuto)

        ottenuto = LibHtml.setVerdeBold(verde)
        println(ottenuto)
        ottenuto = LibHtml.setBluBold(blu)
        println(ottenuto)
        ottenuto = LibHtml.setRossoBold(rosso)
        println(ottenuto)
    }// fine tests

    void testColoriBrowser() {
        ArrayList colori = ['green', 'LIGHTSEAGREEN', 'LIMEGREEN', 'MEDIUMSEAGREEN', 'YELLOWGREEN',
                'ROYALBLUE', 'SKYBLUE', 'CORNFLOWERBLUE', 'DEEPSKYBLUE', 'DODGERBLUE',
                'DEEPPINK', 'ORANGERED', 'TOMATO', 'CRIMSON']
        String testoBrowser = ''


        colori?.each {
            testoBrowser += LibHtml.setColore(it, it)
            testoBrowser += '</br>'
        } // fine del ciclo each
        println(testoBrowser)
    }// fine tests

} // fine della classe test unit
