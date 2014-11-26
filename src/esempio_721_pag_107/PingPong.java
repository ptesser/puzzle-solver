package esempio_721_pag_107;

/**
 * @author  Paolo Tesser
 * @version  0.1
 * <p>Versione tramite l'implementazione di Runnable</p>
 */

public class PingPong extends Thread {

    private String word;
    private int delay;

    public PingPong(String s, int d){
        this.word = s;
        this.delay = d;
    }

    public void run(){
        try{
            for(int i = 0; i < 100 ; ++i){
                System.out.println(word + " ");
                Thread.sleep(delay); // dove può causarsi l'eccezione
            }
        }catch(InterruptedException e){
            // return;
        }

    }

    public static void main( String[] args ){
        Thread t1 = new PingPong("ping",15);
        t1.start();
        Thread t2 = new PingPong("PONG",33);
        t2.start();
    }
}


/**
 * @author  Paolo Tesser
 * @version  0.1
 * <p>Versione tramite l'implementazione di Runnable</p>
 */


/*

public class PingPong implements Runnable {

    private String word;
    private int delay;

    public PingPong(String s, int d){
        this.word = s;
        this.delay = d;
    }

    public void run(){
        try{
            for(int i = 0; i < 100 ; ++i){
                System.out.println(word + " ");
                Thread.sleep(delay); // dove può causarsi l'eccezione
            }
        }catch(InterruptedException e){
            // return;
        }

    }

    public static void main( String[] args ){
        Runnable ping = new PingPong("ping",15);
        Runnable pong = new PingPong("PONG",33);
        Thread t1 = new Thread(ping);
        t1.start();
        Thread t2 = new Thread(pong);
        t2.start();
    }
}




 */