package esercizio_3116_pag_48;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio di modellazione seguendo le istruzioni a pag. 48 del libro
 *
 */

public class C {
    public static void m(Integer[] b1, Integer[] b2){

    }
    public static void main( String[] args ){
        Integer[] a1 = {new Integer(2),new Integer(9)};
        Integer[] a2 = {new Integer(4),new Integer(7)};
        Integer[] a3 = {null,new Integer(5)};
        Integer[] a4 = {new Integer(6),new Integer(1)};
        m(a1,a2);
        System.out.println(a1[0] + " " + a2[0]); // Stampa 4 2
        m(a3,a4);
        System.out.println(a3[0] + " " + a4[0]); // Stampa null 6
        m(a4,null);
        System.out.println(a4[0]); // Stampa 6

    }
}
