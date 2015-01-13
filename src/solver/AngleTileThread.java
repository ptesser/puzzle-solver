package solver;

import logger.Logger;
import puzzle.PuzzleCharacter;
import puzzle.Tile;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class AngleTileThread extends BasicThread{

    private int numThread;
    private Tile[] arrayToSolve;

    /**
     *
     * @param numThread il numero del thread avviato
     * @param start la posizione dalla quale iniziare la ricerca dei pezzi richiesti
     * @param stop la posizione nella quale terminare la ricerca dei pezzi richiesti
     * @param arrayToSolve l'hashmap vista in forma di array mono dimensionale, da scorrere per trovare i pezzi richiesti
     * @param p il Puzzle generale
     * @param s l'oggetto condiviso con gli altri thread per scambiarsi informazioni
     */
    public AngleTileThread(int numThread, int start, int stop, Tile[] arrayToSolve, PuzzleCharacter p, SearchStatus s){
        super(start, stop, p, s);
        this.numThread = numThread;
        this.arrayToSolve = arrayToSolve;
    }

    public void run(){

        boolean findFirstTile = false;
        boolean findLastTile = false;
        boolean exitFor = false;

        /* Controllo nell'oggetto condiviso se qualche altro task non ha già trovato i pezzi che sto cercando*/
        synchronized (this.getSharedStatus()){
            if (this.getSharedStatus().isFindFirstColFirstTile() && this.getSharedStatus().isFindFirstColLastTile()){
                exitFor = true;
            }
        }

        /* Cerco il pezzo in alto a sinistra o in basso a sinistra nella porzione di array indicata da start e da stop */
        for (int i = this.getStart(); i < this.getStop() && !exitFor; ++i ){
            /* Mi ricavo i vari id che mi servono dal pezzo corrente */
            Tile currTile = arrayToSolve[i];
            String idNorth = currTile.getIdNorth();
            String idWest = currTile.getIdWest();
            String idSouth = currTile.getIdSouth();

            /* controllo se il pezzo corrente è il primo in alto a sinistra */
            if (idNorth.equals("VUOTO") && idWest.equals("VUOTO")){
                findFirstTile = true;
                this.getPuzzleSolve().setPuzzleElementSolved(0, 0, currTile);
            }
            /* Controllo se il pezzo corrente è il primo in basso a sinistra */
            if (idSouth.equals("VUOTO") && idWest.equals("VUOTO")){
                findLastTile = true;
                this.getPuzzleSolve().setPuzzleElementSolved(this.getPuzzleSolve().getNumRow()-1, 0, currTile);
            }
            /* Controllo nell'oggetto condiviso se nel frattempo qualche altro task non ha già trovato i pezzi che sto cercando */
            synchronized (this.getSharedStatus()){
                if (this.getSharedStatus().isFindFirstColFirstTile() && this.getSharedStatus().isFindFirstColLastTile()){
                    exitFor = true;
                }
            }

        }
        /* Se è il primo in alto a sinista, segno che l'ho trovato e avvio il thread per comporre la prima metà della prima colonna partendo dall'alto */
        if (findFirstTile){
            synchronized (this.getSharedStatus()) {
                Logger.logger.info("Pezzo in alto a sinistra trovato nel thread: " + this.numThread);
                this.getSharedStatus().setFindFirstColFirstTile(true);
                FirstColThread FirstToHalfTask = new FirstColThread(0, (this.getPuzzleSolve().getNumRow()/2), "down", this.getPuzzleSolve(), this.getSharedStatus());
                Thread t = new Thread(FirstToHalfTask);
                t.start();
            }
        }
        /* Se è il primo in basso a sinista, segno che l'ho trovato e avvio il thread per comporre la seconda metà della prima colonna partendo dal basso */
        if (findLastTile){
            synchronized (this.getSharedStatus()) {
                Logger.logger.info("Pezzo in basso a sinistra trovato nel thread: " + this.numThread);
                this.getSharedStatus().setFindFirstColLastTile(true);
                FirstColThread LastToHalfTask = new FirstColThread(this.getPuzzleSolve().getNumRow() -1, this.getPuzzleSolve().getNumRow()/2+1, "up", this.getPuzzleSolve(), this.getSharedStatus());
                Thread t = new Thread(LastToHalfTask);
                t.start();
            }
        }

        Logger.logger.info("Thread di ricerca degli angoli numero: " + this.numThread + " completato.");
    }


}
