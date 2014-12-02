package PuzzleSolver.Puzzle;

import java.util.ArrayList;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class PuzzleCarattere extends Puzzle { // se cambiata in interfaccia, modificare in implements

    public class PezzoCarattere extends Pezzo{

        private char carattere;

        /**
         * <p>Costruttore della classe interna PezzoCarattere</p>
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

    // MEMBRI PRIVATI
    private ArrayList<Pezzo> puzzleCarattere = new ArrayList<>(0);
    private int numCol;
    private int numRow;

    // METODI PUBBLICI
    public PuzzleCarattere(ArrayList<String> inputContent){

        int i = 0; // variabile di incremento necessaria per aggiungere gli elementi estratti
        // dall'ArrayList di stringhe in input dal file, all'ArrayList di Pezzi

        for (String s : inputContent){
            String[] splitInputContent = s.split("\t"); // perchè con gli spazi si e con la tabulazione no? \t

            String id = splitInputContent[0];
            char c = (splitInputContent[1]).charAt(0); // .replace(" ","")
            String idNord = splitInputContent[2];
            String idSud = splitInputContent[3];
            String idEst = splitInputContent[4];
            String idOvest = splitInputContent[5];

            PezzoCarattere pezzoCorrente = new PuzzleCarattere.PezzoCarattere(id, idNord,idSud, idEst, idOvest, c);
            this.puzzleCarattere.add(i,pezzoCorrente);
            i += 1;

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
    }

    public ArrayList<Pezzo> getPuzzleElement(){ return this.puzzleCarattere; }
    public int getNumCol(){ return this.numCol; }
    public int getNumRow(){ return this.numRow; }
}
