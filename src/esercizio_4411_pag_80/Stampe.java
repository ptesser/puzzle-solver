package esercizio_4411_pag_80;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio per vedere le stampe generate da una gerarchia
 */

interface X {
    public void f();
}

interface Y {
    public int g();
}

class F implements X {
    @Override
    public void f() {
        System.out.println("F.f()");
    }
}

class C implements X {
    @Override
    public void f() {
        System.out.println("C.f()");
    }
}

class D extends C implements Y {
    @Override
    public int g() {
        System.out.println("D.g()");
        return 1;
    }
}

class E extends D {
    @Override
    public int g() {
        System.out.println("E.g()");
        return 2;
    }
}

public class Stampe {
    public static void main( String[] arv ){
        System.out.println("Start first main");
        // X x = new D();
        // C c = x;
        // x.f();
        /**
         * Il codice precedente non compila in quanto il tipo statico della var x è supertipo di C e quindi avrei bisongo di un cast
         */
        System.out.println("End first main");

        System.out.println("Start second main");
        // X x = new F();
        // Y y = x;
        // y.g();
        /**
         * Il codice precedente non compila in quanto alla var y gli si cerca di assegnare un oggetto che ha tipo non presente nella stessa gerarchia.
         */
        System.out.println("End second main");

        System.out.println("Start third main");
        // X x = new C();
        // Y y = (C)x;
        // y.g();
        /**
         * Il codice precedente non compila ?
         */
        System.out.println("End third main");

        System.out.println("Start fourth main");
        Y y = new E();
        D d = (D)y;
        d.f();
        y.g();
        /**
         * Il codice precedente produce il seguente output: C.f() - E.g()
         */
        System.out.println("End fourth main");


    }
}
