package Puzzle;

import Solver.SolverStrategy;
import java.util.ArrayList;


/**
 * @author Tesser Paolo
 *
 */
public abstract class Puzzle {

    /* MEMBRI PRIVATI della classe Puzzle */
    private int numCol;
    private int numRow;
    private SolverStrategy strategy;

    /* METODI PUBBLICI ASTRATTI della classe Puzzle */

    public abstract void solvePuzzle();
    public abstract void showPuzzleTerminal();
    public abstract ArrayList<String> convertToArrayList();

    /* METODI PUBBLICI CONCRETI della classe Puzzle */

    /**
     * visibilità: public perchè necessita di essere chiamato dal client che vuole risolvere il puzzle.
     * final : perché non vogliamo che, estendendo la classe Puzzle, qualcuno modifichi il metodo in modo tale che possa impostare un algoritmo diverso da quello che sceglie il client.
     * @param s oggetto che sarà di un tipo sottoclasse rispetto a SolverStrategy che implementare un determinato algoritmo di risoluzine del puzzle.
     */
    public final void setStrategy(SolverStrategy s){
        this.strategy = s;
    }

    /**
     *
     * @return il tipo di algoritmo che viene utilizzato per risolvere il puzzle.
     */
    public final SolverStrategy getStrategy(){
        return this.strategy;
    }

    /**
     * visibilità : pack perché non vogliamo che altri al di fuori delle classi di puzzle, possano modificare il numero di colonne del puzzle questo compito è riservato solo al costruttore.
     * final : perché non vogliamo che, estendendo la classe Puzzle, qualcuno modifichi il metodo in modo tale che possa impostare un numero di colonne
     *         non conforme alla realtà.
     * @param numCol il numero di colonne del Puzzle da settare.
     */
    final void setNumCol(int numCol) {
        this.numCol = numCol;
    }

    /**
     * visibilità : pack perché non vogliamo che altri al di fuori delle classi di puzzle, possano modificare il numero di righe del puzzle, questo compito è riservato solo al costruttore.
     * final : perché non vogliamo che, estendendo la classe Puzzle, qualcuno modifichi il metodo in modo tale che possa impostare un numero di colonne
     *         non conforme alla realtà.
     * @param numRow il numero di righe del Puzzle da settare.
     */
    final void setNumRow(int numRow) {
        this.numRow = numRow;
    }

    /**
     *
     * @return il numero di colonne del Puzzle.
     */
    public final int getNumCol(){
        return this.numCol;
    }

    /**
     *
     * @return il numero di righe del Puzzle.
     */
    public final int getNumRow(){
        return this.numRow;
    }
}
