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

    public AngleTileThread(int numThread, int start, int stop, Tile[] arrayToSolve, PuzzleCharacter p){
        this.numThread = numThread;
        this.start = start;
        this.stop = stop;
        this.arrayToSolve = arrayToSolve;
        this.puzzleSolve = p;

    }

    public void run(){
        boolean findTile = false;


        for (int i = this.start; i <= this.stop; ++i ){
            Tile currTile = arrayToSolve[i];
            String idNorth = currTile.getIdNorth();
            String idWest = currTile.getIdWest();

            if (idNorth.equals("VUOTO") && idWest.equals("VUOTO")){
                findTile = true;
                puzzleSolve.setPuzzleElementSolved(0, 0, currTile);
            }

        }

        if (findTile){
            Logger.logger.info("Tile in alto a sinistra trovato nel thread: .");
        }
        Logger.logger.info("Thread " + this.numThread + " completato.");
    }


}
