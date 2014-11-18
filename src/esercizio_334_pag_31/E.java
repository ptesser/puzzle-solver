package esercizio_334_pag_31;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio per vedere come vengono chiamati e quando i costruttori
 */

class D{
    int i = 4;
    int j;
    D(){
        print("i = " + i + ", j = " + j);
        j = 7;
    }
    static int x1 = print("static D.x1");
    static int print(String s){
        System.out.println(s);
        return 9;
    }
}

public class E extends D{
    int k = D.print("non static E.k");
    E(){ D.print("k = " + k); }
    static int x2 = D.print("static E.x2");

    public static void main(String[] args){
        D.print("invocazione di E()");
        E e = new E();
    }
}
