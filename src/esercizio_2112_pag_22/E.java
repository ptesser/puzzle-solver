package esercizio_2112_pag_22;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio di esercitazione su cosa stampa
 */

class Z{
    public Z(int x){ System.out.println("Z("+ x + ")");}
}
class C{
    static{ // blocco di inizializzazione statico
        System.out.println("Blocco C");
    }
    static Z z = new Z(1);
}
class D{
    static Z z = new Z(2);
    static{ // blocco di inizializzazione statico
        System.out.println("Blocco D");
    }
}
public class E {
    public static void main(String[] args){
        System.out.println("UNO");
        C c = new C(); // print: Blocco C - Z(1)
        System.out.println("DUE");
        D d = new D(); // print: Z(2) - Blocco D
        System.out.println("TRE");
    }
}
