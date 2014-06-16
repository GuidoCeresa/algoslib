package it.algos.algoslib

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 17-7-13
 * Time: 07:22
 */
class LibTestoTest extends GroovyTestCase {

    void setUp() {
        // Setup logic here
    } // fine del metodo iniziale

    void tearDown() {
        // Tear down logic here
    } // fine del metodo finale

    void testPercentuale() {
        int totaleVociCat
        int numVoci
        String percentualeRichiesta = '85,72%'
        String percentualeOttenuta

        totaleVociCat = 242000
        numVoci = 207451
        percentualeOttenuta = LibTesto.formatPercentuale(numVoci, totaleVociCat)
        assert percentualeOttenuta == percentualeRichiesta
    }// fine test

    void testContains() {
        String testo = "testo , con . vari g diversi [ caratteri { / speciali"
        String virgola = ','
        String punto = '.'
        String g = 'g'
        String quadra = '['
        String graffa = '{'
        String slash = '/'

        assert testo.contains(virgola)
        assert testo.contains(punto)
        assert testo.contains(g)
        assert testo.contains(quadra)
        assert testo.contains(graffa)
        assert testo.contains(slash)
    }// fine test

    /**
     * Restituisce la posizione di un tag in un testo
     * Riceve una lista di tag da provare
     * Restituisce la prima posizione tra tutti i tag trovati
     *
     *
     * @param testo in ingresso
     * @param lista di stringhe/interi, oppure singola stringa/intero
     *
     * @return posizione della prima stringa trovata
     *         -1 se non ne ha trovato nessuna
     *         -1 se il primo parametro è nullo o vuoto, oppure non è una stringa
     *         -1 se il secondo parametro è nullo
     *         -1 se il secondo parametro non è ne una lista di stringhe/interi, ne una stringa/intero
     */
    void testGetPos() {
        String testoUno = 'In questo 14 testo uno volte scrivo la parola due e tre pertanto la trovo'
        String testoDue = 'In questo tre testo tre volte scrivo la parola due e uno pertanto la trovo'
        String strUno = 'uno'
        int numUno = 14
        def lista = [strUno, 'due', 'tre']
        int num = 999
        int richiestoUno = 19
        int richiestoDue = 10
        int ottenuto

        ottenuto = Lib.Text.getPos(null, lista)
        assert ottenuto instanceof Integer
        assert ottenuto == LibTesto.INT_NULLO

        ottenuto = Lib.Text.getPos('', lista)
        assert ottenuto instanceof Integer
        assert ottenuto == LibTesto.INT_NULLO

        ottenuto = Lib.Text.getPos(num, lista)
        assert ottenuto instanceof Integer
        assert ottenuto == LibTesto.INT_NULLO

        ottenuto = Lib.Text.getPos(testoUno, null)
        assert ottenuto instanceof Integer
        assert ottenuto == LibTesto.INT_NULLO

        ottenuto = Lib.Text.getPos(testoUno, '')
        assert ottenuto instanceof Integer
        assert ottenuto == LibTesto.INT_NULLO

        ottenuto = Lib.Text.getPos(testoUno, strUno)
        assert ottenuto instanceof Integer
        assert ottenuto == richiestoUno

        ottenuto = Lib.Text.getPos(testoUno, numUno)
        assert ottenuto instanceof Integer
        assert ottenuto == richiestoDue

        ottenuto = Lib.Text.getPos(testoUno, lista)
        assert ottenuto instanceof Integer
        assert ottenuto == richiestoUno

        ottenuto = Lib.Text.getPos(testoDue, lista)
        assert ottenuto instanceof Integer
        assert ottenuto == richiestoDue

    }// fine tests

    /**
     * Forza il primo carattere della stringa a maiuscolo
     * Restituisce una stringa
     * Un numero ritorna un numero
     * Un nullo ritorna un nullo
     * Un oggetto non stringa ritorna uguale
     */
    void testPrimaMaiuscola() {
        def minuscola = 'tuttominuscolo'
        def maiuscola = 'Tuttominuscolo'
        def richiesto = 'Tuttominuscolo'
        def numero = 125789
        def ottenuto
        def misto = '4prova'
        ArrayList lista = new ArrayList()

        ottenuto = Lib.Text.primaMaiuscola(minuscola)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.primaMaiuscola(maiuscola)
        assert ottenuto in String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.primaMaiuscola(numero)
        assert ottenuto in Integer
        assert ottenuto == numero

        ottenuto = Lib.Text.primaMaiuscola(null)
        assert ottenuto == null

        ottenuto = Lib.Text.primaMaiuscola(misto)
        assert ottenuto in String
        assert ottenuto == misto

        ottenuto = Lib.Text.primaMinuscola(lista)
        assert ottenuto in List
        assert ottenuto == lista
    }// fine tests

    /**
     * Forza il primo carattere della stringa a minuscolo
     * Restituisce una stringa
     * Un numero ritorna un numero
     * Un nullo ritorna un nullo
     * Un oggetto non stringa ritorna uguale
     */
    void testPrimaMinuscola() {
        def minuscola = 'tuttoMinuscolo'
        def maiuscola = 'TuttoMinuscolo'
        def richiesto = 'tuttoMinuscolo'
        def numero = 125789
        def ottenuto
        def misto = '4prova'
        ArrayList lista = new ArrayList()

        ottenuto = Lib.Text.primaMinuscola(minuscola)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.primaMinuscola(maiuscola)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.primaMinuscola(numero)
        assert ottenuto instanceof Integer
        assert ottenuto == numero

        ottenuto = Lib.Text.primaMinuscola(null)
        assert ottenuto == null

        ottenuto = Lib.Text.primaMinuscola(misto)
        assert ottenuto instanceof String
        assert ottenuto == misto

        ottenuto = Lib.Text.primaMinuscola(lista)
        assert ottenuto instanceof List
        assert ottenuto == lista
    }// fine tests

    /**
     * Elimina la testa iniziale della stringa, se esiste.
     * <p/>
     * Esegue solo se la stringa è valida
     * Elimina spazi vuoti iniziali e finali
     * Se manca la testa, restituisce la stringa
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param entrata stringa in ingresso
     * @param testa da eliminare
     *
     * @return uscita stringa convertita
     */
    void testLevaTesta() {
        def testoUno = 'SeptuttoMinuscolo'
        def testoDue = 'Sep tuttoMinuscolo '
        def testoTre = 'Sep Sep tuttoMinuscolo Sep '
        def testoQuattro = 'tuttoSepMinuscolo'
        def richiesto = 'tuttoMinuscolo'
        def richiestoTre = 'Sep tuttoMinuscolo Sep'
        def testa = 'Sep'
        def ottenuto
        def numero = 785

        ottenuto = Lib.Text.levaTesta(testoUno, testa)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.levaTesta(testoDue, testa)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.levaTesta(testoTre, testa)
        assert ottenuto instanceof String
        assert ottenuto == richiestoTre

        ottenuto = Lib.Text.levaTesta(testoUno, null)
        assert ottenuto instanceof String
        assert ottenuto == testoUno

        ottenuto = Lib.Text.levaTesta(null, null)
        assert ottenuto == null

        ottenuto = Lib.Text.levaTesta(numero, null)
        assert ottenuto instanceof Integer
        assert ottenuto == numero

        ottenuto = Lib.Text.levaTesta(numero, testa)
        assert ottenuto instanceof Integer
        assert ottenuto == numero

        ottenuto = Lib.Text.levaTesta(testoQuattro, testa)
        assert ottenuto instanceof String
        assert ottenuto == testoQuattro

        ottenuto = Lib.Text.levaTesta(testoUno, numero)
        assert ottenuto instanceof String
        assert ottenuto == testoUno
    }// fine tests

    /**
     * Elimina la coda terminale della stringa, se esiste.
     * <p/>
     * Esegue solo se la stringa è valida
     * Elimina spazi vuoti iniziali e finali
     * Se manca la coda, restituisce la stringa
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     * @param stringaIn testo in ingresso
     * @param coda da eliminare
     *
     * @return stringa convertita
     */
    void testLevaCoda() {
        def testoUno = 'tuttoMinuscoloSep'
        def testoDue = 'tuttoMinuscolo Sep'
        def testoTre = 'tuttoMinuscolo Sep '
        def testoQuattro = 'tuttoSepMinuscolo'
        def richiesto = 'tuttoMinuscolo'
        def richiestoQuattro = 'tuttoSepMinuscolo'
        def coda = 'Sep'
        def ottenuto
        def numero = 785

        ottenuto = Lib.Text.levaCoda(testoUno, coda)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.levaCoda(testoDue, coda)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.levaCoda(testoTre, coda)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.levaCoda(testoUno, null)
        assert ottenuto instanceof String
        assert ottenuto == testoUno

        ottenuto = Lib.Text.levaCoda(null, null)
        assert ottenuto == null

        ottenuto = Lib.Text.levaCoda(numero, null)
        assert ottenuto instanceof Integer
        assert ottenuto == numero

        ottenuto = Lib.Text.levaCoda(numero, coda)
        assert ottenuto instanceof Integer
        assert ottenuto == numero

        ottenuto = Lib.Text.levaCoda(testoQuattro, coda)
        assert ottenuto instanceof String
        assert ottenuto == richiestoQuattro

        ottenuto = Lib.Text.levaCoda(testoUno, numero)
        assert ottenuto instanceof String
        assert ottenuto == testoUno
    }// fine tests

    /**
     * Sostituisce tutte le occorrenze.
     * <p/>
     * Esegue solo se il testo è valido
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param testoIn in ingresso
     * @param oldStringa da eliminare
     * @param newStringa da sostituire
     * @return testoOut convertito
     */
    void testSostituisce() {
        String testo
        String oldStringa
        String newStringa
        String richiesto
        String ottenuto

        testo = 'marioxlino vede sxempre lui'
        oldStringa = 'x'
        newStringa = ''
        richiesto = 'mariolino vede sempre lui'
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'marioxlino vede sxempre lui'
        oldStringa = 'vede'
        newStringa = 'guarda'
        richiesto = 'marioxlino guarda sxempre lui'
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = '125.785,00'
        oldStringa = '.'
        newStringa = ''
        richiesto = '125785,00'
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = '123,456,789'
        oldStringa = ','
        newStringa = '.'
        richiesto = '123.456.789'
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = '123.456.789'
        oldStringa = '.'
        newStringa = ','
        richiesto = '123,456,789'
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmarioxlino vede sxempre lui'
        oldStringa = 'x'
        newStringa = ''
        richiesto = 'mariolino vede sempre lui'
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmarioxlino vede sxempre luix'
        oldStringa = 'x'
        newStringa = ''
        richiesto = 'mariolino vede sempre lui'
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmario$lino vede s$empre lui$'
        oldStringa = '$'
        newStringa = 'y'
        richiesto = 'xmarioylino vede syempre luiy'
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmario\nlino vede s\nempre lui\n'
        oldStringa = '\n'
        newStringa = '<br>'
        richiesto = 'xmario<br>lino vede s<br>empre lui<br>'
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmario{{lino vede s{{empre lui{{'
        oldStringa = '{{'
        newStringa = '[['
        richiesto = 'xmario[[lino vede s[[empre lui[['
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto

        testo = 'xmario[[lino vede s[[empre lui[['
        oldStringa = '[['
        newStringa = '{{'
        richiesto = 'xmario{{lino vede s{{empre lui{{'
        ottenuto = Lib.Text.sostituisce(testo, oldStringa, newStringa)
        assert ottenuto == richiesto
    }// fine tests

    /**
     * Elimina tutti i caratteri contenuti nella stringa.
     * <p/>
     * Esegue solo se il testo è valido
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param testoIn in ingresso
     * @param subStringa da eliminare
     * @return testoOut stringa convertita
     */
    void testLevaTesto() {
        String testo = 'Prova di scrittura per levare dei caratteri'
        String uno = 'levare'
        String richiestoUno = 'Prova di scrittura per  dei caratteri'
        String due = 'caratteri'
        String richiestoDue = 'Prova di scrittura per levare dei '
        String ottenuto

        ottenuto = Lib.Text.levaTesto(testo, uno)
        assert ottenuto instanceof String
        assert ottenuto == richiestoUno

        ottenuto = Lib.Text.levaTesto(testo, due)
        assert ottenuto instanceof String
        assert ottenuto == richiestoDue
    }// fine tests

    /**
     * Elimina tutti i punti contenuti nella stringa.
     * <p/>
     * Esegue solo se la stringa è valida
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param entrata stringa in ingresso
     * @return uscita stringa convertita
     */
    void testLevaPunti() {
        def numeroUno = '123g456'
        def numeroDue = '123.456'
        def numeroTre = '123456'
        def numeroQuattro = '123456.0'
        def numeroCinque = '123,456'
        def lista = ['uno', 'due']
        def richiesto = '123456'
        def richiestoDue = '1234560'
        def ottenuto

        ottenuto = Lib.Text.levaPunti(numeroUno)
        assert ottenuto instanceof String
        assert ottenuto == numeroUno

        ottenuto = Lib.Text.levaPunti(null)
        assert ottenuto == null

        ottenuto = Lib.Text.levaPunti(lista)
        assert ottenuto instanceof List
        assert ottenuto == lista

        ottenuto = Lib.Text.levaPunti(numeroDue)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.levaPunti(numeroTre)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.levaPunti(numeroQuattro)
        assert ottenuto instanceof String
        assert ottenuto == richiestoDue

        ottenuto = Lib.Text.levaPunti(numeroCinque)
        assert ottenuto instanceof String
        assert ottenuto == numeroCinque
    }// fine tests

    /**
     * Elimina tutte le virgole contenute nella stringa.
     * <p/>
     * Esegue solo se la stringa è valida
     * Se arriva un oggetto non stringa, restituisce l'oggetto
     *
     * @param entrata stringa in ingresso
     * @return uscita stringa convertita
     */
    void testLevaVirgola() {
        def numeroUno = '123g456'
        def numeroDue = '123,456'
        def numeroTre = '123456'
        def numeroQuattro = '123456,0'
        def numeroCinque = '123.456'
        def lista = ['uno', 'due']
        def richiesto = '123456'
        def richiestoDue = '1234560'
        def ottenuto

        ottenuto = Lib.Text.levaVirgole(numeroUno)
        assert ottenuto instanceof String
        assert ottenuto == numeroUno

        ottenuto = Lib.Text.levaVirgole(null)
        assert ottenuto == null

        ottenuto = Lib.Text.levaVirgole(lista)
        assert ottenuto instanceof List
        assert ottenuto == lista

        ottenuto = Lib.Text.levaVirgole(numeroDue)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.levaVirgole(numeroTre)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.levaVirgole(numeroQuattro)
        assert ottenuto instanceof String
        assert ottenuto == richiestoDue

        ottenuto = Lib.Text.levaVirgole(numeroCinque)
        assert ottenuto instanceof String
        assert ottenuto == numeroCinque
    }// fine tests

    /**
     * Formattazione di un numero.
     * <p/>
     * Il numero può arrivare come stringa, intero o double
     * Se la stringa contiene punti e virgole, viene pulita
     * Se la stringa non è convertibile in numero, viene restituita uguale
     * Inserisce il punto separatore ogni 3 cifre
     * Se arriva un oggetto non previsto, restituisce l'oggetto

     * @param numero da formattare (stringa, intero o double)
     * @return numero formattato
     */
    void testFormatNum() {
        String numeroStr
        int numeroNum
        def lista = ['uno', 'due']
        def richiesto
        def ottenuto

        numeroStr = '123g456'
        richiesto = '123g456'
        ottenuto = Lib.Text.formatNum(numeroStr)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Text.formatNum(null)
        assert ottenuto == null

        ottenuto = Lib.Text.formatNum(lista)
        assert ottenuto in List
        assert ottenuto == lista

        numeroStr = '123,456'
        numeroNum = 123456
        richiesto = '123.456'
        ottenuto = Lib.Text.formatNum(numeroStr)
        assert ottenuto instanceof String
        assert ottenuto == richiesto
        ottenuto = Lib.Text.formatNum(numeroNum)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        numeroStr = '123456'
        numeroNum = 123456
        richiesto = '123.456'
        ottenuto = Lib.Text.formatNum(numeroStr)
        assert ottenuto instanceof String
        assert ottenuto == richiesto
        ottenuto = Lib.Text.formatNum(numeroNum)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        numeroStr = '123456,0'
        richiesto = '1.234.560'
        ottenuto = Lib.Text.formatNum(numeroStr)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        numeroStr = '123456789'
        richiesto = '123.456.789'
        ottenuto = Lib.Text.formatNum(numeroStr)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        numeroStr = '1234567890'
        richiesto = '1.234.567.890'
        ottenuto = Lib.Text.formatNum(numeroStr)
        assert ottenuto instanceof String
        assert ottenuto == richiesto
    }// fine tests

    /**
     * Estrae un parte di un testo compresa tra due tag inizio/fine
     * Gli estremi sono COMPRESI
     * Esegue solo se il testo ed i tag sono validi
     * Se manca uno dei due tag, restituisce il testo originale
     * Se i tag sono invertiti, restituisce il testo originale
     * Elimina spazi vuoti
     *
     * @param testo completo da esaminare
     * @param tagIni tag iniziale per il contenuto richiesto
     * @param tagEnd tag finale per il contenuto richiesto
     * @return contenuto richiesto tra i due tag
     */
    void testEstraeCompresi() {
        String testo
        String tagIni
        String tagEnd
        String tagUnicoInizialeFinale
        String richiesto
        String ottenuto

        testo = 'Descrizione della nobile famiglia della Gherardesca di Firenze'
        tagIni = 'della'
        tagEnd = 'della'
        richiesto = 'della nobile famiglia della'
        ottenuto = LibTesto.estraeCompresi(testo, tagIni, tagEnd)
        assert ottenuto == richiesto

        tagUnicoInizialeFinale = 'della'
        ottenuto = LibTesto.estraeCompresi(testo, tagUnicoInizialeFinale)
        assert ottenuto == richiesto

        tagIni = 'della'
        tagEnd = 'pippo'
        richiesto = testo
        ottenuto = LibTesto.estraeCompresi(testo, tagIni, tagEnd)
        assert ottenuto == richiesto

        tagIni = 'della'
        tagEnd = ''
        richiesto = testo
        ottenuto = LibTesto.estraeCompresi(testo, tagIni, tagEnd)
        assert ottenuto == richiesto

        tagIni = 'nobile'
        tagEnd = 'di'
        richiesto = 'nobile famiglia della Gherardesca di'
        ottenuto = LibTesto.estraeCompresi(testo, tagIni, tagEnd)
        assert ottenuto == richiesto

        tagIni = 'di'
        tagEnd = 'nobile'
        richiesto = testo
        ottenuto = LibTesto.estraeCompresi(testo, tagIni, tagEnd)
        assert ottenuto == richiesto
    }// fine tests

    /**
     * Estrae un parte di un testo compresa tra due tag inizio/fine
     * Gli estremi sono ESCLUSI
     * Esegue solo se il testo ed i tag sono validi
     * Se manca uno dei due tag, restituisce il testo originale
     * Se i tag sono invertiti, restituisce il testo originale
     * Elimina spazi vuoti
     *
     * @param testo completo da esaminare
     * @param tagIni tag iniziale per il contenuto richiesto
     * @param tagEnd tag finale per il contenuto richiesto
     * @return contenuto richiesto tra i due tag
     */
    void testEstraeEsclusi() {
        String testo
        String tagIni
        String tagEnd
        String tagUnicoInizialeFinale
        String richiesto
        String ottenuto

        testo = 'Descrizione della nobile famiglia della Gherardesca di Firenze'
        tagIni = 'della'
        tagEnd = 'della'
        richiesto = 'nobile famiglia'
        ottenuto = LibTesto.estraeEsclusi(testo, tagIni, tagEnd)
        assert ottenuto == richiesto

        tagUnicoInizialeFinale = 'della'
        ottenuto = LibTesto.estraeEsclusi(testo, tagUnicoInizialeFinale)
        assert ottenuto == richiesto

        tagIni = 'della'
        tagEnd = 'pippo'
        richiesto = testo
        ottenuto = LibTesto.estraeEsclusi(testo, tagIni, tagEnd)
        assert ottenuto == richiesto

        tagIni = 'della'
        tagEnd = ''
        richiesto = testo
        ottenuto = LibTesto.estraeEsclusi(testo, tagIni, tagEnd)
        assert ottenuto == richiesto

        tagIni = 'nobile'
        tagEnd = 'di'
        richiesto = 'famiglia della Gherardesca'
        ottenuto = LibTesto.estraeEsclusi(testo, tagIni, tagEnd)
        assert ottenuto == richiesto

        tagIni = 'di'
        tagEnd = 'nobile'
        richiesto = testo
        ottenuto = LibTesto.estraeEsclusi(testo, tagIni, tagEnd)
        assert ottenuto == richiesto
    }// fine tests

    /**
     * Elimina la parte di stringa successiva al tag, se esiste.
     * <p/>
     * Esegue solo se la stringa è valida
     * Elimina spazi vuoti iniziali e finali
     * Se manca il tag, restituisce la stringa
     *
     * @param testoIn stringa in ingresso
     * @param tagFinale da eliminare
     *
     * @return testoOut stringa ridotta
     */
    void testLevaDopo() {
        String tagRef = '<ref>'
        String originale = 'Prova di tag varii tipo <ref>'
        String richiesto = 'Prova di tag varii tipo'
        String ottenuto

        ottenuto = LibTesto.levaDopo(originale, tagRef)
        assert ottenuto
        assert ottenuto == richiesto
    }// fine tests

    /**
     * Elimina la parte di stringa successiva al tag <ref>, se esiste.
     *
     * Esegue solo se la stringa è valida
     * Elimina spazi vuoti iniziali e finali
     * Se manca il tag, restituisce la stringa
     *
     * @param testoIn stringa in ingresso
     * @return testoOut stringa ridotta
     */
    void testLevaDopoRef() {
        String originale = 'Prova di tag varii tipo <ref>'
        String richiesto = 'Prova di tag varii tipo'
        String ottenuto

        ottenuto = LibTesto.levaDopoRef(originale)
        assert ottenuto
        assert ottenuto == richiesto

        ottenuto = LibTesto.levaDopoNote(originale)
        assert ottenuto
        assert ottenuto == originale
    } // fine del metodo

    /**
     * Elimina la parte di stringa successiva al tag <!--, se esiste.
     *
     * Esegue solo se la stringa è valida
     * Elimina spazi vuoti iniziali e finali
     * Se manca il tag, restituisce la stringa
     *
     * @param testoIn stringa in ingresso
     * @return testoOut stringa ridotta
     */
    void testLevaDopoNote() {
        String originale = 'Prova di tag varii tipo <!--'
        String richiesto = 'Prova di tag varii tipo'
        String ottenuto

        ottenuto = LibTesto.levaDopoNote(originale)
        assert ottenuto
        assert ottenuto == richiesto

        ottenuto = LibTesto.levaDopoRef(originale)
        assert ottenuto
        assert ottenuto == originale
    } // fine del metodo

    /**
     * Elimina la parte di stringa successiva al tag {{, se esiste.
     *
     * Esegue solo se la stringa è valida
     * Elimina spazi vuoti iniziali e finali
     * Se manca il tag, restituisce la stringa
     *
     * @param testoIn stringa in ingresso
     * @return testoOut stringa ridotta
     */
    void testLevaDopoGraffe() {
        String originale = 'Prova di tag varii tipo{{'
        String richiesto = 'Prova di tag varii tipo'
        String ottenuto

        ottenuto = LibTesto.levaDopoGraffe(originale)
        assert ottenuto
        assert ottenuto == richiesto

        ottenuto = LibTesto.levaDopoRef(originale)
        assert ottenuto
        assert ottenuto == originale
    } // fine del metodo

} // fine della classe test unit
