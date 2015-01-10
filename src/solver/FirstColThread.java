package solver;

import logger.Logger;
import puzzle.PuzzleCharacter;
import puzzle.Tile;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class FirstColThread extends Thread {
    private int start;
    private int stop;
    private PuzzleCharacter puzzleSolve;
    private String type;
    public final SearchStatus sharedStatus;

    /**
     *
     * @param start posizione dove iniziare a comporre la prima colonna
     * @param stop posizione dove finire di comporre la prima colonna
     * @param t comporre la colonna dall'alto (down) o dal basso (up)
     * @param p il Puzzle generale
     * @param s l'oggetto condiviso con gli altri thread per scambiarsi informazioni
     */
    public FirstColThread(int start, int stop, String t, PuzzleCharacter p, SearchStatus s){
        this.start = start;
        this.stop = stop;
        this.type = t;
        this.puzzleSolve = p;
        this.sharedStatus = s;
    }

    public void run(){
        Logger.logger.info("Pos start: " + this.start + ". Pos stop: " + this.stop + ". Type: " + this.type);

        if (this.type.equals("down")){
            for (int i = this.start; i < this.stop; i++){
                Tile nowTile = puzzleSolve.getPuzzleElementSolved()[i][0]; // prelevo il pezzo corrente
                String idTileSud = nowTile.getIdSouth(); // mi ricavo il suo id sud
                Tile newTileSud = puzzleSolve.getPuzzleElementToSolve().get(idTileSud); // prelevo il pezzo a sud dell'id corrente
                puzzleSolve.setPuzzleElementSolved(i+1, 0, newTileSud); // salvo il pezzo a sud nella prossima posizione dell'array

                synchronized (sharedStatus){
                    sharedStatus.setFindFirstToHalf(true);
                    sharedStatus.notify();
                }
            }
        }

        if (this.type.equals("up")){
            for (int i = this.start; i > this.stop; i--){
                Tile nowTile = puzzleSolve.getPuzzleElementSolved()[i][0]; // prelevo il pezzo corrente
                String idTileNorth = nowTile.getIdNorth(); // mi ricavo il suo id nord
                Tile newTileNorth = puzzleSolve.getPuzzleElementToSolve().get(idTileNorth); // prelevo il pezzo a nord dell'id corrente
                puzzleSolve.setPuzzleElementSolved(i-1, 0, newTileNorth); // salvo il pezzo a sud nella prossima posizione dell'array

                synchronized (sharedStatus){
                    sharedStatus.setFindLastToHalf(true);
                    sharedStatus.notify();
                }
            }
        }
    }

}
