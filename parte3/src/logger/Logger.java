package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

/**
 * @author Tesser Paolo
 * @version 0.1
 */
public class Logger {

    /* variabili per necessarie ai log */
    public static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("log");
    public static FileHandler fh;

    static{
        try {
            /* This block configure the logger with handler and formattern */
            Logger.fh = new FileHandler("log");
            Logger.logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            Logger.fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
