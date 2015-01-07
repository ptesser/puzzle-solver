import fileinputoutput.*;
import myexception.IdEmptyExcpt;
import myexception.NumFieldRowExcpt;
import puzzle.*;
import solver.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Tesser Paolo
 * @version 0.1
 */

public class PuzzleSolver {

    public static void main( String[] args ){
        /* acquisisco i percorsi dei file di input e output che mi servono sotto forma di stringhe */
        // String inputFile = "/Users/ptesser/Documents/repository/Bitbucket/progr_concorrente_distribuita/input_files/file_esempio.txt";
        // String outputFile = "/Users/ptesser/Documents/repository/Bitbucket/progr_concorrente_distribuita/output_files/empty.txt";
        String inputFile = args[0];
        String outputFile = args[1];
        // Path dei file di prova: /Users/ptesser/Documents/repository/Bitbucket/progr_concorrente_distribuita/input_files/.txt

        /* trasformo le stringhe in input dei percorsi del file in oggetti Path */
        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        /* leggo il contenuto del file in input e lo trasformo nel formato dati che mi serve */
        FileIO file = new FileIOMod1();
        ArrayList<String> inputContent = file.readContent(inputPath);

        try {
             /* creo un nuovo puzzle da risolvere, generato dall'input acquisito in precedenza */
            Puzzle puzzle1 = new PuzzleCharacter(inputContent);
            /* setto l'algoritmo che voglio usare per risolvere il puzzle */
            puzzle1.setStrategy(new SolverParStrategy());
            /* risolvo il puzzle */
            puzzle1.solvePuzzle();

            /* prelevo l'output risolto nel formato che mi serve per la stampa e stampo */
            /*
            ArrayList<String> outputContent = puzzle1.convertToArrayList();
            if (file instanceof FileIOMod1) {
                ((FileIOMod1) file).writeContent(outputPath, outputContent, puzzle1.getNumRow(), puzzle1.getNumCol());
            } else {
                System.out.println("Impossibile scrivere il puzzle su file.");
            }
            */

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
}
