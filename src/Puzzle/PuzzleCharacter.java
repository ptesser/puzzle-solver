package Puzzle;

import java.util.*;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class PuzzleCharacter extends Puzzle { // se cambiata in interfaccia, modificare in implements

    class TileCharacter extends Tile{

        /* MEMBRI PRIVATI della classe TileCharacter */
        private char character;

        /* METODI PUBBLICI della classe TileCharacter */
        /**
         * <p>Costruttore della classe interna TileCharacter che estende la classe Tile con un membro che dipende dal tipo
         * di Puzzle che si vuole comporre. In questo caso un Puzzle di caratteri alfanumerici.</p>
         *
         * @param id identificatore univoco del tile che stiamo considerando
         * @param idNorth identificatore univoco del tile a nord di quello che stiamo considerando
         * @param idSouth identificatore univoco del tile a sud di quello che stiamo considerando
         * @param idEast identificatore univoco del tile a est di quello che stiamo considerando
         * @param idWest identificatore univoco del tile a ovest di quello che stiamo considerando
         * @param c carattere del tile che stiamo considerando
         */
        public TileCharacter(String id, String idNorth, String idSouth, String idEast, String idWest, char c){
            super(id, idNorth, idSouth, idEast, idWest);
            this.character = c;
        }

        /**
         * @return il carattere memorizzato nel tile
         */
        public final char getCharacter(){ return this.character; }

    }

    /* MEMBRI PRIVATI della classe PuzzleCharacter */
    private HashMap<String, Tile> puzzleCharacterToSolve = new HashMap<>(0);
    private Tile[][] puzzleCharacterSolved;

    /* METODI PUBBLICI della classe PuzzleCharacter */

    /**
     * <p>Costruttore a un parametro di PuzzleCharacter.</p>
     * @param inputContent riceve un ArrayList di Stringhe proveniente dal file in input. Ogni elemento verrà splittato
     *                     e generato un oggetto TileCharacter contenente le info prelevate dala stringa.
     */
    public PuzzleCharacter (ArrayList<String> inputContent){

        int numCol = 0;
        int numRow = 0;

        for (String s : inputContent){
            String[] splitInputContent = s.split("\\t");

            String id = splitInputContent[0];
            char c = (splitInputContent[1]).charAt(0);
            String idNorth = splitInputContent[2];
            String idSouth = splitInputContent[3];
            String idEast = splitInputContent[4];
            String idWest = splitInputContent[5];

            Tile tileCurrent = new PuzzleCharacter.TileCharacter(id, idNorth,idSouth, idEast, idWest, c);
            this.puzzleCharacterToSolve.put(id, tileCurrent);

            /**
                Conto il numero di righe e colonne che formano il puzzle.
                Controllo l'idNorth per trovare il numero di colonne.
                Controllo l'idWest per trovare il numero di righe.
             */
            if (idNorth.equals("VUOTO")){
                numCol += 1;
            }
            if (idWest.equals("VUOTO")){
                numRow += 1;
            }
        }

        // imposto i campi dati della classe Puzzle che viene estesa
        this.setNumCol(numCol);
        this.setNumRow(numRow);

        this.puzzleCharacterSolved = new Tile[numRow][numCol];


    }

    /**
     *
     * @return il membro che contiene il Puzzle non ordinato in una collection HashMap
     */
    // @Override
    public final HashMap<String, Tile> getPuzzleElementToSolve(){
        return this.puzzleCharacterToSolve;
    }

    /**
     *
     * @return il membro che contiene il Puzzle risolto in un array bidimensionale
     */
    // @Override
    public final Tile[][] getPuzzleElementSolved(){
        return this.puzzleCharacterSolved.clone();
    }

    /**
     *
     * @param r indica la riga su cui si andrà ad assegnare il nuovo oggetto
     * @param c indica la colonna su cui si andrà ad assegnare il nuovo oggetto
     * @param t indica l'oggetto che deve essere assegnato in poszione (r,c)
     */
    // @Override
    public final void setPuzzleElementSolved(int r, int c, Tile t){
        this.puzzleCharacterSolved[r][c] = t;
    }

    /**
     * <p>Algoritmo di risoluzione del puzzle.</p>
     */
    @Override
    public final void solvePuzzle() {
        this.getStrategy().executeSolve(this);
    }

    /**
     * <p>Stampa a terminale il puzzle in forma matriciale R x C.</p>
     */
    @Override
    public void showPuzzleTerminal() {
        // le dichiaro fuori dal for così evito di fare ogni volta una chiamata di funzione
        int lengthRow = this.getNumRow();
        int lengthCol = this.getNumCol();

        for (int k = 0; k < lengthRow; k++){
            for (int w = 0; w < lengthCol; w++) {
                System.out.print(((TileCharacter)this.puzzleCharacterSolved[k][w]).getCharacter());
            }
            System.out.println();
        }
    }

    /**
     *
     * @return converte il Puzzle in una ArrayList di Stringhe dove ogni stringa è il carattere del Tile
     */
    @Override
    public ArrayList<String> convertToArrayList() {

        ArrayList<String> puzzleOrdered = new ArrayList<>(0);
        // le dichiaro fuori dal for così evito di fare ogni volta una chiamata di funzione
        int lengthRow = this.getNumRow();
        int lengthCol = this.getNumCol();
        int i = 0;

        for (int k = 0; k < lengthRow; k++){
            for (int w = 0; w < lengthCol; w++) {
                char temp = ((TileCharacter)this.puzzleCharacterSolved[k][w]).getCharacter();
                puzzleOrdered.add(i,Character.toString(temp));
                i++;
            }
        }
        return puzzleOrdered;
    }
}
