package objrem;

import puzzle.Puzzle;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public class ConvertThread extends Thread{

    private String idClient;
    private Puzzle p;
    private HashMap<String, ArrayList<String>> output;

    /**
     * @param idClient identificativo del client sul quale voglio inserire l'output della conversione
     * @param p puzzle da convertire nel formato necessario alla scrittura su file
     * @param out HashMap dove immagazzinare l'output della conversione a secondo del client
     */
    public ConvertThread(String idClient, Puzzle p, HashMap<String, ArrayList<String>> out){
        this.idClient = idClient;
        this.p = p;
        this.output = out;
    }

    public void run(){
        this.output.put(idClient, p.convertToArrayList());
    }
}
