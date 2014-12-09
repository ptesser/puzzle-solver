package MyException;

/**
 * @author Tesser Paolo
 *
 */
public class IdEmptyExcpt extends Exception{
    private String error;
    private String effect;
    private String typeId;

    /**
     * Costruttore dell'eccezione
     *
     */
    public IdEmptyExcpt(String t){
        this.typeId = t;
        this.error = "ERROR! Id: " + this.typeId + " vuoto o formato da una stringa di soli spazi!";
        this.effect = "Il programma terminerà senza risolvere il puzzle!";
    }

    /**
     *
     * @return il messaggio di errore
     */
    public String getError(){
        return this.error;
    }

    /**
     *
     * @return il messaggio sulle conseguenze nel programma
     */
    public String getEffect(){
        return this.effect;
    }

}
