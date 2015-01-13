package solver;

import logger.Logger;
import puzzle.PuzzleCharacter;
import puzzle.Tile;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class RowThread extends BasicThread {
    private int numThread;
    private final int totalRowThread;

    /**
     *
     * @param start il numero della prima riga da comporre
     * @param stop il numero dell'ultima riga da comporre
     * @param p il Puzzle generale
     * @param s l'oggetto condiviso con gli altri thread per scambiarsi informazioni
     */
    public RowThread(int num, int start, int stop, PuzzleCharacter p, SearchStatus s, int t){
        super(start,stop,p,s);
        this.numThread = num;
        this.totalRowThread = t;
    }

    public void run(){
        /* VERSIONE SENZA L'USO DEI THREAD POOL

        for (int j = this.getStart(); j <= this.getStop(); j++){
            for (int z = 0; z < (this.getPuzzleSolve().getNumCol()-1); z++){
                Tile nowTile = this.getPuzzleSolve().getPuzzleElementSolved()[j][z];
                String idTileEast = nowTile.getIdEast();
                Tile newTileEast = this.getPuzzleSolve().getPuzzleElementToSolve().get(idTileEast);
                this.getPuzzleSolve().setPuzzleElementSolved(j,z+1,newTileEast);
            }
        }
        */

        for (int z = 0; z < (this.getPuzzleSolve().getNumCol()-1); z++){
            Tile nowTile = this.getPuzzleSolve().getPuzzleElementSolved()[this.getStart()][z];
            String idTileEast = nowTile.getIdEast();
            Tile newTileEast = this.getPuzzleSolve().getPuzzleElementToSolve().get(idTileEast);
            this.getPuzzleSolve().setPuzzleElementSolved(this.getStart(),z+1,newTileEast);
        }

        synchronized (this.getSharedStatus()){
            int count = this.getSharedStatus().getCountRowThread();
            this.getSharedStatus().setCountRowThread(++count);
            if (this.getSharedStatus().getCountRowThread() == this.totalRowThread)
                this.getSharedStatus().notifyAll();
            Logger.logger.info("Count Thread:" + this.getSharedStatus().getCountRowThread());

           // Logger.logger.info("Thread " + this.numThread + " completato. Ci sono ancora " + (this.totalRowThread-this.getSharedStatus().getCountRowThread()) + " threads in esecuzione.");
        }


    }
}
