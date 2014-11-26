package esempio_722_pag_109;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class ThreadTest extends Thread{

    public ThreadTest(String x){
        super(x); // assegna un nome al Thread
    }

    public void run() {
        for (int k = 0; k <= 5; ++k) {
            System.out.println("Thread " + getName() + "\tWhile " + k);
        }
    }

    public static void main( String[] args ){
        new ThreadTest("Antonio").start();
        new ThreadTest(" Berto").start();
        new ThreadTest("  Carlo").start();
        new ThreadTest("   Diego").start();
    }

}
