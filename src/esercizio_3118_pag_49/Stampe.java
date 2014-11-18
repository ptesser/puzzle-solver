package esercizio_3118_pag_49;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio di esercitazione su cosa stampa, overriding
 */


class A{
    public void print(String s){ System.out.print(s + " "); }
    public void m1(){ print("A.m1"); m2(); }
    public void m2(){ print ("A.m2"); }
}

class B extends A{
    public void m2(){ print("B.m2"); }
    public void m3(){ print("B.m3"); }
}

class C extends A{
    public void m1(){ print("C.m1"); }
    public void m2(){ print("C.m2"); m1(); }
}

class D extends C{
    public void m1(){
        super.m1();
        print("D.m1");
    }
    public void m3(){ print("D.m3"); }
}

public class Stampe {
    public static void main( String[] args ){
        A ref1 = new B();
        A ref2 = new D();
        B ref3 = new B();
        C ref4 = new C();
        C ref5 = new D();
        Object ref6 = new C();

        ref1.m1();
        ref2.m1();
        ref4.m1();
        ref5.m1();
        // ref6.m1(); non compila
        ref1.m2();
        ref2.m2();
        ref3.m2();
        ref4.m2();
        // ref6.m2(); non compila
        ref3.m3();
        // ref5.m3(); non compila
        ((B)ref1).m3();
        // ((D)ref4).m3(); Class Cast Exception
        ((D)ref5).m3();
        // ((B)ref2).m3(); Class Cast Exception
        ((C)ref2).m2();
        // ((D)ref6).m2(); Class Cast Exception

    }

}
