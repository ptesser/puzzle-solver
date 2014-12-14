package esempio_761_pag_120;

/**
 * @author Tesser Paolo
 * @version 0.1
 * Esercizio che stampa solo il valore 0 in quanto l'accesso all'oggetto condiviso da parte dei due thread è mutuamente esclusivo
 */

class C{
    private int i = 0;
    public synchronized void m(){
        for(int k = 0; k < 10000; k++) i++;
        for(int k = 0; k < 10000; k++) i--;
    }
    public synchronized int getI(){
        return this.i;
    }
}

public class T extends Thread{
    private int num;
    private C c;
    public T(int x, C y){
        this.num = x;
        this.c = y;
    }

    public void run(){
        for (int i=0; i<10; i++){
            c.m();
            System.out.println("Thread num " + num + ": c.i= " + c.getI());
        }
    }

    public static void main( String[] args ){
        C c = new C();
        T t1 = new T(1,c);
        T t2 = new T(2,c);
        t1.start();
        t2.start();
    }


}
