// File Logger implementation
public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        // Implement file logging here
        System.out.println("[File] " + message);
    }
}
