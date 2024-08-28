public class Logger {
    // Private static instance of Logger
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {}

    // Public static method to get the instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            // Create a new instance if it doesn't exist
            instance = new Logger();
        }
        return instance;
    }

    // Example logging method
    public void log(String message) {
        System.out.println("Logged: " + message);
    }
}