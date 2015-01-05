package esempio_763_pag_122;

/**
 * @author Tesser Paolo
 * @version 0.1
 */


class C {
    private int i = 0;
    public Object a;
    public C(Object a){
        this.a = a;
    }
    public void m(){
        synchronized (this.a){
            for(int k = 0; k < 100000; k++) i++;
            for(int k = 0; k < 100000; k++) i--;
        }
    }
    public void print(){
        System.out.println(i + " ");
    }
}

class T extends Thread{
    private C c;
    public T(C c){
        this.c = c;
    }
    public void run(){
        for(int i = 0; i < 5; i++){
            c.m();
            synchronized (c.a){
                c.print();
            }
        }
    }
}


public class D {
    public static void main( String[] argv){
        Integer i1 = new Integer(10000);
        Integer i2 = i1;
        C x = new C(i1);
        T t1 = new T(x);
        C y = new C(i2);
        T t2 = new T(y);
        t1.start();
        t2.start();
        /* viene stampata una sequenza di 10 zeri in maniera consecutiva */
    }

}
