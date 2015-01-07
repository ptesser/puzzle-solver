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

                // Set set = p.getPuzzleElementToSolve().entrySet();

                // trovo la dimensione dell'array
                int dimTileArray = ((PuzzleCharacter) o).getPuzzleElementToSolve().size();
                Logger.logger.info("Dim Tile Array: " + dimTileArray);

                // mi creo l'array di Tile dalla HashMap
                Tile[] tileArray = new Tile[dimTileArray];
                tileArray = p.getPuzzleElementToSolve().values().toArray(tileArray);

                int numThread = 3; // decido quanti thread voglio lanciare
                int numLastItem = dimTileArray % numThread; // se la divisione non è esatta mi calcolo i rimanente e gli inserisco nell'ultimo thread
                int numItemThread = dimTileArray / 3;
                int[] posStartThread = new int[numThread];

                for (int i = 0; i < numThread; ++i){
                    posStartThread[i] = numItemThread * i;
                }

                for (int i = 0; i < numThread; ++i){
                    if (i == numThread-1){
                        AngleTileThread t = new AngleTileThread(i, posStartThread[i], posStartThread[i]+numLastItem-1, tileArray, p);
                        t.start();
                    }else{
                        AngleTileThread t = new AngleTileThread(i, posStartThread[i], posStartThread[i]-1, tileArray, p);
                        t.start();
                    }
                }
                // serve sincronizzazione prima di continuare il main

                Logger.logger.info("Risoluzione completata");
                System.out.println("Risoluzione completata.");
            }

        } catch (ArrayStoreException e){
            Logger.logger.info("ArrayStoreException - " + e.getMessage());
        }
    }
}
