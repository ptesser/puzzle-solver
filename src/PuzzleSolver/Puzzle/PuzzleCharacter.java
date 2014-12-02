package PuzzleSolver.Puzzle;

import java.util.*;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class PuzzleCharacter extends Puzzle { // se cambiata in interfaccia, modificare in implements

    public class TileCharacter extends Tile{

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
        public char getCharacter(){ return this.character; }

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
    public PuzzleCharacter(ArrayList<String> inputContent){

        int numCol = 0;
        int numRow = 0;

        for (String s : inputContent){
            String[] splitInputContent = s.split("\\t");

            String id = splitInputContent[0];
            char c = (splitInputContent[1]).charAt(0); // .replace(" ","")
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
    @Override
    public HashMap<String, Tile> getPuzzleElementToSolve(){
        return this.puzzleCharacterToSolve;
    }

    /**
     *
     * @return il membro che contiene il Puzzle risolto in un array bidimensionale
     */
    @Override
    public Tile[][] getPuzzleElementSolved(){
        return this.puzzleCharacterSolved;
    }


    /**
     * <p>Algoritmo di risoluzione del puzzle.</p>
     */
    @Override
    public void solvePuzzle() {
        // ricerco il primo elemento del puzzle (alto a sinistra, nord: VUOTO, ovest: VUOTO)
        Set set = this.puzzleCharacterToSolve.entrySet();
        Iterator i = set.iterator();
        boolean findFirstTile = false;

        while (i.hasNext() && !findFirstTile){
            Map.Entry currIter = (Map.Entry) i.next();
            Tile currTile = (Tile) currIter.getValue();
            String idNorth = currTile.getIdNorth();
            String idWest = currTile.getIdWest();

            if (idNorth.equals("VUOTO") && idWest.equals("VUOTO")){
                findFirstTile = true;
                this.puzzleCharacterSolved[0][0] = currTile;
            }

        }

        // le dichiaro fuori dal for così evito di fare ogni volta una chiamata di funzione
        int lengthRow = this.getNumRow();
        int lengthCol = this.getNumCol();

        // riordino la colonna più a sinistra
        for (int j = 0; j < (lengthRow - 1); j++){
            Tile nowTile = this.puzzleCharacterSolved[j][0];
            String idTileSud = nowTile.getIdSouth();
            Tile newTileSud = this.puzzleCharacterToSolve.get(idTileSud);
            this.puzzleCharacterSolved[j+1][0] = newTileSud;
        }

        for (int j = 0; j < (lengthRow); j++){
            for (int z = 0; z < (lengthCol-1); z++){
                Tile nowTile = this.puzzleCharacterSolved[j][z];
                String idTileEast = nowTile.getIdEast();
                Tile newTileEast = this.puzzleCharacterToSolve.get(idTileEast);
                this.puzzleCharacterSolved[j][z+1] = newTileEast;
            }
        }

        /*

        */
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
