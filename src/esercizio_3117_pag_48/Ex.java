package esercizio_3117_pag_48;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * Esercizio di esercitazione su cosa stampa, Object[] e scambi
 */

public class Ex {
    private Object[] a = new Object[3];
    public void insert( Object ref, int i ){a[i] = ref;}
    public void F(){
        Object t = a[0];
        a[0] = a[2];
        a[2] = t;
    }
    public void G(){
        Object[] t = a;
        t[0] = new String("pluto");
    }
    public void print(){
        for (int i = 0; i < 3; ++i){
            System.out.print(a[i] + " ");
        }
    }
    public static void main( String[] args ){
        Ex e = new Ex();
        e.insert(new Integer(3),2);
        e.insert(new String("pippo"),0);
        e.print();
        System.out.println(" **1");
        e.F();
        e.print();
        System.out.println(" **2");
        Ex f = e;
        f.insert(new Boolean(true),1);
        f.F();
        f.print();
        System.out.println(" **3");
        e.print();
        System.out.println(" **4");
        e.G();
        e.print();
        System.out.println(" **5");
    }
}
