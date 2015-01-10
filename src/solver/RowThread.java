package solver;

import puzzle.PuzzleCharacter;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class RowThread extends BasicThread {

    /**
     *
     * @param start il numero della prima riga da comporre
     * @param stop il numero dell'ultima riga da comporre
     * @param p il Puzzle generale
     * @param s l'oggetto condiviso con gli altri thread per scambiarsi informazioni
     */
    public RowThread(int start, int stop, PuzzleCharacter p, SearchStatus s){
        super(start,stop,p,s);
    }

    public void run(){


    }
}
