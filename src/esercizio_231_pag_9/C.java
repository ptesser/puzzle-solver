package esercizio_231_pag_9;

/**
 * @author  Paolo Tesser
 * @version  0.1
 *
 */

public class C {
    public static void main(String[] args){
        String s = "pippo";
        String t = "pippo";
        System.out.println(s == t); // print true, perchè usiamo un'unica area di memoria per la stringa letterale pippo
        String s1 = new String("pippo");
        String t1 = new String("pippo");
        System.out.println(s1 == t1); // false, perchè abbiamo creato due oggetti diversi e == confronta le aree di memoria puntate dal riferimento e non il contenuto
        String p = new String("pippo");
        String s2 = p; String t2 = p;
        System.out.println(s2 == t2);
        String s3 = new String(p);
        String t3 = new String(p);
        System.out.println(s3 == t3);
    }

}
