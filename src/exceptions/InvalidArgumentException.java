package exceptions;

/**
 * Created by mohamed on 5/22/14.
 * package exceptions
 * project mips-simulator
 */
public class InvalidArgumentException extends Exception {
    @Override
    public String getMessage() {
        return "invalid arguemts exception";
    }
}
