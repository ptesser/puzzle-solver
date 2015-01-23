import pack.*;
import java.rmi.Naming;


/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class MainClient {

    public static void  main(String[] argv) throws Exception{
        String rmiName = "server";
        ORem obj = (ORem) Naming.lookup(rmiName);
        T1 t = new T1(obj);
        t.start();
        for (int i = 0; i < 10 ; i++){
            System.out.println(i);
        }

    }

}
