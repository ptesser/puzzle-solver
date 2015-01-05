package buffer_limitato;


/**
 * @author Tesser Paolo
 * @version 0.1
 */


class BoundedBuffer{
    final Object[] items = new Object[100];
    int count, putptr, takeptr;

    public synchronized void put(Object o) throws InterruptedException{
        while (count == items.length){
            System.out.println("Attendo: buffer PIENO!");
            wait();
        }
        items[putptr] = o;
        putptr++;
        if (putptr == items.length) putptr = 0;
        count++;
        notify();
    }

    public synchronized Object take() throws InterruptedException{
        while (count == 0){
            System.out.println("Attendo: buffer VUOTO!");
            wait();
        }
        Object o = items[takeptr];
        takeptr++;
        if (takeptr == items.length) takeptr = 0;
        count--;
        notify();
        return o;
    }
}

class Produttore extends Thread{
    BoundedBuffer b;

    Produttore(BoundedBuffer b){
        this.b = b;
    }
    public void run(){
        int i = 0;
        while (i < 200){
            synchronized (b){
                b.put("Pippo");
                System.out.println("messo numero " + i);
                i++;
            }

        }
    }
}

class Consumatore extends Thread{
    BoundedBuffer b;

    Consumatore(BoundedBuffer b){
        this.b = b;
    }
    public void run(){
        int i = 0;
        while (i < 200){
            synchronized (b){
                System.out.println("preso numero " + b.take() + " numero " + i);
                i++;
            }

        }
    }
}


public class Buffer {
    public static void main(String[] argv){
        BoundedBuffer buff = new BoundedBuffer();
        Produttore prod = new Produttore(buff);
        Consumatore cons = new Consumatore(buff);
        prod.start();
        cons.start();
    }

}
