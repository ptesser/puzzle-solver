package PuzzleSolver.Puzzle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class PuzzleCarattere extends Puzzle { // se cambiata in interfaccia, modificare in implements

    public class PezzoCarattere extends Pezzo{

        /* MEMBRI PRIVATI della classe PezzoCarattere */
        private char carattere;

        /* METODI PUBBLICI della classe PezzoCarattere */
        /**
         * <p>Costruttore della classe interna PezzoCarattere che estende la classe Pezzo con un membro che dipende dal tipo
         * di Puzzle che si vuole comporre. In questo caso un Puzzle di caratteri alfanumerici.</p>
         *
         * @param id identificatore univoco del pezzo che stiamo considerando
         * @param idNord identificatore univoco del pezzo a nord di quello che stiamo considerando
         * @param idSud identificatore univoco del pezzo a sud di quello che stiamo considerando
         * @param idEst identificatore univoco del pezzo a est di quello che stiamo considerando
         * @param idOvest identificatore univoco del pezzo a ovest di quello che stiamo considerando
         * @param c carattere del pezzo che stiamo considerando
         */
        public PezzoCarattere(String id, String idNord, String idSud, String idEst, String idOvest, char c){
            super(id, idNord, idSud, idEst, idOvest);
            this.carattere = c;
        }

        /**
         * @return il carattere memorizzato nel pezzo
         */
        public char getCarattere(){ return this.carattere; }

    }

    /* MEMBRI PRIVATI della classe PuzzleCarattere */
    private HashMap<String, Pezzo> puzzleCarattereToSolve = new HashMap<>(0);
    private Pezzo[][] puzzleCarattereSolved;

    /* METODI PUBBLICI della classe PuzzleCarattere */

    /**
     * <p>Costruttore a un parametro di PuzzleCarattere.</p>
     * @param inputContent riceve un ArrayList di Stringhe proveniente dal file in input. Ogni elemento verrà splittato
     *                     e generato un oggetto PezzoCarattere contenente le info prelevate dala stringa.
     */
    public PuzzleCarattere(ArrayList<String> inputContent){

        int numCol = 0;
        int numRow = 0;

        for (String s : inputContent){
            String[] splitInputContent = s.split("\\t");

            String id = splitInputContent[0];
            char c = (splitInputContent[1]).charAt(0); // .replace(" ","")
            String idNord = splitInputContent[2];
            String idSud = splitInputContent[3];
            String idEst = splitInputContent[4];
            String idOvest = splitInputContent[5];

            Pezzo pezzoCorrente = new PuzzleCarattere.PezzoCarattere(id, idNord,idSud, idEst, idOvest, c);
            this.puzzleCarattereToSolve.put(id,pezzoCorrente);

            /**
                Conto il numero di righe e colonne che formano il puzzle.
                Controllo l'idNord per trovare il numero di colonne.
                Controllo l'idOvest per trovare il numero di righe.
             */
            if (idNord.equals("VUOTO")){
                numCol += 1;
            }
            if (idOvest.equals("VUOTO")){
                numRow += 1;
            }
        }
        // imposto i campi dati della classe Puzzle che viene estesa
        this.setNumCol(numCol);
        this.setNumRow(numRow);

        this.puzzleCarattereSolved = new Pezzo[numRow][numCol];
    }

    /**
     *
     * @return il membro che contiene il Puzzle non ordinato in una collection HashMap
     */
    public HashMap<String, Pezzo> getPuzzleElementToSolve(){
        return this.puzzleCarattereToSolve;
    }

    /**
     *
     * @return il membro che contiene il Puzzle risolto in un array bidimensionale
     */
    public Pezzo[][] getPuzzleElementSolved(){
        return this.puzzleCarattereSolved;
    }

}
