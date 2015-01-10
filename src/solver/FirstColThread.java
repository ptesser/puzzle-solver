package solver;

import logger.Logger;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class FirstColThread extends Thread {
    private int start;
    private int stop;
    private String type;

    /**
     *
     * @param start posizione dove iniziare a comporre la prima colonna
     * @param stop posizione dove finire di comporre la prima colonna
     * @param t comporre la colonna dall'alto (down) o dal basso (up)
     */
    public FirstColThread(int start, int stop, String t){
        this.start = start;
        this.stop = stop;
        this.type = t;
    }

    public void run(){
        Logger.logger.info("Pos start: " + this.start + ". Pos stop: " + this.stop + ". Type: " + this.type);

        if (this.type == "down"){

        }

        if (this.type == "up"){

        }
    }

}
