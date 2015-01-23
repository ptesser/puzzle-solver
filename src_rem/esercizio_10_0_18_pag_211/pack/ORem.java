package pack;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public interface ORem extends Remote {
    public void stampaRemoto() throws RemoteException;
}


