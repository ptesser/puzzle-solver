package objrem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public interface ObjRem extends Remote{

    /**
     *
     * @return un nuovo identificativo per il client che lo richieda, univoco tra quelli esistenti
     * @throws RemoteException
     */
    public String getNewIdClient() throws RemoteException;

    /**
     *
     * @param idClient identificativo del client dal quale vogliamo ricevere un puzzle in input
     * @param input puzzle sotto forma di ArrayList
     * @throws RemoteException
     */
    public void setClientPuzzle(String idClient, ArrayList<String> input) throws RemoteException;

    /**
     *
     * @param idClient identificativo del client per il quale vogliamo risolvere il puzzle
     * @param algPolicy politica di risoluzione del puzzle: "sequenziale"/"parallelo"
     * @throws RemoteException
     */
    public void solve(String idClient, String algPolicy) throws RemoteException;

    /**
     *
     * @param idClient indentificativo del client per il quale vogliamo convertire il puzzle in un formato scrivibile su file
     * @throws RemoteException
     */
    public void convert(String idClient) throws RemoteException;

    /**
     *
     * @param idClient indentificativo del client per il quale vogliamo restituire il puzzle in un formato scrivibile su file
     * @return puzzle in formato scrivibile su file testuale
     * @throws RemoteException
     */
    public ArrayList<String> getOutput(String idClient) throws RemoteException;

    /**
     *
     * @param idClient identificativo del cliente per il quale vogliamo restituire il numero di colonne del puzzle che ha dato in input
     * @return numero di colonne del puzzle
     * @throws RemoteException
     */
    public int getPuzzleCol(String idClient) throws RemoteException;

    /**
     *
     * @param idClient identificativo del cliente per il quale vogliamo restituire il numero di righe del puzzle che ha dato in input
     * @return numero di righe del puzzle
     * @throws RemoteException
     */
    public int getPuzzleRow(String idClient) throws RemoteException;
}
