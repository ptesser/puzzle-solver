import fileinputoutput.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.util.ArrayList;
import objrem.ObjRem;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public class PuzzleSolverClient {

    public static void main( String[] args ){

        /* acquisisco i percorsi dei file di input e output che mi servono sotto forma di stringhe */
        String inputFile = args[0];
        String outputFile = args[1];
        String nameServer = args[2];

        try {
            /* recupero il riferimento all'oggetto remoto */
            ObjRem obj = (ObjRem) Naming.lookup(nameServer);
            /* mi prelevo un identificativo del client (potrebbe essere un ip o qualcosa di univo) */
            String idClient = obj.getNewIdClient();
            System.out.println("Sono il: " + idClient);

            /* trasformo le stringhe in input dei percorsi del file in oggetti Path */
            Path inputPath = Paths.get(inputFile);
            Path outputPath = Paths.get(outputFile);

            /* leggo il contenuto del file in input e lo trasformo nel formato dati che mi serve */
            FileIO file = new FileIOMod1();
            ArrayList<String> inputContent = file.readContent(inputPath);

            /* setto il puzzle che voglio risolvere nel server remoto */
            obj.setClientPuzzle(idClient, inputContent);
            /* lancio la risoluzione sul server del puzzle */
            obj.solve(idClient, "parallelo");
            /* lancio la conversione sul server del puzzle per ottenere il formato che mi serve per la stampa */
            obj.convert(idClient);

            /* prelevo l'output risolto nel formato che mi serve per la stampa e stampo */
            ArrayList<String> outputContent = obj.getOutput(idClient);
            if (file instanceof FileIOMod1) {
                ((FileIOMod1) file).writeContent(outputPath, outputContent, obj.getPuzzleRow(idClient), obj.getPuzzleCol(idClient));
            } else {
                System.out.println("Impossibile scrivere il puzzle su file!");
            }


        } catch (ConnectException e){
            System.out.println("Attenzione: problemi di connessione con il server!");
            System.out.println("Riprovare in seguito!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
