package objrem;

import logger.Logger;
import myexception.IdEmptyExcpt;
import myexception.NumFieldRowExcpt;
import puzzle.Puzzle;
import puzzle.PuzzleCharacter;
import solver.SolverAlgStrategy;
import solver.SolverParStrategy;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public class ObjRemImpl extends UnicastRemoteObject implements ObjRem{

    private static int NUMCLIENT = 0;
    private HashMap<String, Puzzle> clients = new HashMap<>();
    private HashMap<String, ArrayList<String>> output = new HashMap<>();
    private HashMap<String, SolveThread> solveThread = new HashMap<>();
    private HashMap<String, ConvertThread> convertThread = new HashMap<>();

    public ObjRemImpl () throws RemoteException{}

    /**
     *
     * @return un nuovo identificativo per il client che lo richieda, univoco tra quelli esistenti
     * @throws RemoteException
     */
    @Override
    public synchronized String getNewIdClient() throws RemoteException {
        int tempNumClient = getNumClient();
        setNumClient();
        return "client" + tempNumClient;
    }

    /**
     *
     * @param idClient identificativo del client dal quale vogliamo ricevere un puzzle in input
     * @param input puzzle sotto forma di ArrayList
     * @throws RemoteException
     */
    @Override
    public synchronized void setClientPuzzle(String idClient, ArrayList<String> input) throws RemoteException {

        try{
            Puzzle p = new PuzzleCharacter(input);
            clients.put(idClient, p);
        }
        catch (NumFieldRowExcpt e){
            System.out.println(e.getError());
            System.out.println(e.getEffect());
        }
        catch (IdEmptyExcpt e){
            System.out.println(e.getError());
            System.out.println(e.getEffect());
        }
    }

    /**
     *
     * @param idClient identificativo del client per il quale vogliamo risolvere il puzzle
     * @param algPolicy politica di risoluzione del puzzle: "sequenziale"/"parallelo"
     * @throws RemoteException
     */
    @Override
    public synchronized void solve(String idClient, String algPolicy) throws RemoteException{

        switch (algPolicy){
            case "sequenziale": clients.get(idClient).setStrategy(new SolverAlgStrategy()); break;
            case "parallelo": clients.get(idClient).setStrategy(new SolverParStrategy()); break;
        }

        /* creo il thread che andrà ad eseguire la risoluzione sul puzzle del client che lo richieda */
        Logger.logger.info("Risolvo il puzzle del: " + idClient);
        SolveThread t = new SolveThread(clients.get(idClient));
        solveThread.put(idClient, t);
        t.start();

    }

    /**
     *
     * @param idClient indentificativo del client per il quale vogliamo convertire il puzzle in un formato scrivibile su file
     * @throws RemoteException
     */
    @Override
    public synchronized void convert(String idClient) throws RemoteException {

        /* creo il thread che andrà ad eseguire la conversione del puzzle del client che lo richieda */
        ConvertThread t = new ConvertThread(idClient, clients.get(idClient), output);
        convertThread.put(idClient, t);

        /* posso lanciare il thread che esegue la conversione solo quando sono certo che il thread che risolve il puzzle sia terminato */
        try{
            solveThread.get(idClient).join();
            Logger.logger.info("Converto il puzzle del: " + idClient);
            t.start();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    /**
     *
     * @param idClient indentificativo del client per il quale vogliamo restituire il puzzle in un formato scrivibile su file
     * @return puzzle in formato scrivibile su file testuale
     * @throws RemoteException
     */
    @Override
    public synchronized ArrayList<String> getOutput(String idClient) throws RemoteException {

        /* posso lanciare il thread che restituisce la conversione solo quando sono certo che il thread che esegue la conversione sia terminato */
        try{
            convertThread.get(idClient).join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return output.get(idClient);

    }

    /**
     *
     * @param idClient identificativo del cliente per il quale vogliamo restituire il numero di colonne del puzzle che ha dato in input
     * @return numero di colonne del puzzle
     * @throws RemoteException
     */
    @Override
    public synchronized int getPuzzleCol(String idClient) throws RemoteException {
        return clients.get(idClient).getNumCol();
    }

    /**
     *
     * @param idClient identificativo del cliente per il quale vogliamo restituire il numero di righe del puzzle che ha dato in input
     * @return numero di righe del puzzle
     * @throws RemoteException
     */
    @Override
    public synchronized int getPuzzleRow(String idClient) throws RemoteException {
        return clients.get(idClient).getNumRow();
    }

    /**
     *
     * @return il numero del prossimo client da servire
     */
    private static int getNumClient(){
        return NUMCLIENT;
    }

    /**
     * imposta il valore del prossimo client da servire
     */
    private static void setNumClient(){
        NUMCLIENT++;
    }
}
