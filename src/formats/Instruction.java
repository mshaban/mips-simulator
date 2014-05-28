package formats;

/**
 * Created by mohamed on 5/24/14.
 * package formats
 * project mips-simulator
 */
public abstract class Instruction {

    protected int result;

    public abstract void execute() throws Exception;

    public abstract void writeBack() throws Exception;
}
