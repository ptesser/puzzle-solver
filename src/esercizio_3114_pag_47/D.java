package esercizio_3114_pag_47;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio di modellazione seguendo le istruzioni a pag. 47 del libro
 */

class C{
    private static int s = 5;
    private int x;

    public C(int val){
        x = val;
    }
    public static int getS(){ return s; }
    public int getX(){ return x; }
}
public class D extends C{
    private int y;
    public D(int valX){
        super(valX);
        y = getS();
    }
    public int getY(){ return y; }

    public static int m(C ref){
        if (ref instanceof D){ // entra solo se ref ha tipo dinamico che è sottotipo di D
            return (((D) ref).getY() + ref.getX()); // devo fare un cast perchè il metodo getY non è presente staticamente in C
        }else{
            return getS();
        }
    }
    public static void main( String[] argv ){
        C prova1 = new C(4);
        D prova2 = new D(3);
        System.out.println(m(prova1));
        System.out.println(m(prova2));

    }
}
