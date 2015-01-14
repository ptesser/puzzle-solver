package solver;

import puzzle.*;
import puzzle.Puzzle;
import puzzle.PuzzleCharacter;
import logger.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class SolverParStrategy implements SolverStrategy{

    private final SearchStatus sharedStatus;
    private  int NTHR_ROWS;
    private int NTHR_ANGLE;
    private ExecutorService EXEC_ROWS;

    public SolverParStrategy(){
        this.sharedStatus = new SearchStatus(); // creazione dell'oggetto condiviso tra i Thread
    }

    /**
     *
     * @param o puzzle da risolvere
     */
    @Override
    public void executeSolve(Puzzle o) {
        try {
            if (o instanceof PuzzleCharacter) {

                PuzzleCharacter p = (PuzzleCharacter) o;
                int numColPuzzle = p.getNumCol();
                int numRowPuzzle = p.getNumRow();
                int dimTileArray = p.getPuzzleElementToSolve().size();

                if (numColPuzzle >= 90){
                    this.setNTHR_ROWS(6);
                }else if (numColPuzzle >= 30){
                    this.setNTHR_ROWS(3);
                }else {
                    this.setNTHR_ROWS(2);
                }
                this.EXEC_ROWS = Executors.newFixedThreadPool(this.getNTHR_ROWS());

                if (dimTileArray >=  100){
                    this.setNTHR_ANGLE(5);
                }else if(dimTileArray >= 30){
                    this.setNTHR_ANGLE(3);
                }else{
                    this.setNTHR_ANGLE(2);
                }

                /* Se la divisione non è esatta mi calcolo i rimanente e gli inserisco nell'ultimo task */
                int numLastTiles = dimTileArray % this.getNTHR_ANGLE();
                int numTileForThread = dimTileArray / this.getNTHR_ANGLE();
                int[] posStartThread = new int[this.getNTHR_ANGLE()];

                Logger.logger.info("Dim Tile Array: " + dimTileArray + ". Num col: " + numColPuzzle + ". Num row: " + numRowPuzzle);

                /* Mi creo l'array di Tile dalla HashMap */
                Tile[] tileArray = new Tile[dimTileArray];
                tileArray = p.getPuzzleElementToSolve().values().toArray(tileArray);


                Logger.logger.info("Inizio risoluzione");

                for (int i = 0; i < this.getNTHR_ANGLE(); ++i){
                    posStartThread[i] = numTileForThread * i;
                }

                for (int i = 0; i < this.getNTHR_ANGLE(); ++i){
                    if (i == this.getNTHR_ANGLE()-1){
                        AngleTileThread task = new AngleTileThread(i, posStartThread[i], (posStartThread[i] + numTileForThread)+numLastTiles-1, tileArray, p, sharedStatus);
                        Thread t = new Thread(task);
                        t.start();
                    }else{
                        AngleTileThread task = new AngleTileThread(i, posStartThread[i], (posStartThread[i] + numTileForThread)-1, tileArray, p, sharedStatus);
                        Thread t = new Thread(task);
                        t.start();
                    }
                }

                /* Prendo il lock sull'oggetto condiviso */
                synchronized (sharedStatus){
                    /* Controllo la condizione dell'oggetto condiviso che mi dice se la prima e la seconda metà della prima colonna è stata ordinata */
                    while (!sharedStatus.isFindFirstToHalf() || !sharedStatus.isFindLastToHalf()){
                        try {
                            sharedStatus.wait();
                        }catch (InterruptedException e){
                            Logger.logger.info("InterruptedException caused by a wait() method: " + e.getMessage());
                        }
                    }
                }

                /* Scorro un tot di righe su ogni thread in base al numero che decido */
                for (int i = 0; i < numRowPuzzle; ++i){
                    /* Eseguo la composizione delle righe solo se il numero di colonne è maggiore di 1, altrimenti vuol dire che le righe sono già tutte sistemate */
                    if (p.getNumCol() != 1) {
                        RowThread task = new RowThread(i, 0, p, sharedStatus, numRowPuzzle);
                        EXEC_ROWS.execute(task);
                    }
                }

                /* Prendo il lock sull'oggetto condiviso */
                synchronized (sharedStatus){
                    /* Controllo la condizione dell'oggetto condiviso che mi dice se i task lanciati per ordinare le righe sono stati tutti eseguiti */
                    while (sharedStatus.getCountRowThread() != p.getNumRow()){
                        try {
                            sharedStatus.wait();
                        }catch (InterruptedException e){
                            Logger.logger.info("InterruptedException caused by a wait() method: " + e.getMessage());
                        }
                    }
                }

                EXEC_ROWS.shutdown(); /* Chiudo il Thread Pool */

                Logger.logger.info("Risoluzione completata");

            }
        }catch (ArrayStoreException e){
            Logger.logger.info("ArrayStoreException. " + e.getMessage());
        }
    }

    /**
     *
     * @return il numero di thread pool che saranno attivati per eseguire l'ordinamento delle righe del puzzle
     */
    public final int getNTHR_ROWS(){
        return this.NTHR_ROWS;
    }

    /**
     *
     * @return il numero di thread pool che saranno attivati per eseguire la ricerca e ordinamento degli angoli agli estremi della prima colonna
     */
    public final int getNTHR_ANGLE(){
        return this.NTHR_ANGLE;
    }

    /**
     *
     * @param num il numero di thread pool da settare che saranno eseguiti per eseguire l'ordinamento delle righe del puzzle
     */
    public final void setNTHR_ROWS(int num){
        this.NTHR_ROWS = num;
    }

    /**
     *
     * @param num il numero di thread pool da settare che saranno eseguiti per eseguire la ricerca e ordinamento degli angoli agli estremi della prima colonna
     */
    public final void setNTHR_ANGLE(int num){
        this.NTHR_ANGLE = num;
    }


}
