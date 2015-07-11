package it.algos.algoslib

import java.sql.Timestamp

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 12-8-13
 * Time: 07:44
 */
class LibTimeTest extends GroovyTestCase {

    void setUp() {
        // Setup logic here
    } // fine del metodo iniziale

    void tearDown() {
        // Tear down logic here
    } // fine del metodo finale

    /**
     * Elenco dei giorni dell'anno
     */
    void testGiorni() {
        def listaGiorni
        Map mappa
        int prog = 0

        listaGiorni = LibTime.getAllGiorni()
        assert listaGiorni instanceof ArrayList<Map>
        assert listaGiorni.size() == 366
        assert listaGiorni[0].mese == 1
        assert listaGiorni[0].normale == 1
        assert listaGiorni[0].bisestile == 1
        assert listaGiorni[0].nome == '1 gennaio'
        assert listaGiorni[0].titolo == '1º gennaio'
        assert listaGiorni[58].mese == 2
        assert listaGiorni[58].normale == 59
        assert listaGiorni[58].bisestile == 59
        assert listaGiorni[58].nome == '28 febbraio'
        assert listaGiorni[58].titolo == '28 febbraio'
        assert listaGiorni[59].mese == 2
        assert listaGiorni[59].normale == 0
        assert listaGiorni[59].bisestile == 60
        assert listaGiorni[59].nome == '29 febbraio'
        assert listaGiorni[59].titolo == '29 febbraio'
        assert listaGiorni[60].mese == 3
        assert listaGiorni[60].normale == 60
        assert listaGiorni[60].bisestile == 61
        assert listaGiorni[60].nome == '1 marzo'
        assert listaGiorni[60].titolo == '1º marzo'
        assert listaGiorni[365].mese == 12
        assert listaGiorni[365].normale == 365
        assert listaGiorni[365].bisestile == 366
        assert listaGiorni[365].nome == '31 dicembre'
        assert listaGiorni[365].titolo == '31 dicembre'

//        listaGiorni?.each {
//            mappa = it
//            assert mappa.nome != null
//            prog++
//            println(prog + ' ' + mappa.mese + ' - ' + mappa.normale + ' - ' + mappa.bisestile + ' - ' + mappa.nome + ' - ' + mappa.titolo)
//        } // fine del ciclo each

    }// fine del test

    void testCreaData() {
        String unaData
        Date risultato
        long millisec
        Date richiesta
        GregorianCalendar cal = new GregorianCalendar(2013, 02, 18, 0, 0, 0)
        millisec = cal.getTimeInMillis()
        richiesta = new Date(millisec)

        unaData = '18-03-13'
        risultato = LibTime.getData(unaData)
        assert risultato == richiesta

        unaData = '18-3-13'
        risultato = LibTime.getData(unaData)
        assert risultato == richiesta

        unaData = '18-03-2013'
        risultato = LibTime.getData(unaData)
        assert risultato == richiesta

        unaData = '2013-03-18'
        risultato = LibTime.getData(unaData)
        assertFalse(risultato == richiesta)

    }// fine del test

    void testCreaWikiData() {
        String wikiTime = '2013-03-18T09:39:08Z'
        Date wikiData
        long millisec
        Date dataRichiesta
        GregorianCalendar cal = new GregorianCalendar(2013, 02, 18, 9, 39, 8)
        millisec = cal.getTimeInMillis()
        dataRichiesta = new Date(millisec)

        wikiData = LibTime.getWikiData(wikiTime)
        assert wikiData == dataRichiesta
    }// fine del test

    void testCreaTimestamp() {
        String wikiTime = '2013-03-18T09:39:08Z'
        Timestamp timestamp
        long timestampLongValue = 1363595948000
        long longRisultato

        timestamp = LibTime.getWikiTimestamp(wikiTime)
        longRisultato = timestamp.time
        assert longRisultato == timestampLongValue
    }// fine del test

    void testCreaLongTimestamp() {
        String wikiTime = '2013-03-18T09:39:08Z'
        long timestampLongValue = 1363595948000
        long longRisultato

        longRisultato = LibTime.getWikiLongTimestamp(wikiTime)
        assert longRisultato == timestampLongValue
    }// fine del test

    void testDataFormat() {
        String ottenuto

        ottenuto = LibTime.getGioMeseAnno()
        println('Data corrente: ' + ottenuto)

        ottenuto = LibTime.getGioMeseAnnoTime()
        println('Orario corrente: ' + ottenuto)
    }// fine del test

    void testVariFormati() {
        String dataLunga = '31-ott-2013'
        String dataTipoGac = '31 ott 2013'
        Date unaData
        long millisec
        GregorianCalendar cal = new GregorianCalendar(2013, 9, 31, 0, 0, 0)
        millisec = cal.getTimeInMillis()
        unaData = new Date(millisec)
        String ottenuto

        ottenuto = LibTime.getStringa(unaData)
        assert ottenuto == '31-10-13'

        ottenuto = LibTime.getGioMeseAnno(unaData)
        assert ottenuto == '31-ott-13'

        ottenuto = LibTime.getGioMeseAnnoLungo(unaData)
        assert ottenuto == '31 ott 2013'
    }// fine del test

    void testGetTimeDiff() {
        Date dataInizio = LibTime.getData('18-3-13')
        Date dataFine = LibTime.getData('21-3-13')
        String richiesto = '3 giorni'
        String ottenuto

        ottenuto = LibTime.getTimeDiff(dataInizio, dataFine)
        assertEquals(ottenuto, richiesto)
    }// fine del test

    void testGetTimeDiff2() {
        long inizio = 0
        long fine
        String ottenuto
        String richiesto

        fine = 2
        richiesto='meno di 1 sec.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 999
        richiesto='meno di 1 sec.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 1000
        richiesto='1 sec.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 1999
        richiesto='1 sec.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 2000
        richiesto='2 sec.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 59999
        richiesto='59 sec.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 60000
        richiesto='1 min.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 239999
        richiesto='3 min.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 240000
        richiesto='4 min.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 290000
        richiesto='4 min.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 3599999
        richiesto='59 min.'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 3600000
        richiesto='1 ora'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 3660000
        richiesto='1 ora'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 7199000
        richiesto='1 ora'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 7200000
        richiesto='2 ore'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 86399999
        richiesto='23 ore'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 86400000
        richiesto='1 giorno'
        ottenuto = LibTime.getTimeDiff(inizio, fine)
        assertEquals(ottenuto, richiesto)
    }// fine del test

    void testGetTimeDiffMin() {
        long inizio = 0
        long fine
        String ottenuto
        String richiesto

        fine = 2
        richiesto='meno di 1 sec.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 999
        richiesto='meno di 1 sec.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 1000
        richiesto='1 sec.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 1999
        richiesto='1 sec.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 2000
        richiesto='2 sec.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 59999
        richiesto='59 sec.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 60000
        richiesto='1 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 239999
        richiesto='3 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 240000
        richiesto='4 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 290000
        richiesto='4 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 3599999
        richiesto='59 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 3600000
        richiesto='60 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 3660000
        richiesto='61 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 7199000
        richiesto='119 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 7200000
        richiesto='120 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 86399999
        richiesto='1.439 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)

        fine = 86400000
        richiesto='1.440 min.'
        ottenuto = LibTime.getTimeDiffMin(inizio, fine)
        assertEquals(ottenuto, richiesto)
    }// fine del test

} // fine della classe test unit
