package PuzzleSolver.Puzzle;

/**
 * @author Tesser Paolo
 * @version 0.1
 *
 */

public abstract class Pezzo {

    /* MEMBRI STATICI della classe Pezzo */
    private String id;
    private String idNord;
    private String idSud;
    private String idEst;
    private String idOvest;

    /* METODI PUBBLICI CONCRETI della classe Pezzo */
    /**
     * <p>Costruttore della classe astratta Pezzo, richiamato solo dalle sottoclassi.</p>
     * @param id identificatore univoco del pezzo che stiamo considerando
     * @param idNord identificatore univoco del pezzo a nord di quello che stiamo considerando
     * @param idSud identificatore univoco del pezzo a sud di quello che stiamo considerando
     * @param idEst identificatore univoco del pezzo a est di quello che stiamo considerando
     * @param idOvest identificatore univoco del pezzo a ovest di quello che stiamo considerando
     */
    public Pezzo(String id, String idNord, String idSud, String idEst, String idOvest){
        this.id = id;
        this.idNord = idNord;
        this.idSud = idSud;
        this.idEst = idEst;
        this.idOvest = idOvest;
    }

    /**
     * @return l'identificatore del pezzo che stiamo considerando
     */
    public String getId(){
        return this.id;
    }

    /**
     * @return l'identificatore del pezzo a nord di quello che stiamo considerando
     */
    public String getIdNord(){
        return this.idNord;
    }

    /**
     * @return l'identificatore del pezzo a sud di quello che stiamo considerando
     */
    public String getIdSud(){
        return this.idSud;
    }

    /**
     * @return l'identificatore del pezzo a est di quello che stiamo considerando
     */
    public String getIdEst(){
        return this.idEst;
    }

    /**
     * @return l'identificatore del pezzo a ovest di quello che stiamo considerando
     */
    public String getIdOvest(){
        return this.idOvest;
    }

}
