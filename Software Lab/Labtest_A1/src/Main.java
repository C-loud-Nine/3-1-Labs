// Client code example
public class Main {
    public static void main(String[] args) {
        // Choose logger type
        Logger consoleLogger = new ConsoleLogger();
        LoggingSystem loggingSystem = LoggingSystem.getInstance(consoleLogger);

        // Log messages at different log levels
        loggingSystem.log("INFO: This is an information message");
        loggingSystem.log("DEBUG: This is a debug message");
        loggingSystem.log("ERROR: This is an error message");

        // Add more loggers without modifying existing code
        Logger fileLogger = new FileLogger();
        loggingSystem = LoggingSystem.getInstance(fileLogger);
        loggingSystem.log("INFO: This is an information message");

        Logger databaseLogger = new DatabaseLogger();
        loggingSystem = LoggingSystem.getInstance(databaseLogger);
        loggingSystem.log("DEBUG: This is a debug message");
    }
}
