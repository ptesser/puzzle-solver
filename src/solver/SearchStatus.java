package solver;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class SearchStatus {
    private boolean findFirstColFirstTile = false;
    private boolean findFirstColLastTile = false;
    private boolean findFirstToHalf = false;
    private boolean findLastToHalf = false;
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
     * @return il valore che dice se la prima metà della prima colonna dal primo elemento alla metà è stata composta
     */
    public final boolean getFindFirstToHalf(){
        return this.findFirstToHalf;
    }

    /**
     *
     * @return il valore che dice se la seconda metà della prima colonna dall'ultimo elemento alla metà è stata composta
     */
    public final boolean getFindLastToHalf(){
        return this.findLastToHalf;
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

    /**
     *
     * @param s valore true/false da settare a seconda se si ha finito o meno di comporre la prima colonna dall'alto verso la metà
     */
    public final void setFindFirstToHalf(boolean s){
        this.findFirstToHalf = s;
    }

    /**
     *
     * @param s valore true/false da settare a seconda se si ha finito o meno di comporre la prima colonna dal basso verso la metà
     */
    public final void setFindLastToHalf(boolean s){
        this.findLastToHalf = s;
    }
}
