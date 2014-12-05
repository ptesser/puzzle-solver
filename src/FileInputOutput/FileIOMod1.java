package FileInputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
 * <p>Classe che mi serve per gestire l'input e l'output da file</p>
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

            System.out.println("Read completed");

        } catch (IOException e) {
            System.err.println(e);
        }
        return content;
    }

    public static void writeContent(Path outputFile, ArrayList<String> content,int numRow, int numCol){
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile, charset)) {
            for (String s : content){ // testo del puzzle riordinato in una sola riga
                writer.write(s);
            }
            writer.write("\n\n");

            int i = 0; // contatore che mi serve per sapere quando andare a capo e continuare la stampa su una nuova riga per formare la matrice
            for (String s : content){ // testo del puzzle in forma matriciale
                if (i >= numCol){
                    writer.write("\n");
                    i = 0;
                }
                writer.write(s);
                i++;
            }

            writer.write("\n\n");
            writer.write(numRow + " " + numCol); // R x C

            System.out.println("Write completed");

        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
