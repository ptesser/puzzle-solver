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

    private ArrayList<PezzoCarattere> puzzle = new ArrayList<>(0);


}
