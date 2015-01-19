package myexception;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class NumFieldRowExcpt extends Exception{
    private String error;
    private String effect;

    /**
     * Costruttore dell'eccezione
     *
     */
    public NumFieldRowExcpt(){
        this.error = "ERROR! Riga non conforme alla specifica!";
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
