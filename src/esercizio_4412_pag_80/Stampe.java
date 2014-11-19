package esercizio_4412_pag_80;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio per vedere le stampe generate da una gerarchia
 */

interface X {
    public void f();
}

interface Y {
    public void g();
}

class B implements Y {
    @Override
    public void g() {
        System.out.println("B.g()");
    }
    public void h(){
        System.out.println("B.h()");
    }
}

class C extends B implements X {
    @Override
    public void f() {
        System.out.println("C.f()");
    }
}

class D extends B implements X {
    @Override
    public void f() {
        System.out.println("D.f()");
    }

    @Override
    public void g() {
        System.out.println("D.c()");
    }
    public void h(int n){
        System.out.println("D.h(int)");
    }
    public static void f(X r, Y s) {
        if (r instanceof Y){
            Y y = (Y)r;
            y.g();
        }
        if (s instanceof B){
            s.g();
        }
    }
}

public class Stampe {
    public static void main( String[] arv ){
        System.out.println("Start first main");

        /**
         * Il codice precedente
         */
        System.out.println("End first main");

        System.out.println("Start second main");

        /**
         * Il codice precedente
         */
        System.out.println("End second main");

        System.out.println("Start third main");

        /**
         * Il codice precedente
         */
        System.out.println("End third main");

        System.out.println("Start fourth main");

        /**
         *
         */
        System.out.println("End fourth main");

        System.out.println("Start fifth main");

        /**
         * Il codice precedente
         */
        System.out.println("End fifth main");

        System.out.println("Start sixth main");

        /**
         * Il codice precedente
         */
        System.out.println("End sixth main");

        System.out.println("Start seventh main");

        /**
         * Il codice precedente
         */
        System.out.println("End seventh main");

        System.out.println("Start eighth main");

        /**
         * Il codice precedente
         */
        System.out.println("End eighth main");

        System.out.println("Start ninth main");

        /**
         * Il codice precedente
         */
        System.out.println("End ninth main");
    }
}

