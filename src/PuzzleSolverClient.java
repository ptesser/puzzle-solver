import fileinputoutput.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import objrem.ObjRem;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public class PuzzleSolverClient {

    private static int STEP = 0;

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
            STEP = 1; /* id prelevato in remoto */

            System.out.println("Sono il: " + idClient);

            /* trasformo le stringhe in input dei percorsi del file in oggetti Path */
            Path inputPath = Paths.get(inputFile);
            Path outputPath = Paths.get(outputFile);

            /* leggo il contenuto del file in input e lo trasformo nel formato dati che mi serve */
            FileIO file = new FileIOMod1();
            ArrayList<String> inputContent = file.readContent(inputPath);
            STEP = 2; /* lettura del file in locale effettuata */

            /* setto il puzzle che voglio risolvere nel server remoto */
            obj.setClientPuzzle(idClient, inputContent);
            STEP = 3; /* inviato puzzle da risolvere al server */

            /* lancio la risoluzione sul server del puzzle */
            obj.solve(idClient, "parallelo");


            /* lancio la conversione sul server del puzzle per ottenere il formato che mi serve per la stampa */
            obj.convert(idClient);
            STEP = 4; /* risolto  puzzle sul server */

            /* prelevo l'output risolto nel formato che mi serve per la stampa e stampo */
            ArrayList<String> outputContent = obj.getOutput(idClient);
            STEP = 5; /* convertito puzzle sul server  e ottenuto in locale */

            int numRow = obj.getPuzzleRow(idClient);
            int numCol = obj.getPuzzleCol(idClient);
            STEP = 6; /* prelevate numero colonne e righe sul server  */

            /* anche se il server cada, da qua in poi il client riesce a terminare */
            if (file instanceof FileIOMod1) {
                ((FileIOMod1) file).writeContent(outputPath, outputContent, numRow, numCol);
            } else {
                System.out.println("Impossibile scrivere il puzzle su file!");
            }


        } catch (ConnectException e){

            switch (STEP){
                case 0: {
                    System.out.println("Attenzione: problemi di connessione con il server!");
                    System.out.println("Riprovare in seguito!");
                    break;
                }
                case 1: {
                    System.out.println("Attenzione: problemi di connessione con il server!");
                    System.out.println("Riprovare in seguito!");
                    break;
                }
                case 2: {
                    System.out.println("Attenzione: problemi di connessione con il server!");
                    System.out.println("Lettura del file in input eseguita.");
                    System.out.println("Riprovare in seguito a lanciare il programma!");
                    break;
                }
                case 3: {
                    System.out.println("Attenzione: problemi di connessione con il server!");
                    System.out.println("Puzzle da risolvere inviato al server.");
                    System.out.println("Riprovare in seguito a lanciare il programma!");
                    break;
                }
                case 4: {
                    System.out.println("Attenzione: problemi di connessione con il server!");
                    System.out.println("Puzzle risolto sul server.");
                    System.out.println("Riprovare in seguito a lanciare il programma!");
                    break;
                }
                case 5: {
                    System.out.println("Attenzione: problemi di connessione con il server!");
                    System.out.println("Convertito puzzle e ottenuto in locale!");
                    System.out.println("Riprovare in seguito a lanciare il programma!");
                    break;
                }
            }

        }
        catch (NotBoundException e){
            System.out.println("Attenzione: nome del server non trovato!");
            System.out.println("Provare con il nome dato al server.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
