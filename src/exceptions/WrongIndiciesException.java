package exceptions;

/**
 * Created by EslaMaged on 5/23/14.
 */
public class WrongIndiciesException extends Exception{

    public WrongIndiciesException() {
        super("End Index is bigger that Start Index!s");
    }
}
