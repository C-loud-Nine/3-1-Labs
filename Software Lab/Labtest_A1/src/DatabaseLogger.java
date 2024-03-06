// Database Logger implementation
public class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        // Implement database logging here
        System.out.println("[Database] " + message);
    }
}
