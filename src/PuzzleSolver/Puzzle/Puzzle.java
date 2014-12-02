package PuzzleSolver.Puzzle;

// import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public abstract class Puzzle { // scegliere se farla come interfaccia
    /* MEMBRI STATICI della classe Puzzle */
    private int numCol;
    private int numRow;

    /* METODI PUBBLICI ASTRATTI della classe Puzzle */
    public abstract HashMap<String, Pezzo> getPuzzleElementToSolve();
    public abstract Pezzo[][] getPuzzleElementSolved();

    /* METODI PUBBLICI CONCRETI della classe Puzzle */

    /**
     *
     * @param numCol il numero di colonne del Puzzle da settare
     */
    void setNumCol(int numCol) {
        this.numCol = numCol;
    }

    /**
     *
     * @param numRow il numero di righe del Puzzle da settare
     */
    void setNumRow(int numRow) {
        this.numRow = numRow;
    }

    /**
     *
     * @return il numero di colonne del Puzzle
     */
    public int getNumCol(){
        return this.numCol;
    }

    /**
     *
     * @return il numero di righe del Puzzle
     */
    public int getNumRow(){
        return this.numRow;
    }
}
