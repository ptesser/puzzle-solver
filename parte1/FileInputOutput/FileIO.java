package FileInputOutput;

import java.nio.file.Path;
import java.util.ArrayList;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public interface FileIO {

    public ArrayList<String> readContent(Path inputPath);

}
