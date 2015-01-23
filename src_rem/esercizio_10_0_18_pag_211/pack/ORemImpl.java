package pack;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public class ORemImpl extends UnicastRemoteObject implements ORem {

    public ORemImpl() throws RemoteException {}
    public synchronized void stampaRemoto() throws RemoteException{
        for (int i = 0; i < 10; ++i){
            System.out.println("Remoto");
        }
    }

    public synchronized void stampaNumeri() throws RemoteException{
        for (int i = 0; i < 10; ++i){
            System.out.println(i);
            if (i == 9){
                i = 0;

            }
        }
    }
}
