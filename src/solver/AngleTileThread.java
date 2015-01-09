package solver;

import logger.Logger;
import puzzle.PuzzleCharacter;
import puzzle.Tile;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class AngleTileThread extends Thread{
    private int numThread;
    private int start;
    private int stop;
    private Tile[] arrayToSolve;
    private PuzzleCharacter puzzleSolve;
    public final SearchStatus sharedStatus;

    public AngleTileThread(int numThread, int start, int stop, Tile[] arrayToSolve, PuzzleCharacter p, SearchStatus s){
        this.numThread = numThread;
        this.start = start;
        this.stop = stop;
        this.arrayToSolve = arrayToSolve;
        this.puzzleSolve = p;
        this.sharedStatus = s;

    }

    public void run(){
        boolean findFirstTile = false;
        boolean findLastTile = false;

        Logger.logger.info("Pos di partenza del thread " + this.numThread + " : " + this.start);
        Logger.logger.info("Pos di arrivo del thread " + this.numThread + " : " + this.stop);

        for (int i = this.start; i <= this.stop; ++i ){
            Tile currTile = arrayToSolve[i];
            String idNorth = currTile.getIdNorth();
            String idWest = currTile.getIdWest();
            String idSouth = currTile.getIdSouth();
            // Logger.logger.info("Tile. North: " + idNorth + " - West: " + idWest + " - South: " + idSouth);

            if (idNorth.equals("VUOTO") && idWest.equals("VUOTO")){
                findFirstTile = true;
                puzzleSolve.setPuzzleElementSolved(0, 0, currTile);
            }
            if (idSouth.equals("VUOTO") && idWest.equals("VUOTO")){
                findLastTile = true;
                puzzleSolve.setPuzzleElementSolved(puzzleSolve.getNumRow()-1, 0, currTile);
            }

        }

        if (findFirstTile){
            synchronized (this.sharedStatus) {
                Logger.logger.info("Tile in alto a sinistra trovato nel thread: " + this.numThread);
                sharedStatus.setFindFirstColFirstTile(true);
                sharedStatus.notify();
            }
        }
        if (findLastTile){
            synchronized (this.sharedStatus) {
                Logger.logger.info("Tile in basso a sinistra trovato nel thread: " + this.numThread);
                sharedStatus.setFindFirstColLastTile(true);
                sharedStatus.notify();
            }
        }

        Logger.logger.info("Thread " + this.numThread + " completato.");
    }


}
