package esercizio_10_0_14_pag_209;

/**
 * @author Tesser Paolo
 * @version 0.1
 */


class ObjCond{
    private static int NUMTHREAD;
    private int attesa = 0;

    ObjCond(int a){
        this.NUMTHREAD = a;
    }

    public synchronized int getAttesa(){
        return this.attesa;
    }

    public synchronized void setAttesa(){
        this.attesa++;
    }

    public synchronized int getNUMTHREAD(){
        return this.NUMTHREAD;
    }
}


class C1 extends Thread{

    private ObjCond obj;

    C1(ObjCond o){
        this.obj = o;
    }

    public void stampa(String s){
        for (int i = 0; i < 50; ++i){
            System.out.println(s);
        }
    }

    public void run(){
        this.stampa("A");

        synchronized (obj){
            obj.setAttesa();
            obj.notifyAll();

            System.out.println("INIZIO SYNC DA C1");
            try {
                while (obj.getAttesa() != obj.getNUMTHREAD()){
                    obj.wait();
                }
            }catch(InterruptedException e){}
            System.out.println("FINE SYNC DA C1");
        }
        this.stampa("B");
    }

}

class C2 extends Thread {

    private ObjCond obj;

    C2(ObjCond o){
        this.obj = o;
    }

    public void stampa(String s) {
        for (int i = 0; i < 50; ++i){
            System.out.println(s);
        }
    }


    public void run() {
        try {
            this.sleep(3000); // inserito per controllare se il blocco di SYNC su C1 funzionasse
        }catch (InterruptedException e){}

        this.stampa("C");

        synchronized (obj){
            obj.setAttesa();
            obj.notifyAll();
            System.out.println("INIZIO SYNC DA C2");
            try {
                while (obj.getAttesa() != obj.getNUMTHREAD()){
                    obj.wait();
                }
            }catch(InterruptedException e){}
            System.out.println("FINE SYNC DA C2");
        }
        try {
            this.sleep(3000); // inserito per controllare se riusciva a partire prima C1 dopo il SYNC
        }catch (InterruptedException e){}
        this.stampa("D");
    }
}


public class Main {
    public static void main(String[] argv){
        ObjCond obj = new ObjCond(2);
        C1 c1 = new C1(obj);
        C2 c2 = new C2(obj);

        c1.start();
        c2.start();

    }

}
