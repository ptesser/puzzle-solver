package esercizio_3113_pag_47;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio di esercitazione su cosa stampa, overriding
 */


class C{
    protected static String s = "2";
    public C(){ this(2); }
    public C(int n){
        s = s + n;
        System.out.println(s.length());
    }
    public int m(C ref){
        if (ref instanceof  D){return 2;}
        else {return 1;}
    }
}

class D extends C{
    public int m(C ref){ // overriding of m in C
        if (ref instanceof C){
            return super.m(ref);
        }else{
            return 4;
        }
    }
}

public class E extends  D{
    public E(){
        Integer i = new Integer(s);
        System.out.println(i.intValue());
    }
    public int m(D ref){return 5;}
    public static void main( String[] args ){
        C r = new C(5);
        C s = new D();
        D t = new E();
        E u = new E();
        System.out.println(r.m(t) + " " + s.m(r) + " " + t.m(s) + " " + u.m(t));
        // 2 1 2 5
    }

}
