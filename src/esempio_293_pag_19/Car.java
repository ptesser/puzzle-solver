package esempio_293_pag_19;

/**
 * @author  Paolo Tesser
 * @version  0.1
 *
 */

public class Car {
    private String modello;
    private String colore;
    private int numeroDiSerie;
    private static int proxNumDiSerie = 1;

    /**
     * Costruttore a due parametri della classe Car
     * @param modello modello della macchina
     * @param colore colore della macchina
     */
    public Car(String modello, String colore){
       this.modello = modello;
       this.colore = colore;
       this.numeroDiSerie = proxNumDiSerie++;
    }

    /**
     * Stampa il valore del prossimo numero di serie da assegnare a una macchina
     */
    public static void stampaProxNumSerie(){
        System.out.println("Il prox numero disponibile è " + proxNumDiSerie);
    }

    /**
     * Stampa i dati della macchina su cui viene richiamata la funzione
     */
    public void stampaDati(){
        System.out.println("Questa è una " + modello + " di colore " + colore + ", numero di serie: " + numeroDiSerie + ".");
    }

    public static void main(String[] args){
        Car pippoCar = new Car("Porsche Carrera 4","grigia");
        Car plutoCar = new Car("Ferrari Testarossa","gialla");

        pippoCar.stampaDati();
        plutoCar.stampaDati();

        stampaProxNumSerie();
    }
}
