package it.algos.algoslib

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 30-8-13
 * Time: 20:34
 */
class LibWikiTest extends GroovyTestCase {

    // Setup logic here
    void setUp() {
    } // fine del metodo iniziale

    // Tear down logic here
    void tearDown() {
    } // fine del metodo iniziale

    /**
     * Elimina (eventuali) tripli apici (grassetto) in testa e coda della stringa.
     * Funziona solo se gli apici sono esattamente in TESTA ed in CODA alla stringa
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se arriva una stringa vuota, restituisce una stringa vuota
     * Elimina spazi vuoti iniziali e finali
     *
     * @param stringa in ingresso
     * @return stringa con tripli apici eliminati
     */
    void testSetNoBold() {
        String testoUno = "'''In questo testo la trovo'''"
        String testoDue = "  In questo testo la trovo'''"
        String testoTre = "'''In questo testo la trovo '''"
        String richiesto = "In questo testo la trovo"
        String ottenuto
        int numero = 154
        String vuota = ''

        ottenuto = LibWiki.setNoBold(testoUno)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = LibWiki.setNoBold(testoDue)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = LibWiki.setNoBold(testoTre)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = LibWiki.setNoBold(richiesto)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = LibWiki.setNoBold(numero)
        assert ottenuto == null

        ottenuto = LibWiki.setNoBold(vuota)
        assert ottenuto == vuota
    } // fine del test

    /**
     * Aggiunge tripli apici (grassetto) in testa e coda della stringa.
     * Aggiunge SOLO se gia non esistono
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se arriva una stringa vuota, restituisce una stringa vuota
     * Elimina spazi vuoti iniziali e finali
     *
     * @param stringa in ingresso
     * @return stringa con tripli apici aggiunte
     */
    void testSetBold() {
        String testoUno = "'''In questo testo la trovo'''"
        String testoDue = "  In questo testo la trovo'''"
        String richiesto = "'''In questo testo la trovo'''"
        String ottenuto
        int numero = 154
        String vuota = ''

        ottenuto = Lib.Wiki.setBold(testoUno)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setBold(testoDue)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setBold(richiesto)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setBold(numero)
        assert ottenuto == null

        ottenuto = LibWiki.setBold(vuota)
        assert ottenuto == vuota
    } // fine del test

    /**
     * Elimina (eventuali) doppie quadre in testa e coda della stringa.
     * Funziona solo se le quadre sono esattamente in TESTA ed in CODA alla stringa
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se arriva una stringa vuota, restituisce una stringa vuota
     * Elimina spazi vuoti iniziali e finali
     *
     * @param stringa in ingresso
     * @return stringa con doppie quadre eliminate
     */
    void testSetNoQuadre() {
        String testoUno = '[[In questo testo la trovo]]'
        String testoDue = ' In questo testo la trovo]]'
        String testoTre = '[In questo testo la trovo ]]'
        String testoQuattro = '[In questo testo la trovo]'
        String richiesto = 'In questo testo la trovo'
        String ottenuto
        int numero = 154
        String vuota = ''

        ottenuto = Lib.Wiki.setNoQuadre(testoUno)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoQuadre(testoDue)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoQuadre(testoTre)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoQuadre(testoQuattro)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoQuadre(richiesto)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoQuadre(numero)
        assert ottenuto == null

        ottenuto = LibWiki.setNoQuadre(vuota)
        assert ottenuto == vuota
    } // fine del test

    /**
     * Aggiunge doppie quadre in testa e coda alla stringa.
     * Aggiunge SOLO se gia non esistono (ne doppie, ne singole)
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se arriva una stringa vuota, restituisce una stringa vuota
     * Elimina spazi vuoti iniziali e finali
     *
     * @param stringa in ingresso
     * @return stringa con doppie quadre aggiunte
     */
    void testSetQuadre() {
        String testoUno = ' In questo testo la trovo'
        String testoDue = '[In questo testo la trovo] '
        String richiesto = '[[In questo testo la trovo]]'
        String ottenuto
        int numero = 154
        String vuota = ''

        ottenuto = Lib.Wiki.setQuadre(testoUno)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setQuadre(testoDue)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setQuadre(richiesto)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setQuadre(numero)
        assert ottenuto == null

        ottenuto = LibWiki.setQuadre(vuota)
        assert ottenuto == vuota
    } // fine del test

    /**
     * Elimina (eventuali) doppie graffe in testa e coda della stringa.
     * Funziona solo se le graffe sono esattamente in TESTA ed in CODA alla stringa
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se arriva una stringa vuota, restituisce una stringa vuota
     * Elimina spazi vuoti iniziali e finali
     *
     * @param stringa in ingresso
     * @return stringa con doppie graffe eliminate
     */
    void testSetNoGraffe() {
        String testoUno = '{{In questo testo la trovo}}'
        String testoDue = ' In questo testo la trovo}}'
        String testoTre = '{In questo testo la trovo }}'
        String richiesto = 'In questo testo la trovo'
        String ottenuto
        int numero = 154
        String vuota = ''

        ottenuto = Lib.Wiki.setNoGraffe(testoUno)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoGraffe(testoDue)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoGraffe(testoTre)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoGraffe(richiesto)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoGraffe(numero)
        assert ottenuto == null

        ottenuto = LibWiki.setNoGraffe(vuota)
        assert ottenuto == vuota
    } // fine del test

    /**
     * Aggiunge doppie graffe in testa e coda alla stringa.
     * Aggiunge SOLO se gia non esistono (ne doppie, ne singole)
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se arriva una stringa vuota, restituisce una stringa vuota
     * Elimina spazi vuoti iniziali e finali
     *
     * @param stringa in ingresso
     * @return stringa con doppie graffe aggiunte
     */
    void testSetGraffe() {
        String testoUno = ' In questo testo la trovo'
        String testoDue = '{In questo testo la trovo} '
        String richiesto = '{{In questo testo la trovo}}'
        String ottenuto
        int numero = 154
        String vuota = ''

        ottenuto = Lib.Wiki.setGraffe(testoUno)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setGraffe(testoDue)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setGraffe(richiesto)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setGraffe(numero)
        assert ottenuto == null

        ottenuto = LibWiki.setGraffe(vuota)
        assert ottenuto == vuota
    } // fine del test

    /**
     * Elimina (eventuali) tag ref in testa e coda della stringa.
     * Pulisce la stringa da inizio/fine vuoto (trim)
     * Funziona solo se i tag sono esattamente in TESTA ed in CODA alla stringa
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se arriva una stringa vuota, restituisce una stringa vuota
     * Elimina spazi vuoti iniziali e finali
     *
     * @param stringa in ingresso
     * @return stringa col tag ref iniziale e finale eliminato
     */
    void testSetNoRef() {
        String testoUno = '<ref>In questo testo la trovo</ref>'
        String testoDue = ' In questo testo la trovo<ref/>'
        String testoTre = '<ref>In questo testo la trovo </ref>'
        String testoQuattro = ' <ref>In questo testo la trovo </ref>'
        String richiesto = 'In questo testo la trovo'
        String ottenuto
        int numero = 154
        String vuota = ''

        ottenuto = Lib.Wiki.setNoRef(testoUno)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoRef(testoDue)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoRef(testoTre)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoRef(testoQuattro)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoRef(richiesto)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setNoRef(numero)
        assert ottenuto == null

        ottenuto = LibWiki.setNoRef(vuota)
        assert ottenuto == vuota
    } // fine del test

    /**
     * Aggiunge tag ref in testa e coda alla stringa.
     * Aggiunge SOLO se gia non esiste
     * Se arriva un oggetto non stringa, restituisce nullo
     * Se arriva una stringa vuota, restituisce una stringa vuota
     * Elimina spazi vuoti iniziali e finali
     *
     * @param stringa in ingresso
     * @return stringa con tag ref aggiunti
     */
    void testSetRef() {
        String testoUno = ' In questo testo la trovo'
        String testoDue = '<ref>In questo testo la trovo</ref> '
        String richiesto = '<ref>In questo testo la trovo</ref>'
        String ottenuto
        int numero = 154
        String vuota = ''

        ottenuto = Lib.Wiki.setRef(testoUno)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setRef(testoDue)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setRef(richiesto)
        assert ottenuto instanceof String
        assert ottenuto == richiesto

        ottenuto = Lib.Wiki.setRef(numero)
        assert ottenuto == null

        ottenuto = LibWiki.setRef(vuota)
        assert ottenuto == vuota
    } // fine del test

    /**
     * Suddivide la lista in due colonne.
     *
     * @param listaIn in ingresso
     * @return listaOut in uscita
     */
    void testListaDueColonne() {
        def listaDue = ['due', 'otto']
        def listaTre = ['due', 'otto', 'beta']
        def listaQuattro = ['due', 'otto', 'beta', 'alfa']
        def listaCinque = ['due', 'otto', 'beta', 'alfa', 'omicron']
        def listaSei = ['due', 'otto', 'beta', 'alfa', 'omicron', 'gamma']
        def listaSette = ['due', 'otto', 'beta', 'alfa', 'omicron', 'gamma', 'delta']
        def ottenuto
        String tagColonna = '{{ColBreak}}'

        ottenuto = Lib.Wiki.listaDueColonne(listaDue)
        assert ottenuto.size() == 5
        assert ottenuto[2] == tagColonna

        ottenuto = Lib.Wiki.listaDueColonne(listaTre)
        assert ottenuto.size() == 6
        assert ottenuto[3] == tagColonna

        ottenuto = Lib.Wiki.listaDueColonne(listaQuattro)
        assert ottenuto.size() == 7
        assert ottenuto[3] == tagColonna

        ottenuto = Lib.Wiki.listaDueColonne(listaCinque)
        assert ottenuto.size() == 8
        assert ottenuto[4] == tagColonna

        ottenuto = Lib.Wiki.listaDueColonne(listaSei)
        assert ottenuto.size() == 9
        assert ottenuto[4] == tagColonna

        ottenuto = Lib.Wiki.listaDueColonne(listaSette)
        assert ottenuto.size() == 10
        assert ottenuto[5] == tagColonna
    } // fine del test

    /**
     * Controlla se nel testo ci sono occorrenze pari dei tag.
     *
     * @param testo in ingresso
     * @param tagOpen di apertura
     * @param tagClose di chiusura
     * @return vero se le occorrenze di apertura e chiusura sono uguali
     */
    void testIsTagPari() {
        String testoUno = 'Senza xxscopo nessuno yy potreyybbe farcela'
        String testoDue = 'Senza xxscopo nessuno yy poxxtreyybbe farcela'
        String testoTre = 'Senza xxscopo nxxessuno yy potreyybbe farcela'
        String testoQuattro = 'Senza xxscopo nessuno yy potreyybbe farcelaxx'
        String tagIni = 'xx'
        String tagEnd = 'yy'
        boolean pari

        pari = Lib.Wiki.isTagPari(testoUno, tagIni, tagEnd)
        assert !pari

        pari = Lib.Wiki.isTagPari(testoDue, tagIni, tagEnd)
        assert pari

        pari = Lib.Wiki.isTagPari(testoTre, tagIni, tagEnd)
        assert pari

        pari = Lib.Wiki.isTagPari(testoQuattro, tagIni, tagEnd)
        assert !pari
    } // fine del test

    /**
     * Controlla se nel testo ci sono occorrenze pari delle quadre.
     *
     * @param testo in ingresso
     * @return vero se le occorrenze di apertura e chiusura sono uguali
     */
    void testIsQuadrePari() {
        String testoUnoDispari = 'Senza [[scopo nessuno ]] potre]]bbe farcela'
        String testoDuePari = 'Senza [[scopo nessuno ]] po[[tre]]bbe farcela'
        String testoTrePari = 'Senza [[scopo n[[essuno ]] potre]]bbe farcela'
        String testoQuattroPari = 'Senza [[scopo nessuno ]] potre]]bbe farcela[['
        boolean pari

        pari = Lib.Wiki.isQuadrePari(testoUnoDispari)
        assertFalse(pari)

        pari = Lib.Wiki.isQuadrePari(testoDuePari)
        assertTrue(pari)

        pari = Lib.Wiki.isQuadrePari(testoTrePari)
        assertTrue(pari)

        pari = Lib.Wiki.isQuadrePari(testoQuattroPari)
        assertFalse(pari)
    } // fine del test

    /**
     * Controlla se nel testo ci sono occorrenze pari delle graffe.
     *
     * @param testo in ingresso
     * @return vero se le occorrenze di apertura e chiusura sono uguali
     */
    void testIsGraffePari() {
        String testoUno = 'Senza {{scopo nessuno }} potre}}bbe farcela'
        String testoDue = 'Senza {{scopo nessuno }} po{{tre}}bbe farcela'
        String testoTre = 'Senza {{scopo n{{essuno }} potre}}bbe farcela'
        String testoQuattro = 'Senza {{scopo nessuno }} potre}}bbe farcela{{'
        boolean pari

        pari = Lib.Wiki.isGraffePari(testoUno)
        assertFalse(pari)

        pari = Lib.Wiki.isGraffePari(testoDue)
        assertTrue(pari)

        pari = Lib.Wiki.isGraffePari(testoTre)
        assertTrue(pari)

        pari = Lib.Wiki.isGraffePari(testoQuattro)
        assertFalse(pari)
    } // fine del test

    /**
     * Inserisce il testo in un cassetto
     *
     * @param testoIn in ingresso
     * @return testoOut in uscita
     */
    void testCassetto() {
        String aCapo = '\n'
        String titolo = 'Prova'
        String testoUno = 'Testo valido di prova'
        String testoDue = 'Testo non valido {{di prova'
        String testo
        String ottenuto

        testo = aCapo
        testo += '{{cassetto'
        testo += aCapo
        testo += '|larghezza=100%'
        testo += aCapo
        testo += '|allineamento=sinistra'
        testo += aCapo
        testo += "|titolo= $titolo"
        testo += aCapo
        testo += '|testo='
        testo += aCapo
        testo += testoUno
        testo += aCapo
        testo += '}}'
        testo += aCapo

        ottenuto = Lib.Wiki.cassetto(testoUno, titolo)
        assert ottenuto == testo

        ottenuto = Lib.Wiki.cassetto(testoDue, titolo)
        assert ottenuto == testoDue
    } // fine del test

    void testLevaQuadre() {
        String testo
        String previsto
        String risultato
        Integer numero = 23

        testo = ''
        previsto = ''
        risultato = LibWiki.levaQuadre(testo)
        assert risultato == previsto

        testo = 'Nessuna possibilità'
        previsto = 'Nessuna possibilità'
        risultato = LibWiki.levaQuadre(testo)
        assert risultato == previsto

        testo = '[[Cesare Pavese]]'
        previsto = 'Cesare Pavese'
        risultato = LibWiki.levaQuadre(testo)
        assert risultato == previsto

        testo = '[Cesare Pavese]'
        previsto = 'Cesare Pavese'
        risultato = LibWiki.levaQuadre(testo)
        assert risultato == previsto

        previsto = ''
        risultato = LibWiki.levaQuadre(numero)
        assert risultato == null
    } // fine del test

    void testLevaQuadreDoppie() {
        String testo
        String previsto
        String risultato
        Integer numero = 23

        testo = ''
        previsto = ''
        risultato = LibWiki.levaQuadreDoppie(testo)
        assert risultato == previsto

        testo = 'Nessuna possibilità'
        previsto = 'Nessuna possibilità'
        risultato = LibWiki.levaQuadreDoppie(testo)
        assert risultato == previsto

        testo = '[[Cesare Pavese]]'
        previsto = 'Cesare Pavese'
        risultato = LibWiki.levaQuadreDoppie(testo)
        assert risultato == previsto

        testo = '[Cesare Pavese]'
        previsto = 'Cesare Pavese'
        risultato = LibWiki.levaQuadreDoppie(testo)
        assert risultato == previsto

        previsto = ''
        risultato = LibWiki.levaQuadreDoppie(numero)
        assert risultato == null
    } // fine del test

    void testLevaTonde() {
        String testo
        String previsto
        String risultato
        Integer numero = 23

        testo = ''
        previsto = ''
        risultato = LibWiki.levaTonde(testo)
        assert risultato == previsto

        testo = 'Nessuna possibilità'
        previsto = 'Nessuna possibilità'
        risultato = LibWiki.levaTonde(testo)
        assert risultato == previsto

        testo = '((Cesare Pavese))'
        previsto = '(Cesare Pavese)'
        risultato = LibWiki.levaTonde(testo)
        assert risultato == previsto

        testo = '(Cesare Pavese)'
        previsto = 'Cesare Pavese'
        risultato = LibWiki.levaTonde(testo)
        assert risultato == previsto

        previsto = null
        risultato = LibWiki.levaTonde(numero)
        assert risultato == previsto
    } // fine del test


    void testLevaTondeDoppie() {
        String testo
        String previsto
        String risultato
        Integer numero = 23

        testo = ''
        previsto = ''
        risultato = LibWiki.levaTondeDoppie(testo)
        assert risultato == previsto

        testo = 'Nessuna possibilità'
        previsto = 'Nessuna possibilità'
        risultato = LibWiki.levaTondeDoppie(testo)
        assert risultato == previsto

        testo = '((Cesare Pavese))'
        previsto = 'Cesare Pavese'
        risultato = LibWiki.levaTondeDoppie(testo)
        assert risultato == previsto

        testo = '(Cesare Pavese)'
        previsto = '(Cesare Pavese)'
        risultato = LibWiki.levaTondeDoppie(testo)
        assert risultato == previsto

        previsto = null
        risultato = LibWiki.levaTondeDoppie(numero)
        assert risultato == previsto
    } // fine del test


    void testLevaApicetti() {
        String testo
        String previsto
        String risultato
        Integer numero = 23

        testo = ''
        previsto = ''
        risultato = LibWiki.levaApicetti(testo)
        assert risultato == previsto

        testo = "Nessuna possibilità"
        previsto = "Nessuna possibilità"
        risultato = LibWiki.levaApicetti(testo)
        assert risultato == previsto

        testo = "''Cesare Pavese''"
        previsto = "'Cesare Pavese'"
        risultato = LibWiki.levaApicetti(testo)
        assert risultato == previsto

        testo = "'Cesare Pavese'"
        previsto = "Cesare Pavese"
        risultato = LibWiki.levaApicetti(testo)
        assert risultato == previsto

        previsto = null
        risultato = LibWiki.levaApicetti(numero)
        assert risultato == previsto
    } // fine del test


    void testLevaApicettiDoppi() {
        String testo
        String previsto
        String risultato
        Integer numero = 23

        testo = ''
        previsto = ''
        risultato = LibWiki.levaApicettiDoppi(testo)
        assert risultato == previsto

        testo = "Nessuna possibilità"
        previsto = "Nessuna possibilità"
        risultato = LibWiki.levaApicettiDoppi(testo)
        assert risultato == previsto

        testo = "''Cesare Pavese''"
        previsto = "Cesare Pavese"
        risultato = LibWiki.levaApicettiDoppi(testo)
        assert risultato == previsto

        testo = "'Cesare Pavese'"
        previsto = "'Cesare Pavese'"
        risultato = LibWiki.levaApicettiDoppi(testo)
        assert risultato == previsto

        previsto = null
        risultato = LibWiki.levaApicettiDoppi(numero)
        assert risultato == previsto
    } // fine del test


} // fine della classe
