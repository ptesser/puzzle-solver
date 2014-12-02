package PuzzleSolver.Puzzle;

import java.util.ArrayList;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public abstract class Puzzle { // scegliere se farla come interfaccia

    public abstract ArrayList<Pezzo> getPuzzleElement();
    public abstract int getNumCol();
    public abstract int getNumRow();
}
