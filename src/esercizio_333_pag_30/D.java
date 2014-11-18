package esercizio_333_pag_30;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio per vedere come vengono chiamati e quando i costruttori
 */

class Z{
    int z;
    Z(int i){
        z = i;
        System.out.println("Z: " + i);
    }
}

class C{
    Z i = new Z(2), j = new Z(3);
    C(){ i = new Z(4); }
}
public class D extends C{
    Z x = new Z(5), y = new Z(6);
    D(){
        super();
        x = new Z(7);
    }
    public static void main(String[] args){
        D d = new D();
        System.out.println("\n" + d.i.z + " " + d.j.z + " " + d.x.z + " " + d.y.z);
    }
}
