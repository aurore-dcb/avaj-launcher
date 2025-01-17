package simulator.exceptions;

public class ParseErrorException extends Exception {
    public ParseErrorException (String message) {
        super("parse error: " + message);
    }
}