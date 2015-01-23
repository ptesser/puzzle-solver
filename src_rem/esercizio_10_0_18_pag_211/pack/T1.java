package pack;

import java.rmi.RemoteException;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class T1 extends Thread{
    private ORem obj;

    public T1 (ORem e){
        this.obj = e;
    }

    public void run(){
        try{
            synchronized (obj) {
                obj.stampaRemoto();
            }
        }catch (RemoteException e){}
    }
}
