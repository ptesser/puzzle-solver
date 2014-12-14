package esempio_751_pag_113;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

class T extends Thread{
    private int num;
    private boolean runFlag = false;

    public boolean isRunning(){
        return this.runFlag;
    }
    public T(int x){
        this.num = x;
    }

    public void run(){
        this.runFlag = true;
        for (int i=0; i < 10000; i++){
            System.out.println("Thread num " + this.num + " terminato");
        }
    }

}


public class C {
    public static void main( String[] args ){
        T t1 = new T(1);
        T t2 = new T(2);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        try{
            t1.join();
        }
        catch(InterruptedException e){}

        t2.start();

    }
}
