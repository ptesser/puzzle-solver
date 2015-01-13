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
public class SolverParStrategy implements  SolverStrategy{
    private final SearchStatus sharedStatus;
    private static final int NTHR = 4;
    private static final ExecutorService EXEC = Executors.newFixedThreadPool(NTHR);

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

                Logger.logger.info("Inizio risoluzione");

                PuzzleCharacter p = (PuzzleCharacter) o;

                // trovo la dimensione dell'array
                int dimTileArray = ((PuzzleCharacter) o).getPuzzleElementToSolve().size();
                Logger.logger.info("Dim Tile Array: " + dimTileArray + ". Num col: " + p.getNumCol() + ". Num row: " + p.getNumRow());

                // mi creo l'array di Tile dalla HashMap
                Tile[] tileArray = new Tile[dimTileArray];
                tileArray = p.getPuzzleElementToSolve().values().toArray(tileArray);

                int numThread = 3; // decido quanti thread voglio lanciare per la ricerca del primo in alto a sinistra e dell'ultimo in basso a sinistra
                int numLastItem = dimTileArray % numThread; // se la divisione non è esatta mi calcolo i rimanente e gli inserisco nell'ultimo thread
                int numItemThread = dimTileArray / numThread;
                int[] posStartThread = new int[numThread];

                for (int i = 0; i < numThread; ++i){
                    posStartThread[i] = numItemThread * i;
                }


                for (int i = 0; i < numThread; ++i){
                    if (i == numThread-1){
                        AngleTileThread task = new AngleTileThread(i, posStartThread[i], (posStartThread[i] + numItemThread)+numLastItem-1, tileArray, p, sharedStatus);
                        Thread t = new Thread(task);
                        t.start();
                    }else{
                        AngleTileThread task = new AngleTileThread(i, posStartThread[i], (posStartThread[i] + numItemThread)-1, tileArray, p, sharedStatus);
                        Thread t = new Thread(task);
                        t.start();
                    }
                }

                synchronized (sharedStatus){
                    while (!sharedStatus.isFindFirstToHalf() || !sharedStatus.isFindLastToHalf()){
                        try {
                            sharedStatus.wait();
                        }catch (InterruptedException e){
                            Logger.logger.info("InterruptedException caused by a wait() method: " + e.getMessage());
                        }
                    }
                }


                /* scorro un tot di righe su ogni thread in base al numero che decido */

                /* VERSIONE SENZA L'USO DEI THREAD POOL

                int numThreadRows = 4;
                int numLastRows = p.getNumRow() % numThreadRows; // se la divisione non è esatta mi calcolo i rimanente e gli inserisco nell'ultimo thread
                int numRowForThread = p.getNumRow() / numThreadRows;
                int[] rowStartThread = new int[numThreadRows];
                Logger.logger.info("Il numero di righe per thread è: " + numRowForThread + ". Le righe finali sono: " + numLastRows);

                for (int i = 0; i < numThreadRows; ++i){
                    rowStartThread[i] = numRowForThread * i;
                }

                for (int i = 0; i < numThreadRows; ++i){
                    if (i == numThreadRows-1){ // TO CHANGE VALUE IN CONSTRUCTOR
                        RowThread task = new RowThread(i, rowStartThread[i], (rowStartThread[i] + numRowForThread)+numLastRows-1, p, sharedStatus, numThreadRows);
                        Thread t = new Thread(task);
                        t.start();
                    }else{
                        RowThread task = new RowThread(i, rowStartThread[i], rowStartThread[i+1]-1, p, sharedStatus, numThreadRows);
                        Thread t = new Thread(task);
                        t.start();
                    }
                }
                */

                for (int i = 0; i < p.getNumRow(); ++i){
                    RowThread task = new RowThread(i, i, 0, p, sharedStatus, p.getNumRow());
                    EXEC.execute(task);
                }

                synchronized (sharedStatus){
                    while (sharedStatus.getCountRowThread() != p.getNumRow()){
                        try {
                            sharedStatus.wait();
                        }catch (InterruptedException e){
                            Logger.logger.info("InterruptedException caused by a wait() method: " + e.getMessage());
                        }
                    }
                }
                EXEC.shutdown();
                Logger.logger.info("Risoluzione completata");

            }
        }catch (ArrayStoreException e){
            Logger.logger.info("ArrayStoreException. " + e.getMessage());
        }
    }
}
