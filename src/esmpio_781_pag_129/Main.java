package esmpio_781_pag_129;

/**
 * @author Tesser Paolo
 * @version 0.1
 */


class T1 extends Thread{
    int i;
    T2 t2;

    T1(T2 t){
        this.t2 = t;
    }
    public void run(){
        while (i<10000){
            synchronized (t2){
                i++;
                if (i == 2000){
                    t2.sospendi = true;
                }
                if (i == 6000){
                    t2.sospendi = false;
                    t2.notify();
                }
            }
            try {
                Thread.sleep((int) (Math.random() * 80));
            }catch (InterruptedException e){}
        }
    }

}

class T2 extends Thread {
    boolean sospendi = false;

    public void run(){
        while (true) {
            synchronized (this) {
                while (sospendi) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {}
                }
                System.out.println("topolino");
            }
            try {
                Thread.sleep((int) (Math.random() * 80));
            }catch (InterruptedException e){}
        }
    }
}

public class Main {
    public static void main(String[] argv){
        T2 t2 = new T2();
        T1 t1 = new T1(t2);
        t1.start();
        t2.start();
    }
}
