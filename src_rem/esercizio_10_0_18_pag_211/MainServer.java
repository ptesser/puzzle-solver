import pack.*;

import java.lang.System;
import java.rmi.Naming;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class MainServer {
    public static void main(String[] argv) throws Exception{

        String rmiName = "server";
        ORemImpl obj = new ORemImpl();
        Naming.rebind(rmiName, obj);

        while (true){
            obj.stampaNumeri();
        }


    }

}
