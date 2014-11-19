package it.algos.algoslib

/**
 * Created with IntelliJ IDEA.
 * User: Gac
 * Date: 17-7-13
 * Time: 07:22
 */
class LibMatTest extends GroovyTestCase {

    void setUp() {
        // Setup logic here
    } // fine del metodo iniziale

    void tearDown() {
        // Tear down logic here
    } // fine del metodo finale

    /**
     * Controlla se il numero è pari
     *
     * @param num da controllare
     * @return vero se è pari
     */
    void testPari() {
        int uno = 2
        int due = 3
        int tre = 12450
        int quattro = 12451
        boolean pari

        pari = Lib.Math.isPari(uno)
        assert pari

        pari = Lib.Math.isPari(due)
        assert !pari

        pari = Lib.Math.isPari(tre)
        assert pari

        pari = Lib.Math.isPari(quattro)
        assert !pari
    }// fine del test

    /**
     * Controlla se il numero è dispari
     *
     * @param num da controllare
     * @return vero se è dispari
     */
    void testDispari() {
        int uno = 2
        int due = 3
        int tre = 12450
        int quattro = 12451
        boolean dispari

        dispari = Lib.Math.isDispari(uno)
        assert !dispari

        dispari = Lib.Math.isDispari(due)
        assert dispari

        dispari = Lib.Math.isDispari(tre)
        assert !dispari

        dispari = Lib.Math.isDispari(quattro)
        assert dispari
    }// fine del test

    /**
     * Restituisce il minore dei numeri passati.
     * I numeri possono essere passati come lista o come coppia o tripletta di numeri
     * I numeri possono essere int, double, float e long
     * Considera SOLO i numeri positivi
     *
     * @param numeri lista dei numeri da confrontare
     * @return numero minore
     */
    void testMinorePositivo() {
        int previsto
        int risultato

        previsto = 3
        risultato = LibMat.minimoPositivo(4, 3)
        assert risultato == previsto

        previsto = 54
        risultato = LibMat.minimoPositivo(-25, 821, 54)
        assert risultato == previsto

        previsto = 0
        risultato = LibMat.minimoPositivo(54, 0, -25)
        assert risultato == previsto

        previsto = 12
        risultato = LibMat.minimoPositivo([12, -3, 12, 87])
        assert risultato == previsto
    }// fine del test

    /**
     * Restituisce il minore dei numeri passati.
     * I numeri possono essere passati come lista o come coppia o tripletta di numeri
     * I numeri possono essere int, double, float e long
     * Considera ANCHE i numeri negativi
     *
     * @param numeri lista dei numeri da confrontare
     * @return numero minore
     */
    void testMinoreNegativo() {
        int previsto
        int risultato

        previsto = 3
        risultato = LibMat.minimoNegativo(4, 3)
        assert risultato == previsto

        previsto = -25
        risultato = LibMat.minimoNegativo(-25, 821, 54)
        assert risultato == previsto

        previsto = -25
        risultato = LibMat.minimoNegativo(54, 0, -25)
        assert risultato == previsto

        previsto = -3
        risultato = LibMat.minimoNegativo([12, -3, 12, 87])
        assert risultato == previsto
    } // fine del test

    /**
     * Avanzament di un ciclo
     *
     * @param numeroCorrente del ciclo
     * @param numeroDelBlocco per un ritorno valido
     *
     * @return vero quando numeroCorrente è un multiplo esatto di numeroDelBlocco
     */
    void testAvanzamento() {
        boolean previsto
        boolean risultato
        int numeroCorrente
        int numeroDelBlocco = 10
        int numeroDelBloccoErrato = 0

        numeroCorrente = 0
        previsto = false
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBloccoErrato)
        assert risultato == previsto

        numeroCorrente = 7
        previsto = false
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBloccoErrato)
        assert risultato == previsto

        numeroCorrente = 0
        previsto = false
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBlocco)
        assert risultato == previsto

        numeroCorrente = 1
        previsto = false
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBlocco)
        assert risultato == previsto

        numeroCorrente = 5
        previsto = false
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBlocco)
        assert risultato == previsto

        numeroCorrente = 9
        previsto = false
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBlocco)
        assert risultato == previsto

        numeroCorrente = 10
        previsto = true
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBlocco)
        assert risultato == previsto

        numeroCorrente = 15
        previsto = false
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBlocco)
        assert risultato == previsto

        numeroCorrente = 20
        previsto = true
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBlocco)
        assert risultato == previsto

        numeroCorrente = 21
        previsto = false
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBlocco)
        assert risultato == previsto

        numeroCorrente = 30
        previsto = true
        risultato = LibMat.avanzamento(numeroCorrente, numeroDelBlocco)
        assert risultato == previsto
    }// fine del metodo

} // fine della classe test unit
