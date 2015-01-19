package solver;

import puzzle.PuzzleCharacter;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public abstract class BasicThread implements Runnable{
    private int start;
    private int stop;
    private PuzzleCharacter puzzleSolve;
    private final SearchStatus sharedStatus;

    /**
     *
     * @param start la posizione di partenza per eseguire la composizione/ricerca
     * @param stop la posizione di fine della composizione/ricerca
     * @param p il Puzzle generale
     * @param s l'oggetto condiviso con gli altri thread per scambiarsi informazioni
     */
    public BasicThread(int start, int stop, PuzzleCharacter p, SearchStatus s){
        this.start = start;
        this.stop = stop;
        this.puzzleSolve = p;
        this.sharedStatus = s;
    }

    /**
     *
     * @return la posizione di partenza per eseguire la composizione/ricerca
     */
    public final int getStart(){
        return this.start;
    }

    /**
     *
     * @return la posizione di fine della composizione/ricerca
     */
    public final int getStop(){
        return this.stop;
    }

    /**
     *
     * @return l'oggetto condiviso da i thread per scambiarsi
     */
    public final SearchStatus getSharedStatus(){
        return this.sharedStatus;
    }

    /**
     *
     * @return l'oggetto PuzzleCharachter da risolvere
     */
    public final PuzzleCharacter getPuzzleSolve(){
        return this.puzzleSolve;
    }


}
