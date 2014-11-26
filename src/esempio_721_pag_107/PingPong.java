package esempio_721_pag_107;

/**
 * @author  Paolo Tesser
 * @version  0.1
 *
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
