package esempio_752_pag_115;

/**
 * @author Tesser Paolo
 * @version 0.1
 * Esercizio sui thread demoni
 */

class Daemon extends Thread{
    public int i = 0;
    public Daemon(){
        setDaemon( true );
    }
    public void run(){
        while (true){
            ++i;
            if(i > 100000 ) i = 0;
        }
    }
}

public class D extends Thread{
    Daemon dm = new Daemon();
    private int j = 0;
    public void run(){
        dm.start();
        while (j<100){
            ++j;
            System.out.println(dm.i + " ");
        }
    }

    public static void main (String[] args){
        D d = new D();
        d.start();
    }
}
