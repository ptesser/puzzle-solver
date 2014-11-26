package esercizio_723_pag_109;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public class SimpleThread extends Thread{

    private static int threadCount = 0;
    private int threadNumber = ++threadCount;
    private int countDown = 4;

    public SimpleThread(){
        System.out.println("Costruzione del thread " + threadNumber);
    }

    public void run(){
        while (countDown > 0){
            System.out.println("Thread " + threadNumber + " (" + countDown + ")");
            countDown--;
            if (countDown == 0){
                System.out.println("Thread " + threadNumber + " HA FINITO");
            }
        }
    }

    public static void main( String[] args ){
        for (int i = 0; i<5; ++i){
            new SimpleThread().start();
        }
        System.out.println("Tutti i thread sono vivi!");
    }

}
