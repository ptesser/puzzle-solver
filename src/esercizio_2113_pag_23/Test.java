package esercizio_2113_pag_23;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio di esercitazione su cosa stampa
 */
class A{
    static int a;
    A(int v){ a = v; }
    public void show(){ System.out.println(a);}
}

public class Test {
    public static void main(String[] args){
        A a1 = new A(1);
        A a2 = new A(2);
        a1.show(); // print 2
        a2.show(); // print 2
    }
}
