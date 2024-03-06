import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class LoggingSystemTest {

    @Test
    public void testConsoleLogger() {
        Logger consoleLogger = new ConsoleLogger();
        LoggingSystem loggingSystem = LoggingSystem.getInstance(consoleLogger);
        loggingSystem.log("INFO: Console Logger Test");
        // Assert something here
    }

    @Test
    public void testFileLogger() {
        Logger fileLogger = new FileLogger();
        LoggingSystem loggingSystem = LoggingSystem.getInstance(fileLogger);
        loggingSystem.log("INFO: File Logger Test");
        // Assert something here
    }

    @Test
    public void testDatabaseLogger() {
        Logger databaseLogger = new DatabaseLogger();
        LoggingSystem loggingSystem = LoggingSystem.getInstance(databaseLogger);
        loggingSystem.log("INFO: Database Logger Test");
        // Assert something here
    }

    @Test
    public void testSingletonInstance() {
        Logger consoleLogger = new ConsoleLogger();
        LoggingSystem loggingSystem1 = LoggingSystem.getInstance(consoleLogger);
        LoggingSystem loggingSystem2 = LoggingSystem.getInstance(consoleLogger);

        assertSame(loggingSystem1, loggingSystem2);
    }
}
