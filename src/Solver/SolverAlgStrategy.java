package Solver;

import Puzzle.PuzzleCharacter;
import Puzzle.Tile;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class SolverAlgStrategy implements SolverStrategy {

    @Override
    public void executeSolve(PuzzleCharacter p) {
        // ricerco il primo elemento del puzzle (alto a sinistra, nord: VUOTO, ovest: VUOTO)
        Set set = p.getPuzzleElementToSolve().entrySet();
        Iterator i = set.iterator();
        boolean findFirstTile = false;

        while (i.hasNext() && !findFirstTile){
            Map.Entry currIter = (Map.Entry) i.next();
            Tile currTile = (Tile) currIter.getValue();
            String idNorth = currTile.getIdNorth();
            String idWest = currTile.getIdWest();

            if (idNorth.equals("VUOTO") && idWest.equals("VUOTO")){
                findFirstTile = true;
                p.getPuzzleElementSolved()[0][0] = currTile;
            }

        }

        // le dichiaro fuori dal for così evito di fare ogni volta una chiamata di funzione
        int lengthRow = p.getNumRow();
        int lengthCol = p.getNumCol();

        // riordino la colonna più a sinistra
        for (int j = 0; j < (lengthRow - 1); j++){
            Tile nowTile = p.getPuzzleElementSolved()[j][0];
            String idTileSud = nowTile.getIdSouth();
            Tile newTileSud = p.getPuzzleElementToSolve().get(idTileSud);
            p.getPuzzleElementSolved()[j+1][0] = newTileSud;
        }

        for (int j = 0; j < (lengthRow); j++){
            for (int z = 0; z < (lengthCol-1); z++){
                Tile nowTile = p.getPuzzleElementSolved()[j][z];
                String idTileEast = nowTile.getIdEast();
                Tile newTileEast = p.getPuzzleElementToSolve().get(idTileEast);
                p.getPuzzleElementSolved()[j][z+1] = newTileEast;
            }
        }
        System.out.println("Risoluzione completata.");
    }
}
