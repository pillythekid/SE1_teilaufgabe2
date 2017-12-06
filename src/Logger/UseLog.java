package Logger;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseLog {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public void writeLog() {
        LOGGER.setLevel(Level.INFO);
        LOGGER.severe("Info Log");
        LOGGER.warning("Info Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");
    }

    public static void main(String[] args) {
        UseLog mylog = new UseLog();
        try {
            Log.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mylog.writeLog();
    }
}
