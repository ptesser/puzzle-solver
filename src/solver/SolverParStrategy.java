package solver;

import puzzle.*;
import puzzle.Puzzle;
import puzzle.PuzzleCharacter;
import logger.Logger;


/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class SolverParStrategy implements  SolverStrategy{
    private final SearchStatus sharedStatus;

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
                        AngleTileThread t = new AngleTileThread(i, posStartThread[i], (posStartThread[i] + numItemThread)+numLastItem-1, tileArray, p, sharedStatus);
                        t.start();
                    }else{
                        AngleTileThread t = new AngleTileThread(i, posStartThread[i], (posStartThread[i] + numItemThread)-1, tileArray, p, sharedStatus);
                        t.start();
                    }
                }

                /* ciclo che itera sulla condizione dell'oggetto condiviso finché non viene trovato il primo e l'ultimo elemento della prima colonna */
                synchronized (sharedStatus){
                    while (!sharedStatus.getFindFirstColFirstTile() || !sharedStatus.getFindFirstColLastTile()){
                        try {
                            sharedStatus.wait();
                        }catch (InterruptedException e){
                            Logger.logger.info("InterruptedException caused by a wait() method: " + e.getMessage());
                        }
                    }
                }

                /* trovo la prima colonna a partire dal primo e dall'ultimo elemento della prima colonna */
                FirstColThread FirstToHalfThread = new FirstColThread(0, (p.getNumRow()/2), "down", p, sharedStatus);
                FirstColThread LastToHalfThread = new FirstColThread(p.getNumRow() -1, p.getNumRow()/2+1, "up", p, sharedStatus);
                FirstToHalfThread.start();
                LastToHalfThread.start();

                synchronized (sharedStatus){
                    while (!sharedStatus.getFindFirstToHalf() || !sharedStatus.getFindLastToHalf()){
                        try {
                            sharedStatus.wait();
                        }catch (InterruptedException e){
                            Logger.logger.info("InterruptedException caused by a wait() method: " + e.getMessage());
                        }
                    }
                }


                /* scorro un tot di righe su ogni thread in base al numero che decido */

                int numThreadRows = 4; // decido quanti thread voglio lanciare per la ricerca del primo in alto a sinistra e dell'ultimo in basso a sinistra
                int numLastRows = p.getNumRow() % numThreadRows; // se la divisione non è esatta mi calcolo i rimanente e gli inserisco nell'ultimo thread
                int numRowForThread = p.getNumRow() / numThreadRows;
                int[] rowStartThread = new int[numThreadRows];
                Logger.logger.info("Il numero di righe per thread è: " + numRowForThread + ". Le righe finali sono: " + numLastRows);

                for (int i = 0; i < numThreadRows; ++i){
                    rowStartThread[i] = numRowForThread * i;
                }

                for (int i = 0; i < numThreadRows; ++i){
                    if (i == numThreadRows-1){ // TO CHANGE VALUE IN CONSTRUCTOR
                        RowThread t = new RowThread(i, rowStartThread[i], (rowStartThread[i] + numRowForThread)+numLastRows-1, p, sharedStatus, numThreadRows);
                        t.start();
                    }else{
                        RowThread t = new RowThread(i, rowStartThread[i], rowStartThread[i+1]-1, p, sharedStatus, numThreadRows);
                        t.start();
                    }
                }

                synchronized (sharedStatus){
                    while (sharedStatus.getCountRowThread() != numThreadRows){
                        try {
                            sharedStatus.wait();
                        }catch (InterruptedException e){
                            Logger.logger.info("InterruptedException caused by a wait() method: " + e.getMessage());
                        }
                    }
                }

                Logger.logger.info("Risoluzione completata");

            }
        } catch (ArrayStoreException e){
            Logger.logger.info("ArrayStoreException. " + e.getMessage());
        }
    }
}
