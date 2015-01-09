package solver;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class SearchStatus {
    private boolean findFirstColFirstTile = false;
    private boolean findFirstColLastTile = false;

    /**
     *
     * @return il valore che dice se il primo elemento della prima colonna è stato trovato
     */
    public final boolean getFindFirstColFirstTile (){
        return this.findFirstColFirstTile;
    }

    /**
     *
     * @return il valore che dice se l'ultimo elemento della prima colonna è stato trovato
     */
    public final boolean getFindFirstColLastTile (){
        return this.findFirstColLastTile;
    }

    /**
     *
     * @param f valore true/false da settare a seconda se è stato trovato o meno il primo elemento della prima colonna
     */
    public final void setFindFirstColFirstTile(boolean f){
        this.findFirstColFirstTile = f;
    }

    /**
     *
     * @param f valore true/false da settare a seconda se è stato trovato o meno l'ultimo elemento della prima colonna
     */
    public final void setFindFirstColLastTile(boolean f){
        this.findFirstColLastTile = f;
    }
}
