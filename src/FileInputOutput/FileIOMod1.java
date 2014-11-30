package FileInputOutput;

import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * FileIOMod1 Model Object
 *
 * <p>Classe che mi serve per gestire l'input e l'output da file tramite un ArrayList</p>
 * @author Tesser Paolo
 * @version 0.1
 */

public class FileIOMod1 {

    public static Charset charset = StandardCharsets.UTF_8;

    /**
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

    // TO DO - implementazione del metodo writeContent

}
