import logger.Logger;
import objrem.*;
import java.rmi.Naming;


/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class PuzzleSolverServer {

    public static void main (String[] args) throws Exception{
        /* prelevo il nome del server passato come input */
        String nameServer = args[0];

        /* creo l'oggetto che andrò a rendere disponibile in remoto */
        ObjRemImpl obj = new ObjRemImpl();

        /* rendo disponibile l'oggetto ai client che si connettono sullo stesso nominativo */
        Naming.rebind(nameServer,obj);
        Logger.logger.info("SERVER PRONTO");

    }

}