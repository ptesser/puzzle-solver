package objrem;

import puzzle.Puzzle;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public class SolveThread extends Thread{
    private Puzzle p;

    /**
     *
     * @param p puzzle da risolvere
     */
    public SolveThread(Puzzle p){
        this.p = p;
    }

    public void run(){
        p.solvePuzzle();
    }

}
