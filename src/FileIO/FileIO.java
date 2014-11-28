package FileIO;
import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/*
 * Questa programma prende come parametri due file,
 * legge il contenuto dal primo e lo scrive nel secondo
 * rimuovendo i caratteri di ritrono a capo.
 */


/**
 * FileIO Model Object
 *
 * <p>Classe che mi serve per gestire l'input e l'output da file</p>
 *
 * @author Tesser Paolo
 * @version 1.0.0
 *
 */

public class FileIO {

    public static Charset charset = StandardCharsets.UTF_8;

    /**
     *
     * @param inputPath percorso del file in input da leggere
     * @return un ArrayList contenente un elemento per ogni riga del file passato
     */
    public static ArrayList<String> readContent(Path inputPath) {
        ArrayList<String> content = new ArrayList<>(0);

        try (BufferedReader reader = Files.newBufferedReader(inputPath, charset)) {
            String line = null;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                content.add(line);
                ++i;
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return content;
    }



    /**
     * Esempio di main che legge un file in input dato e lo stampa
     * @param args rappresenta le stringhe da inserire da linea di comando per ricevere in input/output i file di testo
     */

    public static void main(String[] args) {
        // String inputFile = args[0];
        // String outputFile = args[1];

        String inputFile = "/Users/ptesser/Documents/repository/Bitbucket/progr_concorrente_distribuita/input_files/test1.txt"; // inserisco una percorso statico
        Path inputPath = Paths.get(inputFile);
        // Path outputPath = Paths.get(outputFile);

        ArrayList<String> inputContent = readContent(inputPath);


        // stampa il numero di elementi nella lista

        int dimArray = inputContent.size();
        for (int i = 0; i < dimArray; ++i){
            System.out.println(inputContent.get(i));
        }
        // writeContent(outputPath, inputContent);

        /**
         * Mi trova il percorso di dove la mia classe che sta venendo eseguita si trova
         */
        // ClassLoader loader = FileIO.class.getClassLoader();
        // System.out.println(loader.getResource("FileIO/FileIO.class"));

    }


}
