package solver;

import logger.Logger;
import puzzle.PuzzleCharacter;
import puzzle.Tile;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class FirstColThread extends BasicThread {

    private String type;

    /**
     *
     * @param start posizione dove iniziare a comporre la prima colonna
     * @param stop posizione dove finire di comporre la prima colonna
     * @param t comporre la colonna dall'alto (down) o dal basso (up)
     * @param p il Puzzle generale
     * @param s l'oggetto condiviso con gli altri thread per scambiarsi informazioni
     */
    public FirstColThread(int start, int stop, String t, PuzzleCharacter p, SearchStatus s){
        super(start,stop,p,s);
        this.type = t;
    }

    public void run(){
        Logger.logger.info("Pos start: " + this.getStart() + ". Pos stop: " + this.getStop() + ". Type: " + this.type);

        if (this.type.equals("down")){
            for (int i = this.getStart(); i < this.getStop(); i++){
                Tile nowTile = this.getPuzzleSolve().getPuzzleElementSolved()[i][0]; // prelevo il pezzo corrente
                String idTileSud = nowTile.getIdSouth(); // mi ricavo il suo id sud
                Tile newTileSud = this.getPuzzleSolve().getPuzzleElementToSolve().get(idTileSud); // prelevo il pezzo a sud dell'id corrente
                this.getPuzzleSolve().setPuzzleElementSolved(i+1, 0, newTileSud); // salvo il pezzo a sud nella prossima posizione dell'array

                synchronized (this.getSharedStatus()){
                    this.getSharedStatus().setFindFirstToHalf(true);
                    this.getSharedStatus().notify();
                }
            }
        }

        if (this.type.equals("up")){
            for (int i = this.getStart(); i > this.getStop(); i--){
                Tile nowTile = this.getPuzzleSolve().getPuzzleElementSolved()[i][0]; // prelevo il pezzo corrente
                String idTileNorth = nowTile.getIdNorth(); // mi ricavo il suo id nord
                Tile newTileNorth = this.getPuzzleSolve().getPuzzleElementToSolve().get(idTileNorth); // prelevo il pezzo a nord dell'id corrente
                this.getPuzzleSolve().setPuzzleElementSolved(i-1, 0, newTileNorth); // salvo il pezzo a sud nella prossima posizione dell'array

                synchronized (this.getSharedStatus()){
                    this.getSharedStatus().setFindLastToHalf(true);
                    this.getSharedStatus().notify();
                }
            }
        }
    }

}
