package simulator.exceptions;

public class ExecutionException extends Exception {
    public ParseErrorException (String message) {
        super("execution error: " + message);
    }
}