package solver;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class SearchStatus {

    private boolean findFirstColFirstTile;
    private boolean findFirstColLastTile;
    private boolean findFirstToHalf;
    private boolean findLastToHalf;
    private int countRowThread;

    public SearchStatus(){
        this.findFirstColFirstTile = false;
        this.findFirstColLastTile = false;
        this.findFirstToHalf = false;
        this.findLastToHalf = false;
        this.countRowThread = 0;
    }
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
     * @return il valore che dice quanti thread per comporre le righe somo terminati
     */
    public final int getCountRowThread(){
        return this.countRowThread;
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

    /**
     *
     * @param c valore intero che setta il numero di thread conclusi per comporre le righe
     */
    public final void setCountRowThread(int c){
        this.countRowThread = c;
    }
}
