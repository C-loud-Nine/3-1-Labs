// Logging System using Singleton pattern
public class LoggingSystem {
    private static LoggingSystem instance;
    private Logger logger;

    private LoggingSystem(Logger logger) {
        this.logger = logger;
    }

    public static synchronized LoggingSystem getInstance(Logger logger) {
        if (instance == null) {
            instance = new LoggingSystem(logger);
        }
        return instance;
    }

    public void log(String message) {
        logger.log(message);
    }
}
