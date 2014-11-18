package esercizio_312_pag_27;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio per vedere ogni quanto passa il Garbage Collector
 */
public class Finalize {
    public void finalize(){ System.out.println("invocato finalize()"); }

    public static void main(String[] args){
        for (int i = 0; i < 100000; ++i){
            new Finalize();
            System.out.println(i);
        }
    }
}
