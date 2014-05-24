package exceptions;

/**
 * Created by mohamed on 5/23/14.
 * package exceptions
 * project mips-simulator
 */
public class InvalidOperationException extends Exception {

    public InvalidOperationException() {
        super("This operation is invalid.");
    }

}
