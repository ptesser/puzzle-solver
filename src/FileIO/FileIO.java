package FileIO;
import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    private static Charset charset = StandardCharsets.UTF_8;

    /**
     *
     * @param args rappresenta le stringhe da inserire da linea di comando per ricevere in input/output i file di testo
     */
    public static void main(String[] args) {
        // String inputFile = args[0];
        String inputFile = "../../../../../input_files/test1.txt"; // inserisco una percorso statico
        // String outputFile = args[1];

        Path inputPath = Paths.get(inputFile);
        // Path outputPath = Paths.get(outputFile);
        String inputContent = readContent(inputPath);
        System.out.println(inputContent);
        // writeContent(outputPath, inputContent);

        /**
         * Mi trova il percorso di dove la mia classe che sta venendo eseguita si trova
         */
        ClassLoader loader = FileIO.class.getClassLoader();
        System.out.println(loader.getResource("FileIO/FileIO.class"));

    }

    private static String readContent(Path inputPath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(inputPath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return content.toString();
    }

}
