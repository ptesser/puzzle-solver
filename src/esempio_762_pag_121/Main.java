package esempio_762_pag_121;

/**
 * @author Tesser Paolo
 * @version 0.1
 */


class T extends Thread{
    Object lock;
    T(Object l){
        this.lock = l;
    }
    public void run(){
        synchronized (lock){
            System.out.println("pippo");
            System.out.println("pluto");
        }
    }

}

public class Main {
    public static void main( String[] argv){
        Object lock = new Object();
        T t1 = new T(lock);
        T t2 = new T(lock);
        t1.start();
        t2.start();
        /* viene stampato in maniera atomica: pippo pluto / pippo pluto */

    }


}
