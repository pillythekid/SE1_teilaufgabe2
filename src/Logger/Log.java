package Logger;

import java.io.IOException;
import java.util.logging.*;

public class Log {

    static private FileHandler Txt;
    static private SimpleFormatter formatTxt;

    static public void init() throws IOException {
        try {
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            logger.setLevel(Level.INFO);
            Txt = new FileHandler("Log.txt");
            formatTxt = new SimpleFormatter();
            Txt.setFormatter(formatTxt);
            logger.addHandler(Txt);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
