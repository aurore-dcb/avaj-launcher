package simulator.exceptions;

public class ExecutionException extends Exception {
    public ExecutionException (String message) {
        super("execution error: " + message);
    }
}