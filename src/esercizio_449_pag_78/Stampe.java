package esercizio_449_pag_78;


/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio per vedere le stampe generate da una gerarchia
 */


interface  X {
    void f();
}

class B {
    public void g(){
        System.out.println("B.g()");
    }
}

class C extends B implements X {
    public void f(){
        System.out.println("C.f()");
    }
    public void f( Object ref ){
        System.out.println("C.f(Object)");
    }
}

abstract class A extends B implements X {
    public void f(){
        System.out.println("A.f()");
    }
    public void g(){
        System.out.println("A.g()");
    }
    public abstract B f( B ref );
}


class D extends A {
    public static B st = new B();
    public void f(){
        System.out.println("D.f()");
    }
    public B f( B ref ){
        if (ref instanceof A) return (D)ref;
        return st;
    }
}

public class Stampe {
    public static void main( String[] argv ){
        System.out.println("Start first main");
        // B b = new A();
        // X x = (A)b;
        // x.f();
        /**
         * Il codice precedente non compila in quanto la classe A, essendo astratta, non può essere istanziata.
         */
        System.out.println("End first main");

        System.out.println("Start second main");
        // A a = new D();
        // B b = a;
        // b.g();
        // a.g();
        // a.f(b);
        /**
         * Il codice precedente genera il seguente output: A.g() - A.g()
         */
        System.out.println("End second main");

        System.out.println("Start third main");
        // B b = new D();
        //A a1 = (A)b;
        // A a2 = (D)b;
        // a1.f();
        // a2.f();
        /**
         * Il codice precedente genera il seguente output: D.f() - D.f()
         */
        System.out.println("End third main");

        System.out.println("Start fourth main");
        // D d = new D();
        // B b1 = d;
        // B b2 = d.f(b1);
        // b2.g();
        /**
         * Il codice precedente genera il seguente output: A.g()
         */
        System.out.println("End fourth main");

        System.out.println("Start fifth main");
        // B b1 = new B();
        // A a = new D();
        // B b2 = a.f(b1);
        // X x = (D)b2;
        /**
         * Il codice precedente genera una ClassCastException
         */
        System.out.println("End fifth main");

        System.out.println("Start sixth main");

        /**
         * Il codice precedente genera il seguente output: A.g() - A.g()
         */
        System.out.println("End sixth main");

        System.out.println("Start seventh main");

        /**
         * Il codice precedente genera il seguente output: A.g() - A.g()
         */
        System.out.println("End seventh main");

        System.out.println("Start eighth main");

        /**
         * Il codice precedente genera il seguente output: A.g() - A.g()
         */
        System.out.println("End eighth main");

    }


}
