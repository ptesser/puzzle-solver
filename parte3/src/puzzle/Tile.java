package puzzle;

/**
 * @author Tesser Paolo
 *
 */

public abstract class Tile {

    /* MEMBRI STATICI della classe Tile */
    private String id;
    private String idNorth;
    private String idSouth;
    private String idEast;
    private String idWest;

    /* METODI PUBBLICI CONCRETI della classe Tile */
    /**
     * <p>Costruttore della classe astratta Tile, richiamato solo dalle sottoclassi.</p>
     * @param id identificatore univoco del tile che stiamo considerando
     * @param idNorth identificatore univoco del tile a nord di quello che stiamo considerando
     * @param idSouth identificatore univoco del tile a sud di quello che stiamo considerando
     * @param idEast identificatore univoco del tile a est di quello che stiamo considerando
     * @param idWest identificatore univoco del tile a ovest di quello che stiamo considerando
     */
    public Tile(String id, String idNorth, String idSouth, String idEast, String idWest){
        this.id = id;
        this.idNorth = idNorth;
        this.idSouth = idSouth;
        this.idEast = idEast;
        this.idWest = idWest;
    }
    /* Tutti i metodi getXXX vengono firmati come final perché non si deve permetterne la ridefinizione in sottoclassi*/
    /**
     * @return l'identificatore del tile che stiamo considerando
     */
    public final String getId(){
        return this.id;
    }

    /**
     * @return l'identificatore del tile a nord di quello che stiamo considerando
     */
    public final String getIdNorth(){
        return this.idNorth;
    }

    /**
     * @return l'identificatore del tile a sud di quello che stiamo considerando
     */
    public final String getIdSouth(){
        return this.idSouth;
    }

    /**
     * @return l'identificatore del tile a est di quello che stiamo considerando
     */
    public final String getIdEast(){
        return this.idEast;
    }

    /**
     * @return l'identificatore del tile a ovest di quello che stiamo considerando
     */
    public final String getIdWest(){
        return this.idWest;
    }

}
