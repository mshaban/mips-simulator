package formats;

/**
 * Created by mohamed on 5/22/14.
 * package formats
 * project mips-simulator
 */
public abstract class JFormat extends Instruction {

    String label;

    public JFormat(String label) throws Exception {
        this.label = label;
    }

    public abstract void execute();
}
