package esercizio_2114_pag_23;

import java.util.Objects;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio di esercitazione su cosa stampa
 */
public class C {
    public static void F(Object r, Object s){
        Object t = r;
        r = s;
        s = t;
    }
    public static void main(String[] args){
        Integer x = new Integer(2);
        Integer y = new Integer(3);
        F(x,y);
        System.out.println(x + " " + y);
        String s = new String("pippo");
        F(x,s);
        System.out.println(x + " - " + y + " - " + s);
    }
}
